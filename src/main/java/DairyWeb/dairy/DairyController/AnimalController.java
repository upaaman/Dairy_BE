package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.RequestDTO.AnimalCreateReqDTO;
import DairyWeb.dairy.DairyDTOs.RequestDTO.AnimalUpdateReqDTO;
import DairyWeb.dairy.DairyDTOs.ResponseDTOs.AnimalResDTO;
import DairyWeb.dairy.DairyEntities.Animal;
import DairyWeb.dairy.DairyServices.AnimalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getAll")
    public ResponseEntity<List<Animal>> getAllAnimals(){
        List<Animal> allAnimalsList=animalService.getAllAnimals();
        return ResponseEntity.status(200).body(allAnimalsList);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id){
        Animal animal=animalService.getAnimalById(id);
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

    @DeleteMapping("/deleteAnimal/{id}")
    public  ResponseEntity<String> deleteAnimalWithId(@PathVariable Long id){
        String temp=animalService.deleteAnimalById(id);
        if(temp==null){
            return ResponseEntity.status(400).body("No animal found with this id.");
        }
        return ResponseEntity.status(200).body(temp);
    }
}
