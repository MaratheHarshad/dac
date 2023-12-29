import { Product } from "../Product";

// Service layer reduces the overhelming of the parent to child props communication and vice versa

class ProductService {
  constructor() {
    this.prodarr = [
      new Product(11, "Chair", 34, 4444),
      new Product(12, "Shelf", 70, 2222),
      new Product(13, "Table", 50, 2000),
    ];
  }
  getallproducts() {
    return this.prodarr;
  }

  insertProduct(p) {
    this.prodarr.push(
      new Product(parseInt(p.pid), p.pname, parseInt(p.qty), parseInt(p.price))
    );
  }

  deleteProduct(pid) {
    let pos = this.prodarr.findIndex((prod) => prod.pid === pid);

    this.prodarr.splice(pos, 1);
  }

  updateProduct(p) {
    let pos = this.prodarr.findIndex((prod) => prod.pid === p.pid);

    this.prodarr.splice(
      pos,
      1,
      new Product(parseInt(p.pid), p.pname, parseInt(p.qty), parseInt(p.price))
    );
  }
}
export default new ProductService();
