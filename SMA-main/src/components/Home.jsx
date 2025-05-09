import { useEffect, useState } from "react"
import Sidenav from "./partials/Sidenav"
import Topnav from "./partials/Topnav"
import axiosInstance from "./../utils/Axios"
import Header from "./partials/Header"
import HorizontalCards from "./partials/HorizontalCards"
import Dropdown from "./partials/Dropdown"
import Loader from "./Loader"
const Home = () => {
    document.title = "SMA | Homepage"
    const [wallpaper, setWallpaper] = useState(null);
    const [trending,setTrending] = useState(null);
    const [category,setCategory] = useState("all");
    const getHeaderWallpaper = async()=>{
      try {
        const { data } = await axiosInstance.get(
          `trending/all/week`
        );
        // console.log(await data);
        let randomData =  data.results[(Math.random()*data.results.length).toFixed()];
        // let randomData =  data.results[19];
        setWallpaper(randomData)
      } catch (error) {
        console.log("Error", error);
      }
    }
    const getTrending = async () => {
      try {
        const { data } = await axiosInstance.get(`trending/${category}/day`);

        setTrending(data.results);
      } catch (error) {
        console.log("Error", error);
      }
    };
    useEffect(()=>{
      !wallpaper && getHeaderWallpaper();
      getTrending();
    },[category])
  // console.log(trending);

  return wallpaper && trending ? (
    <>
      <Sidenav />
      <div className="w-[80%] h-full overflow-auto overflow-x-hidden ">
        <Topnav />
        <Header data={wallpaper} />
        <div className="flex justify-between p-5">
          <h1 className="text-3xl font-semibold text-zinc-400">Trending</h1>
          <Dropdown
            title="Filter"
            options={["tv", "movie", "all"]}
            changeElement={(e) => setCategory(e.target.value)}
          />
        </div>
        <HorizontalCards data={trending} changeElement={setCategory} />
      </div>
    </>
  ) : (
    <Loader />
  );
}

export default Home
