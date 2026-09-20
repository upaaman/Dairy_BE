package DairyWeb.dairy.DairyEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please enter employee name.")
    private String name;
    @NotBlank(message = "Please enter employee notes.")
    private String notes;
    @NotNull(message = "Please select status of employee.")
    private Boolean status;

    public Employee() {
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Employee(Long id, String name, String notes, Boolean status, String address, String contact, LocalDate dateOfJoining) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.status = status;
        this.address = address;
        this.contact = contact;
        this.dateOfJoining = dateOfJoining;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @NotBlank(message = "Please enter employee address.")
    private String address;
    @NotBlank(message = "Please enter employee contact.")
    private String contact;
    @NotNull(message = "Please enter employee date of joining.")
    private LocalDate dateOfJoining;
}
