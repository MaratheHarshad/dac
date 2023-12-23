// var can be re declare

var a = 5;
var a = 23;

let y = 34;

// let y = 23 // error because of redeclaration

// scope
// var is global or function scope
// let is blocked scope

var b = 23; // global because it is outside function
let d = 32; // global

// function scope

function f1() {
  var g = 34; // function scope
  let f = 48;

  if (g > 30) {
    var x = "aaa";
    let v = 300;
  }

  console.log("usign var ", g, x);
  //console.log("using let", f, v); // error for v -> uncaught reference v is not defined here
  console.log("using let", f);
}

f1();

//  ********* hoisting **************

// moving something up is nothing but the hoisting

// variable hoisting is possible in var
// hoisting is not possible in let

// var p;
console.log("variable without declaration", p);
var p = 23;

//console.log("variable without declaration", q); // error - uncaught reference cannot access 'q' before initialization
let q = 54; // the let declaration doesn't get hoisted

const c = 34;

//c = 42 // change in the value of constant is not allowed

// Traditional way how we writing function
function f2() {}

// ECHMA5 version
const f3 = function () {};

// ECHMA6
// Arrow Function
const f4 = () => {};
