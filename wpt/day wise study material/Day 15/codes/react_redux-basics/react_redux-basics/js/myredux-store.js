/// write action creator function
const new_booking = (id, name, amt) => {
  return {
    type: "newbooking",
    payload: { id, name, amt },
  };
};

const cancel_booking = (id, name, amt) => {
  return {
    type: "cancelbooking",
    payload: { id, name, amt },
  };
};

// write reducers function
//this reducers manages reservation list
const managereservation = (oldreservation = [], action) => {
  console.log("in manageReservation reducer");
  switch (action.type) {
    case "newbooking":
      //add new object
      return [...oldreservation, { ...action.payload }];
    case "cancelbooking":
      //delete the given object
      return oldreservation.filter((ob) => ob.id !== action.payload.id);
    default:
      //keep the state as it is
      return oldreservation;
  }
};
//this reducers manages cancellation list
const managecancellation = (cancellationlist = [], action) => {
  console.log("in managecancellation reducer");
  switch (action.type) {
    case "cancelbooking":
      return [...cancellationlist, { ...action.payload }];
    default:
      return cancellationlist;
  }
};

//this reducers manages amount
const manageamount = (amount = 3000, action) => {
  console.log("in manageamount reducer");
  switch (action.type) {
    case "newbooking":
      return amount + parseFloat(action.payload.amt);
    case "cancelbooking":
      return amount - parseFloat(action.payload.amt);
    default:
      return amount;
  }
};

// create store
const { createStore, combineReducers } = Redux;
const ticketbooking = combineReducers({
  resevationList: managereservation,
  cancellationList: managecancellation,
  amount: manageamount,
});
const store = createStore(ticketbooking);
//use store bycreatin and dispatching action
//create one newbooking action

var action = new_booking(12, "Mugdha", 3000);
//dispatch the action to the store
store.dispatch(action);
console.log(store.getState());

//use store bycreatin and dispatching action
//create one newbooking action
var action1 = new_booking(13, "Tanaya", 4000);
//dispatch the action to the store
store.dispatch(action1);

console.log("state");
console.log(store.getState());

//use store bycreatin and dispatching action
//create one newbooking action
var action2 = cancel_booking(13, "Tanaya", 2000);
//dispatch the action to the store
store.dispatch(action2);

console.log(store.getState());
