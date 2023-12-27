const express = require("express");
const router = express.Router(); // creating object of Router

// import db connection

const connection = require("../db/dbconnect");

// all the routes will be delegated here

router.get("/products", (req, res) => {
  // query is an asynchronous func
  connection.query("select * from products", (err, data, fields) => {
    if (err) {
      console.log(err);
      return res.status(500).send("<h4>No data found</h4>");
    } else {
      // display data in views
      // this will generate ./views/index.ejs

      res.render("index", { prodData: data });
    }
  });
});

router.get("/displayaddform", (req, res) => {
  res.render("add_prod");
});

router.post("/addproduct", (req, res) => {
  connection.query(
    "insert into products values (?,?,?,?)",
    [
      parseInt(req.body.id),
      req.body.name,
      parseInt(req.body.qty),
      parseFloat(req.body.price),
    ],
    (err, result) => {
      if (err) {
        console.log("error while inserting data");
      } else {
        console.log("product inserted " + result);
      }

      res.redirect("/products");
    }
  );
});

// handling logic for delete product get method

router.get("/delete/:pid", (req, res) => {
  connection.query(
    "delete from products where id = ?",
    [req.params.pid],
    (err, result) => {
      if (err) {
        console.log(err);
        res.status(500).send(err);
      } else {
        // console.log(result);
        res.redirect("/products");
      }
    }
  );
});

// this is same object routes in app.js
module.exports = router;
