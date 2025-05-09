import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axiosInstance from "../utils/Axios";
import InfiniteScroll from "react-infinite-scroll-component";
import Dropdown from "./partials/Dropdown";
import Topnav from "./partials/Topnav";
import Cards from "./partials/Cards";
import Loader from "./Loader";

const Movie = () => {
    const navigate = useNavigate();
    const [category, setCategory] = useState("now_playing");
    const [movie, setMovie] = useState([]);
    const [page, setPage] = useState(1);
    const [hasMore, setHasMore] = useState(true); //for react-infinite-scroll-component use

    document.title = "SMA | Movies ";
    const getMovie = async () => {
      try {
        const { data } = await axiosInstance.get(
          `/movie/${category}?page=${page}&language=hi`
        );

        if (data.results.length > 0) {
          setMovie((prevData) => [...prevData, ...data.results]);
        //   console.log(movie);
          setPage(page + 1);
        //   console.log(page);
        } else {
          setHasMore(false);
        }
      } catch (error) {
        console.log("Error", error);
      }
    };
    const refreshHandler = async () => {
      //for new data when refreshing the webpage
      if (movie.length === 0) {
        getMovie();
      } else {
        await setPage(1);
        await setMovie([]);
        await getMovie();
      }
    };
    useEffect(() => {
      refreshHandler();
    }, [category]);

  return movie.length > 0 ? (
    <div className="w-screen h-screen ">
      <div className="px-[5%] w-full   flex justify-between items-center ">
        <h1 className="text-xl font-semibold text-zinc-400">
          <i
            onClick={() => navigate(-1)}
            className="ri-arrow-left-line text-[#6556CD] mr-3"
          ></i>
          Movie <small className="ml-2 text-sm text-zinc-600">({category})</small>
        </h1>
        <div className="w-[80%] flex items-center">
          <Topnav />
          <Dropdown
            title="Category"
            options={["popular", "top_rated","upcoming","now_playing"]}
            changeElement={(e) => setCategory(e.target.value)}
          />
          <div className="w-[2%]"></div>
        </div>
      </div>

      <InfiniteScroll
        loader={<h1>Loading ...</h1>}
        dataLength={movie.length}
        next={getMovie}
        hasMore={hasMore}
      >
        <Cards data={movie} title="movie" />
      </InfiniteScroll>
    </div>
  ) : (
    <Loader />
  );
};

export default Movie;
