const initialstate = {
  Name: "",
  Author: "",
  Price: "",
};

export function manageformdetails(formdetails = initialstate, action) {
  if (action.type === "handleinputchange") {
    return {
      ...formdetails,
      [action.payload.attributeName]: action.payload.attributeValue,
    };
  } else {
    return formdetails;
  }
}
