package DairyWeb.dairy.DairySpecifications;

import DairyWeb.dairy.DairyEntities.SalaryTransaction;
import DairyWeb.dairy.DairyEnums.SalaryTransactionType;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class SalaryTransactionSpecification {

    public static Specification<SalaryTransaction> hasEmployeeId(Long employeeId) {
        return (root, query, cb) ->
                cb.equal(root.get("employee").get("id"), employeeId);
    }

    public static Specification<SalaryTransaction> transactionDateGreaterThanOrEqualTo(
            LocalDate startDate) {

        return (root, query, cb) ->
                cb.greaterThanOrEqualTo(
                        root.get("transactionDate"),
                        startDate
                );
    }

    public static Specification<SalaryTransaction> transactionDateLessThanOrEqualTo(
            LocalDate endDate) {

        return (root, query, cb) ->
                cb.lessThanOrEqualTo(
                        root.get("transactionDate"),
                        endDate
                );
    }

    public static Specification<SalaryTransaction> hasSalaryMonth(
            String salaryMonth) {

        return (root, query, cb) ->
                cb.equal(root.get("salaryMonth"), salaryMonth);
    }

    public static Specification<SalaryTransaction> hasType(
            SalaryTransactionType type) {

        return (root, query, cb) ->
                cb.equal(root.get("type"), type);
    }
}