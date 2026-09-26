package DairyWeb.dairy.DairyEntities;

import DairyWeb.dairy.DairyEnums.BreedingMethod;
import DairyWeb.dairy.DairyEnums.BreedingStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Breeding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="breeded_animal_id" , nullable = false)
    private Animal animal;
    private LocalDate breedingDate;
    private BreedingMethod method;

    @Override
    public String toString() {
        return "Breeding{" +
                "id=" + id +
                ", animal=" + animal +
                ", breedingDate=" + breedingDate +
                ", method=" + method +
                ", expectedCalvingDate=" + expectedCalvingDate +
                ", actualCalvingDate=" + actualCalvingDate +
                ", notes='" + notes + '\'' +
                ", status=" + status +
                ", producedAnimal=" + producedAnimal +
                '}';
    }

    private LocalDate expectedCalvingDate;
    private LocalDate actualCalvingDate;
    private String notes;
    private BreedingStatus status;
    @ManyToOne
    @JoinColumn(name="produced_animal_id" , nullable = true)
    private Animal producedAnimal;

    public Breeding() {
    }

    public Breeding(Long id, Animal animal, LocalDate breedingDate, BreedingMethod method, LocalDate expectedCalvingDate, LocalDate actualCalvingDate, String notes, BreedingStatus status, Animal producedAnimal) {
        this.id = id;
        this.animal = animal;
        this.breedingDate = breedingDate;
        this.method = method;
        this.expectedCalvingDate = expectedCalvingDate;
        this.actualCalvingDate = actualCalvingDate;
        this.notes = notes;
        this.status = status;
        this.producedAnimal = producedAnimal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public LocalDate getBreedingDate() {
        return breedingDate;
    }

    public void setBreedingDate(LocalDate breedingDate) {
        this.breedingDate = breedingDate;
    }

    public BreedingMethod getMethod() {
        return method;
    }

    public void setMethod(BreedingMethod method) {
        this.method = method;
    }

    public LocalDate getExpectedCalvingDate() {
        return expectedCalvingDate;
    }

    public void setExpectedCalvingDate(LocalDate expectedCalvingDate) {
        this.expectedCalvingDate = expectedCalvingDate;
    }

    public LocalDate getActualCalvingDate() {
        return actualCalvingDate;
    }

    public void setActualCalvingDate(LocalDate actualCalvingDate) {
        this.actualCalvingDate = actualCalvingDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public BreedingStatus getStatus() {
        return status;
    }

    public void setStatus(BreedingStatus status) {
        this.status = status;
    }

    public Animal getProducedAnimal() {
        return producedAnimal;
    }

    public void setProducedAnimal(Animal producedAnimal) {
        this.producedAnimal = producedAnimal;
    }
}
