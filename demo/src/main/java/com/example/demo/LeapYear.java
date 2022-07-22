package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class LeapYear {

    public boolean isLeapYear(final int year) throws Exception{

        if(year < 0)
          throw new Exception("Year can't be negative");

        if(year % 100 == 0 && year % 400 != 0)
            return false;

        if(year % 4 == 0 && year % 100 != 0)
            return true;

        if(year % 4 != 0)
            return false;

        return true;
    }

}
