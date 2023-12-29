const fs = require("fs");

// it is an asynchronous functions
// returns an reader stream
const reader = fs.createReadStream("data.txt");

let str = "";

// reader stream on data is streaming
reader.on("data", (chunk) => {
  str += chunk;
});

// on end of streaming
reader.on("end", () => {
  str = str.split("\n");

  str.map((line, lineNumber) => {
    console.log(`${lineNumber + 1}  : ${line}`);
  });
});

// if there were error
reader.on("error", () => {
  console.log("error occured while reading data");
});
