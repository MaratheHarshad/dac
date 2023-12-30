import { createStore } from "redux";
import {railwayStore} from './reducers/myreducers'
const store=createStore(railwayStore,{},
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

export default store;
    