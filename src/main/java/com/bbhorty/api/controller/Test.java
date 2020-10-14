package com.bbhorty.api.controller;

import com.bbhorty.api.entity.Families;
import com.bbhorty.api.entity.Regroupments;
import com.bbhorty.api.services.FamiliesService;
import com.bbhorty.api.services.RegroupmentsService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;


@RestController
@RequiredArgsConstructor
@Slf4j
class Test {
    @GetMapping()
    LocalDate test() {
        long time = Period.ofWeeks(3).get(ChronoUnit.DAYS);
        Period period = Period.ofDays(20);
        LocalDate date = LocalDate.now();
        date.plus(period);

        return  date;
    }


}