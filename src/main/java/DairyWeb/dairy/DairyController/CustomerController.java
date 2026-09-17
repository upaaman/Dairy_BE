package DairyWeb.dairy.DairyController;

import DairyWeb.dairy.DairyDTOs.RequestDTO.CustomerSellerUpdateDTO;
import DairyWeb.dairy.DairyEntities.Customer;
import DairyWeb.dairy.DairyServices.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer request){
        return ResponseEntity.status(200).body(customerService.createCustomer(request));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.status(200).body(customerService.getAllCustomers());
    }

    @PatchMapping("/update/{id}")
    public String updateCustomerById(
            @PathVariable Long id,
            @Valid  @RequestBody CustomerSellerUpdateDTO customer){

        customerService.updateCustomer(id,customer);
        return "Customer updated successfully.";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id){
        Customer temp=customerService.deleteCustomerById(id);
        if(temp==null){
        return ResponseEntity.status(400).body("No customer found with this id.");
        }
        return ResponseEntity.status(200).body("Customer deleted Successully");
    }

}
