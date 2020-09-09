package com.bbhorty.api.controller;

import com.bbhorty.api.services.FamiliesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/catalogue")
@RequiredArgsConstructor
@Slf4j
class Test {

    @Autowired
    private FamiliesService familiesService;


    @GetMapping("/test")
    String test() {
        return familiesService.getById(1).getName();
    }

}