import { Link } from "react-router-dom"

import noimage from "../../assets/noimage.jpg";

const Cards = ({data,title}) => {
  return (
    <div className="flex flex-wrap w-full h-full  px-[5%] justify-center bg-[#1F1E24]   ">
      {data.map((c, i) => (
        <Link
          to={`/${c.media_type || title}/details/${c.id}`}
          className="relative w-[25vh] h-[40vh] mx-[2%] my-[2%]  "
          key={i}
        >
          <img
            className=" shadow-[8px_17px_38px_2px_rgba(0,0,0,0.5)] hover:scale-[0.98] hover:shadow-[8px_5px_20px_2px_rgba(0,0,0,0.5)] h-[35vh] object-cover"
            src={
              c.poster_path || c.backdrop_path || c.profile_path
                ? `https://image.tmdb.org/t/p/original/${
                    c.poster_path || c.backdrop_path || c.profile_path
                  }`
                : noimage
            }
            alt=""
          />
          <h1 className="text-xl text-zinc-400 mt-3 font-semibold">
            {c.name || c.title || c.original_title || c.original_name}
          </h1>
          {c.vote_average && (
            <div className=" absolute right-[0] top-[75%] bg-yellow-700 w-[6vh] h-[6vh] font-semibold flex justify-center items-center rounded-full ">
              {(c.vote_average * 10).toFixed()} <sup>%</sup>
            </div>
          )}
        </Link>
      ))}
    </div>
  );
}

export default Cards
