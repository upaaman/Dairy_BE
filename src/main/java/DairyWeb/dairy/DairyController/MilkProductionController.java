package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.RequestDTO.MilkProductionRequestDTO;
import DairyWeb.dairy.DairyEntities.MilkProduction;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import DairyWeb.dairy.DairyServices.MilkProductionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/milkProduction")
public class MilkProductionController {

    private final MilkProductionService milkProductionService;
    public MilkProductionController(MilkProductionService milkProductionService){
        this.milkProductionService=milkProductionService;
    }

    @PostMapping("/create")
    public MilkProduction addMilkProduction(
            @Valid @RequestBody MilkProductionRequestDTO requestDTO){
        return milkProductionService.createMilkProduction(requestDTO);
    }

    @GetMapping("/getAll")
    public List<MilkProduction> getAllMilkProduction(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
             @RequestParam(required = false) MilkShifts productionShift,
              @RequestParam(required = false) AnimalType animalType,
                @RequestParam(required=false) Long animalId
    ){
        return milkProductionService.getAllMilkProduction(startDate,endDate,productionShift,animalType,animalId);
    }

}
