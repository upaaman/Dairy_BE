package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.CustomerSellerUpdateDTO;
import DairyWeb.dairy.DairyEntities.Seller;
import DairyWeb.dairy.DairyExceptions.BusinessException;
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

    public Seller updateSeller(Long id, CustomerSellerUpdateDTO request){
        Seller updatedSeller=sellerRepo.findById(id).orElseThrow(
                ()->new BusinessException("Seller not found with this id "+ id));

        if(request.getName()!=null){
            updatedSeller.setName(request.getName());
        }
        if(request.getAddress()!=null){
            updatedSeller.setAddress(request.getAddress());
        }
        if(request.getContact()!=null){
            updatedSeller.setContact(request.getContact());
        }
        if(request.getMilkRates()!=null){
            updatedSeller.setMilkRates(request.getMilkRates());
        }


        return sellerRepo.save(updatedSeller);
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
