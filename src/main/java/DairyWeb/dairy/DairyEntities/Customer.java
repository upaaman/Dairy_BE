package DairyWeb.dairy.DairyEntities;

import DairyWeb.dairy.DairyDTOs.ResponseDTOs.MilkRates;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }
    public Customer(){}

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

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

    private String contact;
    private String address;

    public MilkRates getMilkRates() {
        return milkRates;
    }

    public void setMilkRates(MilkRates milkRates) {
        this.milkRates = milkRates;
    }

    @Embedded
    private MilkRates milkRates;

    public Customer(Long id, String name, String contact, String address, MilkRates milkRates) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.milkRates = milkRates;
    }
}
