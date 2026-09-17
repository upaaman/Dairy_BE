package DairyWeb.dairy.DairySpecifications;

import DairyWeb.dairy.DairyEntities.MilkPurchase;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class MilkPurchaseSpecification {

    public static Specification<MilkPurchase> hasStartDate(LocalDate startDate) {
        return (root, query, criteriaBuilder) -> {

            if (startDate == null) {
                return null;
            }

            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("purchaseDate"),
                    startDate
            );
        };
    }


    public static Specification<MilkPurchase> hasEndDate(LocalDate endDate) {
        return (root, query, criteriaBuilder) -> {

            if (endDate == null) {
                return null;
            }

            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("purchaseDate"),
                    endDate
            );
        };
    }


    public static Specification<MilkPurchase> hasShift(MilkShifts shift) {
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


    public static Specification<MilkPurchase> hasAnimalType(AnimalType animalType) {
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


    public static Specification<MilkPurchase> hasSellerId(Long sellerId) {
        return (root, query, criteriaBuilder) -> {

            if (sellerId == null) {
                return null;
            }

            return criteriaBuilder.equal(
                    root.get("seller").get("id"),
                    sellerId
            );
        };
    }
}