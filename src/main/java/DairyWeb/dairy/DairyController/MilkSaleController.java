package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.RequestDTO.MilkSaleRequstDTO;
import DairyWeb.dairy.DairyDTOs.RequestDTO.MilkSaleUpdateDTO;
import DairyWeb.dairy.DairyEntities.MilkSale;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import DairyWeb.dairy.DairyServices.MilkSaleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/milkSale")
public class MilkSaleController {
    private MilkSaleService milkSaleService;
    public MilkSaleController(MilkSaleService milkSaleService ){
        this.milkSaleService=milkSaleService;
    }

    @PostMapping("/create")
    public ResponseEntity<MilkSale> createMilkSale(@RequestBody MilkSaleRequstDTO request){
        MilkSale temp=milkSaleService.createMilkSale(request);
        if(temp==null){
            return ResponseEntity.status(400).body(null);
        }
        return ResponseEntity.status(200).body(temp);
    }

    @PatchMapping("/update/{id}")
    public MilkSale updateMilkSale(@PathVariable Long id ,@Valid @RequestBody MilkSaleUpdateDTO request){
       return milkSaleService.updateMilkSale(id,request);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MilkSale>> getAllMilkSale(
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam (required = false)MilkShifts shift,
            @RequestParam(required = false) AnimalType animalType,
            @RequestParam (required = false)Long customerId
    ){
        List<MilkSale> temp=milkSaleService.getAllMilkSale(startDate,endDate,shift,animalType,customerId);
        return ResponseEntity.status(200).body(temp);
    }
}
