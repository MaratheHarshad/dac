const http = require("http");

// asynchronous function which creates server and takes callback fun as parameter
const server = http.createServer(function (request, response) {
  // req, res object should be generated by server
  // req is used to read req
  // res is used to respond the client

  console.log(
    "received request: " + request.url + " Method: " + request.method
  );

  //            -> parts
  //   request -> header, body
  //   response -> status code, header, body

  response.writeHeader(200, { "content-type": "text/html" });
  response.write("<h1>Hellow World</h1>");
  response.write("<h3>Welcome to node js server side programming</h3>");

  response.end("<h4>this is the end event</h4>");
});

// start the server on particular port

server.listen(9090, function () {
  console.log("server running at port 9090");
  console.log("http://localhost:9090");
});

// controller -> is concept which iteracts with the user
