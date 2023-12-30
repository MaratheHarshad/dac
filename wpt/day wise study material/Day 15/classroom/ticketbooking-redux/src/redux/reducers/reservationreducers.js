export const manageReservation = (oldreservation = [], action) => {
  // object destructuring

  const { type, payload } = action;

  switch (type) {
    case "newbooking":
      return [...oldreservation, { ...payload }];

    case "cancelbooking":
      return oldreservation.filter((ob) => ob.id !== payload.id);

    default:
      return oldreservation;
  }
};

export const manageCancellation = (oldcancellation = [], action) => {
  // object destructuring

  const { type, payload } = action;

  switch (type) {
    case "cancelbooking":
      // to calculate refund amount
      return [...oldcancellation, { ...payload }];

    default:
      return oldcancellation;
  }
};

export const manageamount = (amount = 3000, action) => {
  // object destructuring

  const { type, payload } = action;

  switch (type) {
    case "newbooking":
      return amount + parseFloat(payload.amt);

    case "cancelbooking":
      return amount - parseFloat(payload.amt);
    default:
      return amount;
  }
};
