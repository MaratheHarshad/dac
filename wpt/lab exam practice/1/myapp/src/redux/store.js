import { createStore } from "redux";

import { formStore } from "./reducers/formcombinereducer";

const store = createStore(
  formStore,
  {},
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

export default store;
