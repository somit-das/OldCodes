
import loader from "../assets/404_2.gif";
const NotLoader = () => {
  return (
    <div className=" w-screen h-screen flex justify-center items-center bg-[rgb(15,8,27)]">
      <img src={loader} alt="" className="h-[50%] object-cover" />
    </div>
  );
}

export default NotLoader