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
const managereservation = (olderreservation = [], action) => {
  console.log("in managereservation reducer");
  switch (action.type) {
    case "newbooking":
      // add new object
      return [...olderreservation, { ...action.payload }];

    case "cancelbooking":
      // delet the given object
      return olderreservation.filter(
        (ob) => ob.id !== parseInt(action.payload.id)
      );

    default:
      // keep the state as it is
      return olderreservation;
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

// create store

// create store is a funciton in which we're storing the createStore funciton  and combineReducers function from Redux
const { createStore, combineReducers } = Redux;

// to generate this as a state object -> combineReducers
const ticketbooking = combineReducers({
  reservationList: managereservation,
  cancellationlist: managecancellation,
  amount: manageamount,
});

// use store

const store = createStore(ticketbooking);
// use store bycreation and dispatching action
const action = new_booking(12, "Mugdha", 300);
// dispatch the action to the store
store.dispatch(action);
