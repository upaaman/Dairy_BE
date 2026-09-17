package DairyWeb.dairy.DairyDTOs.ResponseDTOs;

import java.math.BigDecimal;

public class DashboardResDTO {

    private BigDecimal totalProduction;
    private BigDecimal totalProductionChange;
    private BigDecimal totalPurchaseQuantity;
    private BigDecimal totalPurchaseQuantityChange;
    private BigDecimal totalPurchaseAmount;
    private BigDecimal totalPurchaseAmountChange;
    private BigDecimal totalSaleQuantity;
    private BigDecimal totalSaleQuantityChange;
    private BigDecimal totalSaleAmount;
    private BigDecimal totalSaleAmountChange;

    public BigDecimal getTotalProduction() {
        return totalProduction;
    }

    public BigDecimal getTotalProductionChange() {
        return totalProductionChange;
    }

    public BigDecimal getTotalPurchaseQuantity() {
        return totalPurchaseQuantity;
    }

    public BigDecimal getTotalPurchaseQuantityChange() {
        return totalPurchaseQuantityChange;
    }

    public BigDecimal getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public BigDecimal getTotalPurchaseAmountChange() {
        return totalPurchaseAmountChange;
    }

    public BigDecimal getTotalSaleQuantity() {
        return totalSaleQuantity;
    }

    public BigDecimal getTotalSaleQuantityChange() {
        return totalSaleQuantityChange;
    }

    public BigDecimal getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public BigDecimal getTotalSaleAmountChange() {
        return totalSaleAmountChange;
    }

    public DashboardResDTO(BigDecimal totalProduction, BigDecimal totalProductionChange, BigDecimal totalPurchaseQuantity, BigDecimal totalPurchaseQuantityChange, BigDecimal totalPurchaseAmount, BigDecimal totalPurchaseAmountChange, BigDecimal totalSaleQuantity, BigDecimal totalSaleQuantityChange, BigDecimal totalSaleAmount, BigDecimal totalSaleAmountChange) {
        this.totalProduction = totalProduction;
        this.totalProductionChange = totalProductionChange;
        this.totalPurchaseQuantity = totalPurchaseQuantity;
        this.totalPurchaseQuantityChange = totalPurchaseQuantityChange;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.totalPurchaseAmountChange = totalPurchaseAmountChange;
        this.totalSaleQuantity = totalSaleQuantity;
        this.totalSaleQuantityChange = totalSaleQuantityChange;
        this.totalSaleAmount = totalSaleAmount;
        this.totalSaleAmountChange = totalSaleAmountChange;
    }

}