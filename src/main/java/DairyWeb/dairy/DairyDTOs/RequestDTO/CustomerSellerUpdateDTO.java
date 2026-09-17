package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyDTOs.ResponseDTOs.MilkRates;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;

public class CustomerSellerUpdateDTO {
    private String name;
    private String contact;
    private String address;
    @Valid
    @Embedded
    private MilkRates milkRates;

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

    public MilkRates getMilkRates() {
        return milkRates;
    }

    public void setMilkRates(MilkRates milkRates) {
        this.milkRates = milkRates;
    }
}
