const http = require("http");

const server = http.createServer((req, res) => {
  // conditional statments to identify the url (if-else or switch)

  if (req.url == "/home" && req.method == "GET") {
    res.write("<h1>home page</h1>");
    res.end("<h1>this is end of home page</h1>");
  } else {
    res.write("<h1>about us page</h1>");
    res.end("<h1>this is end of about page</h1>");
  }
});

server.listen(3000, (req, res) => {});
