package DairyWeb.dairy.DairyDTOs.ResponseDTOs;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDetailsResDTO {
    private String name;
    private String notes;
    private Boolean status;
    private String address;
    private String contact;
    private BigDecimal totalRemainingAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalRemainingAmount() {
        return totalRemainingAmount;
    }

    public void setTotalRemainingAmount(BigDecimal totalRemainingAmount) {
        this.totalRemainingAmount = totalRemainingAmount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public List<EmployeeSalaryResDTO> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<EmployeeSalaryResDTO> salaries) {
        this.salaries = salaries;
    }

    private LocalDate dateOfJoining;
    private List<EmployeeSalaryResDTO> salaries;
}
