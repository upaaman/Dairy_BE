package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.MilkProductionRequestDTO;
import DairyWeb.dairy.DairyEntities.Animal;
import DairyWeb.dairy.DairyEntities.MilkProduction;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import DairyWeb.dairy.DairyExceptions.AnimalNotFoundException;
import DairyWeb.dairy.DairyRepository.AnimalRepo;
import DairyWeb.dairy.DairyRepository.MilkProductionRepo;
import DairyWeb.dairy.DairySpecifications.MilkProductionSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MilkProductionService {
    private final AnimalRepo animalRepo;
    private MilkProductionRepo milkProductionRepo;
    public MilkProductionService(MilkProductionRepo milkProductionRepo, AnimalRepo animalRepo){
        this.milkProductionRepo=milkProductionRepo;
        this.animalRepo = animalRepo;
    }

    public MilkProduction createMilkProduction(MilkProductionRequestDTO request){
        Animal animal=animalRepo.findById(request.getAnimalId())
                .orElseThrow(()->new AnimalNotFoundException("Animal not found with id " +request.getAnimalId()));

        MilkProduction production=new MilkProduction();

        production.setAnimal(animal);
        production.setQuantity(request.getQuantity());
        production.setProductionShift(request.getShift());
        production.setProductionDate(request.getProductionDate());

        return milkProductionRepo.save(production);
    }

    public List<MilkProduction> getAllMilkProduction(
            LocalDate startDate,
            LocalDate endDate,
            MilkShifts productionShift,
            AnimalType animalType,
            Long animalId
    ){
        Specification<MilkProduction> specification =
                Specification.where(
                                MilkProductionSpecification.hasStartDate(startDate)
                        )
                        .and(
                                MilkProductionSpecification.hasEndDate(endDate)
                        )
                        .and(
                                MilkProductionSpecification.hasShift(productionShift)
                        )
                        .and(
                                MilkProductionSpecification.hasAnimalType(animalType)
                        )
                        .and(
                                MilkProductionSpecification.hasAnimalId(animalId)
                        );
        return milkProductionRepo.findAll(specification);
    }

}
