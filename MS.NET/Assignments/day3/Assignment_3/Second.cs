using System.Security.Cryptography.X509Certificates;

namespace Assignment_3
{

    /*
     
        
        2. Create an array of Employee class objects
            Accept details for all Employees
            Display the Employee with highest Salary
            Accept EmpNo to be searched. Display all details for that employee.

     */
    internal class Second
    {
        static void Main()
        {
            Console.WriteLine("Enter the number of Employees : ");
            Employee[] employees = new Employee[int.Parse(Console.ReadLine())];

            int index = 0;

            bool flag = true;

            while (flag)
            {

                Console.WriteLine("Enter choice: ");
                Console.WriteLine("1. Add new Employee");
                Console.WriteLine("2. Display the employee with highest salary");
                Console.WriteLine("3. Enter empNo to display the information");

                switch (int.Parse(Console.ReadLine()))
                {
                    case 1:
                        {
                            if(index < employees.Length)
                            {
                                Console.WriteLine("Enter emp name and salary");
                                Employee emp = new Employee(Console.ReadLine(), int.Parse(Console.ReadLine()));
                                employees[index++] = emp;
                            }
                            else
                            {
                                Console.WriteLine("Array Full");
                            }
                            
                            break;
                        }

                    case 2:
                        {
                            Employee emp = EmployeeWithHighestSalary(employees);
                            Console.WriteLine("Employee with highest salary " + emp);
                            break;
                        }

                    case 3:
                        {
                            Console.WriteLine("Enter employee number to display information");
                            int empNo = int.Parse(Console.ReadLine());

                            if(empNo > index + 1)
                            {
                                Console.WriteLine("Employee not exist");
                            }
                            else
                            {
                                Console.WriteLine(employees[empNo - 1]);
                            }

                            break;
                        }
                    case 4:
                        {
                            flag = false;
                            break;
                        }
                    default:
                        {
                            Console.WriteLine("Enter valid choice");
                            break;
                        }
                }

            }

            static Employee EmployeeWithHighestSalary(Employee[] employees)
            {

                Employee e = null;

                foreach (Employee emp in employees)
                {
                    if(e == null)
                    {
                        e = emp;
                    }
                    else if(e.Salary < emp.Salary) { }
                    {
                        e = emp;
                    }
                }

                /*Console.WriteLine(e);*/
                return e;
            }

            
        }
    }

    class Employee
    {

        private static int ctr = 0;



        public int EmpNo { get; set; }
        public string Name { get; set; }
        public decimal Salary { get; set; }

        public Employee(string name, decimal salary)
        {
            this.EmpNo = ++ctr;
            this.Name = name;
            this.Salary = salary;
        }

        override
        public string ToString()
        {

            return this.Name + ", " + this.Salary;
        }

    }
}
