package DairyWeb.dairy.DairyDTOs.ResponseDTOs;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Embeddable
public class MilkRates {
    public BigDecimal getCowMilkRate() {
        return cowMilkRate;
    }

    public void setCowMilkRate(BigDecimal cowMilkRate) {
        this.cowMilkRate = cowMilkRate;
    }

    public BigDecimal getBuffaloMilkRate() {
        return buffaloMilkRate;
    }

    public void setBuffaloMilkRate(BigDecimal buffaloMilkRate) {
        this.buffaloMilkRate = buffaloMilkRate;
    }
    @Positive(message = "Please enter valid value for cow milk rate.")
    private BigDecimal cowMilkRate;
    @Positive(message = "Please enter valid value buffalo milk rate.")
    private BigDecimal buffaloMilkRate;
}
