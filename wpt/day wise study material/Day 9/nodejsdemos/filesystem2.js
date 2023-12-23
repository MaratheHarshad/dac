const fs = require("fs");

let data = fs.readFile("test1.txt", (err, data) => {
  console.log("data");
});
console.log(data); // it will print -> undefined , bcz readFile is async function
// fs.readFile() -> go in ready queue and after main thread execution , control would be given to function in ready queue
