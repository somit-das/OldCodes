import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { asyncLoadPerson, removeperson } from "../store/actions/personActions";
import {
  Link,
  Outlet,
  useLocation,
  useNavigate,
  useParams,
} from "react-router-dom";
import Loader from "./Loader";
import HorizontalCards from "./partials/HorizontalCards";
import ReactPlayer from "react-player";
import SortedCards from "./partials/SortedCards";

const PersonDetails = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const { pathname } = useLocation();
  const { info } = useSelector((state) => state.person);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(asyncLoadPerson(id));
    return () => {
      dispatch(removeperson());
    };
  }, [id]);
  console.log(info)
  return info ? (
    <div className="pl-[5%] pr-[3%]  w-screen h-screen bg-[#1F1E24] overflow-y-auto pb-5%">
      {/* {part 1} */}
      <nav className="h-[10vh] w-full text-zinc-100 flex items-center gap-5 text-xl ">
        <Link
          onClick={() => navigate(-1)}
          className=" drop-shadow-md ri-arrow-left-line text-[#6556CD] mr-3"
        ></Link>
        <Link
          //   onClick={() => navigate({replace:true})}
          to={"/"}
          className=" drop-shadow-md ri-home-9-fill text-[#6556CD] mr-3"
        ></Link>
      </nav>

      {/* { part 2} */}
      <div className="w-full min-h-[100vh]  flex ">
        <div className="w-[20%]">
          <img
            className="shadow-[8px_10px_38px_2px_#22365ebf] h-[30 vh] object-cover"
            src={`https://image.tmdb.org/t/p/original/${
              info.detail.profile_path || info.detail.backdrop_path
            }`}
            title={info.detail.name}
            alt=""
          />
          <hr className=" border-none h-[2px] bg-zinc-500 mt-5 mb-2" />
          {/* Social Media Links */}
          <div className="text-xl text-white flex gap-2">
            <a
              target="_blank"
              href={`https://www.wikidata.org/wiki/${info.externalId?.wikidata_id}`}
            >
              <i className=" drop-shadow-md ri-earth-fill"></i>
            </a>
            <a
              target="_blank"
              href={`https://www.imdb.com/name/${info.externalId?.imdb_id}`}
            >
              imdb
            </a>

            <a
              target="_blank"
              href={`https://www.facebook.com/${info.externalId?.facebook_id}`}
            >
              <i className="ri-facebook-circle-fill"></i>
            </a>

            <a
              target="_blank"
              href={`https://www.instagram.com/${info.externalId?.instagram_id}`}
            >
              <i className="ri-instagram-fill"></i>
            </a>

            <a
              target="_blank"
              href={`https://www.twitter.com/${info.externalId?.twitter_id}`}
            >
              <i className="ri-twitter-x-fill"></i>
            </a>
            <a
              target="_blank"
              href={`https://www.twitter.com/${info.externalId?.twitter_id}`}
            >
              <i className="ri-youtube-fill"></i>
            </a>
          </div>
          {/* Personal Info */}
          <h1 className="text-xl text-zinc-400 font-semibold my-5">
            Personal Information
          </h1>
          <h1 className="text-lg text-zinc-400 font-semibold">Known For</h1>
          <h1 className=" text-zinc-400 ">
            {info.detail.known_for_department}
          </h1>

          <h1 className="text-lg text-zinc-400 font-semibold mt-3">
            Birth Day
          </h1>
          <h1 className=" text-zinc-400 ">{info.detail.birthday}</h1>

          {info.detail.deathday && (
            <>
              <h1 className="text-lg text-zinc-400 font-semibold mt-3">
                Death Day
              </h1>
              <h1 className=" text-zinc-400 ">{info.detail.deathday}</h1>
            </>
          )}

          <h1 className="text-lg text-zinc-400 font-semibold mt-3">Gender</h1>
          <h1 className=" text-zinc-400 ">
            {info.detail.gender == 2 ? "male" : "female"}
          </h1>

          <h1 className="text-lg text-zinc-400 font-semibold mt-3">
            Place Of Birth
          </h1>
          <h1 className=" text-zinc-400 ">{info.detail.place_of_birth}</h1>

          <h1 className="text-lg text-zinc-400 font-semibold mt-3">Website</h1>
          <h1 className=" text-zinc-400 ">
            {info.detail.homepage
              ? info.detail.homepage?.split("//")[1].split("www.")[1]
              : "None"}
          </h1>

          <h1 className="text-lg text-zinc-400 font-semibold mt-3">
            Popularity
          </h1>
          <h1 className=" text-zinc-400 ">{info.detail.popularity}</h1>

          <h1 className="text-lg text-zinc-400 font-semibold mt-3">
            Also Known as
          </h1>
          <h1 className=" text-zinc-400 ">
            {info.detail.also_known_as.join(", ")}
          </h1>
        </div>
        <div className="w-[77  %] ml-[3%]">
          <h1 className="text-6xl text-zinc-400 font-black my-5">
            {info.detail.name}
          </h1>
          <h1 className="text-2xl text-zinc-400 font-semibold mb-2 mt-2">
            Biography
          </h1>
          <h1 className=" text-zinc-400 ">{info.detail.biography}</h1>
          <h1 className="text-2xl text-zinc-400 font-semibold mb-5 mt-5">
            Movie Credits
          </h1>
          <div className="w-[70vw]">
            <SortedCards data={[...info.movieCredits.cast]} type={"movie"} />
          </div>

          <h1 className="text-2xl text-zinc-400 font-semibold mb-5 mt-5">
            TV Credits
          </h1>
          <div className="w-[70vw]">
            <SortedCards data={[...info.tvCredits.cast]} type={"tv"} />
          </div>

          <h1 className="text-2xl text-zinc-400 font-semibold mb-5 mt-5">
            Combined Credits
          </h1>
          <div className="w-[70vw]">
            <SortedCards data={[...info.combinedCredits.cast]} />
          </div>
        </div>
      </div>
    </div>
  ) : (
    <Loader />
  );
};

{/*  */}

export default PersonDetails;