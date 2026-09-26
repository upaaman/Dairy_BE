package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyEnums.BreedingStatus;

import java.time.LocalDate;

public class BreedingUpdateDTO {
    private String notes;
    private LocalDate actualCalvingDate;
    private BreedingStatus status;
    private Long producedAnimal;

    public LocalDate getActualCalvingDate() {
        return actualCalvingDate;
    }

    public BreedingStatus getStatus() {
        return status;
    }

    public Long getProducedAnimal() {
        return producedAnimal;
    }

    public String getNotes() {
        return notes;
    }

}
