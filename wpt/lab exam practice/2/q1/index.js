$(document).ready(() => {
  const participants = [];
  // training charges
  const trainingCharges = [
    { seminar: "SOA", level: "Introductor", charges: 2500 },
    { seminar: "SOA", level: "Intermediate", charges: 3500 },
    { seminar: "SOA", level: "Advance", charges: 6000 },
    { seminar: "Design Patterns", level: "Introductor", charges: 4000 },
    { seminar: "Design Patterns", level: "Intermediate", charges: 5500 },
    { seminar: "Design Patterns", level: "Advance", charges: 8000 },
    { seminar: "Business Intelligence", level: "Introductor", charges: 5000 },
    { seminar: "Business Intelligence", level: "Intermediate", charges: 7000 },
    { seminar: "Business Intelligence", level: "Advance", charges: 8000 },
  ];
  // function to calculate the Training cost

  $("#calculate-training-cost").click(() => {
    // grab the selected - seminar
    const seminarType = $("#seminar-type")[0].value;

    // grab the selected - level
    const selectedLevel = $('input[name="level"]:checked').val();
    // both are mandatory
    calculateTrainingCost(seminarType, selectedLevel);
  });

  const calculateTrainingCost = (seminarType, selectedLevel) => {
    console.log(seminarType);
    console.log(selectedLevel);

    if (selectedLevel === undefined) {
      $("#levelErr").html("level is important").addClass("show-err");
    } else {
      $("#levelErr").html("").removeClass("show-err");

      // calculate and show the training cost in the : input box

      const trainingType = trainingCharges.find((entry) => {
        return entry.seminar === seminarType && entry.level === selectedLevel;
      });

      const trainingCost = trainingType.charges;

      $("#cost-of-seminar").val(trainingCost);

      return trainingCost;
    }
  };

  // method to handle form before submit

  // validate the input data and push the user data inside participants data

  $("#submit").click(() => {
    // access and validate all the inputs

    const firstName = $("#first-name").val();
    const lastName = $("#last-name").val();

    const email = $("#email").val();
    const confirmEmail = $("#confirm-email").val();

    const seminarType = $("#seminar-type")[0].value;

    const level = $(":radio[name='level']:checked").val();

    // validate names id
    if (!validateName(firstName) || !validateName(lastName)) {
      alert("Name should not be empty");
      return;
    }

    // validate email id
    if (!validateEmailId(email, confirmEmail)) {
      return;
    }

    // validate level

    if (level === undefined) {
      alert("please select an level");
      return;
    }

    // inputs are valid, put the participant  details in array

    let p = {
      firstName: firstName,
      lastName: lastName,
      email: email,
      confirmEmail: confirmEmail,
      seminarType: seminarType,
      seminarLevel: level,
      trainingCost: calculateTrainingCost(seminarType, level),
    };

    participants.push(p);

    console.log(participants);

    alert("successful");

    // clear the form here

    $("#myform")[0].reset();
  });

  const validateName = (name) => {
    return name.trim().length > 0 && name !== undefined;
  };

  const validateEmailId = (email, confirmEmail) => {
    if (
      email.trim().length === 0 ||
      confirmEmail.trim().length === 0 ||
      email === undefined ||
      confirmEmail === undefined
    ) {
      alert("email fields shouldb not be empty");
      return false;
    } else if (email !== confirmEmail) {
      alert("email and confirm email should match");
      return false;
    }

    // if ctrl reaches here means inputs are valid

    return true;
  };

  // display participants list in new window

  $("#display").click(() => {
    const newTab = window.open();

    if (newTab) {
      // Create a new element
      var divElement = document.createElement("div");

      var table = document.createElement("table");

      table.style.border = "1px solid black";
      table.setAttribute("border", "5px");
      //   $("table").css("border", "1px solid black");

      str = `<thead><tr><td>Name</td><td>email</td><td>seminar type</td><td>level</td><td>training cost</td></tr></thead>`;

      participants.forEach((participant) => {
        str += `<tr><td>${
          participant.firstName + " " + participant.lastName
        }</td><td>${participant.email}</td><td>${
          participant.seminarType
        }</td><td>${participant.seminarLevel}</td><td>${
          participant.trainingCost
        }</td></tr>`;
      });

      table.innerHTML = str;

      divElement.append(table);

      // Append the new element to the body of the new tab
      newTab.document.body.appendChild(divElement);
    }
  });
});
