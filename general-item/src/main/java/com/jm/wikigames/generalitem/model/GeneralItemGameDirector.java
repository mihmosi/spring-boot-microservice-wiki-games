package com.jm.wikigames.generalitem.model;

import com.jm.wikigames.generalitem.model.enums.Status;
import lombok.Builder;
import lombok.NonNull;

public class GeneralItemGameDirector {

    @Builder(builderMethodName = "builderRelease")
    public static GeneralItemGame generalItemGameRelease(Long id, @NonNull String name, String dateOfCreation, String genre, String heroes, String villains) {
        return new GeneralItemGame(id, name, dateOfCreation, genre, heroes, villains, Status.RELEASE);
    }

    @Builder(builderMethodName = "builderProduction", builderClassName = "BuilderProduction")
    public static GeneralItemGame generalItemGameProduction(Long id, @NonNull String name, String dateOfCreation, String genre, String heroes, String villains) {
        return new GeneralItemGame(id, name, dateOfCreation, genre, heroes, villains, Status.PRODUCTION);
    }

}
