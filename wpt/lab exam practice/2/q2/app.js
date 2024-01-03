const fs = require("fs");

const rs = fs.createReadStream("data.txt");

let data = "";
rs.on("data", (chunk) => {
  data += chunk;
});

rs.on("end", () => {
  let elemCount = 0;

  console.log("Square");

  data.split("\n").map((num) => {
    num = parseInt(num);
    if (!isNaN(num)) {
      console.log(num * num);
      elemCount++;
    }
  });

  let t = data.split("\n").reduce((acc, num) => {
    num = parseInt(num);
    if (!isNaN(num)) {
      return acc + parseInt(num);
    }
    {
      return acc;
    }
  }, 0);

  console.log("Total:", t);

  console.log("Average:", t / elemCount);
});
