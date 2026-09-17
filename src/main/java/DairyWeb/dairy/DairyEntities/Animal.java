package DairyWeb.dairy.DairyEntities;

import DairyWeb.dairy.DairyEnums.AnimalGender;
import DairyWeb.dairy.DairyEnums.AnimalStatus;
import DairyWeb.dairy.DairyEnums.AnimalType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "animals")
public class Animal{

    public  Animal(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnimalGender getGender() {
        return gender;
    }

    public void setGender(AnimalGender gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public AnimalStatus getStatus() {
        return status;
    }

    public void setStatus(AnimalStatus status) {
        this.status = status;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(Long id, AnimalGender gender, String breed, BigDecimal purchasePrice, String name, LocalDate dateOfBirth, LocalDate dateOfPurchase, AnimalStatus status, AnimalType type,String notes) {
        this.id = id;
        this.gender = gender;
        this.breed = breed;
        this.purchasePrice = purchasePrice;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfPurchase = dateOfPurchase;
        this.status = status;
        this.type = type;
        this.notes=notes;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    private AnimalGender gender;
    private String breed;
    private BigDecimal purchasePrice;
    private String name;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    private LocalDate dateOfBirth;
    private LocalDate dateOfPurchase;
    private String notes;

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    @Enumerated(EnumType.STRING)
    private AnimalStatus status;
    @Enumerated(EnumType.STRING)
    private AnimalType type;
}