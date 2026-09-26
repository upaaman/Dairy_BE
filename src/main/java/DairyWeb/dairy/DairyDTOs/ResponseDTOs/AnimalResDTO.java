package DairyWeb.dairy.DairyDTOs.ResponseDTOs;

import DairyWeb.dairy.DairyEntities.Expense;
import DairyWeb.dairy.DairyEntities.MilkProduction;
import DairyWeb.dairy.DairyEnums.AnimalGender;
import DairyWeb.dairy.DairyEnums.AnimalStatus;
import DairyWeb.dairy.DairyEnums.AnimalType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AnimalResDTO {
    private AnimalGender gender;
    private String breed;
    private String name;
    private Boolean active;
    private AnimalResDTO mother;
    private List<AnimalResDTO> childAnimals;


    public AnimalGender getGender() {
        return gender;
    }

    public AnimalResDTO getMother() {
        return mother;
    }

    public void setMother(AnimalResDTO mother) {
        this.mother = mother;
    }

    public List<AnimalResDTO> getChildAnimals() {
        return childAnimals;
    }

    public void setChildAnimals(List<AnimalResDTO> childAnimals) {
        this.childAnimals = childAnimals;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalStatus getStatus() {
        return status;
    }

    public void setStatus(AnimalStatus status) {
        this.status = status;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    private AnimalStatus status;
    private AnimalType type;

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    private List<MilkProduction> milkProductionList;
    private BigDecimal totalMilkProduced;

    private LocalDate dateOfPurchase;

    public List<MilkProduction> getMilkProductionList() {
        return milkProductionList;
    }

    public void setMilkProductionList(List<MilkProduction> milkProductionList) {
        this.milkProductionList = milkProductionList;
    }

    public BigDecimal getTotalMilkProduced() {
        return totalMilkProduced;
    }

    public void setTotalMilkProduced(BigDecimal totalMilkProduced) {
        this.totalMilkProduced = totalMilkProduced;
    }

    private LocalDate dateOfBirth;
    private BigDecimal purchasePrice;
    private String notes;
    private BigDecimal totalExpense;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Expense> getExpenseRecordOfAnimal() {
        return expenseRecordOfAnimal;
    }

    public void setExpenseRecordOfAnimal(List<Expense> expenseRecordOfAnimal) {
        this.expenseRecordOfAnimal = expenseRecordOfAnimal;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private List<Expense> expenseRecordOfAnimal;

    public BigDecimal getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(BigDecimal totalExpense) {
        this.totalExpense = totalExpense;
    }
}
