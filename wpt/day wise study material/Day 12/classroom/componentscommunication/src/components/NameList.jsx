import React from "react";

import NameDetails from "./NameDetails";

const NameList = (props) => {
  return (
    <div>
      {props.nmarr.map((ob) => (
        <NameDetails fname={ob} />
      ))}
    </div>
  );
};

export default NameList;
