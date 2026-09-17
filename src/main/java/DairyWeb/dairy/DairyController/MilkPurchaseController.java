package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.RequestDTO.MilkPurchaseRequestDTO;
import DairyWeb.dairy.DairyEntities.MilkPurchase;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import DairyWeb.dairy.DairyServices.MilkPurchaseService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/purchase")
public class MilkPurchaseController {
    private MilkPurchaseService milkPurchaseService;
    public MilkPurchaseController(MilkPurchaseService milkPurchaseService){
        this.milkPurchaseService=milkPurchaseService;
    }

    @PostMapping("/create")
    public MilkPurchase createMilkPurchase(@RequestBody  MilkPurchaseRequestDTO milkPurchase){
        return milkPurchaseService.createMilkPurchase(milkPurchase);
    }

    @GetMapping("/getAll")
    public List<MilkPurchase> getAllPurchases(
           @RequestParam(required = false) LocalDate startDate,
           @RequestParam(required = false) MilkShifts shift,
           @RequestParam(required = false) LocalDate endDate,
           @RequestParam(required = false)  AnimalType animalType,
           @RequestParam(required = false) Long sellerId
    ){
        return milkPurchaseService.getAllMilkPurchase(  startDate,
                 endDate,
                 shift,
                 animalType,
                 sellerId);
    }



}
