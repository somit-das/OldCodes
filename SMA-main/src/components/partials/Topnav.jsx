import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axiosInstance from "../../utils/Axios";
import noimage from "../../assets/noimage.jpg";
function Topnav() {
  const [query, setQuery] = useState("");
  const [searches, setSearches] = useState([]);
  // console.log(query);
  const getSearch = async () => {
    try {
      const { data } = await axiosInstance.get(`search/multi?query=${query}`);
      // console.log(await data);
      setSearches(await data.results);
    } catch (error) {
      console.log("Error", error);
    }
  };
  useEffect(() => {
    getSearch();
  }, [query]);
  return (
    <div className="w-[80%] h-[5vh] my-3 relative flex m-auto items-center ">
      <i className="ri-search-line text-xl text-zinc-400"></i>
      <input
        onChange={(e) => setQuery(e.target.value)}
        value={query}
        className="w-[70%] mx-2   px-4 py-2 text-md outline-none border-none bg-[#0e0d0e] text-white rounded"
        type="text"
        placeholder="search anything"
      />
      {query.length > 0 && (
        <i
          onClick={() => setQuery("")}
          className="ri-close-fill text-2xl text-zinc-400"
        ></i>
      )}
      <div className="absolute z-[100] w-[69%] max-h-[55vh] bg-zinc-300  top-[90%] left-[6%]  overflow-auto rounded">
        {searches.length > 0 &&
          searches.map((s, i) => {
            let image_path = s.backdrop_path || s.profile_path || null;
            let name_title =
              s.name || s.title || s.original_title || s.original_name;
            return (
              
                <Link
                  to={
                    s.profile_path
                      ? `/person/details/${s.id}`
                      : `/${s.media_type}/details/${s.id}`
                  }
                  key={i}
                  className="text-zinc-500 font-semibold hover:text-black hover:bg-zinc-400 w-[100%] p-5 flex justify-start items-center border-b-2 border-zinc-100"
                >
                  <img
                    className="h-[10vh] w-[10vh] object-cover rounded mr-10 shadow-lg"
                    src={
                      image_path
                        ? `https://image.tmdb.org/t/p/original/${image_path}`
                        : noimage
                    }
                    alt=""
                  />
                  <span>{name_title}</span>
                </Link>
               
            );
          })}
      </div>
    </div>
  );
}

export default Topnav;
