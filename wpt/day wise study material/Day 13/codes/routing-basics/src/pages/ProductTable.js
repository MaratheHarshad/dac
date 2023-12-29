import React from 'react'
import { Outlet, Link } from 'react-router-dom'

export default function ProductTable() {
  return (
    <div>
      {/* Link component will change the url to /form after you click on the button */}
      <Link to="/form">
        <button className="btn btn-dark m-2" type="button" name="btn" id="btn">Add new product</button>
      </Link>
      <ul>
        <li>
          <Link to="/table/p1">
            Product 1
          </Link>
        </li>
        <li>
          <Link to="/table/p2">
            Product 2
          </Link>
        </li>
        <li>

          <Link to="/table/p3">
            Product 3
          </Link></li>
      </ul>
      <div>
        {/* It is place holder to display child component */}
        {/* Outlet is an component provided by react-router-dom, it is an placeholder to display the child component */}
        <Outlet></Outlet>
      </div>
    </div >
  )
}
