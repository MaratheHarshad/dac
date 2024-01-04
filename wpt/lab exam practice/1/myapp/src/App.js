import { useState } from "react";
import axios from "axios";
import "./App.css";
import { useDispatch, useSelector } from "react-redux";
import { formAction } from "./redux/actions/formaction";

function App() {
  // state for books
  const [books, setBooks] = useState([]);

  // dispatch from react-redux, to dispatch the action to redux store and accordingly reducers will get executed
  const dispatch = useDispatch();

  const formdetails = useSelector((state) => state.formdetails);

  // function to handle change on input elements
  const handlechange = (e) => {
    // if Name attributes is changed then, name = Name, and value = value inside that input tag

    // object dereferencing {}
    const { name, value } = e.target;

    console.log(name, value);

    const action = formAction(name, value);
    dispatch(action);
    // setFormdetails({ ...formdetails, [name]: value });
  };

  // function to validate and add new book to server array

  const addbook = () => {
    // no field should be empty

    const Name = formdetails.Name;
    const Author = formdetails.Author;
    const Price = formdetails.Price;

    // if any of the field is empty
    if (Name.length < 1 || Author.length < 1 || Price.length < 1) {
      alert("Please enter all the fields");
      return;
    }

    // make a axios request to the server, and new object return by server to the books array

    const url = "http://localhost:9090/books/book";
    axios
      .post(url, {
        Name,
        Author,
        Price,
      })
      .then((result) => {
        books.push({ ...result.data });
        setBooks([...books]);
      })
      .catch((err) => {
        console.log("error while inserting book in server");
      });
  };

  //
  return (
    <div className="App">
      <div>
        <form>
          <table>
            <tr>
              <td>Name:</td>
              <td>
                <input
                  type="text"
                  name="Name"
                  id="name"
                  value={formdetails.Name}
                  onChange={handlechange}
                />
              </td>
              <td>Author:</td>
              <td>
                <input
                  type="text"
                  name="Author"
                  id="author"
                  value={formdetails.Author}
                  onChange={handlechange}
                />
              </td>
              <td>Price:</td>
              <td>
                <input
                  type="number"
                  name="Price"
                  id="price"
                  value={formdetails.Price}
                  onChange={handlechange}
                />
              </td>

              <td>
                <button type="button" onClick={addbook}>
                  Add Book
                </button>
              </td>
            </tr>
          </table>
        </form>
      </div>

      {/* if there exists book only then display table */}
      {books.length > 0 && (
        <div id="books-table">
          <table>
            <thead>
              <th>Id</th>
              <th>Name</th>
              <th>Author</th>
              <th>Price</th>
            </thead>
            <tbody>
              {books.map((book) => (
                <tr>
                  <td>{book.Id}</td>
                  <td>{book.Name}</td>
                  <td>{book.Author}</td>
                  <td>{book.Price}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default App;
