const express = require("express");
const app = express();

app.use((req, res, next) => {
  console.log("This is middleware");
  // writing next is important other wise control would never reach to the original route
  next();
});

// __ -> (underscore underscore) dunder

app.get("/hello", (req, res) => {
  // it will be taking care of -> creating stream , transferring html text

  // __dirname -> in build variable available for every project
  res.sendFile("/public/hello.html", { root: __dirname });
});

// routing
// no next fun -> this is the last module we want to execute for this request
app.get("/aboutus", (req, res) => {
  res.send("<h1>in about us</h1>");
});

// start the app
// listen starts the server
app.listen(3000, () => {
  console.log("http://localhost:3000");
});
