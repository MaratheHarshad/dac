import React from "react";

const NameDetails = (props) => {
  return (
    // 12 grid container
    <div className="container">
      {/* 12 columns in 1 row */}
      <div className="row">
        <div className="col-md-3">{/* svg link of bootstrap icon */}</div>
        <div className="col-md-9">
          <p>{props.fname}</p>
        </div>
      </div>
    </div>
  );
};

export default NameDetails;
