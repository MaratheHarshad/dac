// alert("hey, it's working");

const display = () => {
  const radius = Number(document.getElementById("radius-id").value);

  const area = Math.PI * radius * radius;
  const circumference = 2 * Math.PI * radius;

  document.getElementById("area").innerHTML = area;
  document.getElementById("circumference").innerHTML = circumference;
};
