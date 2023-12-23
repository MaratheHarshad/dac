exports.combination = function (n, r) {
  return factorial(n) / factorial(n - r);
};

exports.user = { uid: 12, uname: "xxx" };

function factorial(n) {
  let fact = 1;
  for (let i = 1; i <= n; i++) {
    fact = fact * i;
  }

  return fact;
}
