package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.RequestDTO.VaccineCreateDTO;
import DairyWeb.dairy.DairyEntities.Vaccine;
import DairyWeb.dairy.DairyServices.VaccineService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {
    private final VaccineService vaccineService;
    public VaccineController(VaccineService vaccineService){
        this.vaccineService=vaccineService;
    }
    @PostMapping("/create")
    public Vaccine createVacccine(@RequestBody @Valid VaccineCreateDTO req){
        return vaccineService.createVaccine(req);
    }
    @GetMapping("getAll")
    public List<Vaccine> getAll(){
        return vaccineService.getAll();
    }
}
