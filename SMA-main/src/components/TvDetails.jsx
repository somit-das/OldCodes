import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
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
import { asyncLoadTv, removetv } from "../store/actions/tvActions";

import noimage from "../assets/noimage.jpg";

const TvDetails = () => {
  const { id } = useParams();
    const navigate = useNavigate();
    const {pathname} = useLocation();
    const { info } = useSelector((state) => state.tv);
    const dispatch = useDispatch();
  
    useEffect(() => {
      dispatch(asyncLoadTv(id));
      return () => { 
        dispatch(removetv());
      };
    }, [id]);
  return info ? (
    <div
      style={{
        background: `linear-gradient(rgba(0,0,0,0.2),rgba(0,0,0,0.4),rgba(0,0,0,0.5)),url(https://image.tmdb.org/t/p/original/${
          info.detail.backdrop_path || info.detail.poster_path
        })`,
        backgroundRepeat: "no-repeat",
        backgroundPosition: "top 10%",
        backgroundSize: "cover",
      }}
      className=" relative  w-screen  overflow-hidden   px-[10%]"
    >
      <div className=" h-screen overflow-y-auto disabled_overflow_y">
        {/* {part 1} */}
        <nav className="h-[10vh] w-full text-zinc-100 flex items-center gap-10 text-xl ">
          <Link
            onClick={() => navigate(-1)}
            className=" drop-shadow-md ri-arrow-left-line text-[#6556CD] mr-3"
          ></Link>
          <Link
            //   onClick={() => navigate({replace:true})}
            to={"/"}
            className=" drop-shadow-md ri-home-9-fill text-[#6556CD] mr-3"
          ></Link>

          <a target="_blank" href={info.detail.homepage}>
            <i className=" drop-shadow-md ri-external-link-fill"></i>
          </a>
          <a
            target="_blank"
            href={`https://www.wikidata.org/wiki/${info.externalId?.wikidata_id}`}
          >
            <i className=" drop-shadow-md ri-earth-fill"></i>
          </a>
          <a
            target="_blank"
            href={`https://www.imdb.com/title/${info.externalId?.imdb_id}`}
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
        </nav>

        {/* {part 2  poster and details} */}
        <div className="w-full flex">
          <img
            className="shadow-[8px_17px_38px_2px_rgba(0,0,0,.5)] h-[55vh] object-cover"
            src={`https://image.tmdb.org/t/p/original/${
              info.detail.poster_path || info.detail.backdrop_path
            }`}
            alt=""
          />
          <div className="ml-[5%] text-white">
            <h1 className="text-5xl font-black text-white ">
              {info.detail.name ||
                info.detail.title ||
                info.detail.original_name ||
                info.detail.original_title}
              <small className="ml-2 text-2xl font-bold text-zinc-300 ">
                ({info.detail.first_air_date.split("-")[0]})
              </small>
            </h1>
            <h1 className="text-3xl mt-2 mb-2 font-semibold italic text-zinc-300 ">
              {info.detail.tagline}
            </h1>

            <div className="mt-3 mb-5  flex  text-white items-center gap-x-3 ">
              <span className=" bg-yellow-700 w-[6vh] h-[6vh] font-semibold flex justify-center items-center rounded-full ">
                {(info.detail.vote_average * 10).toFixed()} <sup>%</sup>
              </span>
              <h1 className="text-xl font-semibold w-[60px] leading-6 ">
                User Score{" "}
              </h1>

              <h1>{info.detail.genres.map((g, i) => g.name).join(",  ")}</h1>
              <h1>{info.detail.runtime} min</h1>
            </div>
            <div>
              <h1 className="">first release : {info.detail.first_air_date}</h1>
              <h1> last release : {info.detail.last_air_date}</h1>
            </div>
            <h1 className="text-xl mt-5 mb-3">Overview</h1>
            <p>{info.detail.overview}</p>
            <h1 className="text-2xl mb-3 mt-5">Tv Translated</h1>
            <p className="mb-5">{info.translations.join(", ")}</p>

            <Link
              className="px-5 py-2 bg-purple-600 text-yellow-400s rounded "
              to={`${pathname}/trailer`}
            >
              <i className="ri-play-line mr-2"></i>Play Trailer
            </Link>
          </div>
        </div>

        {/* { part 3 Available on platforms } */}
        <div className="w-[80%] flex flex-col gap-y-5   mt-10  ">
          {info.watchProviders && info.watchProviders.flatrate && (
            <div className="flex  gap-x-10 items-center text-white">
              <h1>Available on Platforms</h1>
              {info.watchProviders.flatrate.map((w, i) => (
                <img
                  title={w.provider_name}
                  className="w-[5vh] h-[5vh] object-cover rounded-md"
                  src={`https://image.tmdb.org/t/p/original/${w.logo_path}`}
                  key={i}
                />
              ))}
            </div>
          )}
          {info.watchProviders && info.watchProviders.rent && (
            <div className="flex  gap-x-10 items-center text-white">
              <h1>Available on Rent</h1>
              {info.watchProviders.rent.map((w, i) => (
                <img
                  title={w.provider_name}
                  className="w-[5vh] h-[5vh] object-cover rounded-md"
                  src={`https://image.tmdb.org/t/p/original/${w.logo_path}`}
                  key={i}
                />
              ))}
            </div>
          )}
          {info.watchProviders && info.watchProviders.buy && (
            <div className="flex  gap-x-10 items-center text-white">
              <h1>Available to Buy</h1>
              {info.watchProviders.buy.map((w, i) => (
                <img
                  title={w.provider_name}
                  className="w-[5vh] h-[5vh] object-cover rounded-md"
                  src={`https://image.tmdb.org/t/p/original/${w.logo_path}`}
                  key={i}
                />
              ))}
            </div>
          )}
        </div>

        {/* { part 4 Trailers} */}
        <hr className=" border-none h-[2px] bg-zinc-500 mt-10 mb-5 " />

        {info.videos.results.length > 0 && (
          <div className="  flex flex-col gap-5 mb-10 ">
            <h1 className="text-white text-3xl">Trailers Stuffs</h1>
            <div className="flex gap-10 overflow-x-auto ">
              {info.videos.results.map((ytv, i) => {
                return (
                  <div className="shrink-0 mb-5" key={i}>
                    <ReactPlayer
                      url={`https://www.youtube.com/watch?v=${ytv.key}`}
                      width={"50vh"}
                      height={"30vh"}
                      light={true}
                    />
                  </div>
                );
              })}
            </div>
          </div>
        )}

        {/* {part 4.5 seasons } */}
        
        {info.videos.results.length > 0 && (
          <div className="  flex flex-col gap-5 mb-10 ">
            <h1 className="text-white text-3xl">Seasons</h1>
            <div className="w-[100%] flex overflow-y-hidden mb-5 p-5  gap-4 ">
              {info.detail.seasons.length >0 ? info.detail.seasons.map((tv, i) => { 
                return (
                  <div className="flex flex-shrink-0 flex-col justify-between  " key={i}>
                    <img
                      className=" shadow-[8px_17px_38px_2px_rgba(0,0,0,0.5)] hover:scale-[0.98] hover:shadow-[8px_5px_20px_2px_rgba(0,0,0,0.5)] h-[35vh] object-cover"
                      src={ (tv.poster_path || tv.backdrop_path || tv.profile_path ? `https://image.tmdb.org/t/p/original/${
                        tv.poster_path || tv.backdrop_path || tv.profile_path
                      }`: noimage)}
                      alt=""
                    />
                    <h1 className="text-xl text-zinc-400 mt-3 font-semibold">
                      {tv.name }
                    </h1>
                  </div>
                );
              }):(<h1 className="text-3xl mt-5 text-white font-black text-center">Nothing to Show</h1>)}
            </div>
          </div>
        )}

        {/* { part 5 Recomendation & Similarities} */}
        {(info.recommendations.length > 0 || info.similar.length > 0) && (
          <div className="  flex flex-col gap-5">
            <h1 className="text-white text-3xl">Recommended or Similar</h1>
            <HorizontalCards
              data={
                info.recommendations.length > 0
                  ? info.recommendations
                  : info.similar
              }
            />
          </div>
        )}
        {/*{ part 6 Cast & Crews}*/}
        <div className="  flex flex-col gap-5">
          <h1 className="text-white text-3xl">Casts</h1>
          <HorizontalCards data={info.credits.cast} />
        </div>
        {/* { part 7 Crews} */}
        <div className="  flex flex-col gap-5">
          <h1 className="text-white text-3xl">Crew</h1>
          <HorizontalCards data={info.credits.crew} />
        </div>
        {/* {part 7 Reviews} */}
      </div>

      <Outlet />
    </div>
  ) : (
    <Loader />
  ); 
};

export default TvDetails;
