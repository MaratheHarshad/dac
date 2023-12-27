// import http module and create server
const http = require("http");
// import fs to read form.html
const fs = require("fs");

// import url module to parse the data from url
const url = require("url");

const m1 = require("./calc");

const server = http.createServer((req, res) => {
  res.writeHeader(200, { "contenty-type": "text/html" });

  // parse the req url
  const queryString = url.parse(req.url, true);
  switch (queryString.pathname) {
    case "/":
      const rs = fs.createReadStream("./public/form.html");

      // rs is type of -> read stream
      // pipe acceps -> write stream as paramter

      rs.pipe(res);

      // res.end() is not required in case read/write stream
      break;

    case "/submit_data":
      let num1 = parseInt(queryString.query.num1);
      let num2 = parseInt(queryString.query.num2);

      if (queryString.query.btn === "add") {
        str = "<h2>" + m1.add(num1, num2) + "</h2>";
        // res.end(`<h2>addition is : ${m1.add(num1, num2)}</h2>`);
        res.write(str);
        res.end();
      } else if (queryString.query.btn === "square") {
        res.end(`<h2> square is : ${m1.square(num1)} </h2>`);
      }

      break;

    default: {
      res.end("working");
    }
  }
});

server.listen(3000, () => {
  console.log(`http://localhost:3000`);
});
