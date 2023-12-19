using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;


namespace MinimalAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValuesController : ControllerBase
    {

        [HttpGet]
        public List<Employee> Get()
        {
            List<Employee> employees = new List<Employee>();

            employees.Add(new Employee { EmpId = 1, Name = "Harshad" });
            employees.Add(new Employee { EmpId = 2, Name = "Aditya" });

            return employees;

            

        }

        [HttpPost("{id}/{name}")]
        public int Post(int id, string name)
        {
            

                
            return id;
        }
    }
}
