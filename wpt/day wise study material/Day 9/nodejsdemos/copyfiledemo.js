const fs = require("fs");
fs.copyFile("test1.txt", "test.txt", (err) => {
  if (err) {
    console.log(err);
  } else {
    // reading file after copy is done
    fs.readFile("test.txt", (err, data) => {
      if (err) {
        console.log("Error while reading " + err);
      } else {
        console.log(data.toString());
      }
    });
  }
});
