import { Link } from "react-router-dom";
import noimage from "../../assets/noimage.jpg";
const SortedCards = ({data,type}) => {
  
  data.sort((a,b)=>b.popularity - a.popularity);

  return  <div className="w-[100%] pl-5 flex overflow-y-hidden pb-4 mb-5">
          {data.length>0 ?data.map((d,i)=>{
             
              return (
                <Link
                  to={`/${type}/details/${d.id}`}
                  key={i}
                  className={"min-w-[35%] h-[54vh] flex flex-col gap-2 bg-zinc-900 mr-5 mb-0"}
                >
                  <img
                    className=" h-[30vh]   object-cover w-full"
                    src={` ${
                      d.backdrop_path || d.poster_path || d.profile_path
                        ? `https://image.tmdb.org/t/p/original/${
                            d.backdrop_path || d.poster_path || d.profile_path
                          }`
                        : noimage
                    }`}
                    alt=""
                  />
                  <div className="text-white py-3 px-7 pb-10 h-[45%] flex flex-col justify-evenly">
                    <h1
                      className={"text-xl font-semibold  text-center"}
                    >
                      {d.name || d.title || d.original_title || d.original_name}
                    </h1>
                    
                      <h2
                        className={"text-center text-sm text-zinc-400"}
                      >
                        {`${d.character == undefined ? "" : d.character}`}
                      </h2>
                    
                      <h2
                        className={"text-center text-sm text-zinc-400" }
                      >
                        {`${d.department == undefined ? "" : d.job||d.character || d.known_for_department}`}
                      </h2>
                    
  
                    {d.overview && (
                      <p className="mt-1 text-sm">
                        {d?.overview?.slice(0, 200)}...{" "}
                        <span className="font-bold text-zinc-500">more</span>
                      </p>
                    )}
                  </div>
                </Link>
              );
          }):(<h1 className="text-3xl text-white font-black text-center "> Nothing to Show</h1>)}
        </div>;
};

export default SortedCards;
