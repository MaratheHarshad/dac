// require modules
const express = require("express");
const cors = require("cors");

// import routes
const bookrouter = require("./routes/bookrouter");

// create express instance
const app = express();

// set middlewares

// body-parser , version 9 onwards no need to explicity installed the body-parser

app.use(express.urlencoded({ extended: false }));
app.use(express.json());

// allow to cross-origin-resource-sharing
app.use(cors());

// define route handlers
// for all /books request -> use this router
app.use("/books", bookrouter);

app.get("/", (req, res) => {
  console.log("working");
  res.status(200);
  res.send();
});
// start the server

app.listen(9090, () => {
  console.log("server started");
  console.log("http://localhost:9090");
});
