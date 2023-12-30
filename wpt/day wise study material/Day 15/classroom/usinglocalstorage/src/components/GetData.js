import React, { useEffect, useState } from "react";

function GetData() {
  const [data, setdata] = useState("");

  useEffect(() => {
    if (localStorage.emparr !== undefined) {
      setdata(localStorage.getItem("emparr"));
    }
  });
  return (
    <div>
      GetData<br></br>
      {data}
    </div>
  );
}

export default GetData;
