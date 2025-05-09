import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axiosInstance from "../utils/Axios";
import InfiniteScroll from "react-infinite-scroll-component";
import Topnav from "./partials/Topnav";
import Cards from "./partials/Cards";
import Loader from "./Loader";

const People = () => {
  document.title = "SMA | Person";
  const navigate = useNavigate();
  const [category, setCategory] = useState("popular");
  const [person, setPerson] = useState([]);
  const [page, setPage] = useState(1);
  const [hasMore, setHasMore] = useState(true); //for react-infinite-scroll-component use

  const getPerson = async () => {
    try {
      const { data } = await axiosInstance.get(
        `/person/${category}?page=${page}`
      );

      if (data.results.length > 0) {
        setPerson((prevData) => [...prevData, ...data.results]);
           console.log(person);
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
    if (person.length === 0) {
      getPerson();
    } else {
      await setPage(1);
      await setPerson([]);
      await getPerson();
    }
  };
  useEffect(() => {
    refreshHandler();
  }, [category]);
  return person.length > 0 ? (
    <div className="w-screen h-screen ">
      <div className="px-[5%] w-full   flex justify-between items-center ">
        <h1 className="text-xl font-semibold text-zinc-400">
          <i
            onClick={() => navigate(-1)}
            className="ri-arrow-left-line text-[#6556CD] mr-3"
          ></i>
          Stars
          
        </h1>
        <div className="w-[80%] flex items-center">
          <Topnav />
          <div className="w-[2%]"></div>
        </div>
      </div>

      <InfiniteScroll
        loader={<h1>Loading ...</h1>}
        dataLength={person.length}
        next={getPerson}
        hasMore={hasMore}
      >
        <Cards data={person} title= "person" />
      </InfiniteScroll>
    </div>
  ) : (
    <Loader />
  );
};

export default People;
