import { createStore } from "redux";

import { reducers } from "./reducers/myprodreducers";

const store = createStore(
  reducers,
  {},
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

// reducer , {}, plugin

export default store;