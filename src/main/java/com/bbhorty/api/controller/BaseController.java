package com.bbhorty.api.controller;

import com.bbhorty.api.entity.dto.CatalogueDTO;
import com.bbhorty.api.utils.EnvironmentVariable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Collection;

@RestController
@RequestMapping
@RequiredArgsConstructor
@ApiIgnore
public class BaseController {

    @GetMapping
    public String HelloWorld(){
        return "Hello World";

    }

}
