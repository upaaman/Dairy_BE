package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyEntities.Seller;
import DairyWeb.dairy.DairyServices.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {
    private SellerService sellerService;
    public SellerController(SellerService sellerService){
        this.sellerService=sellerService;
    }
    @PostMapping("/create")
    public Seller addSeller(@RequestBody Seller seller){
        return sellerService.createSeller(seller);
    }

    @GetMapping("/getAll")
    public List<Seller> addSeller(){
        return sellerService.getAllSellers();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSellerById(@PathVariable Long id){
        System.out.println(id+"id is here bro");
        Seller temp=sellerService.deleteSellerById(id);
        if(temp==null){
            return ResponseEntity.status(400).body("No seller present with this id.");
        }
        return ResponseEntity.status(200).body("Seller deleted successfully");
    }
}
