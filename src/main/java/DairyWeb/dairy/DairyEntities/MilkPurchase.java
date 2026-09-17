package DairyWeb.dairy.DairyEntities;

import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "milkPurchase")
public class MilkPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate purchaseDate;
    private BigDecimal quantity;
    private BigDecimal rate;

    @ManyToOne
    @JoinColumn(name="seller_id" , nullable = false)
    private Seller seller;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
    public  MilkPurchase(){

    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public MilkPurchase(Long id, LocalDate purchaseDate, BigDecimal quantity, BigDecimal rate, Seller seller, AnimalType animalType, MilkShifts shift, BigDecimal amount) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.rate = rate;
        this.seller = seller;
        this.animalType = animalType;
        this.shift = shift;
        this.amount = amount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    public MilkShifts getShift() {
        return shift;
    }

    public void setShift(MilkShifts shift) {
        this.shift = shift;
    }

    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    @Enumerated(EnumType.STRING)
    private MilkShifts shift;
    private BigDecimal amount;

}
