package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.MilkProductionUpdateDTO;
import DairyWeb.dairy.DairyDTOs.RequestDTO.MilkSaleRequstDTO;
import DairyWeb.dairy.DairyDTOs.RequestDTO.MilkSaleUpdateDTO;
import DairyWeb.dairy.DairyEntities.Animal;
import DairyWeb.dairy.DairyEntities.Customer;
import DairyWeb.dairy.DairyEntities.MilkProduction;
import DairyWeb.dairy.DairyEntities.MilkSale;
import DairyWeb.dairy.DairyEnums.AnimalType;
import DairyWeb.dairy.DairyEnums.MilkShifts;
import DairyWeb.dairy.DairyExceptions.AnimalNotFoundException;
import DairyWeb.dairy.DairyExceptions.BusinessException;
import DairyWeb.dairy.DairyRepository.CustomerRepo;
import DairyWeb.dairy.DairyRepository.MilkSaleRepo;
import DairyWeb.dairy.DairySpecifications.MilkSaleSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class MilkSaleService {
    private MilkSaleRepo milkSaleRepo;
    private CustomerRepo customerRepo;
    public MilkSaleService(MilkSaleRepo milkSaleRepo, CustomerRepo customerRepo){
        this.milkSaleRepo=milkSaleRepo;
        this.customerRepo=customerRepo;
    }
    public MilkSale createMilkSale(MilkSaleRequstDTO request){
        Customer customer= customerRepo.findById(request.getCustomerId())
                .orElseThrow(() ->
                new RuntimeException("Customer not found with this id."));

        MilkSale sale= new MilkSale();

        sale.setAnimalType(request.getAnimalType());
        sale.setCustomer(customer);
        sale.setQuantity(request.getQuantity());
        sale.setRate(request.getRate());
        sale.setSaleDate(request.getSaleDate());
        sale.setShift(request.getShift());

        BigDecimal totalAmount = request.getQuantity().multiply(request.getRate());
        sale.setAmount(totalAmount);

      return  milkSaleRepo.save(sale);

    }

public MilkSale updateMilkSale(Long id, MilkSaleUpdateDTO req){
    MilkSale milkSale=milkSaleRepo.findById(id).orElseThrow(
            ()-> new BusinessException("Milk sale not found with this id")
    );
    Customer customer=customerRepo.findById(req.getCustomerId()).orElseThrow(
            ()-> new BusinessException("Customer not found with this id")
    );

    milkSale.setSaleDate(req.getSaleDate());
    milkSale.setQuantity(req.getQuantity());
    milkSale.setRate(req.getRate());
    milkSale.setShift(req.getShift());
    milkSale.setAnimalType(req.getAnimalType());
    milkSale.setAmount(req.getAmount());
    milkSale.setCustomer(customer);


    return milkSaleRepo.save(milkSale);
}


    public List<MilkSale> getAllMilkSale(
            LocalDate startDate,
            LocalDate endDate,
            MilkShifts shift,
            AnimalType animalType,
            Long customerId
    ) {

        Specification<MilkSale> specification =
                Specification.where(
                                MilkSaleSpecification.hasStartDate(startDate)
                        )
                        .and(MilkSaleSpecification.hasEndDate(endDate))
                        .and(MilkSaleSpecification.hasShift(shift))
                        .and(MilkSaleSpecification.hasAnimalType(animalType))
                        .and(MilkSaleSpecification.hasCustomerId(customerId));

        return milkSaleRepo.findAll(specification);
    }

}
