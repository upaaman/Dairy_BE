package DairyWeb.dairy.DairyEntities;

import DairyWeb.dairy.DairyEnums.MilkShifts;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class MilkProduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public MilkProduction() {

    }
    @Enumerated(EnumType.STRING)
    private MilkShifts productionShift;


    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public MilkShifts getProductionShift() {
        return productionShift;
    }

    public void setProductionShift(MilkShifts productionShift) {
        this.productionShift = productionShift;
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

    public MilkProduction(Long id, MilkShifts productionShift, BigDecimal quantity, Animal animal, LocalDate productionDate) {
        this.id = id;
        this.productionShift = productionShift;
        this.quantity = quantity;
        this.animal = animal;
        this.productionDate = productionDate;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name="animal_id" , nullable = false)
    private Animal animal;
    private LocalDate productionDate;

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }
}
