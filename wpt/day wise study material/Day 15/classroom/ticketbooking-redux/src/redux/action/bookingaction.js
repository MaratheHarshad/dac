export const newbooking = (id, name, amt) => {
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

export const cancellationbooking = (id, name, amt) => {
  return {
    type: "cancelbooking",
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
