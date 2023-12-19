using Microsoft.EntityFrameworkCore.Metadata.Internal;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.Data.SqlClient;
using System.Data;

namespace CodeFirstApproach.Models
{
    public partial class Employee
    {
        [Key]
        [Column("EmpNo", TypeName = "int")]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public int EmpNo { get; set; }
        [Column("Name", TypeName = "varchar(50)")]
        public string Name { get; set; } = null!;
        [Column("Basic", TypeName = "decimal(18,2)")]
        public decimal Basic { get; set; }
        [Column("DeptNo", TypeName = "int")]
        public int DeptNo { get; set; }

        [ForeignKey("DeptNo")]
        public virtual Department? DeptNoNavigation { get; set; } = null!;


        public static List<Employee> GetEmployees()
        {

            List<Employee> employees = new List<Employee>();

            SqlConnection cn =  new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=EmpDb;Integrated Security=True;Connect Timeout=30;Encrypt=True;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";

            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = System.Data.CommandType.Text;
                cmd.CommandText = "Select * from Employees";

                SqlDataReader dr = cmd.ExecuteReader();

                while(dr.Read())
                {
                    Employee emp = new Employee();
                    emp.EmpNo = dr.GetInt32("EmpNo");
                    emp.Basic = dr.GetDecimal("Basic");
                    emp.Name = dr.GetString("Name");
                    emp.DeptNo = dr.GetInt32("DeptNo");

                    employees.Add(emp);

                }


            }
            catch (Exception ex)
            {
                throw new Exception("Error while fetching data");
            }
            finally
            {
                cn.Close();
            }

            Console.WriteLine(employees);


            return employees;
        
            
        }
    }

}
