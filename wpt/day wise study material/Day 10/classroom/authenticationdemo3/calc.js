//create a user defined local module calc.js that exposes the following functions:

// add(a,b);
// square(a);
// sum(a,b,c);

// create a module

// exports is a pre built object available in node js
const add = (a, b) => {
  return a + b;
};

const square = (a) => {
  return a * a;
};

module.exports = { square, add };
