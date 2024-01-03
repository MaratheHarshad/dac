import React, { useState } from "react";
import "./AdditionForm.css";

function AdditionForm() {
  const [number1, setNumber1] = useState(0);

  const [number2, setNumber2] = useState(0);

  const [result, setResult] = useState("");

  const [show, setShow] = useState(false);

  function addnumbers() {
    setShow(true);
    setResult(parseInt(number1) + parseInt(number2));
  }

  return (
    <div id="addition-form">
      <div id="table">
        <table>
          <tbody>
            <tr>
              <td>Number 1: </td>
              <td>
                <input
                  type="number"
                  name="number1"
                  id="number1"
                  value={number1}
                  onChange={(e) => {
                    setShow(false);
                    setNumber1(e.target.value);
                  }}
                />
              </td>
            </tr>
            <tr>
              <td>Number 2: </td>
              <td>
                <input
                  type="number"
                  name="number2"
                  id="number2"
                  value={number2}
                  onChange={(e) => {
                    setShow(false);
                    setNumber2(e.target.value);
                  }}
                />
              </td>
            </tr>
            <tr>
              <td>
                <button type="button" onClick={addnumbers}>
                  Add
                </button>
              </td>
            </tr>
          </tbody>
        </table>

        {show && (
          <div>
            <b>Sum is : </b>
            {result}
          </div>
        )}
      </div>
    </div>
  );
}

export default AdditionForm;
