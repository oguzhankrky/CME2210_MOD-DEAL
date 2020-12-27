package person;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;



public class Date {
    

    private int year;
    private int month;
    private int day;
    public Date(String date) {
        this.month = Integer.parseInt(date.split(":")[0]);
        this.year = Integer.parseInt(date.split(":")[1]);
    }

    @Override
    public String toString() {
        return  day +
                ":" + month +
                ":" + year;
    }
    public String toString2() {
        return   month +
                ":" + year;
    } 
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if(o==null)return false;
        Date date = new Date(String.valueOf(o));
        return year == date.year &&
                month == date.month;
    }


}
