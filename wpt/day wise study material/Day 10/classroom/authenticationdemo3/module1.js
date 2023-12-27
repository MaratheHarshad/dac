const array = [
  {
    nm: "user1",
    passwd: "pass1",
  },
  {
    nm: "user2",
    passwd: "pass2",
  },
  {
    nm: "user3",
    passwd: "pass3",
  },
  {
    nm: "user4",
    passwd: "pass4",
  },
];

const validateUser = (uname, pass) => {
  const user = array.find((person) => {
    return person.nm === uname && person.passwd === pass;
  });

  if (user === undefined) {
    array.push({ nm: uname, passwd: pass });
  }

  console.log(array);
  return user === undefined ? null : user;
};

module.exports = { validateUser };
