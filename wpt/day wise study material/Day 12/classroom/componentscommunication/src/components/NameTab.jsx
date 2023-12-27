import React from "react";

import NameForm from "./NameForm";

const NameTab = (props) => {
  const insertdata = (nm) => {
    console.log("in insert datanametab", nm);

    // propagate the name to parent

    props.insertdata(nm);
  };

  const deletedata = (nm) => {
    props.removename(nm);
  };
  return (
    <div>
      <table>
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
          </tr>
        </thead>

        <tbody>
          {/* dynamically generate the body */}
          {props.nmarr.map((ob, index) => (
            // to uniquely identify element in the virtual dom -> key property is used
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{ob}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <NameForm adddata={insertdata} deletedata={deletedata} />
    </div>
  );
};

export default NameTab;
