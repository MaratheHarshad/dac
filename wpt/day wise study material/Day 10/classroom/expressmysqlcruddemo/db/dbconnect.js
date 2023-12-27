// importing mysql2 installed package to manipulate db
const mysql = require("mysql2");

// configure properties while creating the sql connection
const mysqlconnection = mysql.createConnection({
  host: "127.0.0.1",
  user: "root",
  password: "root",
  port: 3306,
  database: "nodejstest",
  //   multipleStatements : true; // if we want to execute  ?
});

// connecting to the db
mysqlconnection.connect((err) => {
  if (err) {
    console.log("error occured", err);
  } else {
    console.log("connection done");
  }
});

module.exports = mysqlconnection;
