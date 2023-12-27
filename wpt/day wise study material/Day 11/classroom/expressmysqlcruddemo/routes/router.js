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

      res.send(data);
    }
  });
});

// add -> verb
// product -> noun
// our url should never have verb ( url should never tell what this request is doing)

router.post("/products/product/:pnum", (req, res) => {
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
        res.status(500).send("no data found");
      } else {
        console.log(result);
        res.status(201).send("data added successfully");
      }
    }
  );
});

// handling logic for delete product get method

router.delete("/products/product/:pnum", (req, res) => {
  connection.query(
    "delete from products where id = ?",
    [req.params.pnum],
    (err, result) => {
      if (err) {
        console.log(err);
        res.status(500).send(err);
      } else {
        console.log(result);
        res.status(200).send("deleted successfully");
      }
    }
  );
});

// rerieve details of one product with id received via request params

router.get("/products/product/:pnum", function (req, resp) {
  connection.query(
    "select * from products where id=?",
    [parseInt(req.params.pnum)],
    function (err, data) {
      if (err) {
        console.log(err);
        resp.status(500).send("<h3>no data found</h3>");
      } else {
        console.log(data);
        resp.status(200).send(data);
      }
    }
  );
});

// update product received via request body and update in the database

router.put("/products/product/:pnum", function (req, resp) {
  connection.query(
    "update products set name=?,qty=?,price=? where id=?",
    [req.body.name, req.body.qty, req.body.price, req.params.pnum],
    function (err, result) {
      if (err) {
        console.log(err);
        resp.status(500).send("<h3>no data updated</h3>");
      } else {
        console.log(result);
        resp.send(200).send("data updated success fully updated");
      }
    }
  );
});

// this is same object routes in app.js
module.exports = router;
