// pipe in linux -> internally 1 temp file is created and data is transfered to another part
// here also similar thing

const fs = require("fs");
const rs = fs.createReadStream("test.txt");
const ws = fs.createWriteStream("tragetdata.txt");

// suppose , test.txt is a very big file
// we have to transer data using pipe function

// src => rs
// dest => ws

rs.pipe(ws); // data transferring, internally temp file is created

// till while end event occurs
// read stream generate data event
// then write event occurs
