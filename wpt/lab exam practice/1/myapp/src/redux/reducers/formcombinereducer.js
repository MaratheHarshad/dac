import { combineReducers } from "redux";
import { manageformdetails } from "./formreducer";

export const formStore = combineReducers({
  formdetails: manageformdetails,
});
