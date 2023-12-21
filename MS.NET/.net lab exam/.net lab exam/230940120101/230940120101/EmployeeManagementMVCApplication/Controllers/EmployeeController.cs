using EmployeeManagementMVCApplication.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using EmployeeManagementMVCApplication.Models;

namespace EmployeeManagementMVCApplication.Controllers
{
    public class EmployeeController : Controller
    {
        // GET: EmployeeController
        public ActionResult Index()
        {
            List<Employee> employees = EmployeeService.GetEmployees();
            return View(employees);
        }

        

        // GET: EmployeeController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: EmployeeController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]

        // Auto matically emp object will be binded from the data inserted
        public ActionResult Create(Employee emp)
        {
            try
            {
                // insert the employee into DB
                EmployeeService.Add(emp);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: EmployeeController/Edit/5
        public ActionResult Edit(int id)
        {
            // find the Employee by id, to display the information

            try
            {
                Employee employee = EmployeeService.GetEmployee(id);
                return View(employee);
            }
            catch
            {
                return RedirectToAction("Index");
            }
            
        }

        // POST: EmployeeController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, Employee emp)

        {

          
            try
            {
                // execute a Update Employee
                EmployeeService.Update(id,emp);

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
            try
            {
                Employee employee = EmployeeService.GetEmployee(id);
                return View(employee);
            }
            catch
            {
                return RedirectToAction("Index");
            }
        }

        // POST: EmployeeController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, Employee emp)
        {
            try
            {
                EmployeeService.Delete(id);
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
