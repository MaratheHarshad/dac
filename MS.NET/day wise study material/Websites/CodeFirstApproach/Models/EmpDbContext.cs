using Microsoft.EntityFrameworkCore;

namespace CodeFirstApproach.Models
{
    //CFActsDec23
    public partial class EmpDbContext : DbContext
    {
        public EmpDbContext()
        {
        }

        public EmpDbContext(DbContextOptions<EmpDbContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Department> Departments { get; set; }

        public virtual DbSet<Employee> Employees { get; set; }

     }
}
