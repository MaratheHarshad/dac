import { combineReducers } from "redux";

import { manageprodarr } from "./productreducers";

export const reducers = combineReducers({

    allprod : manageprodarr,
    
})
