package DairyWeb.dairy.DairyEntities;

import DairyWeb.dairy.DairyEnums.SalaryTransactionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class SalaryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private LocalDate transactionDate;

    private BigDecimal amount;

    public SalaryTransaction() {
    }

    public Long getId() {
        return id;
    }

    public SalaryTransaction(Long id, Employee employee, LocalDate transactionDate, BigDecimal amount, String salaryMonth, SalaryTransactionType type, String notes) {
        this.id = id;
        this.employee = employee;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.salaryMonth = salaryMonth;
        this.type = type;
        this.notes = notes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    private String salaryMonth;

    @Enumerated(EnumType.STRING)
    private SalaryTransactionType type;

    private String notes;

}
