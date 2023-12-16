using System.Text;

namespace FileHandling
{
    internal class Program
    {
        static void Main1()
        {


            /*Directory.CreateDirectory("D:\\aaaa");*/
/*
            CreateTextFile1();
            ReadTextFile1();
*/
            

        }

        static void Main()
        {
            Directory.CreateDirectory("D:\\aaaa");


            CreateTextFile2();
            ReadTextFile2();

            Console.ReadLine();

        }
        /*private static void CreateTextFile1()
        {
            
            StreamWriter writer = File.CreateText("D:\\aaaa\\a.txt");
            writer.WriteLine("Hello World");
            writer.WriteLine("Line 2");
            writer.WriteLine("Done for the day");

            writer.Close();
        }*/

        private static void CreateTextFile2()
        {

            /*StreamWriter writer = File.CreateText("D:\\aaaa\\a.txt");
            writer.WriteLine("Hello World");
            writer.WriteLine("Line 2");
            writer.WriteLine("Done for the day");
*/

            FileStream stream = File.Open(@"D:\aaaa\b.txt", FileMode.Create);

            String s = "This is text going to be in byte array";

            byte[] array = Encoding.Default.GetBytes(s);    

            stream.Write(array, 0, array.Length);

            stream.Close();

        }

       /* static void ReadTextFile1()
        {
            string s;
            StreamReader reader = File.OpenText("D:\\aaaa\\a.txt");
            while ((s = reader.ReadLine()) != null)
            {
                Console.WriteLine(s);
            }

            
            reader.Close();
        }*/



        private static void ReadTextFile2()
        {

           
            FileStream stream = File.Open(@"D:\aaaa\b.txt", FileMode.Open);

            byte[] array = new byte[stream.Length]; 
            stream.Read(array, 0, (int)(stream.Length));

            Console.WriteLine(array.);

            stream.Close();

        }



    }
    }