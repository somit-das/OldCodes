export { removeperson } from "../reducers/personSlice";

import axiosInstance from "../../utils/Axios";
import { loadperson } from "../reducers/personSlice";

export const asyncLoadPerson = (id) => async (dispatch, getState) => {
  try {
    const detail = await axiosInstance.get(`/person/${id}`);
    const externalId = await axiosInstance.get(`/person/${id}/external_ids`);
    const combinedCredits  = await axiosInstance.get(`/person/${id}/combined_credits`);
    const tvCredits = await axiosInstance.get(`/person/${id}/tv_credits`);
    const movieCredits = await axiosInstance.get(`/person/${id}/movie_credits`);
    
    let theUltimateDetails = {
      detail: detail.data,
      externalId: externalId.data,
      combinedCredits:combinedCredits.data,
      tvCredits:tvCredits.data,
      movieCredits:movieCredits.data,

    };
    dispatch(loadperson(theUltimateDetails));
    // console.log(theUltimateDetails);
  } catch (error) {
    console.log("Error: ", error);
  }
};
