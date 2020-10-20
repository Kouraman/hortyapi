package com.bbhorty.api.utils;

import com.bbhorty.api.entity.models.Catalogue;
import com.bbhorty.api.entity.models.Image;
import com.bbhorty.api.entity.models.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CdnUrlMaker {

    @Autowired
    EnvironmentVariable env;

    private String getCdnUrl(){
        return env.getCdnBaseUrl();
    }

    public String getImgPath(Catalogue catalogue){
        return getCdnUrl()+"/"+catalogue.getSrcImg();
    }


    public Collection<Image> setImgPath(Plant plant){

        plant.getImages().forEach(image -> image.setSrcImg(getCdnUrl()+"/"+image.getSrcImg()));

        return plant.getImages();
    }
}
