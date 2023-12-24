// in every module
// there are 2 types of functions

// 1) async functions
// 2) sync functions

// any function ends with -> sync  -> it is synchronous function

// whenever we use async function
// first parameter is "path of file" (in case of using 'fs' module)
// last parameter is always a callback function
// and in callback function
// para1 = error fun
// para2 = data

// fs -> predefined module (./ not require)
const fs = require("fs");

// returns buffer
const data = fs.readFileSync("text.txt");

console.log(data.toString());

// write data to the file
// create new file if not exist or override if exists
fs.writeFileSync("test1.txt", "The text is written by js code");

// returns buffer
const data2 = fs.readFileSync("test1.txt");

console.log(data2.toString());
