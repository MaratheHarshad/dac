import React, { useEffect, useState } from "react";
import ProductService from "../service/ProductService";

export default function ProductForm(props) {
  const [formdetails, setformdetails] = useState({
    pid: "",
    pname: "",
    qty: "",
    price: "",
  });

  const [formerrors, seterrors] = useState({});

  //
  useEffect(() => {
    console.log("in use effect of product form");
    if (props.editprod.pid !== undefined) {
      setformdetails({ ...props.editprod });
    }
  }, [props.editprod]);

  const validateForm = () => {
    let errors = {};

    if (
      props.editprod.pid === undefined &&
      formdetails.pid.trim().length === 0
    ) {
      errors.piderr = "pid cannot be empty";
    }

    if (formdetails.qty <= 0) {
      errors.qtyerr = "qty cannot be 0 or < 0";
    }

    seterrors(errors);

    return errors;
  };

  const addproduct = () => {
    let errors = validateForm();

    if (Object.keys(errors).length > 0) {
      // we dont' want to add object
      return;
    } else {
      // add the object in the array
      ProductService.insertProduct(formdetails);
      setformdetails({ pid: "", pname: "", qty: "", price: "" });
      props.chflag(false);
    }
  };

  // closure function for updating the product

  const updateproduct = () => {
    let errors = validateForm();

    if (Object.keys(errors).length > 0) {
      // we dont' want to add object

      return;
    } else {
      // add the object in the array
      ProductService.updateProduct(formdetails);
      setformdetails({ pid: "", pname: "", qty: "", price: "" });
      props.chflag(false);
    }
  };

  const handlechange = (e) => {
    // let name = e.target.name;
    // let value = e.target.value;

    // object destructuring
    // this is equivalent to previous two lines
    // it will retrieve name property of even.target assign it name variable, also retrieve value property and assign to value variable

    let { name, value } = e.target;

    // override what ever the value of name variable property

    setformdetails({ ...formdetails, [name]: value });
  };
  return (
    <div>
      <form>
        <div class="form-group">
          <label htmlFor="pid">Product Id</label>
          <input
            type="text"
            className="form-control"
            id="pid"
            name="pid"
            value={formdetails.pid}
            onChange={handlechange}
            readOnly={props.editprod.pid !== undefined}
          />
        </div>
        <div class="form-group">
          <label htmlFor="pname">Product pname</label>
          <input
            type="text"
            class="form-control"
            id="pname"
            name="pname"
            value={formdetails.pname}
            onChange={handlechange}
          />

          <p>{formerrors.piderr}</p>
        </div>
        <div class="form-group">
          <label htmlFor="qty">Product qty</label>
          <input
            type="number"
            class="form-control"
            id="qty"
            name="qty"
            value={formdetails.qty}
            onChange={handlechange}
          />
          <p>{formerrors.qtyerr}</p>
        </div>
        <div>
          <label htmlFor="price">Product price</label>
          <input
            type="text"
            class="form-control"
            id="price"
            name="price"
            value={formdetails.price}
            onChange={handlechange}
          />
        </div>
        {props.editprod.pid === undefined ? (
          <button
            type="button"
            class="btn btn-primary"
            id="add"
            name="add"
            onClick={addproduct}
          >
            add product
          </button>
        ) : (
          <button
            type="button"
            class="btn btn-primary"
            id="update"
            name="update"
            onClick={updateproduct}
          >
            update product
          </button>
        )}
      </form>
    </div>
  );
}
