package DairyWeb.dairy.DairySpecifications;

import DairyWeb.dairy.DairyEntities.MilkSale;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class MilkSaleSpecification {

    public static Specification<MilkSale> hasStartDate(LocalDate startDate) {
        return (root, query, criteriaBuilder) -> {

            if (startDate == null) {
                return null;
            }

            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("saleDate"),
                    startDate
            );
        };
    }


    public static Specification<MilkSale> hasEndDate(LocalDate endDate) {
        return (root, query, criteriaBuilder) -> {

            if (endDate == null) {
                return null;
            }

            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("saleDate"),
                    endDate
            );
        };
    }


    public static Specification<MilkSale> hasShift(MilkShifts shift) {
        return (root, query, criteriaBuilder) -> {

            if (shift == null) {
                return null;
            }

            return criteriaBuilder.equal(
                    root.get("shift"),
                    shift
            );
        };
    }


    public static Specification<MilkSale> hasAnimalType(AnimalType animalType) {
        return (root, query, criteriaBuilder) -> {

            if (animalType == null) {
                return null;
            }

            return criteriaBuilder.equal(
                    root.get("animalType"),
                    animalType
            );
        };
    }


    public static Specification<MilkSale> hasCustomerId(Long customerId) {
        return (root, query, criteriaBuilder) -> {

            if (customerId == null) {
                return null;
            }

            return criteriaBuilder.equal(
                    root.get("customer").get("id"),
                    customerId
            );
        };
    }
}