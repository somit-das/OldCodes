import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axiosInstance from "../utils/Axios";
import InfiniteScroll from "react-infinite-scroll-component";
import Dropdown from "./partials/Dropdown";
import Topnav from "./partials/Topnav";
import Cards from "./partials/Cards";
import Loader from "./Loader";

const Tvshows = () => {
    document.title = "SMA | Tv Shows";
     const navigate = useNavigate();
     const [category, setCategory] = useState("airing_today");
     const [tv, setTv] = useState([]);
     const [page, setPage] = useState(1);
     const [hasMore, setHasMore] = useState(true); //for react-infinite-scroll-component use

     const getTv = async () => {
       try {
         const { data } = await axiosInstance.get(
           `/tv/${category}?page=${page}&language=hi`
         );

         if (data.results.length > 0) {
           setTv((prevData) => [...prevData, ...data.results]);
        //    console.log(tv);
           setPage(page + 1);
        //    console.log(page);
         } else {
           setHasMore(false);
         }
       } catch (error) {
         console.log("Error", error);
       }
     };
     const refreshHandler = async () => {
       //for new data when refreshing the webpage
       if (tv.length === 0) {
         getTv();
       } else {
         await setPage(1);
         await setTv([]);
         await getTv();
       }
     };
     useEffect(() => {
       refreshHandler();
     }, [category]);
  return tv.length > 0 ? (
    <div className="w-screen h-screen ">
      <div className="px-[5%] w-full   flex justify-between items-center ">
        <h1 className="text-xl font-semibold text-zinc-400">
          <i
            onClick={() => navigate(-1)}
            className="ri-arrow-left-line text-[#6556CD] mr-3"
          ></i>
          Tv Shows
          <small className="ml-2 text-sm text-zinc-600">({category})</small>
        </h1>
        <div className="w-[80%] flex items-center">
          <Topnav />
          <Dropdown
            title="Category"
            options={["popular", "top_rated", "on_the_air", "airing_today"]}
            changeElement={(e) => setCategory(e.target.value)}
          />
          <div className="w-[2%]"></div>
        </div>
      </div>

      <InfiniteScroll
        loader={<h1>Loading ...</h1>}
        dataLength={tv.length}
        next={getTv}
        hasMore={hasMore}
      >
        <Cards data={tv} title= "tv" />
      </InfiniteScroll>
    </div>
  ) : (
    <Loader />
  );
};

export default Tvshows;
