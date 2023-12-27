// create a file mydata.xt and myfile.data read contetns of both files parallely and display number of words in each file. (use asynchronous api)

// import fs module to read the files

const fs = require("fs");

const file1 = "mydata.txt";
const file2 = "myfile.txt";

console.log("Before");

// asynchronous reading the content of file
fs.readFile(file1, (err, data) => {
  if (err) {
    console.error(`Error while fetching content of ${file1}`);
  } else {
    console.log(data.toString());
    // first split the words by new line
    data = data.toString().split("\n").join(" ");
    // split the words by space between them
    console.log("Number of words: " + data.toString().split(/\s+/).length);
  }
});

// readFile is an asynchrounous api

fs.readFile(file2, (err, data) => {
  if (err) {
    console.error(`Error while fetching content of ${file2}`);
  } else {
    console.log(data.toString());
  }
});

console.log("after");
