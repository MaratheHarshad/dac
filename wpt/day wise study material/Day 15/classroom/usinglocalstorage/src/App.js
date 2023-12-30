import logo from "./logo.svg";
import "./App.css";

import "bootstrap/dist/css/bootstrap.min.css";
import { useEffect, useState } from "react";
import EmpList from "./components/EmpList";
import EmpForm from "./components/EmpForm";
import GetData from "./components/GetData";

function App() {
  // state to store the emparr list

  const [emparr, setemparr] = useState([]);

  const addemployee = (emp) => {
    setemparr([...emparr, emp]);
  };

  // componentDidMount
  useEffect(() => {
    // alert(localStorage.getItem("emparr")); // return null

    // if (localStorage.getItem("emparr") !== null) {
    if (localStorage.emparr !== undefined) {
      const newarr = JSON.parse(localStorage.getItem("emparr")); // get data from localstorage

      setemparr(newarr);
    }
    // return is working as componentWillUnmount as class component
    // equivalent to componentWillUnmount
    return () => {
      console.log("in Unmount function");
    };
  }, []);
  //  componentDidUpdate
  useEffect(() => {
    if (emparr.length > 0) {
      localStorage.setItem("emparr", JSON.stringify(emparr));
    }
  }, [emparr]);

  return (
    <div className="App">
      <div>
        <EmpList arr={emparr} />
      </div>
      <div>
        <EmpForm insertemp={addemployee}></EmpForm>
      </div>
      <div>
        <GetData />
      </div>
    </div>
  );
}

export default App;
