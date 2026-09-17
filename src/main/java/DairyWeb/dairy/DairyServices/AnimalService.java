package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.AnimalCreateReqDTO;
import DairyWeb.dairy.DairyDTOs.ResponseDTOs.AnimalResDTO;
import DairyWeb.dairy.DairyEntities.Animal;
import DairyWeb.dairy.DairyExceptions.AnimalNotFoundException;
import DairyWeb.dairy.DairyRepository.AnimalRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AnimalService {


    private AnimalRepo animalRepo;
    public AnimalService(AnimalRepo animalRepo){
        this.animalRepo=animalRepo;
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

    public Animal getAnimalById(Long id){
        Optional<Animal> temp = animalRepo.findById(id);

        return temp.orElseThrow(() ->
                new AnimalNotFoundException(
                        "Animal not found with id: " + id
                )
        );
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
