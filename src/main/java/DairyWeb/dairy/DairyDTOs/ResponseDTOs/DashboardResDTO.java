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
    private BigDecimal totalExpenseAmount;
    private BigDecimal totalExpenseAmountChange;

    public BigDecimal getTotalExpenseAmount() {
        return totalExpenseAmount;
    }

    public DashboardResDTO(BigDecimal totalProduction, BigDecimal totalProductionChange, BigDecimal totalPurchaseQuantity, BigDecimal totalPurchaseQuantityChange, BigDecimal totalPurchaseAmount, BigDecimal totalPurchaseAmountChange, BigDecimal totalSaleQuantity, BigDecimal totalSaleQuantityChange, BigDecimal totalExpenseAmount, BigDecimal totalExpenseAmountChange, BigDecimal totalSaleAmount, BigDecimal totalSaleAmountChange, BigDecimal totalSalariesPaid, BigDecimal salariesPaidChange) {
        this.totalProduction = totalProduction;
        this.totalProductionChange = totalProductionChange;
        this.totalPurchaseQuantity = totalPurchaseQuantity;
        this.totalPurchaseQuantityChange = totalPurchaseQuantityChange;
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.totalPurchaseAmountChange = totalPurchaseAmountChange;
        this.totalSaleQuantity = totalSaleQuantity;
        this.totalSaleQuantityChange = totalSaleQuantityChange;
        this.totalExpenseAmount = totalExpenseAmount;
        this.totalExpenseAmountChange = totalExpenseAmountChange;
        this.totalSaleAmount = totalSaleAmount;
        this.totalSaleAmountChange = totalSaleAmountChange;
        this.totalSalariesPaid = totalSalariesPaid;
        this.salariesPaidChange = salariesPaidChange;
    }

    public BigDecimal getTotalExpenseAmountChange() {
        return totalExpenseAmountChange;
    }

    private BigDecimal totalSaleAmount;
    private BigDecimal totalSaleAmountChange;
    private BigDecimal totalSalariesPaid;
    private BigDecimal salariesPaidChange;

    public BigDecimal getSalariesPaidChange() {
        return salariesPaidChange;
    }
    public BigDecimal getTotalSalariesPaid() {
        return totalSalariesPaid;
    }

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

}