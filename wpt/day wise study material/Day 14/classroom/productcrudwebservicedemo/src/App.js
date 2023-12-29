import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./components/Header";
import MainNavBar from "./components/MainNavBar";
import Footer from "./components/Footer";

import { Route, Routes } from "react-router-dom";
import ProductTable from "./pages/ProductTable";
import ProductList from "./pages/ProductList";
import ProductForm from "./pages/ProductForm";
import ProductEdit from "./pages/ProductEdit";
import ProductDetails from "./pages/ProductDetails";

function App() {
  return (
    <div className="App">
      <Header />
      <MainNavBar />
      <Routes>
        <Route path="/table" element={<ProductTable></ProductTable>}>
          <Route path=":pid" element={<ProductDetails></ProductDetails>} />
        </Route>

        <Route path="/list" element={<ProductList></ProductList>} />
        <Route path="/form" element={<ProductForm></ProductForm>} />
        <Route path="/edit/:pid" element={<ProductEdit></ProductEdit>} />
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
