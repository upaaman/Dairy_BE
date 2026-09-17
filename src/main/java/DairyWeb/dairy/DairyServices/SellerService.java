package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyEntities.Seller;
import DairyWeb.dairy.DairyRepository.SellerRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class SellerService {
    private SellerRepo sellerRepo;
    public SellerService(SellerRepo sellerRepo){
        this.sellerRepo=sellerRepo;
    }


    public Seller createSeller(Seller seller){

        return sellerRepo.save(seller);
    }
    public List<Seller> getAllSellers(){

        return sellerRepo.findAll();
    }

    public Seller deleteSellerById(Long id){
        Optional<Seller> temp=sellerRepo.findById(id);
        if(temp.isPresent()){
        sellerRepo.deleteById(id);
        return temp.get();
        }
        return null;
    }

}
