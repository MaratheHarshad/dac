import { createStore } from "redux"; // deprecated, because redux-toolkit is available which reduces the code

import { railwayStore } from "./reducers/myreducers";

// passing default values and extension for chrome
const store = createStore(
  railwayStore,
  {},
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

export default store;
