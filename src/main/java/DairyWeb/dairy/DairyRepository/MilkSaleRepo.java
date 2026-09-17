package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.MilkSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface MilkSaleRepo extends JpaRepository<MilkSale, Long>, JpaSpecificationExecutor<MilkSale> {

    @Query("""
    SELECT COALESCE(SUM(m.quantity), 0)
    FROM MilkSale m
    WHERE m.saleDate >= :startDate
    AND m.saleDate <= :endDate
""")
    BigDecimal getTotalMilkSaleQuantity(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    @Query("""
    SELECT COALESCE(SUM(m.amount), 0)
    FROM MilkSale m
    WHERE m.saleDate >= :startDate
    AND m.saleDate <= :endDate
""")
    BigDecimal getTotalMilkSaleAmount(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
