import React, { useEffect, useState } from "react";
import ProductService from "../service/ProductService";

import { Link, Outlet } from "react-router-dom";
import { type } from "@testing-library/user-event/dist/type";

export default function ProductTable() {
  // create a array as state

  const [prodarr, setprodarr] = useState([]);
  const [searcharr, setsearcharr] = useState([]);
  const [searchtxt, setsearchtxt] = useState([]);

  // state for filter type, initially set filter by pname

  const [filtertype, setfiltertype] = useState("pname");

  // this is equivalent to componentDidMount

  useEffect(() => {
    console.log("inside the useEffect of productTable");
    let newarr = ProductService.getAllProducts();

    setprodarr([...newarr]);
    setsearcharr([...newarr]);
  }, []);

  // this function will keep on updating value of searchtxt when user type something in the text box
  const handlechange = (event) => {
    setsearchtxt(event.target.value);
  };

  // useEffect for search txt whenever there is change is searchtxt

  // similar to componentDidUpdate of class component
  useEffect(() => {
    if (searchtxt === "") {
      setsearcharr([...prodarr]);
    } else {
      // find all product which has searchtext in the product pname
      // let newarr = prodarr.filter((p) => p.pname.includes(searchtxt));

      // convert filtertype to string , in case filter type is pid (Number)
      let newarr = prodarr.filter((p) =>
        String(p[filtertype]).includes(searchtxt)
      );

      // at time of componentMount the length of prodarr is empty, i.e it sets searcharr as empty as well
      // so check (for first time when in prodarr the data is not filled )
      if (prodarr.length > 0) {
        setsearcharr([...newarr]);
      }
      // console.log("new arr in useeffect of searchtxt : " + newarr);
    }
  }, [searchtxt]);

  // componentDidMount for prodarr
  useEffect(() => {
    console.log(prodarr);
  }, [prodarr]);

  // method to delete product

  const deleteproduct = (pid) => {
    ProductService.deleteproduct(pid);
    fetchdata();
  };

  // method to fetch data

  const fetchdata = () => {
    let arr = ProductService.getAllProducts();
    setprodarr([...arr]);
    setsearcharr([...arr]);
  };

  // method to select the filtering criterial

  const handleselect = (event) => {
    // gives the selected index from the select list
    const { selectedIndex } = event.target;

    console.log(selectedIndex);

    // if selected index != 0 (means not an placeholder type option)

    if (selectedIndex !== 0) {
      // find by which type we have to apply the filter
      // event.target[selectedIndex].value -> returns an type prefixes with search-[type]
      console.log(event.target[selectedIndex].value);

      // separate the prefix-type
      // Array destructuring
      const [prefix, type] = event.target[selectedIndex].value.split("-");

      // apply the filter criteria on type now , in short set(update) the filter type

      setfiltertype(type);
    } else {
      // if filter type is not selected then select it by "pname"
      setfiltertype("pname");
    }
  };

  return (
    <div>
      {/* use Link compoenent if you want to change the link after clicking the button */}
      <Link to="/form">
        <button type="button" name="btn" id="add" className="btn btn-info m-4">
          Add new Product
        </button>
      </Link>

      <input
        type="text"
        name="search"
        id="search"
        onChange={handlechange}
        value={searchtxt}
      />

      <select
        name="searchby"
        id="searchby"
        className="ml-1"
        onChange={handleselect}
      >
        <option value="">select filter</option>
        <option value="search-pid">pid</option>
        <option value="search-pname">pname</option>
      </select>

      <table className="table table-scripted">
        <thead>
          <tr>
            <th> Product Id</th>

            <th> Product Name </th>
            <th> Product qty </th>
            <th> Product price </th>
            <th> Action</th>
          </tr>
        </thead>

        <tbody>
          {searcharr.map((prod) => (
            <tr key={prod.pid}>
              <th>{prod.pid}</th>
              <td>{prod.pname}</td>
              <td>{prod.qty}</td>
              <td>{prod.price}</td>
              <td>
                <Link to={`/table/${prod.pid}`}>
                  <button className="btn btn-success" id="view">
                    view
                  </button>
                </Link>

                {/* state -> is used to transfer the data from, one component to another component */}
                <Link to={`/edit/${prod.pid}`} state={{ edprod: prod }}>
                  <button className="btn btn-primary" id="edit">
                    edit
                  </button>
                </Link>

                <button
                  className="btn btn-danger"
                  id="delete"
                  onClick={() => {
                    deleteproduct(prod.pid);
                  }}
                >
                  delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <Outlet></Outlet>
    </div>
  );
}
