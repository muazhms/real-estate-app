package com.realestateapp;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomApartmentGeneratorTest {
    private static final double MAX_MULTIPLIER = 4.0;

    private double minArea;
    private BigDecimal minPricePerSquareMeter;

    @Test
    void should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice(){
        this.minArea = 30.0;
        this.minPricePerSquareMeter = new BigDecimal(3000.0);

        for (int i = 0; i < 10; i++) {
            RandomApartmentGenerator randomApartment = new RandomApartmentGenerator();
            Apartment apartment = randomApartment.generate();

            assertTrue(isApartmentAreaInRange(apartment.getArea()));
            assertTrue(isApartmentPriceInRange(apartment.getPrice()));
        }
    }

    @Test
    void should_GenerateCorrectApartment_When_CustomMinAreaMinPrice(){
        this.minArea = 40.0;
        this.minPricePerSquareMeter = new BigDecimal(6000.0);

        for (int i = 0; i < 10; i++) {
            RandomApartmentGenerator randomApartment = new RandomApartmentGenerator(minArea, minPricePerSquareMeter);
            Apartment apartment = randomApartment.generate();

            assertTrue(isApartmentAreaInRange(apartment.getArea()));
            assertTrue(isApartmentPriceInRange(apartment.getPrice()));
        }
    }

    private boolean isApartmentAreaInRange(double area) {
        return area > minArea && area < minArea * MAX_MULTIPLIER;
    }

    private boolean isApartmentPriceInRange(BigDecimal price){
        BigDecimal minPrice = new BigDecimal(minArea).multiply(minPricePerSquareMeter);
        BigDecimal maxPrice = new BigDecimal(minArea).multiply(minPricePerSquareMeter).multiply(new BigDecimal(MAX_MULTIPLIER)).multiply(new BigDecimal(MAX_MULTIPLIER));
        return price.compareTo(minPrice) > 0  && price.compareTo(maxPrice) < 0;
    }
}
