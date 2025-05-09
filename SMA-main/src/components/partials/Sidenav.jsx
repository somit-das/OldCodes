import { Link } from "react-router-dom"
function Sidenav() {
  
  return (
    <div className="w-[20%] h-full border-r border-zinc-700 p-10 ">
      <h1 className="text-2xl text-white font-bold">
        <i className="text-blue-600 ri-dvd-fill mr-3"></i>
        <span className="">SMA</span>
      </h1>
      <nav className="flex flex-col text-zinc-400 text-xl mb-5">
        <h1 className="text-white font-semibold text-xl mt-10 mb-5 ml-1">
          New Feeds
        </h1>
        <Link
          to="/trending"
          className="hover:bg-[#6556CD] hover:text-white hover:rounded-lg px-5 py-2 duration-300"
        >
          <i className="mr-2 ri-fire-fill"></i> Trending
        </Link>
        <Link
          to="/popular"
          className="hover:bg-[#6556CD] hover:text-white hover:rounded-lg px-5 py-2 duration-300"
        >
          <i className="mr-2  ri-user-heart-line"></i> Popular
        </Link>
        <Link
          to="/movie"
          className="hover:bg-[#6556CD] hover:text-white hover:rounded-lg px-5 py-2 duration-300"
        >
          <i className="mr-2 ri-movie-2-fill"></i> Movies
        </Link>
        <Link
          to="/tv"
          className="hover:bg-[#6556CD] hover:text-white hover:rounded-lg px-5 py-2 duration-300"
        >
          <i className="mr-2 ri-tv-fill"></i> Tv Shows
        </Link>
        <Link
          to="/person"
          className="hover:bg-[#6556CD] hover:text-white hover:rounded-lg px-5 py-2 duration-300"
        >
          <i className="mr-2 ri-team-fill"></i> People
        </Link>
      </nav>
      <hr className="border-none h-[0.1px] bg-zinc-400" />
      <nav className="flex flex-col text-zinc-400 text-xl mb-2">
        <h1 className="text-white font-semibold text-xl mt-5 mb-5 ml-1">
          Website Information
        </h1>
        <Link className="hover:bg-[#6556CD] hover:text-white hover:rounded-lg px-5 py-2 duration-300">
          <i className="mr-2 ri-information-fill"></i> About SMA
        </Link>
        <Link className="hover:bg-[#6556CD] hover:text-white hover:rounded-lg px-5 py-2 duration-300">
          <i className="mr-2 ri-phone-fill"></i> Contact US
        </Link>
      </nav>
    </div>
  );
}

export default Sidenav
