export { removetv } from "../reducers/tvSlice";

import axiosInstance from "../../utils/Axios";
import { loadtv } from "../reducers/tvSlice";

export const asyncLoadTv = (id) => async (dispatch, getState) => {
  try {
    const detail = await axiosInstance.get(`/tv/${id}`);
    const externalId = await axiosInstance.get(`/tv/${id}/external_ids`);
    const recommendations = await axiosInstance.get(
      `/tv/${id}/recommendations`
    );
    const similar = await axiosInstance.get(`/tv/${id}/similar`);
    const translations = await axiosInstance.get(`/tv/${id}/translations`);
    const videos = await axiosInstance.get(`/tv/${id}/videos`);
    const watchProviders = await axiosInstance.get(
      `/tv/${id}/watch/providers`
    );
    // const reviews = await axiosInstance.get(`/tv/${id}/reviews`);
    const credits = await axiosInstance.get(
      `/tv/${id}/aggregate_credits`
    );
    let theUltimateDetails = {
      detail: detail.data,
      externalId: externalId.data,
      similar: similar.data,
      translations: translations.data.translations.map((t) => t.name),
      videos: videos.data,
      recommendations: recommendations.data.results,
      watchProviders: watchProviders.data.results.IN,
      // reviews:reviews.data,
      credits: credits.data,
    };
    dispatch(loadtv(theUltimateDetails));
    // console.log(theUltimateDetails);
  } catch (error) {
    console.log("Error: ", error);
  }
};
