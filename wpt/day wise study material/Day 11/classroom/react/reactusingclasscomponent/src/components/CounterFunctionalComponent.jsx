import { useState, useEffect } from "react";

const CounterFunctionalComponent = () => {
  // old versioin
  // statement functional compoennts
  // it is a simple variable
  let count = 0;

  // only when state, props is changing then only rerenderign of component is happend

  // using hooks it is possible to design statefull functional component
  // all the functions start with 'use' all are hooks
  // hooks are the asynchronous functions,

  // use state function accesspts initial values as a parameter, and return 2 values,
  //   the variable and reference to setter method

  const [cnt, setCnt] = useState(0);

  // it is a closure function
  // function inside function
  const increment = () => {
    // count++;
    // console.log("count: ", count);

    // asynchronous function which updates the state of

    setCnt(cnt + 1);
  };

  // useEffect
  // is a hook/ function
  // that call function whenever there is change in the states provided to useEffect hook in second parameter

  // this hook replaces componentDidUpdate Lifecycle method of class components
  // in functional components -> useEffect is used

  // if array of second parameter is empty, it only execute once at a time of component rendering
  useEffect(() => {
    console.log(cnt);
  }, [cnt]);

  return (
    <div>
      {/* events names should be write in camelcase format */}
      {/* without curly braces-> fun name means call only when button is clicked */}
      <h1>Functional Component</h1>

      {/* <h3>you clicked {count} times</h3> */}
      <h3>you clicked {cnt} times</h3>

      <button type="button" onClick={increment}>
        increment
      </button>
      <button type="button">decrement</button>
      <button type="button">reset</button>
    </div>
  );
};

export default CounterFunctionalComponent;
