namespace WebApplication1
{
    public class Program
    {
        public static void Main(string[] args)
        {
            //var builder = WebApplication.CreateBuilder(args);

            WebApplicationBuilder builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddControllersWithViews();

            //var app = builder.Build();

            WebApplication app = builder.Build();

            // Configure the HTTP request pipeline.

            /* 
             * when server receives the request 
             * between the server and controller it goes through set of steps 
             */
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
            }

            /*
             * to wwwroot folder to work / to enabled
             * UseStaticFiles(); is used
             */
            app.UseStaticFiles();

            /* 
             * enable the url to be recognized 
             * to execute a particular business logic
             
             */
            app.UseRouting();


            /*
             * 
             * Authentication -> deals with identity of person
             * Authorization -> permission deals with authorization
             */


            app.UseAuthorization();



            //app.MapControllerRoute(
            //    name: "default", // it can be any name
            //    pattern: "{controller=Home}/{action=Index}/{id?}"); // only valid url pattern this website contain
            //              default controller  = Home
            //              name of controller - suffix
            // -> {controller=Home}

            // by default index method would execute -> {action=Index}

            // {id?} -> ? denotes it might not be passed



            // we can give other patterns aswell 


            //app.MapControllerRoute(
            //    name: "Emp",
            //    pattern: "Employees/{action=index}/{id?}");



            app.MapControllerRoute(
                name: "default", // it can be any name
                pattern: "{controller=Default}/{action=Index}/{id?}"); // only valid url pattern this website contain


            app.MapControllerRoute(
               name: "default", // it can be any name
               pattern: "{controller=Default}/{action=Index}/{id?}/{a}/{b}");

            app.Run();
        }
    }
}
