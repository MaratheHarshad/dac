using Microsoft.Data.SqlClient;

using System.Data;

namespace Databases
{
    internal class Program
    {
        static void Main()
        {
            //Connect();
            //Insert1();

            Employee obj = new Employee { EmpNo = 7, Name = "D'Silva", Basic = 99999, DeptNo = 20 };

            //Insert2(obj);
            // Insert3(obj);
            //Insert4(obj);
            //SelectSingleValue();
            //DataReader1();
            //DataReader2();

            // Lab Work Methods :


            //GetSingleEmployee(1);
            //GetSingleEmployee(1);
            //GetAllEmployees();

            //Employee emp = new Employee { EmpNo = 5, Name = "D'Silva", Basic = 99999, DeptNo = 2 };
            //UpdateEmployee(emp);

            //DeleteEmployee(2);


            //MARS();
            //CallFuncReturningSqlDataReader();

            //Transactions();
        }
        static void Connect()
        {
            SqlConnection cn = new SqlConnection();
            //cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;User Id=sa;Password=pwd";
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
            
            
            //cn.ConnectionString = @"Data Source = (localdb)\MSSQLLocalDB; Initial Catalog = ActsDec2023; Integrated Security = True; Connect Timeout = 30; Encrypt = False; Trust Server Certificate = False; Application Intent = ReadWrite; Multi Subnet Failover = False";
            try
            {
                cn.Open();
                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        static void Connect2()
        {
            using (SqlConnection cn = new SqlConnection())
            {
                cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
                try
                {
                    cn.Open();
                    Console.WriteLine("success");
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);
                }
               
            }
            
        }

        static void Insert1()
        {
            SqlConnection cn = new SqlConnection();
            //cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;User Id=sa;Password=pwd";
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = CommandType.Text;
                cmdInsert.CommandText = "insert into Employees values(1,'Jatin', 12345, 30)";
                cmdInsert.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        static void Insert2(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            //cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;User Id=sa;Password=pwd";
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = CommandType.Text;

                // syntax error for -> this emp Name -> using string literals
                //Employee obj = new Employee { EmpNo = 7, Name = "D'Silva", Basic = 99999, DeptNo = 20 };
                cmdInsert.CommandText = $"insert into Employees values({obj.EmpNo},{obj.Name}, {obj.Basic}, {obj.DeptNo})";

                Console.WriteLine(cmdInsert.CommandText);
                Console.ReadLine();
                cmdInsert.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }
        //parameters
        static void Insert3(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = CommandType.Text;
                cmdInsert.CommandText = "insert into Employees values(@EmpNo,@Name,@Basic,@DeptNo)";

                cmdInsert.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
                cmdInsert.Parameters.AddWithValue("@Basic", obj.Basic);
                cmdInsert.Parameters.AddWithValue("@DeptNo", obj.DeptNo);


                cmdInsert.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        //stored procedure
        static void Insert4(Employee obj)
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = CommandType.StoredProcedure;
                cmdInsert.CommandText = "InsertEmployee";

                cmdInsert.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
                cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
                cmdInsert.Parameters.AddWithValue("@Basic", obj.Basic);
                cmdInsert.Parameters.AddWithValue("@DeptNo", obj.DeptNo);
                cmdInsert.ExecuteNonQuery();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        static void SelectSingleValue()
        {
            SqlConnection cn = new SqlConnection();
            //cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;User Id=sa;Password=pwd";
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select Name from Employees where EmpNo=1";
                //cmd.CommandText = "select count(*) from Employees ";
                //cmd.CommandText = "select * from Employees ";
                object retval = cmd.ExecuteScalar();
                Console.WriteLine(retval);
                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        //select multiple values
        static void DataReader1()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees ";
                
                SqlDataReader dr = cmd.ExecuteReader();
                //dr.HasRows  //---returns true if at least 1 row
                while (dr.Read()) 
                {
                    Console.WriteLine(dr[1]);
                    Console.WriteLine(dr["Name"]);
                    //Employee o = new Employee();
                    //o.Name = dr["Name"].ToString();
                    //o.EmpNo = (int)dr["EmpNo"];

                    //o.Name = dr.GetString(1);
                    //o.Name = dr.GetString("Name");
                    //o.EmpNo = dr.GetInt32("EmpNo");

                }
                dr.Close();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        static void DataReader2()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "select * from Employees;select * from departments ";

                SqlDataReader dr = cmd.ExecuteReader();

                while (dr.Read())
                {
                    Console.WriteLine(dr[1]);
                    Console.WriteLine(dr["Name"]);
                    //Employee o = new Employee();
                    //o.Name = dr["Name"].ToString();
                    //o.EmpNo = (int)dr["EmpNo"];

                    //o.Name = dr.GetString(1);
                    //o.Name = dr.GetString("Name");
                    //o.EmpNo = dr.GetInt32("EmpNo");

                }
                Console.WriteLine();
                dr.NextResult();
                while (dr.Read())
                {
                    Console.WriteLine(dr["DeptName"]);
                }
                dr.Close();

                Console.WriteLine("success");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }
        }

        //TO DO - ALSO CALLED LAB ASSIGNMENT
        static Employee GetSingleEmployee(int EmpNo)
        {
            // select single employee by empno
            Employee obj = new Employee();

            // open a connection 

            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;";


            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = "SELECT * FROM Employees WHERE EmpNo = @EmpNo";

                cmd.Parameters.AddWithValue("@EmpNo", EmpNo);

                SqlDataReader dr = cmd.ExecuteReader();

                if (dr.Read())
                {
//                    Console.WriteLine(dr[0] + " " + dr[1] + " " + dr[2] + " " + dr[3]);
                    obj.EmpNo = dr.GetInt32(0);
                    obj.Name = dr.GetString(1);
                    obj.Basic = dr.GetDecimal(2);
                    obj.DeptNo = dr.GetInt32(3);

                }

                Console.WriteLine(obj);
                return obj;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }



            return obj;
        }

        // lab work

        // add a method to return list of All the employees
        static List<Employee> GetAllEmployees()
        {
            List<Employee> list = new List<Employee>();

            SqlConnection cn = new SqlConnection();

            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;Connect Timeout=30;Encrypt=True;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;
                cmd.CommandText = @"Select * from Employees";

                SqlDataReader dr = cmd.ExecuteReader();

                while(dr.Read())
                {
                    Employee obj = new Employee();
                    obj.EmpNo = dr.GetInt32(0);
                    obj.Name = dr.GetString(1);
                    obj.Basic = dr.GetDecimal(2);
                    obj.DeptNo = dr.GetInt32(3);

                    list.Add(obj);
                }


            }
            catch(Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close() ;
            }

            /*foreach (var item in list)
            {
                Console.WriteLine(item);
            }*/

            return list;
        }

        // add a method to update the employee details

        static void UpdateEmployee(Employee emp)
        {

            // create connection instance
            SqlConnection cn = new SqlConnection();
            // set connection string
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;Connect Timeout=30;Encrypt=True;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";



            // try
            // open connection using sql connection


            // catch
            // throw exp

            // finally
            // close the connection

            try
            {
                cn.Open();

                // create instance of sql command
                // set cmd connection
                // set cmd CommandType
                // set cmd CommandText
                // execute cmd


                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.Text;

                // update only non - primary key fields
                cmd.CommandText = "update Employees set Name = @Name, DeptNo = @DeptNo, Basic = @Basic where EmpNo = @EmpNo";

                // set paratemers
                

                cmd.Parameters.Add(new SqlParameter("@Name", emp.Name));
                cmd.Parameters.Add(new SqlParameter("@Basic", emp.Basic));
                cmd.Parameters.Add(new SqlParameter("@DeptNo", emp.DeptNo));
                cmd.Parameters.Add(new SqlParameter("@EmpNo", emp.EmpNo));

                // execute

                // returns the number of rows affected
                cmd.ExecuteNonQuery();

            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
            finally
            {
                cn.Close();
            }



        }

        // add a method to delete the employee by Employee Number

        static void DeleteEmployee(int EmpNo)
        {
            SqlConnection cn = new SqlConnection();

            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True;Connect Timeout=30;Encrypt=True;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";
            try
            {
                cn.Open();
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = cn;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "DeleteEmployee";

                cmd.Parameters.AddWithValue("@EmpNo", EmpNo);

                cmd.ExecuteNonQuery();

                Console.WriteLine("Deleted Successfully");


            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                cn.Close();
            }

            
        }




        static void MARS()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MsSqlLocalDb;Initial Catalog=ActsDec2023;Integrated Security=true;MultipleActiveResultSets=true";
            cn.Open();

            SqlCommand cmdDepts = new SqlCommand();
            cmdDepts.Connection = cn;
            cmdDepts.CommandType = CommandType.Text;
            cmdDepts.CommandText = "Select * from Departments";

            SqlCommand cmdEmps = new SqlCommand();
            cmdEmps.Connection = cn;
            cmdEmps.CommandType = CommandType.Text;

            SqlDataReader drDepts = cmdDepts.ExecuteReader();
            while (drDepts.Read())
            {
                Console.WriteLine((drDepts["DeptName"]));

                cmdEmps.CommandText = "Select * from Employees where DeptNo = " + drDepts["DeptNo"];
                SqlDataReader drEmps = cmdEmps.ExecuteReader();
                while (drEmps.Read())
                {
                    Console.WriteLine(("    " + drEmps["Name"]));
                }
                drEmps.Close();
            }
            drDepts.Close();
            cn.Close();

        }
        static void CallFuncReturningSqlDataReader()
        {
            SqlDataReader dr = GetDataReader();
            while (dr.Read())
            {
                Console.WriteLine(dr[1]);
            }
            dr.Close();
        }
        static SqlDataReader GetDataReader()
        {
            SqlConnection cn = new SqlConnection();
            cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True";
            cn.Open();
            SqlCommand cmdInsert = new SqlCommand();
            cmdInsert.Connection = cn;
            cmdInsert.CommandType = System.Data.CommandType.Text;
            cmdInsert.CommandText = "select * from Employees ";
            //SqlDataReader dr = cmdInsert.ExecuteReader();
            SqlDataReader dr = cmdInsert.ExecuteReader(CommandBehavior.CloseConnection);
            //cn.Close();
            return dr;
        }

        static void Transactions()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True";
            cn.Open();
            SqlTransaction t = cn.BeginTransaction();

            SqlCommand cmdInsert = new SqlCommand();
            cmdInsert.Connection = cn;
            cmdInsert.Transaction = t;

            cmdInsert.CommandType = System.Data.CommandType.Text;
            cmdInsert.CommandText = "insert into Employees values(10, 'Shweta', 12345, 30)";

            SqlCommand cmdInsert2 = new SqlCommand();
            cmdInsert2.Connection = cn;
            cmdInsert2.Transaction = t;

            cmdInsert2.CommandType = System.Data.CommandType.Text;
            cmdInsert2.CommandText = "insert into Employees values(20, 'Shweta', 12345, 30)";
            try
            {
                cmdInsert.ExecuteNonQuery();
                cmdInsert2.ExecuteNonQuery();
                t.Commit();
                Console.WriteLine("no errors- commit");
            }
            catch (Exception ex)
            {
                t.Rollback();
                Console.WriteLine("Rollback");
                Console.WriteLine(ex.Message);
            }
            cn.Close();

        }

        static async void AsyncConnCode()
        {
            SqlConnection conn = new SqlConnection();
            conn.ConnectionString = "";
            Task t = conn.OpenAsync();
            //do other code here

            if (!t.IsCompleted)
                t.Wait();
            //code after conn is opened
            await conn.CloseAsync();
        }
        static async void AsyncConnCode2()
        {
            SqlConnection conn = new SqlConnection();
            conn.ConnectionString = "";
            await conn.OpenAsync();
            //
            await conn.CloseAsync();
        }


        static async void AsyncCommand()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsJan23;Integrated Security=True";

            await cn.OpenAsync();  //async connection
            try
            {
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = CommandType.Text;
                cmdInsert.CommandText = "insert into Employees values(40,'Ganesh',10000,20)";

                await cmdInsert.ExecuteNonQueryAsync();
                //object o = await cmdInsert.ExecuteScalarAsync();

                Console.WriteLine("okay");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            if (cn.State == ConnectionState.Open)
                cn.Close();

        }

        static void AsyncCommand2()
        {
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsJan23;Integrated Security=True";

            cn.Open();

            SqlCommand cmdInsert = new SqlCommand();
            cmdInsert.Connection = cn;
            cmdInsert.CommandType = CommandType.Text;
            cmdInsert.CommandText = "Select * from Employees";
            //SqlDataReader dr = await cmdInsert.ExecuteReaderAsync();

            //cmdInsert.BeginExecuteReader(CallBackFunc, null);
            
            cmdInsert.BeginExecuteReader(delegate (IAsyncResult ar)
            {
                SqlDataReader dr = cmdInsert.EndExecuteReader(ar);
                while (dr.Read())
                {
                    Console.WriteLine(dr["Name"]);
                    //Console.WriteLine(dr[1]);
                }
                dr.Close();
                cn.Close();
            }, null);

            Console.WriteLine("code after begin....");


            Console.ReadLine();
        }
        //static void CallBackFunc(IAsyncResult ar)
        //{
        //    SqlDataReader dr = cmdInsert.EndExecuteReader(ar);

        //}
    }
    public class Employee
    {
        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Basic { get; set; }
        public int DeptNo { get; set; }


        override

        public string ToString()
        {
            return this.EmpNo + " " + this.Name;
        }

    }
}