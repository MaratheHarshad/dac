// import express
const express = require("express");
// create express object
const app = express();

// import user defined module
const m1 = require("./module1");
const m2 = require("./calc");

// common middleware, body-parser , for every request

// this is middleware which helps to parse th url and separate data from t
// it will generate a object by name query in req object if method is get
// it will generate object by name body in req object if the method is post
app.use(express.urlencoded({ extended: false }));
//urlencode -> automatically receives req, res object and internally do next()

app.get("/login", (req, res) => {
  res.sendFile("/public/login.html", { root: __dirname });
});

app.post("/validate", (req, res) => {
  //   res.send("uname : " + req.body.uname + " password : " + req.body.pword);

  //   or

  const u = m1.validateUser(req.body.uname, req.body.pword);

  if (u === null) {
    res.send("<h1>invalid user<h1>");
  } else {
    // res.send("<h1>valid user</h1>");
    // or
    res.sendFile("/public/form.html", { root: __dirname });
  }
});

app.get("/calculate", (req, res) => {
  // since it is get request
  //  values can be access using req.query
  let num1 = parseInt(req.query.num1);
  let num2 = parseInt(req.query.num2);

  if (req.query.btn === "add") {
    res.send("<h1>Addition :" + m2.add(num1, num2) + "</h1>");
  } else {
    res.send("<h1>Square : " + m2.square(num1) + "</h1>");
  }
});

// start the server
app.listen(9090, (req, res) => {
  console.log("http://localhost:9090");
});
