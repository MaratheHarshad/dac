const fs = require("fs");

// last parameter of async fun should be call back function

const fname = "test1.txt";
fs.exists(fname, function (flag) {
  if (flag) {
    fs.stat(fname, function (err, status) {
      if (err) {
        console.log("error occured: ", err);
      } else {
        console.log("size", status.size);

        // filename, mode (read, write), callback function

        fs.open(fname, "r", function (err, fd) {
          if (err) {
            console.log(err);
          } else {
            var buff = Buffer.alloc(10);
            // file descriptor, which buffer, how many characters , , , call back func
            fs.read(fd, buff, 0, 10, null, function (err, bytesread, buffer) {
              //                     -> current file position or null
              if (err) {
                console.log(err);
              } else {
                console.log(buffer.toString());
              }
            });
          }
          fs.close(fd);
        });
      }
    });
  }
});
