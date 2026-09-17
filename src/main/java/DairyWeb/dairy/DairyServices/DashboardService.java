package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.ResponseDTOs.DashboardResDTO;
import DairyWeb.dairy.DairyEntities.MilkPurchase;
import DairyWeb.dairy.DairyExceptions.BusinessException;
import DairyWeb.dairy.DairyRepository.MilkProductionRepo;
import DairyWeb.dairy.DairyRepository.MilkPurchaseRepo;
import DairyWeb.dairy.DairyRepository.MilkSaleRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Service
public class DashboardService {

    private MilkProductionRepo milkProductionRepo;
    private MilkPurchaseRepo milkPurchaseRepo;
    private MilkSaleRepo milkSaleRepo;


    public DashboardService(MilkProductionRepo milkProductionRepo, MilkPurchaseRepo milkPurchaseRepo, MilkSaleRepo milkSaleRepo) {
        this.milkProductionRepo = milkProductionRepo;
        this.milkPurchaseRepo=milkPurchaseRepo;
        this.milkSaleRepo=milkSaleRepo;
    }

    public BigDecimal getTotalMilkProduction(
            LocalDate startDate,
            LocalDate endDate) {

        return milkProductionRepo.getTotalMilkProduction(
                startDate,
                endDate
        );

    }
    public BigDecimal getTotalMilkPurchaseQuantity(
            LocalDate startDate,
            LocalDate endDate) {

        return milkPurchaseRepo.getTotalMilkPurchaseQuantity(
                startDate,
                endDate
        );

    }

    public BigDecimal getTotalMilkPurchaseAmount(
            LocalDate startDate,
            LocalDate endDate) {

        return milkPurchaseRepo.getTotalMilkPurchaseAmount(
                startDate,
                endDate
        );

    }

    public BigDecimal getTotalMilkSaleQuantity(
            LocalDate startDate,
            LocalDate endDate) {

        return milkSaleRepo.getTotalMilkSaleQuantity(
                startDate,
                endDate
        );

    }
    public BigDecimal getTotalMilkSaleAmount(
            LocalDate startDate,
            LocalDate endDate) {

        return milkSaleRepo.getTotalMilkSaleAmount(
                startDate,
                endDate
        );

    }

    private LocalDate[] getPreviousPeriod(
            LocalDate startDate,
            LocalDate endDate
    ) {

        long numberOfDays =
                ChronoUnit.DAYS.between(startDate, endDate) + 1;

        LocalDate previousEndDate =
                startDate.minusDays(1);

        LocalDate previousStartDate =
                startDate.minusDays(numberOfDays);

        return new LocalDate[]{
                previousStartDate,
                previousEndDate
        };
    }
    private BigDecimal calculatePercentageChange(
            BigDecimal current,
            BigDecimal previous
    ) {

        if (previous.compareTo(BigDecimal.ZERO) == 0) {

            if (current.compareTo(BigDecimal.ZERO) == 0) {
                return BigDecimal.ZERO;
            }

            return BigDecimal.ZERO;
        }

        return current
                .subtract(previous)
                .divide(previous, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public DashboardResDTO getDashboard(
            LocalDate startDate,
            LocalDate endDate
    ) {

        BigDecimal totalProduction =
                getTotalMilkProduction(startDate, endDate);

        BigDecimal totalPurchaseQuantity =
                getTotalMilkPurchaseQuantity(startDate, endDate);

        BigDecimal totalPurchaseAmount =
                getTotalMilkPurchaseAmount(startDate, endDate);

        BigDecimal totalSaleQuantity =
                getTotalMilkSaleQuantity(startDate, endDate);

        BigDecimal totalSaleAmount =
                getTotalMilkSaleAmount(startDate, endDate);

        LocalDate[] previousPeriod =getPreviousPeriod(startDate, endDate);


        LocalDate previousStartDate = previousPeriod[0];
        LocalDate previousEndDate = previousPeriod[1];
// Previous period values
        BigDecimal previousProduction =
                getTotalMilkProduction(
                        previousStartDate,
                        previousEndDate
                );

        BigDecimal previousPurchaseQuantity =
                getTotalMilkPurchaseQuantity(
                        previousStartDate,
                        previousEndDate
                );

        BigDecimal previousPurchaseAmount =
                getTotalMilkPurchaseAmount(
                        previousStartDate,
                        previousEndDate
                );

        BigDecimal previousSaleQuantity =
                getTotalMilkSaleQuantity(
                        previousStartDate,
                        previousEndDate
                );

        BigDecimal previousSaleAmount =
                getTotalMilkSaleAmount(
                        previousStartDate,
                        previousEndDate
                );


        // Percentage changes
        BigDecimal productionChange =
                calculatePercentageChange(
                        totalProduction,
                        previousProduction
                );

        BigDecimal purchaseQuantityChange =
                calculatePercentageChange(
                        totalPurchaseQuantity,
                        previousPurchaseQuantity
                );

        BigDecimal purchaseAmountChange =
                calculatePercentageChange(
                        totalPurchaseAmount,
                        previousPurchaseAmount
                );

        BigDecimal saleQuantityChange =
                calculatePercentageChange(
                        totalSaleQuantity,
                        previousSaleQuantity
                );

        BigDecimal saleAmountChange =
                calculatePercentageChange(
                        totalSaleAmount,
                        previousSaleAmount
                );

System.out.println(totalProduction+" " +previousProduction+" ->"+productionChange+"aman is temp" + totalProduction +
       " "+ productionChange
      + " "+ totalPurchaseQuantity
      + " "+ purchaseQuantityChange
      + " "+ totalPurchaseAmount
      + " "+ purchaseAmountChange
      + " "+ totalSaleQuantity
      + " "+ saleQuantityChange
      + " "+ totalSaleAmount
      + " "+ saleAmountChange);
        return new DashboardResDTO(
                totalProduction,
                productionChange,
                totalPurchaseQuantity,
                purchaseQuantityChange,
                totalPurchaseAmount,
                purchaseAmountChange,
                totalSaleQuantity,
                saleQuantityChange,
                totalSaleAmount,
                saleAmountChange
        );
    }

}