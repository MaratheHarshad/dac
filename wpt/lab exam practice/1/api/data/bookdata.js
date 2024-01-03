const books = [];

const addBook = (Author, Name, Price) => {
  books.push(new Book(books.length + 1, Author, Name, Price));
  console.log("book inserted");
};

const getAllBooks = () => {
  return books;
};

const getNewAddedBook = () => {
  return books[books.length - 1];
};

function Book(Id, Author, Name, Price) {
  return {
    Id,
    Author,
    Name,
    Price,
  };
}

module.exports = { addBook, getAllBooks, getNewAddedBook };
