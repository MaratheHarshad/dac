
namespace WebApiUsingEF
{

    // steps 
    /*  
     *  install Microsoft.EntityFrameworkSqlServer
     *  install Microsoft.EntityFrameworkCore
     *  instal
     *  Scaffold-DbContext "Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=EmployeesMVCDatabase;Integrated Security=True" Microsoft.EntityFrameWorkCore.SqlServer -OutputDir Models
     *  Scaffold-DbContext "Data Source=(localdb)\MsSqlLocalDb;Initial Catalog=EmployeesMVCDatabase;Integrated Security=True" Microsoft.EntityFrameworkCore.SqlServer -OutputDir Models
     *  Scaffold-DbContext "Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=EmployeesMVCDatabase;Integrated Security=True" Microsoft.EntityFrameworkCore.SqlServer -OutputDir Models
     */  
     
    public class Program
{
    public static void Main(string[] args)
    {
        var builder = WebApplication.CreateBuilder(args);

        // Add services to the container.

        builder.Services.AddControllers();
        // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
        builder.Services.AddEndpointsApiExplorer();
        builder.Services.AddSwaggerGen();

        var app = builder.Build();

        // Configure the HTTP request pipeline.
        if (app.Environment.IsDevelopment())
        {
            app.UseSwagger();
            app.UseSwaggerUI();
        }

        app.UseAuthorization();


        app.MapControllers();

        app.Run();
    }
}
}
