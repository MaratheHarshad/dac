using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace MyWebApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValuesController : ControllerBase
    {
        // GET: api/Values
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET api/Values/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value: " + id ;
        }

        // POST api/Values
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/Values/5
        [HttpPut("{id}")]

        // in case of Employee class , would be replaced by  [FromBody] Employee employee
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/Values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
