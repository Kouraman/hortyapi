package com.bbhorty.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;


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