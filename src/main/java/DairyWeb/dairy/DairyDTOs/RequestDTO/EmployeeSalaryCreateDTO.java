package DairyWeb.dairy.DairyDTOs.RequestDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeSalaryCreateDTO {
    @NotNull(message = "Please provide employee id")
    private Long employeeId;
    @Positive
    @NotNull(message = "Please provide monthly salary")
    private BigDecimal monthlySalary;
    @NotNull(message = "Please provide effective from date")
    private LocalDate effectiveFrom;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
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
    @NotNull(message = "Please provide effective to date")
    private LocalDate effectiveTo;
}
