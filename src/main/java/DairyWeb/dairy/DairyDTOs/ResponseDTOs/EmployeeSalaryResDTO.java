package DairyWeb.dairy.DairyDTOs.ResponseDTOs;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeSalaryResDTO {
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private BigDecimal monthlySalary;
    private Long id;

    public LocalDate getEffectiveFrom() {
        return effectiveFrom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

}
