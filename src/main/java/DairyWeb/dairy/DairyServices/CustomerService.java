package DairyWeb.dairy.DairyServices;
import DairyWeb.dairy.DairyEntities.Customer;
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
