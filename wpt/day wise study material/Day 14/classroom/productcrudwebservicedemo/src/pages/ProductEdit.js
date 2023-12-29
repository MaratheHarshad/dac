import React, { useEffect, useState } from "react";
import ProductService from "../service/ProductService";
import { useLocation, useNavigate, useParams } from "react-router-dom";

export default function ProductEdit() {
  // useNavigate will give you a reference of navigator
  const navigate = useNavigate();

  // hook provided by react-router-dom, to access the url param
  const params = useParams();

  // hook provided by react-router-dom, to access the state provided by caller
  // using location.state we can access the state
  const location = useLocation();

  const [formdetails, setformdetails] = useState({
    pid: "",
    pname: "",
    qty: "",
    price: "",
  });

  useEffect(() => {
    console.log("in productedit object initialization useeffect");
    setformdetails({ ...location.state.edprod });
  }, []);

  // change the specific attribute using [] operator

  const handlechange = (event) => {
    const { name, value } = event.target;
    setformdetails({ ...formdetails, [name]: value });
  };

  // closure function to add product in db/local array

  const updateproduct = () => {
    if (
      formdetails.pname === "" ||
      formdetails.qty === "" ||
      formdetails.price === ""
    ) {
      alert("pls fill all the fields");
      return;
    }

    // if control reachers here, then
    // add the product in the array/db

    ProductService.updateproduct(formdetails.pid, formdetails);
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
            readOnly
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

        <button
          type="button"
          className="btn btn-primary"
          onClick={updateproduct}
        >
          Update Product
        </button>
      </form>
    </div>
  );
}
