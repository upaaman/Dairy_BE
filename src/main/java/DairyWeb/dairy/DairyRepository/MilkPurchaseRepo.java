package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.MilkPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface MilkPurchaseRepo extends JpaRepository<MilkPurchase,Long>, JpaSpecificationExecutor<MilkPurchase> {

    @Query("""
        SELECT COALESCE(SUM(m.quantity), 0)
          FROM MilkPurchase m
          WHERE m.purchaseDate >= :startDate
          AND m.purchaseDate <= :endDate
""")
    BigDecimal getTotalMilkPurchaseQuantity(
            LocalDate startDate,
            LocalDate endDate
    );


    @Query("""
        SELECT COALESCE(SUM(m.amount), 0)
          FROM MilkPurchase m
          WHERE m.purchaseDate >= :startDate
          AND m.purchaseDate <= :endDate
""")
    BigDecimal getTotalMilkPurchaseAmount(
            LocalDate startDate,
            LocalDate endDate
    );
}
