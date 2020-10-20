package com.bbhorty.api.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class EnvironmentVariable {

    @Value("${base-url.api}")
    private String apiBaseUrl;

    @Value("${base-url.cdn}")
    private String cdnBaseUrl;

    public final static String CATALOGUE_URI = "catalogue";

    public final static String CATEGORY_URI = "category";

    public final static String FAMILY_URI = "family";

    public final static String REGROUPMENT_URI = "regroupment";

    public final static String PLANT_URI = "plant";

}
