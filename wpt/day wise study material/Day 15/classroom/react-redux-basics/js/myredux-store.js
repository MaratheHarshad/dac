// write action creator (functios)

// accepts 3 parameters
const new_booking = (id, name, amt) => {
  return {
    type: "newbooking",
    payload: {
      //   id: id,
      //   name: name,
      //   amt: amt,

      // equivalent to

      id,
      name,
      amt,
    },
  };
};

const cancel_booking = (id, name, amt) => {
  return {
    type: "cancelbooking",
    payload: {
      id,
      name,
      amt,
    },
  };
};

// write reducers (reducer functios for every state propert)

// this reducers manages reservation list
const managereservation = (oldreservation = [], action) => {
  console.log(action.type);
  console.log("in managereservation reducer");
  switch (action.type) {
    case "newbooking":
      // add new object
      return [...oldreservation, { ...action.payload }];

    case "cancelbooking":
      // delet the given object
      return oldreservation.filter(
        (ob) => ob.id !== parseInt(action.payload.id)
      );

    default:
      // keep the state as it is
      return oldreservation;
  }
};

// this reducers manages cancellationlist list
const managecancellation = (cancellationlist = [], action) => {
  console.log("in managecancellation reducer");
  switch (action.type) {
    case "cancelbooking":
      return [...cancellationlist, { ...action.payload }];

    default:
      return cancellationlist;
  }
};

// this reducers manages manageamount
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

// createStore and combinerReducers are essential functions use to set up and manage the Redux store.

// createStore is a part of Redux library which holds the complete state tree of application

// In larger applications, you might have multiple slices of the state managed by different reducer functions. combineReducers is used to combine these reducer functions into a single reducer that can be passed to createStore

const { createStore, combineReducers } = Redux;

// to generate this as a state object -> combineReducers
const ticketbooking = combineReducers({
  reservationList: managereservation,
  cancellationlist: managecancellation,
  amount: manageamount,
});

// use store

const store = createStore(ticketbooking);
// use store by creating and dispatching action
const action = new_booking(12, "Mugdha", 300);
// dispatch the action to the store
store.dispatch(action);

console.log(store.getState());

// create action to cancel booking

const cancelAction = cancel_booking(12, "Mugdha", 200);

// dispatch is a special type of function provided by store, which updates the state
store.dispatch(cancelAction);

console.log(store.getState());
