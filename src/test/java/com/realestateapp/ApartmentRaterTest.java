package com.realestateapp;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRaterTest {

    @Test
    void should_ReturnCorrectRating_When_CorrectApartment() {
        Apartment apartmentBest = new Apartment(5.0, new BigDecimal(10000.0));
        assertEquals(0, ApartmentRater.rateApartment(apartmentBest));

        Apartment apartmentNormal = new Apartment(2.0, new BigDecimal(14000.0));
        assertEquals(1, ApartmentRater.rateApartment(apartmentNormal));

        Apartment apartmentWorst = new Apartment(2.0, new BigDecimal(20000.0));
        assertEquals(2, ApartmentRater.rateApartment(apartmentWorst));
    }

    @Test
    void should_ReturnErrorValue_When_IncorrectApartment(){
        Apartment apartmentIncorrect = new Apartment(0.0, new BigDecimal(10000.0));
        assertEquals(-1, ApartmentRater.rateApartment(apartmentIncorrect));
    }

    @Test
    void should_CalculateAverageRating_When_CorrectApartmentList(){
        List<Apartment> apartmentsListCorrect = new ArrayList<>();
        apartmentsListCorrect.add(new Apartment(5.0, new BigDecimal(10000.0)));
        apartmentsListCorrect.add(new Apartment(2.0, new BigDecimal(14000.0)));
        apartmentsListCorrect.add(new Apartment(2.0, new BigDecimal(20000.0)));

        assertEquals(1, ApartmentRater.calculateAverageRating(apartmentsListCorrect));
    }

    @Test
    void should_ThrowExceptionInCalculateAverageRating_When_EmptyApartmentList(){
        List<Apartment> apartmentsListEmpty = new ArrayList<>();

        assertThrows(RuntimeException.class, () -> {
            ApartmentRater.calculateAverageRating(apartmentsListEmpty);
        });

    }
}
