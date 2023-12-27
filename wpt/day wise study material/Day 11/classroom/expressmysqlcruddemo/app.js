// import all the libraries

const express = require("express");
const app = express(); // object of express
const routes = require("./routes/router");

// inbuilt module
const path = require("path");

// configure the application

// to add static references
app.set(express.static(path.join(__dirname, "public")));
// app.use("/css", express.static(path.join(__dirname, "public/css")))

// define middlewares
app.use(express.urlencoded({ extended: false }));
app.use(express.json());

// define route handlers

// when request reach to home route,
app.use("/", routes);

// express
// provides object whose name is router
// which allow us to write the routing application by followign design patterns

// start the server

app.listen(9090, () => {
  console.log("http://localhost:9090");
});

// mandatory line if we're using routes
module.exports = app;
