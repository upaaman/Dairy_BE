package DairyWeb.dairy.DairySpecifications;

import DairyWeb.dairy.DairyEntities.MilkProduction;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class MilkProductionSpecification {

    public static Specification<MilkProduction> hasStartDate(LocalDate startDate) {
        return (root, query, criteriaBuilder) -> {

            if (startDate == null) {
                return null;
            }

            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get("productionDate"),
                    startDate
            );
        };
    }

    public static Specification<MilkProduction> hasEndDate(LocalDate endDate) {
        return (root, query, criteriaBuilder) -> {

            if (endDate == null) {
                return null;
            }

            return criteriaBuilder.lessThanOrEqualTo(
                    root.get("productionDate"),
                    endDate
            );
        };
    }

    public static Specification<MilkProduction> hasShift(MilkShifts shift) {
        return (root, query, criteriaBuilder) -> {

            if (shift == null) {
                return null;
            }

            return criteriaBuilder.equal(
                    root.get("productionShift"),
                    shift
            );
        };
    }

    public static Specification<MilkProduction> hasAnimalType(AnimalType animalType) {
        return (root, query, criteriaBuilder) -> {

            if (animalType == null) {
                return null;
            }

            return criteriaBuilder.equal(
                    root.get("animal").get("type"),
                    animalType
            );
        };
    }

    public static Specification<MilkProduction> hasAnimalId(Long animalId) {
        return (root, query, criteriaBuilder) -> {

            if (animalId == null) {
                return null;
            }

            return criteriaBuilder.equal(
                    root.get("animal").get("id"),
                    animalId
            );
        };
    }
}