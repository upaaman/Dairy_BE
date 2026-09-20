package DairyWeb.dairy.DairyEntities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class EmployeeSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeSalary() {
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(LocalDate effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public LocalDate getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(LocalDate effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public EmployeeSalary(Long id, Employee employee, LocalDate effectiveFrom, LocalDate effectiveTo, BigDecimal monthlySalary) {
        this.id = id;
        this.employee = employee;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
        this.monthlySalary = monthlySalary;
    }

    private BigDecimal monthlySalary;

}
