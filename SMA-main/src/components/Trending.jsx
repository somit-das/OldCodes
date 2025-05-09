import { Link, useNavigate } from "react-router-dom";
import Topnav from "./partials/Topnav";
import Dropdown from "./partials/Dropdown";
import { useEffect, useState } from "react";
import axiosInstance from "../utils/Axios"
import Cards from "./partials/Cards";
import Loader from "./Loader";
import InfiniteScroll from 'react-infinite-scroll-component';
const Trending = () => {
    const navigate = useNavigate();
    const [category,setCategory] = useState("all");
    const [duration,setDuration] = useState("day");
    const [trending,setTrending] = useState([]);
    const [page,setPage] = useState(1);
    const [hasMore,setHasMore] = useState(true); //for react-infinite-scroll-component use

    document.title = "SMA | Trending "+category.toUpperCase() ;
    const getTrending = async () => {
      try {
        const { data } = await axiosInstance.get(`trending/${category}/${duration}?page=${page}`);

        if(data.results.length>0){
             setTrending((prevData) => [...prevData, ...data.results]);
            //  console.log(trending);
             setPage(page + 1);
            //  console.log(page);
        }else{
            setHasMore(false);
        }
      } catch (error) {
        console.log("Error", error);
      }
    };
    const refreshHandler = async() =>{ //for new data when refreshing the webpage
        if(trending.length ===0){
            getTrending();
        } else {
            await setPage(1);
            await setTrending([]);
            await getTrending();
        }

    };
    useEffect(()=>{
        refreshHandler();
    },[category,duration]);
  return trending.length > 0 ? (
    <div className="w-screen h-screen ">
      <div className="px-[5%] w-full   flex justify-between items-center ">
        <h1 className="text-xl font-semibold text-zinc-400">
          <i
            onClick={() => navigate(-1)}
            className="ri-arrow-left-line text-[#6556CD] mr-3"
          ></i>
          Trending
        </h1>
        <div className="w-[80%] flex items-center">
          <Topnav />
          <Dropdown
            title= {category.toUpperCase()}
            options={["movie", "tv", "all"]}
            changeElement={(e) => setCategory(e.target.value)}
          />
          <div className="w-[2%]"></div>
          <Dropdown
            title= {duration.toUpperCase()}
            options={["week", "day"]}
            changeElement={(e) => setDuration(e.target.value)}
          />
        </div>
      </div>

      <InfiniteScroll
        loader={<h1>Loading ...</h1>}
        dataLength={trending.length}
        next={getTrending}
        hasMore={hasMore}
      >
        <Cards data={trending} title={category} />
      </InfiniteScroll>
    </div>
  ) : (
    <Loader />
  );
}

export default Trending
