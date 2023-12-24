const fs = require("fs");

var rs = fs.createReadStream("test.txt");
var str = "";

// node.js is going to generate this events (data, end, error)
// JS is event driving programming

rs.on("data", function (chunk) {
  str += chunk;
});

rs.on("end", function () {
  console.log("reached to the end of file");
  console.log(str);
});

rs.on("error", function (err) {
  console.log("error occured", err);
});
