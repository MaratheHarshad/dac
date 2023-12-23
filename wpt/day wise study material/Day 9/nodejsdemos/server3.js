// import http module
const http = require("http");

// creating node server
const server = http.createServer((req, res) => {
  const url = req.url;

  // set the res header
  res.writeHeader(200, { "content-type": "text/html" });

  switch (url) {
    case "/home":
      res.write("<h1>Inside Home page</h1>");
      break;
    case "/about":
      res.write("<h1>Inside About page</h1>");
      break;

    default:
      res.write(`<h1>Inside ${url} page</h1>`);
      break;
  }

  res.end();
});

server.listen(3000, () => {});
