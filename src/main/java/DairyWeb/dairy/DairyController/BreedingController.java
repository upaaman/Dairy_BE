package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.RequestDTO.BreedingCreateDTO;
import DairyWeb.dairy.DairyDTOs.RequestDTO.BreedingUpdateDTO;
import DairyWeb.dairy.DairyEntities.Breeding;
import DairyWeb.dairy.DairyServices.BreedingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breeding")
public class BreedingController {

    private final BreedingService breedingService;
    public BreedingController(BreedingService breedingService){
        this.breedingService=breedingService;
    }

    @PostMapping("/create")
    public Breeding createBreeding(
            @Valid @RequestBody BreedingCreateDTO req
            ){
        return breedingService.createBreeding(req);
    }

    @PatchMapping("/update/{id}")
    public Breeding updateBreeding(
            @PathVariable Long id,
             @RequestBody BreedingUpdateDTO req
    ){
        return breedingService.updateBreeding(id,req);
    }

    @GetMapping("/getAll")
    public List<Breeding> getAllBreeding(){
        return breedingService.getAllBreedingRecords();
    }

}
