package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.MilkPurchaseRequestDTO;
import DairyWeb.dairy.DairyEntities.MilkPurchase;
import DairyWeb.dairy.DairyEntities.Seller;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import DairyWeb.dairy.DairyRepository.MilkPurchaseRepo;
import DairyWeb.dairy.DairyRepository.SellerRepo;
import DairyWeb.dairy.DairySpecifications.MilkPurchaseSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class MilkPurchaseService {
    private MilkPurchaseRepo milkPurchaseRepo;
    private SellerRepo sellerRepo;
    public MilkPurchaseService(MilkPurchaseRepo milkPurchaseRepo,SellerRepo sellerRepo){
        this.milkPurchaseRepo=milkPurchaseRepo;
        this.sellerRepo = sellerRepo;
    }
    public MilkPurchase createMilkPurchase(MilkPurchaseRequestDTO request){
        Seller seller=sellerRepo.findById(request.getSellerId())
                .orElseThrow(() ->
                        new RuntimeException("Seller not found with this id"));
        MilkPurchase purchase= new MilkPurchase();

        purchase.setPurchaseDate(request.getPurchaseDate());
        purchase.setShift(request.getShift());
        purchase.setQuantity(request.getQuantity());
        purchase.setRate(request.getRate());
        purchase.setAnimalType(request.getAnimalType());
        purchase.setSeller(seller);

        BigDecimal totalAmount = request.getQuantity().multiply(request.getRate());
        purchase.setAmount(totalAmount);

        return milkPurchaseRepo.save(purchase);
    }
    public List<MilkPurchase> getAllMilkPurchase(
            LocalDate startDate,
            LocalDate endDate,
            MilkShifts shift,
            AnimalType animalType,
            Long sellerId
    ) {

        Specification<MilkPurchase> specification =
                Specification.where(
                                MilkPurchaseSpecification.hasStartDate(startDate)
                        )
                        .and(MilkPurchaseSpecification.hasEndDate(endDate))
                        .and(MilkPurchaseSpecification.hasShift(shift))
                        .and(MilkPurchaseSpecification.hasAnimalType(animalType))
                        .and(MilkPurchaseSpecification.hasSellerId(sellerId));

        return milkPurchaseRepo.findAll(specification);
    }

}
