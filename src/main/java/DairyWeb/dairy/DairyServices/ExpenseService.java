package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.ExpenseCreateReqDTO;
import DairyWeb.dairy.DairyEntities.Animal;
import DairyWeb.dairy.DairyEntities.Expense;
import DairyWeb.dairy.DairyExceptions.BusinessException;
import DairyWeb.dairy.DairyRepository.AnimalRepo;
import DairyWeb.dairy.DairyRepository.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private ExpenseRepo expenseRepo;
    private AnimalRepo animalRepo;
    public  ExpenseService(ExpenseRepo expenseRepo,AnimalRepo animalRepo){
        this.expenseRepo=expenseRepo;
        this.animalRepo=animalRepo;

    }
    public Expense createExpense(ExpenseCreateReqDTO req){


       Expense expense=new Expense();
       expense.setAmount(req.getAmount());
       expense.setExpenseDate(req.getExpenseDate());
       expense.setNotes(req.getNotes());
       expense.setType(req.getType());
       if(req.getImageUrl()!=null){
           expense.setImageUrl(req.getImageUrl());
       }

        if (req.getAnimalId() != null) {
            Animal animal = animalRepo.findById(req.getAnimalId())
                    .orElseThrow(() -> new BusinessException("Animal not found"));

            expense.setAnimal(animal);
        }


       return expenseRepo.save(expense);
    }

    public List<Expense>getAllExpeses(){
        return expenseRepo.findAll();
    }

}
