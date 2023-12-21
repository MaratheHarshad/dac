using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace MVCUsingEF.Models;

public partial class TblEmployee
{

    [Required(ErrorMessage = "Required Field")]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    [Display(Name = "Employee Id")]
    public int EmployeeId { get; set; }

    [Display(Name = "Employee Name")]
    public string EmployeeName { get; set; } = null!;

    public string EmployeeCity { get; set; } = null!;

    [DataType(DataType.Date)]
    public DateOnly EmployeeDob { get; set; }

    public string? EmployeeGender { get; set; }

    public decimal EmployeeSalary { get; set; }
}
