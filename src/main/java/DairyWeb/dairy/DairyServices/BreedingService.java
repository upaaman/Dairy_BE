package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.BreedingCreateDTO;
import DairyWeb.dairy.DairyDTOs.RequestDTO.BreedingUpdateDTO;
import DairyWeb.dairy.DairyEntities.Animal;
import DairyWeb.dairy.DairyEntities.Breeding;
import DairyWeb.dairy.DairyEnums.BreedingStatus;
import DairyWeb.dairy.DairyExceptions.BusinessException;
import DairyWeb.dairy.DairyRepository.AnimalRepo;
import DairyWeb.dairy.DairyRepository.BreedingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedingService {
    private final BreedingRepo breedingRepo;
    private final AnimalRepo animalRepo;

    public BreedingService(BreedingRepo breedingRepo,AnimalRepo animalRepo){
        this.breedingRepo=breedingRepo;
        this.animalRepo=animalRepo;
    }

    public Breeding createBreeding(BreedingCreateDTO req){
        Animal animal= animalRepo.findById(req.getAnimal()).orElseThrow(
                ()-> new BusinessException("Animal not found with this id : "+ req.getAnimal())
        );



        Breeding breeding = new Breeding();
        breeding.setAnimal(animal);
        breeding.setBreedingDate(req.getBreedingDate());
        breeding.setMethod(req.getMethod());
        breeding.setNotes(req.getNotes());
        breeding.setExpectedCalvingDate(req.getExpectedCalvingDate());
        breeding.setStatus(BreedingStatus.INSEMINATED);

        return breedingRepo.save(breeding);
    }

    public Breeding updateBreeding(Long id,BreedingUpdateDTO req){
      Breeding breeding = breedingRepo.findById(id).
      orElseThrow(()-> new BusinessException("Breeding not found with this id"));

      if(req.getStatus()!=null){
          breeding.setStatus(req.getStatus());
      }
      if(req.getActualCalvingDate()!=null){
          breeding.setActualCalvingDate(req.getActualCalvingDate());
      }
      if(req.getNotes()!=null){
            breeding.setNotes(req.getNotes());
      }
      if(req.getProducedAnimal()!=null){
          BreedingStatus finalStatus =req.getStatus() != null ? req.getStatus(): breeding.getStatus();
          if(finalStatus != BreedingStatus.CALVED){
              throw new BusinessException(
                      "Produced animal can only be added when breeding status is CALVED"
              );
          }
           Animal producedAnimal=animalRepo.findById(req.getProducedAnimal()).orElseThrow(
                   ()-> new BusinessException("Produced Animal not found")
           );
           breeding.setProducedAnimal(producedAnimal);
      }

      return breedingRepo.save(breeding);

    }

    public List<Breeding> getAllBreedingRecords(){

        return breedingRepo.findAll();
    }
}
