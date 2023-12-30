import React from "react";

function EmpList(props) {
  return (
    <div>
      <table border={2} className="m-2">
        <thead>
          <tr>
            <th>Employee id</th>
            <th>Employee name</th>
          </tr>
        </thead>

        <tbody>
          {props.arr.map((e) => (
            <tr key={e.empid}>
              <td>{e.empid}</td>
              <td>{e.ename}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default EmpList;
