package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.Animal;
import DairyWeb.dairy.DairyEntities.MilkProduction;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface MilkProductionRepo extends JpaRepository<MilkProduction,Long>,
        JpaSpecificationExecutor<MilkProduction> {

    @Query("""
    SELECT COALESCE(SUM(m.quantity), 0)
    FROM MilkProduction m
    WHERE m.productionDate >= :startDate
    AND m.productionDate <= :endDate
""")
    BigDecimal getTotalMilkProduction(
            LocalDate startDate,
            LocalDate endDate
    );

}
