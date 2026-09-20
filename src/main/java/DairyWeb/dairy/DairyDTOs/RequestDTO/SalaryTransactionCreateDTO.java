package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyEntities.Employee;
import DairyWeb.dairy.DairyEnums.SalaryTransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalaryTransactionCreateDTO {
    @NotNull(message = "Please provide employee id")
    private Long employeeId;
    @NotNull(message = "Please provide transaction date")
    private LocalDate transactionDate;
    @NotNull(message = "Please provide amount")
    private BigDecimal amount;
    @NotNull(message = "Please provide salary month")
    private String salaryMonth;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(String salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public SalaryTransactionType getType() {
        return type;
    }

    public void setType(SalaryTransactionType type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    @NotNull(message = "Please provide type of transaction")
    private SalaryTransactionType type;
    private String notes;
}
