package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.VaccineCreateDTO;
import DairyWeb.dairy.DairyEntities.Animal;
import DairyWeb.dairy.DairyEntities.Vaccine;
import DairyWeb.dairy.DairyExceptions.BusinessException;
import DairyWeb.dairy.DairyRepository.AnimalRepo;
import DairyWeb.dairy.DairyRepository.VaccineRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineService {
    private final VaccineRepo vaccineRepo;
    private  final AnimalRepo animalRepo;
    public VaccineService(VaccineRepo vaccineRepo,AnimalRepo animalRepo){
        this.vaccineRepo=vaccineRepo;
        this.animalRepo=animalRepo;
    }

    public Vaccine createVaccine(VaccineCreateDTO req){
        Animal animal =animalRepo.findById(req.getAnimalId()).
                orElseThrow(()->new BusinessException("Animal not found with this id"));

        Vaccine vaccine=new Vaccine();
        vaccine.setAnimal(animal);
        vaccine.setNotes(req.getNotes());
        vaccine.setVaccineDate(req.getVaccineDate());
        vaccine.setVaccineName(req.getVaccineName());

        return vaccineRepo.save(vaccine);
    }
    public List<Vaccine> getAll(){
        return vaccineRepo.findAll();
    }
}
