package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.SalaryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface SalaryTransactionRepo extends JpaRepository<SalaryTransaction,Long>, JpaSpecificationExecutor<SalaryTransaction> {

    @Query("""
    SELECT COALESCE(SUM(s.amount), 0)
    FROM SalaryTransaction s
    WHERE s.type = 'PAYMENT'
    AND s.transactionDate >= :startDate
    AND s.transactionDate <= :endDate
""")
    BigDecimal getTotalSalariesPaid(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    @Query("""
    SELECT COALESCE(SUM(
        CASE
            WHEN s.type = 'SALARY_CREDIT' THEN s.amount
            WHEN s.type = 'PAYMENT' THEN -s.amount
            ELSE 0
        END
    ), 0)
    FROM SalaryTransaction s
    WHERE s.employee.id = :employeeId
""")
    BigDecimal getTotalRemainingAmount(@Param("employeeId") Long employeeId);
}
