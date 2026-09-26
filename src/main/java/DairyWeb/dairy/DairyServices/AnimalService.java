package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.AnimalCreateReqDTO;
import DairyWeb.dairy.DairyDTOs.RequestDTO.AnimalUpdateReqDTO;
import DairyWeb.dairy.DairyDTOs.ResponseDTOs.AnimalResDTO;
import DairyWeb.dairy.DairyEntities.Animal;
import DairyWeb.dairy.DairyEntities.Breeding;
import DairyWeb.dairy.DairyEntities.Expense;
import DairyWeb.dairy.DairyEntities.MilkProduction;
import DairyWeb.dairy.DairyEnums.AnimalStatus;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import DairyWeb.dairy.DairyExceptions.AnimalNotFoundException;
import DairyWeb.dairy.DairyExceptions.BusinessException;
import DairyWeb.dairy.DairyRepository.AnimalRepo;
import DairyWeb.dairy.DairyRepository.BreedingRepo;
import DairyWeb.dairy.DairyRepository.ExpenseRepo;
import DairyWeb.dairy.DairyRepository.MilkProductionRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class AnimalService {


    private AnimalRepo animalRepo;
    private MilkProductionRepo milkProductionRepo;
    private ExpenseRepo expenseRepo;
    private BreedingRepo breedingRepo;
    public AnimalService(AnimalRepo animalRepo, MilkProductionRepo milkProductionRepo, ExpenseRepo expenseRepo,BreedingRepo breedingRepo){
        this.animalRepo=animalRepo;
        this.milkProductionRepo=milkProductionRepo;
        this.expenseRepo=expenseRepo;
        this.breedingRepo=breedingRepo;
    }

    public AnimalResDTO createAnimal(AnimalCreateReqDTO dto) {
        Animal animal = new Animal();

        animal.setType(dto.getType());
        animal.setGender(dto.getGender());
        animal.setBreed(dto.getBreed());
        animal.setPurchasePrice(dto.getPurchasePrice());
        animal.setDateOfBirth(dto.getDateOfBirth());
        animal.setDateOfPurchase(dto.getDateOfPurchase());
        animal.setName(dto.getName());
        animal.setStatus(dto.getStatus());
        animal.setNotes(dto.getNotes());
        animal.setActive(true);

        Animal savedAnimal= animalRepo.save(animal);

        AnimalResDTO animalRes=new AnimalResDTO();

        animalRes.setName(savedAnimal.getName());
        animalRes.setType(savedAnimal.getType());
        animalRes.setGender(savedAnimal.getGender());
        animalRes.setBreed(savedAnimal.getBreed());
        animalRes.setStatus(savedAnimal.getStatus());

        return animalRes;
    }

    public List<Animal> getAllAnimals(AnimalStatus status,Boolean includeInactiveAsWell){
        List<Animal> temp =null;
        if(includeInactiveAsWell!=null && includeInactiveAsWell){
            temp=animalRepo.findAll();
        }
        else if(status!=null){
            temp=animalRepo.findByActiveTrueAndStatus(status);
        }
        else temp= animalRepo.findByActiveTrue();
        return temp;
    }

    public List<Animal> getAllInactiveAnimals(){
        List<Animal> temp= animalRepo.findByActiveFalse();
        return temp;
    }

    private AnimalResDTO mapToBasicAnimalDTO(Animal animal) {

        AnimalResDTO dto = new AnimalResDTO();

        dto.setId(animal.getId());
        dto.setName(animal.getName());
        dto.setGender(animal.getGender());
        dto.setType(animal.getType());
        dto.setBreed(animal.getBreed());
        dto.setDateOfBirth(animal.getDateOfBirth());
        dto.setStatus(animal.getStatus());
        dto.setActive(animal.getActive());

        return dto;
    }
    public AnimalResDTO getAnimalById(Long id, LocalDate startDate , LocalDate endDate){

        Animal temp = animalRepo.findById(id).orElseThrow(
                ()-> new BusinessException("Animal not found with this id : ")
        );
        List<MilkProduction> milkProductionList=milkProductionRepo.findByAnimalIdAndProductionDateBetweenOrderByProductionDateDesc(
                id,
                startDate,
                endDate
        );
        BigDecimal totalMilkProduced=milkProductionRepo.getTotalMilkProductionByAnimal(id,startDate,endDate);

        List<Expense> expenseRecord=expenseRepo.findByAnimalIdAndExpenseDateBetween(
                id,
                startDate,
                endDate
        );
        BigDecimal totalExpenseOfAnimal=expenseRepo.getTotalExpenseOfAnimal(
                id,
                startDate,
                endDate
        );

        // CHILD ANIMALS
        List<Breeding> breedings =
                breedingRepo.findByAnimalIdAndProducedAnimalIsNotNull(id);
        List<AnimalResDTO> childAnimals =
                breedings.stream()
                        .map(Breeding::getProducedAnimal)
                        .map(this::mapToBasicAnimalDTO)
                        .toList();

        // MOTHER
        Optional<Breeding> motherBreeding =
                breedingRepo.findFirstByProducedAnimalId(id);

        AnimalResDTO mother = null;

        if (motherBreeding.isPresent()) {
            mother = mapToBasicAnimalDTO(
                    motherBreeding.get().getAnimal()
            );
        }

        AnimalResDTO resAnimal = new AnimalResDTO();

        resAnimal.setName(temp.getName());
        resAnimal.setGender(temp.getGender());
        resAnimal.setType(temp.getType());
        resAnimal.setBreed(temp.getBreed());
        resAnimal.setStatus(temp.getStatus());
        resAnimal.setNotes(temp.getNotes());
        resAnimal.setDateOfBirth(temp.getDateOfBirth());
        resAnimal.setPurchasePrice(temp.getPurchasePrice());
        resAnimal.setDateOfBirth(temp.getDateOfBirth());
        resAnimal.setMilkProductionList(milkProductionList);
        resAnimal.setTotalMilkProduced(totalMilkProduced);
        resAnimal.setTotalExpense(totalExpenseOfAnimal);
        resAnimal.setExpenseRecordOfAnimal(expenseRecord);
        resAnimal.setId(temp.getId());
        resAnimal.setActive(temp.getActive());
        resAnimal.setChildAnimals(childAnimals);
        resAnimal.setMother(mother);


        return resAnimal;

    }
    public String updateAnimal(Long id, AnimalUpdateReqDTO request){
        Animal animal=animalRepo.findById(id)
                .orElseThrow(()->
                      new  AnimalNotFoundException("Animal not found with id :"+ id));
        if(request.getName()!=null){
            if (request.getName().isBlank()) {
                throw new BusinessException(
                        "Animal name cannot be empty."
                );
            }

            animal.setName(request.getName().trim());
        }
        if(request.getStatus()!=null){
            animal.setStatus(request.getStatus());
        }
        if(request.getNotes()!=null){
            animal.setNotes(request.getNotes().trim());
        }
            System.out.println(request.getActive()+" aman"+ request.getName());
        if(request.getActive()!=null){
            animal.setActive(request.getActive());
        }
     Animal updatedAnimal=   animalRepo.save(animal);
       return "Done";
    }

    public List<Animal> getAnimalsForProduction(
            LocalDate productionDate,
            MilkShifts shift
    ) {

        List<Animal> animals =
                animalRepo.findByActiveTrueAndStatus(AnimalStatus.PRODUCING);

        return animals.stream()
                .filter(animal ->
                        !milkProductionRepo
                                .existsByAnimalIdAndProductionDateAndProductionShift(
                                        animal.getId(),
                                        productionDate,
                                        shift
                                )
                )
                .toList();
    }

    public String deleteAnimalById(Long Id){
       Optional<Animal> temp= animalRepo.findById(Id);
       if(temp.isPresent()){
           animalRepo.deleteById(Id);
           return "Animal deleted successfully";
       }
       return null;
    }
}
