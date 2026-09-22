package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.AnimalCreateReqDTO;
import DairyWeb.dairy.DairyDTOs.RequestDTO.AnimalUpdateReqDTO;
import DairyWeb.dairy.DairyDTOs.ResponseDTOs.AnimalResDTO;
import DairyWeb.dairy.DairyEntities.Animal;
import DairyWeb.dairy.DairyEntities.Expense;
import DairyWeb.dairy.DairyEntities.MilkProduction;
import DairyWeb.dairy.DairyExceptions.AnimalNotFoundException;
import DairyWeb.dairy.DairyExceptions.BusinessException;
import DairyWeb.dairy.DairyRepository.AnimalRepo;
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
    public AnimalService(AnimalRepo animalRepo, MilkProductionRepo milkProductionRepo, ExpenseRepo expenseRepo){
        this.animalRepo=animalRepo;
        this.milkProductionRepo=milkProductionRepo;
        this.expenseRepo=expenseRepo;
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

        Animal savedAnimal= animalRepo.save(animal);

        AnimalResDTO animalRes=new AnimalResDTO();

        animalRes.setName(savedAnimal.getName());
        animalRes.setType(savedAnimal.getType());
        animalRes.setGender(savedAnimal.getGender());
        animalRes.setBreed(savedAnimal.getBreed());
        animalRes.setStatus(savedAnimal.getStatus());

        return animalRes;
    }

    public List<Animal> getAllAnimals(){
        List<Animal> temp= animalRepo.findAll();
        return temp;
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
        System.out.println(expenseRecord+"upda");
        BigDecimal totalExpenseOfAnimal=expenseRepo.getTotalExpenseOfAnimal(
                id,
                startDate,
                endDate
        );

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
     Animal updatedAnimal=   animalRepo.save(animal);
       return "Done";
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
