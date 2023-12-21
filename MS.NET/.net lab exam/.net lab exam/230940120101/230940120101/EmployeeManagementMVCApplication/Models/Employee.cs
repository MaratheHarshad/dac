using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace EmployeeManagementMVCApplication.Models
{
    // class Employee With validations
    public class Employee
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int EmployeeId { get; set; }

        [Required(ErrorMessage = "Employee Name is Required")]
        [DataType(DataType.Text)]
        [Display(Name = "Employee Name")]

        public string? EmployeeName { get; set; }




        [Required(ErrorMessage = "City is Required")]
        [DataType(DataType.Text)]
        [Display(Name = "Employee City")]

        public string? EmployeeCity { get; set; }
        [Required(ErrorMessage = "Address is Required")]
        [DataType(DataType.Text)]
        [Display(Name = "Employee Address")]
        [MaxLength(500, ErrorMessage = "Address length should be less than 500 charactesr")]
        public string? EmployeeAddress { get; set; }





    }
}
