package tests;

public class TimeBuilder {


    private int hours;
    private int minutes;
    private int days;

    public TimeBuilder setHours(int hours) {

        this.hours = hours;
        return this;
    }

    public TimeBuilder setMinutes(int minutes) {

        this.minutes = minutes;
        return this;
    }

    public TimeBuilder setDays(int days) {

        this.days = days;
        return this;
    }

    public  TimeBuilder reset(){
        days=0;
        minutes=0;
        hours =0;
        return this;
    }

    public int toMinutes() {

        var result = 0;

        if(days> 0)
            result += days * 24*60;

        if (hours > 0)
            result += hours * 60;

        if(minutes> 0)
            result += minutes;

        return result;


    }
}
