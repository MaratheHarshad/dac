const express = require("express");
const router = express.Router();
const { addBook, getNewAddedBook } = require("../data/bookdata");

// post method on
// https://localhost:9090/books/book
// to add new book in to the array

router.post("/book", (req, res) => {
  const { Author, Name, Price } = req.body;

  // before passing the price, parse it

  // add new book into the array

  addBook(Author, Name, parseInt(Price));

  res.status(200).send(getNewAddedBook());
});

router.get("/book", (req, res) => {
  res.status(200).send("working");
});

module.exports = router;
