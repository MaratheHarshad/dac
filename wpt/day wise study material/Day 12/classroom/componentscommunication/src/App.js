import "./App.css";

import React, { useState } from "react";

import Audi from "./images/Audi.jpg";

import Header from "./components/Header";
import Footer from "./components/Footer";
import NameTab from "./components/NameTab";
import NameList from "./components/NameList";
// for bootstrap to be load
// import "./bootstrap/dist/css/bootstrap.min.css";

function App() {
  // let namearr = ["Harshad", "Khagesh", "Jatin", "Manish"];

  const [namearr, setNamearr] = useState([
    "Harshad",
    "Khagesh",
    "Jatin",
    "Manish",
  ]);

  const addnewname = (nm) => {
    console.log("in add new name in App", nm);
    // namearr.push(nm);
    // ... -> spread operator, keep the prev data as it is in state
    setNamearr([...namearr, nm]);
    console.log(namearr);
  };

  const removename = (nm) => {
    console.log("in remove name in App", nm);

    setNamearr(namearr.filter((name) => name !== nm));
    console.log(namearr);
  };

  return (
    <div className="App">
      <h1>Name lists</h1>
      <Header />

      <div className="container">
        <div className="row">
          <div className="col-sm-12 col-md-4">
            <img src={Audi} height={200} width={200}></img>
          </div>
          <div className="col-sm-12 col-md-5">
            <NameTab
              nmarr={namearr}
              insertdata={addnewname}
              removename={removename}
            />
          </div>
          <div className="col-sm-12 col-md-4">
            <NameList nmarr={namearr} />
          </div>
        </div>
      </div>

      <Footer />
    </div>
  );
}

export default App;
