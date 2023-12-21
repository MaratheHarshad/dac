using EmployeesMVC.Models;
using Microsoft.Build.ObjectModelRemoting;
using Microsoft.Data.SqlClient;
using System.Data;

namespace EmployeesMVC.Services
{
    public class EmployeeServices
    {


        // method to return the all the employess from the database
        public static List<EmployeeModel> Employees()
        {
            List<EmployeeModel> employees = new List<EmployeeModel>();

            SqlConnection cn = new SqlConnection();

            try
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=EmployeesMVCDatabase;Integrated Security=True;Connect Timeout=30;Encrypt=True;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
                cn.Open();

                SqlCommand cmd = new SqlCommand();
                cmd.CommandType = System.Data.CommandType.Text;
                cmd.Connection = cn;

                cmd.CommandText = "select * from tbl_Employees";
                


                SqlDataReader reader = cmd.ExecuteReader();

                while (reader.Read()) { 

                    EmployeeModel employee = new EmployeeModel();
                    employee.EmployeeGender = reader.GetString("EmployeeGender");
                    employee.EmployeeCity = reader.GetString("EmployeeCity");
                    employee.EmployeeDOB = reader.GetDateTime("EmployeeDOB");
                    employee.EmployeeId = reader.GetInt32("EmployeeId");
                    employee.EmployeeName = reader.GetString("EmployeeName");
                    employee.EmployeeSalary = reader.GetDecimal("EmployeeSalary");

                    employees.Add(employee);
                }

               


            }
            catch (Exception ex)
            {
                throw new Exception("Error while fetching employees");
            }
            finally
            {
                cn.Close();
            }


            return employees;
        }



        // method to add a new employee in to the DB
        
        // Remaining -> validations are remainging
        public static void Add(EmployeeModel emp)
        {
            SqlConnection cn = new SqlConnection();

            try
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=EmployeesMVCDatabase;Integrated Security=True;Connect Timeout=30;Encrypt=True;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
                cn.Open();

                SqlCommand cmd = new SqlCommand();
                cmd.CommandType = System.Data.CommandType.Text;
                cmd.Connection = cn;
                cmd.CommandText = "insert into tbl_Employees values(@EmployeeName, @EmployeeCity, @EmployeeDOB, @EmployeeGender, @EmployeeSalary)";



                //cmd.Parameters.Add("@EmployeeDOB", System.Data.SqlDbType.Date).Value = format;
                cmd.Parameters.AddWithValue("@EmployeeName", emp.EmployeeName);
                cmd.Parameters.AddWithValue("@EmployeeCity", emp.EmployeeCity);
                cmd.Parameters.AddWithValue("@EmployeeGender", emp.EmployeeGender);
                cmd.Parameters.AddWithValue("@EmployeeDOB", emp.EmployeeDOB);
                cmd.Parameters.AddWithValue("@EmployeeSalary", emp.EmployeeSalary);

                // returns the no of rows affected
                cmd.ExecuteNonQuery();


            }
            catch (Exception ex)
            {
                throw new Exception("Error while inserting employee");
            }
            finally
            {
                cn.Close();
            }
        }



        // method to find the Employee by id and return

        public static EmployeeModel Find(int EmployeeId)
        {

            SqlConnection cn = new SqlConnection();
            EmployeeModel employee = new EmployeeModel();

            try {

                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=EmployeesMVCDatabase;Integrated Security=True;Connect Timeout=30;Encrypt=True;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
                cn.Open();

                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from tbl_Employees where EmployeeId = @EmployeeId";

                // set parameters
                cmd.Parameters.AddWithValue("@EmployeeId", EmployeeId);

                SqlDataReader reader = cmd.ExecuteReader();

                // employee found set all the properties
                if (reader.Read())
                {
                    employee.EmployeeGender = reader.GetString("EmployeeGender");
                    employee.EmployeeCity = reader.GetString("EmployeeCity");
                    employee.EmployeeDOB = reader.GetDateTime("EmployeeDOB");
                    employee.EmployeeId = reader.GetInt32("EmployeeId");
                    employee.EmployeeName = reader.GetString("EmployeeName");
                    employee.EmployeeSalary = reader.GetDecimal("EmployeeSalary");
                }



            }
            catch (Exception ex)
            {
                throw new Exception("Exception occured while Finding the Employee");
            }
            finally
            {
                cn.Close();
            }

            return employee;
        }

    }

}

