const fs = require("fs");

// to check whether files exists or not
fs.exists("test1.txt", function (flag) {
  //   console.log("File exists: " + flag);

  if (flag) {
    fs.stat("test1.txt", function (err, status) {
      if (err) {
        console.log("Error occured", err);
      } else {
        console.log(status);
        console.log("is file? ", status.isFile());
        console.log("is directory? ", status.isDirectory());
        console.log("size", status.size);
      }
    });
  }
});
