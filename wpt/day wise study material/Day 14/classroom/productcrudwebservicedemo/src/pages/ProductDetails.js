import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import ProductService from "../service/ProductService";
export default function ProductDetails() {
  const params = useParams();

  const [prod, setprod] = useState({ pid: "", pname: "", qty: "", price: "" });

  // componentDidMount lifecycle method
  // find the prod using product id and display it

  useEffect(() => {
    const prod = ProductService.getById(parseInt(params.pid));

    if (prod === undefined) {
      alert("Wrong product id");
    } else {
      setprod(prod);
    }
  }, []);

  // this useEffect will get executed every time params/params pid is changing
  useEffect(() => {
    const prod = ProductService.getById(parseInt(params.pid));

    setprod(prod);
  }, [params.pid]);

  return (
    <div>
      <div className="card">
        <div className="card-body">
          <h5 className="card-title">{prod.pname}</h5>
          <h5 className="card-subtitle mb-2 text-muted">{prod.qty}</h5>
          <h5 className="card-subtitle mb-2 text-muted">{prod.price}</h5>
        </div>
      </div>
    </div>
  );
}
