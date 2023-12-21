using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

using EmployeesMVC.Models;
using Microsoft.Data.SqlClient;
using System.Data;
using EmployeesMVC.Services;


namespace EmployeesMVC.Controllers
{
    public class EmployeeController : Controller
    {
        // GET: EmployeeController

       
        public ActionResult Index()
        {
            
            List<EmployeeModel> list = EmployeeServices.Employees();

//            list.Add(new EmployeeModel { EmployeeCity = "Jalgaon", EmployeeGender = "male", EmployeeName = "Harshad", EmployeeSalary = 20000, EmployeeDOB = new DateTime(2002, 04, 02) });
            return View(list);
        }

        // GET: EmployeeController/Details/5
        //public ActionResult Details(int id)
        //{
        //    return View();
        //}

        // GET: EmployeeController/Create
        public ActionResult Create()
        {

            return View();
        }

        // POST: EmployeeController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]


        // direct EmployeeModel emp will be injected by the .NET
        public ActionResult Create(EmployeeModel emp)
        {

            try {

                EmployeeServices.Add(emp);

                return RedirectToAction("Index");
                   
            }
            catch(Exception ex)
            {

                return View();

            }
        }

        // GET: EmployeeController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: EmployeeController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection colln)
        {
            try
            {

                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: EmployeeController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: EmployeeController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }



        public ActionResult Details(int id)
        {


            EmployeeModel emp = EmployeeServices.Find(id);

            // strongly typed view that passes the object to the view
            return View(emp);
        }
    }
}
