// Overloading

// in javascript overloading is not possible
// new definition override the previous definition of the function

// for every functio there exist an array of -> arguments(implicity available)
// arguments arrray is not availabe in arrow function

function f1() {
  console.log("in function f1");
  // arguments -> is implictly available argument objects in
  console.log(arguments);
}

f1();

// we can pass any number of parameter
f1(12, 3, 23);

// we can pass any number of parameter
f1(12, 3, 23, 4);

function f2(x, y) {
  console.log(x, y, arguments);
  var s = 0;

  for (var num in arguments) {
    s = s + num;
  }
}

f2(1, 2, 3, 4, 5);

// in js if we have to pass the number of parameters
// Rest operator is used

//... are called as "rest operator"
// arguments array is not available in arrow function

const f5 = (x, y, ...z) => {
  console.log("in function f5");
  console.log(x, y);
  console.log(z);
};

f5(4, 5, 6, 7);

// *********************** Closure functions **********************

// if there is a function which has access to it's parent function scope
// then it is called as closure functions

// closure function is a nested function
// inner function is a closure function
// closure functions can also be called as private functions

// in case we don't want this function to be available globally
// function factorial(n) {
//   var f = 1;

//   for (var i = 1; i <= n; i++) {
//     f = f * i;
//   }

//   return f;
// }

function combination(n, r) {
  nf = factorial(n);
  nrf = factorial(n - r);

  // accessible only only within the block, closure functions can use this
  let confidentialData = "some data";

  // closure function because it has access to it s parent function scope
  function factorial(n) {
    var f = 1;

    for (var i = 1; i <= n; i++) {
      f = f * i;
    }

    return f;
  }

  return nf / nrf;
}
console.log(combination());

// self calling function
// gets executed only once
// if we want to execute certain logic only once

(function () {
  console.log("in self calling function");
})();
