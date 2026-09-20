package DairyWeb.dairy.DairyServices;

import DairyWeb.dairy.DairyDTOs.RequestDTO.SalaryTransactionCreateDTO;
import DairyWeb.dairy.DairyEntities.Employee;
import DairyWeb.dairy.DairyEntities.SalaryTransaction;
import DairyWeb.dairy.DairyEnums.SalaryTransactionType;
import DairyWeb.dairy.DairyExceptions.BusinessException;
import DairyWeb.dairy.DairyRepository.EmployeeRepo;
import DairyWeb.dairy.DairyRepository.SalaryTransactionRepo;
import DairyWeb.dairy.DairySpecifications.SalaryTransactionSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalaryTransactionService {
    private SalaryTransactionRepo salaryTransactionRepo;
    private EmployeeRepo employeeRepo;
    public SalaryTransactionService(SalaryTransactionRepo salaryTransactionRepo, EmployeeRepo employeeRepo){
        this.salaryTransactionRepo=salaryTransactionRepo;
        this.employeeRepo=employeeRepo;
    }

    public SalaryTransaction createSalaryTransaction(SalaryTransactionCreateDTO req){
        Employee emp=employeeRepo.findById(req.getEmployeeId()).orElseThrow(
                ()->new BusinessException("Employee not found with this id : "+ req.getEmployeeId())
        );
        SalaryTransaction salaryTransaction= new SalaryTransaction();

        salaryTransaction.setAmount(req.getAmount());
        salaryTransaction.setEmployee(emp);
        salaryTransaction.setNotes(req.getNotes());
        salaryTransaction.setSalaryMonth(req.getSalaryMonth());
        salaryTransaction.setTransactionDate(req.getTransactionDate());
        salaryTransaction.setType(req.getType());

        return salaryTransactionRepo.save(salaryTransaction);

    }
    public List<SalaryTransaction> getAllSalaryTransactions(
            Long employeeId,
            LocalDate startDate,
            LocalDate endDate,
            String salaryMonth,
            SalaryTransactionType type
    ) {

        Specification<SalaryTransaction> specification =
                (root, query, cb) -> cb.conjunction();

        if (employeeId != null) {
            specification = specification.and(
                    SalaryTransactionSpecification.hasEmployeeId(employeeId)
            );
        }

        if (startDate != null) {
            specification = specification.and(
                    SalaryTransactionSpecification
                            .transactionDateGreaterThanOrEqualTo(startDate)
            );
        }

        if (endDate != null) {
            specification = specification.and(
                    SalaryTransactionSpecification
                            .transactionDateLessThanOrEqualTo(endDate)
            );
        }

        if (salaryMonth != null) {
            specification = specification.and(
                    SalaryTransactionSpecification.hasSalaryMonth(salaryMonth)
            );
        }

        if (type != null) {
            specification = specification.and(
                    SalaryTransactionSpecification.hasType(type)
            );
        }

        return salaryTransactionRepo.findAll(specification);
    }
}
