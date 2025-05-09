export { removemovie} from '../reducers/movieSlice'

import axiosInstance from '../../utils/Axios'
import { loadmovie } from '../reducers/movieSlice'

export const asyncLoadMovie = (id) => async (dispatch, getState) => {
  try {
    const detail = await axiosInstance.get(`/movie/${id}`);
    const externalId = await axiosInstance.get(`/movie/${id}/external_ids`);
    const recommendations = await axiosInstance.get(
      `/movie/${id}/recommendations`
    );
    const similar = await axiosInstance.get(`/movie/${id}/similar`);
    const translations = await axiosInstance.get(`/movie/${id}/translations`);
    const videos = await axiosInstance.get(`/movie/${id}/videos`);
    const watchProviders = await axiosInstance.get(
      `/movie/${id}/watch/providers`
    );
    // const reviews = await axiosInstance.get(`/movie/${id}/reviews`);
    const credits = await axiosInstance.get(`https://api.themoviedb.org/3/movie/${id}/credits`);
    let theUltimateDetails = {
      detail: detail.data,
      externalId: externalId.data,
      similar: similar.data,
      translations : translations.data.translations.map(t=>t.name) ,
      videos: videos.data,
      recommendations:recommendations.data.results,
      watchProviders: watchProviders.data.results.IN,
      // reviews:reviews.data,
      credits:credits.data
    };
    dispatch(loadmovie(theUltimateDetails))
    // console.log(theUltimateDetails);
  } catch (error) {
    console.log("Error: ", error);
  }
};