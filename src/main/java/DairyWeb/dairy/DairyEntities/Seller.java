package DairyWeb.dairy.DairyEntities;

import DairyWeb.dairy.DairyDTOs.ResponseDTOs.MilkRates;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Seller() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotBlank(message = "Please enter valid name")
    private String name;
    @NotBlank(message = "Please enter valid contact number")
    private String contact;
    @NotBlank(message = "Please enter valid address")
    private String address;
    @Valid
    @Embedded
    private MilkRates milkRates;

    public MilkRates getMilkRates() {
        return milkRates;
    }

    public void setMilkRates(MilkRates milkRates) {
        this.milkRates = milkRates;
    }

    public Seller(Long id, String name, String contact, String address, MilkRates milkRates) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.milkRates = milkRates;
    }
}
