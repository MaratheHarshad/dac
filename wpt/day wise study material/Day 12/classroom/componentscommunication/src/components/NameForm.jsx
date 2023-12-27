import React, { useState } from "react";

const NameForm = (props) => {
  // closure function

  // if changes are happening on variable change should refelected into state

  // two way binding
  // component to view
  // view to component

  const [name, setName] = useState("");
  const [errmsg, setErrmsg] = useState("");

  // pass the name to parent for adding it in the array which
  const addName = (e) => {
    // do not perform the default action of submit
    e.preventDefault();

    if (name.trim().length === 0) {
      //   alert("name cannot be blank");

      // to display errmessage beside the text box
      setErrmsg("name cannot be blank");
    } else {
      setErrmsg("");
      // propagating the data to the parent component
      props.adddata(name);

      // clear the name
      setName("");
    }
  };

  const delname = () => {
    if (name.trim().length === 0) {
      setErrmsg("name cannot be blank");
    } else {
      setName("");
      props.deletedata(name);
    }
  };

  return (
    <div>
      {name}
      <form onSubmit={addName}>
        <label htmlFor="name">Name</label>
        <input
          type="text"
          id="name"
          name="name"
          value={name}
          // two way binding -> sending data from view to component
          onChange={(event) => {
            setName(event.target.value);
          }}
        />

        <p>{errmsg}</p>

        <button type="submit">ADD NAME</button>
      </form>
    </div>
  );
};

export default NameForm;
