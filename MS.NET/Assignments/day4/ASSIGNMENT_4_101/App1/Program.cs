namespace App1
{
    internal class Program
    {
        static void Main1(string[] args)
        {
            Dictionary<int, Employee> employeeDict = new Dictionary<int, Employee>();

            employeeDict.Add(1, new Employee("Harshad", 100000, 1));
            employeeDict.Add(2, new Employee("Manish", 150000, 2));
            employeeDict.Add(3, new Employee("Khagesh", 50000, 1));
            employeeDict.Add(4, new Employee("Rushikesh", 40000, 2));
            employeeDict.Add(5, new Employee("Prashant", 100000, 1));
            employeeDict.Add(5, new Employee("Prashant", 100000, 1));

            foreach (KeyValuePair<int, Employee> item in employeeDict)
            {
                Console.WriteLine(item.Key);
                Console.WriteLine(item.Value);
            }
        }
        static void Main()
        {
            List<Employee> employeeList = new List<Employee>();
            employeeList.Add(new Employee("Harshad", 100000, 1));
            employeeList.Add(new Employee("Manish", 150000, 2));
            employeeList.Add(new Employee("Khagesh", 50000, 1));
            employeeList.Add(new Employee("Rushikesh", 40000, 2));
            employeeList.Add(new Employee("Prashant", 100000, 1));

            //displayList(employeeList);
            displaySorted(employeeList);


        }
        static void displaySorted(List<Employee> list)
        {
            list.Sort();
            Console.WriteLine("Sorted:");
            displayList(list);
        }
        static void displayList(List<Employee> list)
        {
            foreach (Employee item in list)
            {
                Console.WriteLine(item);
            }
        }
    }
    public class Employee : IComparable<Employee>
    {
        private static int lastEmpNo;
        int empNo;
        string name;
        decimal basic;
        short deptNo;

        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                if (value != null)
                    name = value;
                else
                    Console.WriteLine("Invalid Name");
            }
        }

        public int EmpNo
        {
            get
            {
                return empNo;
            }
            set
            {
                empNo = value;
            }
        }

        public decimal Basic
        {
            get
            {
                return basic;
            }
            set
            {
                if (value < 10000 || value > 200000)
                    Console.WriteLine("Invalid Basic");
                else
                    basic = value;
            }
        }

        public short DeptNo
        {
            get
            {
                return deptNo;
            }
            set
            {
                if (value > 0)
                    deptNo = value;
                else
                    Console.WriteLine("Invalid DeptNo");
            }
        }


        public Employee(string Name = "default", decimal Basic = 10000, short DeptNo = 1)
        {
            empNo = ++lastEmpNo;
            this.Name = Name;
            this.Basic = Basic;
            this.DeptNo = DeptNo;
        }

        public override string ToString()
        {
            return "EmpNo: " + EmpNo + " " + "Name: " + Name + " " + "Basic: " + Basic + " " + " DeptNo: " + DeptNo;
        }


        // Sorted in ascending order
        public int CompareTo(Employee? other)
        {


            if (this.Basic < other.Basic)
                return -1;
            else
            {
                return 1;
            }
        }


    }
}
