function f1() {
  console.log("in func f1");
}

function f2() {
  console.log("in func f2");
}

function f3() {
  console.log("in func f3");
}

user = { uid: 12, uname: "yyyy" };

// module.exports -> allows us to provide alias for members

module.exports = {
  function1: f1,
  function2: f2,
  function3: f3,
  user: user,
};
