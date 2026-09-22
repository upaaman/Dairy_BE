package DairyWeb.dairy.DairyEntities;

import DairyWeb.dairy.DairyEnums.ExpenseType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ExpenseType type;
    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    private LocalDate expenseDate;
    private String notes;
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public Expense() {
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Expense(Long id, ExpenseType type, Long amount, LocalDate expenseDate, String notes, Animal animal) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.notes = notes;
        this.animal = animal;
    }
}
