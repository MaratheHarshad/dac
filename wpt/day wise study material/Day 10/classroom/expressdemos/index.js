// import express library
const express = require("express");
// create express object
const app = express();

// middlewares are the functions which you want to execute for every request
// common task we want to execute for every request

// if we want to execute only for get method
// app.get()

// if we want to execute it for all the methods
// for every request, it is common functionality for all urls

// third parameter -> next
app.use(function (req, res, next) {
  console.log("This is first middleware");
  console.log("url : " + req.url);

  // mandatory to write, reference to execute next request
  next();
});

app.use(function (req, res, next) {
  console.log("This is second middleware");
  console.log("url : " + req.url);

  // mandatory to write, reference to execute next request
  next();
});

// router modules

// if app receives an request in /home then that callback fun should execute

app.get("/home", function (req, res) {
  // by default header: content-type : text/html

  // send function can be only executed once
  res.send("<h1>Home page</h1>");
});

app.get("/aboutus", function (req, res) {
  var str = "<h1>Hellow World!!</h1>";
  str += "<h2>Welcome to express js programming</h2>";

  res.send(str);
});

app.listen(9090, () => {
  console.log("http://localhost:9090");
});
