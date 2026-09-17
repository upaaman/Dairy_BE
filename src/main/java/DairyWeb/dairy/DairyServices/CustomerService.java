package DairyWeb.dairy.DairyServices;
import DairyWeb.dairy.DairyDTOs.RequestDTO.CustomerSellerUpdateDTO;
import DairyWeb.dairy.DairyEntities.Customer;
import DairyWeb.dairy.DairyExceptions.BusinessException;
import DairyWeb.dairy.DairyRepository.CustomerRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepo customerRepo;
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo=customerRepo;
    }


    public Customer createCustomer(Customer customer){

        return customerRepo.save(customer);
    }
    public Customer updateCustomer(Long id, CustomerSellerUpdateDTO request){
    Customer updatedCustomer=customerRepo.findById(id).orElseThrow(
            ()->new BusinessException("Customer not found with this id "+ id));

        if(request.getName()!=null){
         updatedCustomer.setName(request.getName());
        }
        if(request.getAddress()!=null){
            updatedCustomer.setAddress(request.getAddress());
        }
        if(request.getContact()!=null){
            updatedCustomer.setContact(request.getContact());
        }
        if(request.getMilkRates()!=null){
            updatedCustomer.setMilkRates(request.getMilkRates());
        }


        return customerRepo.save(updatedCustomer);
    }
    public List<Customer> getAllCustomers(){

        return customerRepo.findAll();
    }

    public Customer deleteCustomerById(Long id){
        Optional<Customer> temp=customerRepo.findById(id);
        if(temp.isPresent()){
            customerRepo.deleteById(id);
            return temp.get();
        }
        return null;
    }

}
