class ProductService {
  constructor() {
    this.prodarr = [
      { pid: 1, pname: "chair", qty: 34, price: 444 },
      { pid: 2, pname: "Table", qty: 50, price: 666 },
      { pid: 3, pname: "shelf", qty: 38, price: 222 },
    ];
  }

  // method to return all the products
  getAllProducts() {
    return this.prodarr;
  }

  insertProduct(product) {
    console.log("in service add/insert");

    // parse the number keys

    product.pid = parseInt(product.pid);
    product.qty = parseInt(product.qty);
    product.price = parseInt(product.price);
    this.prodarr.push(product);
  }

  deleteproduct(pid) {
    let pos = this.prodarr.findIndex((prod) => prod.pid === pid);

    this.prodarr.splice(pos, 1);
  }

  // method to update the product using pid

  updateproduct(pid, newprod) {
    let pos = this.prodarr.findIndex((prod) => prod.pid === pid);
    this.prodarr.splice(pos, 1, newprod);
  }

  // method to get product by product id

  getById(pid) {
    // finds the product if exists undefined otherwise
    let product = this.prodarr.find((prod) => prod.pid === pid);

    return product;
  }
}

export default new ProductService();
