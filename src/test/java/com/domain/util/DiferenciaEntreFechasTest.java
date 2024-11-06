package com.domain.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiferenciaEntreFechasTest {

    @Autowired
    public DiferenciaEntreFechas diferenciaEntreFechas;

    @Test
    void calculateIssueYears() {
        diferenciaEntreFechas = new DiferenciaEntreFechas();

        LocalDate currentDate  = LocalDate.now();
        LocalDate yesterdayDate = currentDate.minusYears(100);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaIndependencia = yesterdayDate.format(myFormatObj);
        //String fechaIndependencia = "12/08/1844";

        Period resultado = diferenciaEntreFechas.calculateYearsOfIndependency(fechaIndependencia);

        assertEquals(0,resultado.getMonths() );
        assertEquals(0,resultado.getDays() );
        assertEquals(100,resultado.getYears() );
    }

    @Test
    void givenDate_whenUsingDateClass_thenReturnYesterday() {
        Date date = new Date(2023, Calendar.DECEMBER, 20);
        Date yesterdayDate = new Date(date.getTime() - 24 * 60 * 60 * 1000);
        Date expectedYesterdayDate = new Date(2023, Calendar.DECEMBER, 19);

        assertEquals(expectedYesterdayDate, yesterdayDate);
    }

    @Test
    void givenDate_whenUsingLocalDateClass_thenReturnYesterday() {
        LocalDate localDate = LocalDate.of(2023, 12, 20);
        LocalDate yesterdayDate = localDate.minusDays(1);
        LocalDate expectedYesterdayDate = LocalDate.of(2023, 12, 19);

        assertEquals(expectedYesterdayDate, yesterdayDate);
    }

    @Test
    void givenDate_whenUsingCalendarClass_thenReturnYesterday() {
        Calendar date = new GregorianCalendar(2023, Calendar.APRIL, 20, 4, 0);
        date.add(Calendar.DATE, -1);
        Calendar expectedYesterdayDate = new GregorianCalendar(2023, Calendar.APRIL, 19, 4, 0);

        assertEquals(expectedYesterdayDate, date);
    }

}