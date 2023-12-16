using Microsoft.AspNetCore.Mvc;

namespace WebApplication1.Controllers
{
    public class DefaultController : Controller
    {
        // Action methods
        public IActionResult Index(int? id, int a = 5, int b = 10) // Binding // id by default as 0
        {
            
            //return View(); // looking for view -> Index.cshtml
            // return View("ViewName") looking for view -> ViewName.cshtml

            //return NotFound();

            //return Accepted();


            // ViewBag -> dynamic object
            //          -> can add properties at runtime
            //          -> to pass the data from controller to view

            // accept a and b using query string

            ViewBag.Id = id;
            ViewBag.A = a;
            ViewBag.B = b;


            return View();
        }

        //public IActionResult Index(int? id) -> id is nullable type here
    }
}

//Binding
//    The variable automatically get the value if the parameter variable name matches the name of variable in pattern of MapControllerRoute
//    Names should be same (parameter name and variable name in pattern)