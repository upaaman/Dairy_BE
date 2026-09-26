package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.RequestDTO.AnimalCreateReqDTO;
import DairyWeb.dairy.DairyDTOs.RequestDTO.AnimalUpdateReqDTO;
import DairyWeb.dairy.DairyDTOs.ResponseDTOs.AnimalResDTO;
import DairyWeb.dairy.DairyEntities.Animal;
import DairyWeb.dairy.DairyEnums.AnimalStatus;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import DairyWeb.dairy.DairyServices.AnimalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    private AnimalService animalService;
    public AnimalController(AnimalService animalService){
        this.animalService=animalService;
    }

    @PostMapping("/create")
    public ResponseEntity<AnimalResDTO> addAnimalController(
        @Valid @RequestBody AnimalCreateReqDTO bodyAnimal){
        AnimalResDTO temp= animalService.createAnimal(bodyAnimal);
        return ResponseEntity.status(201).body(temp);
    }

    @GetMapping("/getAll/inactive")
    public ResponseEntity<List<Animal>> getAllInactiveAnimals(){
        List<Animal> allAnimalsList=animalService.getAllInactiveAnimals();
        return ResponseEntity.status(200).body(allAnimalsList);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Animal>> getAllAnimals(
            @RequestParam(required = false) AnimalStatus status,
            @RequestParam(required = false) Boolean includeInactiveAsWell
            ){
        List<Animal> allAnimalsList=animalService.getAllAnimals(status,includeInactiveAsWell);
        return ResponseEntity.status(200).body(allAnimalsList);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AnimalResDTO> getAnimalById(@PathVariable Long id,
    @RequestParam(required = false) LocalDate startDate,
    @RequestParam (required = false)LocalDate endDate
    ){
        AnimalResDTO animal=animalService.getAnimalById(id,startDate,endDate);
        if(animal!=null){
        return ResponseEntity.status(200).body(animal);
        }
        return ResponseEntity.status(400).body(null);
    }
    @PatchMapping("/update/{id}")
    public String updateAnimalById(
            @PathVariable Long id,
         @Valid   @RequestBody AnimalUpdateReqDTO updatedAnimalReq){

         animalService.updateAnimal(id,updatedAnimalReq);
         return "Animal updated successfully.";
    }

    @GetMapping("/getAllMilkProductionAnimals")
    public ResponseEntity<List<Animal>> getAnimalsForProduction(
            @RequestParam LocalDate productionDate,
            @RequestParam MilkShifts shift
            ){
        List<Animal> allAnimalsList=animalService.getAnimalsForProduction(productionDate,shift);
        return ResponseEntity.status(200).body(allAnimalsList);
    }


    @DeleteMapping("/deleteAnimal/{id}")
    public  ResponseEntity<String> deleteAnimalWithId(@PathVariable Long id){
        String temp=animalService.deleteAnimalById(id);
        if(temp==null){
            return ResponseEntity.status(400).body("No animal found with this id.");
        }
        return ResponseEntity.status(200).body(temp);
    }
}
