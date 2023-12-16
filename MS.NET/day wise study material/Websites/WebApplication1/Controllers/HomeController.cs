using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{

    /* 
     * while naming controller
     * name must have suffix of "Controller"
     */
    public class HomeController : Controller

        
    {
        private readonly ILogger<HomeController> _logger;


        // dependency injection
        // allow to use something somewhere -> ILogger
        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        // if index is by default return an view
        public IActionResult Index()
        {

            // view in views/Home/{method name}{index.cshtml here}
            // .cshtml -> c sharp html

            return View();
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}

// url contain which action method to called

// views/Shared -> contains the view to call from another Controllers
