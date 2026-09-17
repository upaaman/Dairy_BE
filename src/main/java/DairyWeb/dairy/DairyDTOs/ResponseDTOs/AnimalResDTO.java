package DairyWeb.dairy.DairyDTOs.ResponseDTOs;

import DairyWeb.dairy.DairyEnums.AnimalGender;
import DairyWeb.dairy.DairyEnums.AnimalStatus;
import DairyWeb.dairy.DairyEnums.AnimalType;

public class AnimalResDTO {
    private AnimalGender gender;
    private String breed;
    private String name;

    public AnimalGender getGender() {
        return gender;
    }

    public void setGender(AnimalGender gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

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

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    private AnimalStatus status;
    private AnimalType type;
}
