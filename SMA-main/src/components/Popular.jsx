import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axiosInstance from "../utils/Axios"
import InfiniteScroll from "react-infinite-scroll-component";
import Dropdown from "./partials/Dropdown";
import Topnav from "./partials/Topnav";
import Cards from "./partials/Cards";
import Loader from "./Loader";
const Popular = () => {
  const navigate = useNavigate();
  const [category, setCategory] = useState("tv");
  const [popular, setPopular] = useState([]);
  const [page, setPage] = useState(1);
  const [hasMore, setHasMore] = useState(true); //for react-infinite-scroll-component use
  
    document.title = "SMA | Popular " + category.toUpperCase();
  const getPopular = async () => {
    try {
      const { data } = await axiosInstance.get(
        `${category}/popular?page=${page}&language=hi`
      );

      if (data.results.length > 0) {
        setPopular((prevData) => [...prevData, ...data.results]);
        // console.log(popular);
        setPage(page + 1);
        // console.log(page);
      } else {
        setHasMore(false);
      }
    } catch (error) {
      console.log("Error", error);
    }
  };
  const refreshHandler = async () => {
    //for new data when refreshing the webpage
    if (popular.length === 0) {
      getPopular();
    } else {
      await setPage(1);
      await setPopular([]);
      await getPopular();
    }
  };
  useEffect(() => {
    refreshHandler();
  }, [category]);

  return popular.length > 0 ? (
    <div className="w-screen h-screen ">
      <div className="px-[5%] w-full   flex justify-between items-center ">
        <h1 className="text-xl font-semibold text-zinc-400">
          <i
            onClick={() => navigate(-1)}
            className="ri-arrow-left-line text-[#6556CD] mr-3"
          ></i>
          Popular
        </h1>
        <div className="w-[80%] flex items-center">
          <Topnav />
          <Dropdown
            title={category.toUpperCase()}
            options={["movie", "tv"]}
            changeElement={(e) => setCategory(e.target.value)}
          />
          <div className="w-[2%]"></div>
         
        </div>
      </div>

      <InfiniteScroll
        loader={<h1>Loading ...</h1>}
        dataLength={popular.length}
        next={getPopular}
        hasMore={hasMore}
      >
        <Cards data={popular} title={category} />
      </InfiniteScroll>
    </div>
  ) : (
    <Loader />
  );

}

export default Popular
