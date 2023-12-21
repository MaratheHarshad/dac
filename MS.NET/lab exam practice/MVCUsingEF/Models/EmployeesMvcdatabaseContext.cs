using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace MVCUsingEF.Models;

public partial class EmployeesMvcdatabaseContext : DbContext
{
    public EmployeesMvcdatabaseContext()
    {
    }

    public EmployeesMvcdatabaseContext(DbContextOptions<EmployeesMvcdatabaseContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Table> Tables { get; set; }

    public virtual DbSet<TblEmployee> TblEmployees { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Data Source=(localdb)\\MsSqlLocalDb;Initial Catalog=EmployeesMVCDatabase;Integrated Security=true");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Table>(entity =>
        {
            entity.HasKey(e => e.Id).HasName("PK__Table__3214EC072B9D5D58");

            entity.ToTable("Table");

            entity.Property(e => e.Id).ValueGeneratedNever();
        });

        modelBuilder.Entity<TblEmployee>(entity =>
        {
            entity.HasKey(e => e.EmployeeId).HasName("PK__tbl_Empl__7AD04F11D899DCB4");

            entity.ToTable("tbl_Employees");

            entity.Property(e => e.EmployeeCity)
                .HasMaxLength(50)
                .IsUnicode(false);
            entity.Property(e => e.EmployeeDob).HasColumnName("EmployeeDOB");
            entity.Property(e => e.EmployeeGender)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.EmployeeName)
                .HasMaxLength(50)
                .IsUnicode(false);
            entity.Property(e => e.EmployeeSalary).HasColumnType("decimal(18, 2)");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
