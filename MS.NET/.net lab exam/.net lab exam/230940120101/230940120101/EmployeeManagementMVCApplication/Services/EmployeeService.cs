using EmployeeManagementMVCApplication.Models;
using Microsoft.Data.SqlClient;
using System.Data;

namespace EmployeeManagementMVCApplication.Services
{

    // Data Access Layer and Services layer is in the same Layer
    public class EmployeeService
    {

        public EmployeeService() { }


        // Method to get the list of all the employees from the Database
        public static List<Employee> GetEmployees()
        {

            List<Employee> employees = new List<Employee>();

            // Data Access Using ADO.NET

            SqlConnection cn = new SqlConnection();

            try
            {
                // open the connection
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=EmployeesDatabaseLabExam;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
                cn.Open();

                // create sql command
                // set the command connection

                // select query
                SqlCommand cmd = new SqlCommand();

                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "SELECT * FROM Employees";



                // execute the query

                SqlDataReader reader = cmd.ExecuteReader();

                // iterate till the reader.Read() == false

                while (reader.Read())
                {
                    Employee emp = new Employee();

                    // Data Binding 
                    emp.EmployeeId = reader.GetInt32("EmployeeId");
                    emp.EmployeeName = reader.GetString("EmployeeName");
                    emp.EmployeeCity = reader.GetString("EmployeeCity");
                    emp.EmployeeAddress = reader.GetString("EmployeeAddress");

                    employees.Add( emp );
                }


            }
            catch (Exception)
            {
                throw new Exception("Exception Occured While fetching the Employees from DB");
            }
            finally
            {
                // close the connection
                cn.Close();
            }

            


            return employees;
        }





        // method to find and return the employee by EmployeeId

        public static Employee GetEmployee(int id)
        {


            Employee emp = new Employee();

            SqlConnection cn = new SqlConnection();

            try
            {
                // open the connection
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=EmployeesDatabaseLabExam;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
                cn.Open();

                // create sql command
                // set the command connection

                // select command
                SqlCommand cmd = new SqlCommand();

                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "SELECT * FROM Employees WHERE EmployeeId = @EmployeeId";


                // set the cmd params

                cmd.Parameters.AddWithValue("@EmployeeId", id);
                // execute the query

                SqlDataReader reader = cmd.ExecuteReader();

                // bind the employee object

                if(reader.Read())
                {
                  
                    
                    // Data Binding 
                    emp.EmployeeId = reader.GetInt32("EmployeeId");
                    emp.EmployeeName = reader.GetString("EmployeeName");
                    emp.EmployeeCity = reader.GetString("EmployeeCity");
                    emp.EmployeeAddress = reader.GetString("EmployeeAddress");

                }


            }
            catch (Exception)
            {
                throw new Exception("Exception Occured While fetching the particular the Employee");
            }
            finally
            {
                // close the connection
                cn.Close();
            }

            
            return emp;

        }


        // Method to add new Employee to the DB

        public static void Add(Employee employee)
        {

            // create a sql connection 
            
           
            SqlConnection cn = new SqlConnection();

            try
            {
                // open the connection
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=EmployeesDatabaseLabExam;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
                cn.Open();

                // create sql command
                // set the command connection

                // insert command
                SqlCommand cmd = new SqlCommand();

                cmd.Connection = cn;
                cmd.CommandType = System.Data.CommandType.Text;
                cmd.CommandText = "INSERT INTO Employees VALUES(@EmployeeName, @EmployeeCity, @EmployeeAddress)";

                // set the command parameters
                cmd.Parameters.AddWithValue("@EmployeeName", employee.EmployeeName);
                cmd.Parameters.AddWithValue("@EmployeeCity", employee.EmployeeCity);
                cmd.Parameters.AddWithValue("@EmployeeAddress", employee.EmployeeAddress);


                // Return the number of rows affected in this case : 1
                cmd.ExecuteNonQuery();

            }
            catch (Exception)
            {
                throw new Exception("Exception Occured While Adding the Employee");
            }
            finally
            {
                // close the connection
                cn.Close();
            }
        }











        // method to update the employee details or update the employee

        public static void Update(int id, Employee employee) {


            SqlConnection cn = new SqlConnection();

            try
            {
                // open the connection
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=EmployeesDatabaseLabExam;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
                cn.Open();

                // create sql command
                // set the command connection

                // update command
                SqlCommand cmd = new SqlCommand();

                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "UPDATE Employees SET EmployeeName = @EmployeeName, EmployeeCity = @EmployeeCity, EmployeeAddress = @EmployeeAddress  WHERE EmployeeId = @EmployeeId";

                // set the cmd parameters
                // set the command parameters
                cmd.Parameters.AddWithValue("@EmployeeId", id);
                cmd.Parameters.AddWithValue("@EmployeeName", employee.EmployeeName);
                cmd.Parameters.AddWithValue("@EmployeeCity", employee.EmployeeCity);
                cmd.Parameters.AddWithValue("@EmployeeAddress", employee.EmployeeAddress);


                // return the number of rows affected
                cmd.ExecuteNonQuery();


            }
            catch (Exception)
            {
                throw new Exception("Exception Occured While Updating the Employee");
            }
            finally
            {
                // close the connection
                cn.Close();
            }


        }



        // method to delete the employee from the DB

        public static void Delete(int id) {



            SqlConnection cn = new SqlConnection();

            try
            {
                // open the connection
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=EmployeesDatabaseLabExam;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
                cn.Open();

                // create sql command
                // set the command connection

                // delete command
                SqlCommand cmd = new SqlCommand();

                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "DELETE FROM Employees WHERE EmployeeId = @EmployeeId";

                
                // set the command parameters
                cmd.Parameters.AddWithValue("@EmployeeId", id);
                


                // return the number of rows affected
                cmd.ExecuteNonQuery();


            }
            catch (Exception)
            {
                throw new Exception("Exception Occured While Deleting the Employee");
            }
            finally
            {
                // close the connection
                cn.Close();
            }


        }


    }

}
