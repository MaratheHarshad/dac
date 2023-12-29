import React, { useState } from "react";
import ProductService from "../service/ProductService";
import { useNavigate } from "react-router-dom";

export default function ProductForm() {
  // useNavigate will give you a reference of navigator
  const navigate = useNavigate();

  const [formdetails, setformdetails] = useState({
    pid: "",
    pname: "",
    qty: "",
    price: "",
  });

  // change the specific attribute using [] operator

  const handlechange = (e) => {
    setformdetails({ ...formdetails, [e.target.name]: e.target.value });
  };

  // closure function to add product in db/local array

  const addproduct = () => {
    if (
      formdetails.pid === "" ||
      formdetails.pname === "" ||
      formdetails.qty === "" ||
      formdetails.price === ""
    ) {
      alert("pls fill all the fields");
      return;
    }

    // if control reachers here, then
    // add the product in the array/db

    ProductService.insertProduct(formdetails);
    setformdetails({ pid: "", pname: "", qty: "", price: "" });

    // use navigate to change url via function
    navigate("/table");
  };

  return (
    <div>
      <form>
        <div className="form-group">
          <label htmlFor="pid">Product Id</label>
          <input
            type="text"
            className="form-control"
            id="pid"
            name="pid"
            value={formdetails.pid}
            onChange={handlechange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="pname">Product Name</label>
          <input
            type="text"
            className="form-control"
            id="pname"
            name="pname"
            value={formdetails.pname}
            onChange={handlechange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="qty">product qty</label>
          <input
            type="number"
            className="form-control"
            id="qty"
            name="qty"
            value={formdetails.qty}
            onChange={handlechange}
          />
        </div>

        <div className="form-group">
          <label htmlFor="price">Product price</label>
          <input
            type="text"
            className="form-control"
            id="price"
            name="price"
            value={formdetails.price}
            onChange={handlechange}
          />
        </div>

        <button type="button" className="btn btn-primary" onClick={addproduct}>
          Add Product
        </button>
      </form>
    </div>
  );
}
