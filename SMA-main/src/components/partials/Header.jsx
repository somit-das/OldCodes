import { Link } from "react-router-dom";


const Header=({data}) =>{
    // console.log(data);
  return (
    <div
      style={{
        background: `linear-gradient(rgba(0,0,0,0.2),rgba(0,0,0,0.4),rgba(0,0,0,0.5)),url(https://image.tmdb.org/t/p/original/${
          data.backdrop_path || data.profile_path
        })`,
        backgroundRepeat: "no-repeat",
        backgroundPosition: "top 10%",
        backgroundSize: "cover",
      }}
      className="w-full h-[50vh]  flex flex-col justify-end items-start p-[5%] mt-2"
    >
      <h1 className="w-[70%] text-5xl font-black text-white">
        {data.name || data.title || data.original_title || data.original_name}
      </h1>
      <p className=" mt-5 text-white w-[70%]">
        {data?.overview?.slice(0, 200)}...{" "}
        <Link to={`/${data.media_type}/details/${data.id}`} className="font-bold text-blue-400">more</Link>
      </p>
      <div className="text-white mt-5 flex gap-x-6">
        {data.first_air_date && (
          <p>
            <i className="ri-megaphone-fill mr-3"></i>
            {data.first_air_date}
          </p>
        )}
        {data.media_type && (
          <p>
            <i className="ri-album-fill mr-1"></i>
            {data.media_type.toUpperCase()}
          </p>
        )}
      </div>
      <div className="text-white mt-5 flex gap-x-6">
        {/* {console.log(data.vote_average + "  " + typeof(data.vote_average))} */}
        {Number(data.vote_average)!==0 && (
          <p>
            <i className="ri-star-half-line mr-3"></i>
            {data.vote_average.toPrecision(2)}
          </p>
        )}
        {Number(data.vote_count)!==0 && (
          <p>
            <i className="ri-group-line mr-1"></i>{" "}
            {data.vote_count}
          </p>
        )}
      </div>
      <Link 
        to={`/${data.media_type}/details/${data.id}/trailer`}
        className="p-4 bg-yellow-200 h-[2vh] flex items-center mt-5 rounded">
        Watch Trailer
      </Link>
    </div>
  );
};
export default Header