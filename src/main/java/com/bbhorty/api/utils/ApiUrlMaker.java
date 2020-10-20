package com.bbhorty.api.utils;

import com.bbhorty.api.entity.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiUrlMaker {

    @Autowired
    EnvironmentVariable env;

    public String getPath(Catalogue catalogue){
        if (catalogue instanceof Category){
            return getCategory((Category) catalogue);
        }
        if (catalogue instanceof Family){
            return getFamily((Family) catalogue);
        }
        if (catalogue instanceof Regroupment){
            return getRegroupment((Regroupment) catalogue);
        }
        if (catalogue instanceof Plant){
            return getPlant((Plant) catalogue);
        }
        return "error";
    }

    public String getPath(Plant plant){
        return getCatalogue()+"/"+EnvironmentVariable.PLANT_URI+"/"+plant.getId();
    }

    private String getCatalogue(){
        return env.getApiBaseUrl()+"/"+EnvironmentVariable.CATALOGUE_URI;
    }

    private String getCategory(Category category){
        return getCatalogue()+"/"+EnvironmentVariable.CATEGORY_URI+"/"+category.getId();
    }

    private String getFamily(Family family){
        return getCatalogue()+"/"+EnvironmentVariable.FAMILY_URI+"/"+family.getId();
    }

    private String getRegroupment(Regroupment regroupment){
        return getCatalogue()+"/"+EnvironmentVariable.REGROUPMENT_URI+"/"+regroupment.getId();
    }

    private String getPlant(Plant plant){
        return getCatalogue()+"/"+EnvironmentVariable.PLANT_URI+"/"+plant.getId();
    }


}
