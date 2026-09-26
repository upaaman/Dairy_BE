package DairyWeb.dairy.DairyEntities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Vaccine() {
    }

    private String vaccineName;
    private LocalDate vaccineDate;

    public Animal getAnimal() {
        return animal;
    }

    public Vaccine(Long id, String vaccineName, LocalDate vaccineDate, Animal animal, String notes) {
        this.id = id;
        this.vaccineName = vaccineName;
        this.vaccineDate = vaccineDate;
        this.animal = animal;
        this.notes = notes;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public LocalDate getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(LocalDate vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @ManyToOne
    @JoinColumn(name = "animal_id",nullable = false)
    private Animal animal;
    private String notes;
}
