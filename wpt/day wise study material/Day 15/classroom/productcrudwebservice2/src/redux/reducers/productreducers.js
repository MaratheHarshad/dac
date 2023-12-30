const initialstate = {
  proddata: [],
};

export const manageprodarr = (state = initialstate, action) => {
  switch (action.type) {
    case "setdata":
      return { ...state, allprod: [...action.payload] };
  }
};
