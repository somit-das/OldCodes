
import loader from "../assets/loading_3.gif";
const Loader = () => {
  return (
  <div className='w-screen h-screen flex justify-center items-center bg-[rgb(15,8,27)]'>
      <img src={loader} alt="" className='h-[40%] object-cover' />
    </div>
  )
}

export default Loader
