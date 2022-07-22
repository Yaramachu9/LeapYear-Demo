package com.example.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class LeapYearTest {

  @Autowired
  private LeapYear leapYear;


  @Test
  public void testYearDivisibleBy400() throws Exception{

      int year = 2000;
      boolean result = leapYear.isLeapYear(year);
      Assertions.assertEquals(true, result);

  }

    @Test
    public void testYearDivisibleBy100NotBy400() throws Exception{

        int year = 1700;
        boolean result = leapYear.isLeapYear(year);
        Assertions.assertEquals(false, result);

    }

    @ParameterizedTest
    @ValueSource(ints = {2008,2012,2016})
    public void testYearsDivisibleBy4NotBy100(int year) throws Exception{

        boolean result = leapYear.isLeapYear(year);
        Assertions.assertEquals(true, result);

    }

    @ParameterizedTest
    @ValueSource(ints = {2017, 2018, 2019})
    public void testYearsNotDivisibleBy4(int year) throws Exception{

        boolean result = leapYear.isLeapYear(year);
        Assertions.assertEquals(false, result);

    }

    @Test
    public void testNegativeYear() {

        Exception exception = assertThrows(
                Exception.class,
                () -> leapYear.isLeapYear(-1700)
        );

        Assertions.assertEquals("Year can't be negative",exception.getMessage());

    }



}
