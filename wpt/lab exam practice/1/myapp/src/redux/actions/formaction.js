export const formAction = (attributeName, attributeValue) => {
  return {
    type: "handleinputchange",
    payload: {
      attributeName,
      attributeValue,
    },
  };
};
