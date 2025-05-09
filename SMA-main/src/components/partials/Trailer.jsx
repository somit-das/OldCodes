
import ReactPlayer from 'react-player';
import { useSelector } from 'react-redux';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import NotLoader from '../NotLoader';
const Trailer = () => {
    const {pathname} =useLocation();
    const category = pathname.includes("movie") ? "movie" :"tv";
    const ytvideo = useSelector((state)=>state[category].info.videos);
    const navigate = useNavigate();
    console.log(pathname,ytvideo)
  return (
    <div className=" bg-[rgba(0,0,0,0.8)] absolute z-[100]  top-0 left-0 w-screen h-screen flex  items-center  justify-center ">
      <Link
        onClick={() => navigate(-1,{ replace: true })}
        className="hover:text-[#6556CD] ri-close-circle-fill absolute right-[20%] z-[102] top-[10%] right-[10%] text-4xl bg-red-400"
      ></Link>
      {ytvideo.results.length > 0 ?
      <ReactPlayer
        url={`https://www.youtube.com/watch?v=${ytvideo.results[0]?.key}`}
        height={"40vw "}
        width={"80vw"}
        controls={true}
      />:<NotLoader/>} 
    </div>
  ) ;
}

export default Trailer
