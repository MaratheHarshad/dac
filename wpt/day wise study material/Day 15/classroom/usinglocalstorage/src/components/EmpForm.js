import React, { useState } from "react";

function EmpForm(props) {
  // states required for 2 way binding

  const [formdetails, setformdetails] = useState({ empid: "", ename: "" });

  const handlechange = (e) => {
    // object destructuring
    let { name, value } = e.target;

    // set form details as it is and override [name] attribute
    setformdetails({ ...formdetails, [name]: value });
  };

  const adddata = () => {
    props.insertemp(formdetails);
    setformdetails({ empid: "", ename: "" });
  };

  return (
    <div>
      <form>
        <label htmlFor="empid">Employee id</label>
        <input
          type="text"
          name="empid"
          id="empid"
          value={formdetails.empid}
          onChange={handlechange}
        />
        <br />
        <label htmlFor="ename">Employee Name</label>
        <input
          type="text"
          name="ename"
          id="ename"
          value={formdetails.ename}
          onChange={handlechange}
        />

        <br />
        <button type="button" name="btn" id="btn" onClick={adddata}>
          Add new Employee
        </button>
      </form>
    </div>
  );
}

export default EmpForm;
