package DairyWeb.dairy.DairyEntities;

import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class MilkSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate saleDate;
    private BigDecimal quantity;
    private BigDecimal rate;

    public MilkSale() {
    }


    @Enumerated(EnumType.STRING)
    private MilkShifts shift;

    public Long getId() {
        return id;
    }

    public MilkSale(Long id, LocalDate saleDate, BigDecimal quantity, BigDecimal rate, MilkShifts shift, AnimalType animalType, Customer customer, BigDecimal amount) {
        this.id = id;
        this.saleDate = saleDate;
        this.quantity = quantity;
        this.rate = rate;
        this.shift = shift;
        this.animalType = animalType;
        this.customer = customer;
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public MilkShifts getShift() {
        return shift;
    }

    public void setShift(MilkShifts shift) {
        this.shift = shift;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Enumerated(EnumType.STRING)
    private AnimalType animalType ;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
