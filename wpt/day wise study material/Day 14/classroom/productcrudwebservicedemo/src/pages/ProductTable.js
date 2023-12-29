import React, { useEffect, useState } from "react";
import ProductService from "../service/ProductService";

import { Link, Outlet } from "react-router-dom";

export default function ProductTable() {
  // create a array as state

  const [prodarr, setprodarr] = useState([]);
  const [searcharr, setsearcharr] = useState([]);
  const [searchtxt, setsearchtxt] = useState([]);

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
      let newarr = prodarr.filter((p) => p.pname.includes(searchtxt));

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
