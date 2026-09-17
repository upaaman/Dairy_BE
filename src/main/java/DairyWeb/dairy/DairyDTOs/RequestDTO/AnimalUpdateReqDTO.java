package DairyWeb.dairy.DairyDTOs.RequestDTO;

import DairyWeb.dairy.DairyEnums.AnimalStatus;

public class AnimalUpdateReqDTO {
    private String name;
    private AnimalStatus status;
    private String notes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalStatus getStatus() {
        return status;
    }

    public void setStatus(AnimalStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
