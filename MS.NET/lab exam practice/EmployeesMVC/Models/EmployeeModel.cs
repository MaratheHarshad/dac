using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace EmployeesMVC.Models
{
    public class EmployeeModel
    {


        [Key]
        [Display(Name = "Employee Id ")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int EmployeeId { get; set; }

        [DataType(DataType.Text)]

        [Required(ErrorMessage = "Please enter your name"), MaxLength(50)]
        public string? EmployeeName { get; set; }

        [DataType(DataType.Text)]
        public string? EmployeeCity { get; set; }

        [Required(ErrorMessage = "Please enter your birth date")]


        [DataType(DataType.Date)]
        [Column(TypeName = "date")]
        [Display(Name = "Date of Birth")]

        
        public DateTime EmployeeDOB { get; set; }

        [DataType(DataType.Text)]

        [Display(Name = "Employee Gender")]
        public string? EmployeeGender { get; set; }

        [Display(Name = "Employee Salary")]
        public decimal EmployeeSalary { get; set; }


    }
}
