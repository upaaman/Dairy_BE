package DairyWeb.dairy.DairyRepository;

import DairyWeb.dairy.DairyEntities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepo extends JpaRepository<Expense,Long> {
    @Query("""
    SELECT COALESCE(SUM(e.amount), 0)
    FROM Expense e
    WHERE e.animal.id = :animalId
    AND e.expenseDate >= :startDate
    AND e.expenseDate <= :endDate
""")
    BigDecimal getTotalExpenseOfAnimal(
            Long animalId,
            LocalDate startDate,
            LocalDate endDate
    );

    List<Expense> findByAnimalIdAndExpenseDateBetween(
            Long animalId,
            LocalDate startDate,
            LocalDate endDate
    );

    @Query("""
    SELECT COALESCE(SUM(e.amount), 0)
    FROM Expense e
    WHERE e.expenseDate >= :startDate
    AND e.expenseDate <= :endDate
""")
    BigDecimal getTotalExpenseAmount(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
