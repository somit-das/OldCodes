import axios from 'axios';

const instance = axios.create({
  baseURL: "https://api.themoviedb.org/3/",
  headers:{
    accept:'application/json',
    Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZDk0OGZjNTE5ZWFmNDFmYTQ4ZjNlOWRhMThiMDg4MyIsIm5iZiI6MTcyNzQwMDg0Ny4yNzMsInN1YiI6IjY2ZjYwYjhmYmUzZjFjYWI0ZDcwOWM4ZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.319BVeKBMq7QCyV1lr4dU78IaT7M5qHRS8uTN7FmLuU'
  }
});

export default instance;
// const options = {
//   method: 'GET',
//   url: 'https://api.themoviedb.org/3/authentication',
//   headers: {
//     accept: 'application/json',
//     Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5ZDk0OGZjNTE5ZWFmNDFmYTQ4ZjNlOWRhMThiMDg4MyIsIm5iZiI6MTcyNzQwMDg0Ny4yNzMsInN1YiI6IjY2ZjYwYjhmYmUzZjFjYWI0ZDcwOWM4ZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.319BVeKBMq7QCyV1lr4dU78IaT7M5qHRS8uTN7FmLuU'
//   }
// };

// axios
//   .request(options)
//   .then(res => console.log(res.data))
//   .catch(err => console.error(err));