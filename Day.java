public class Day {
    int day;
    int month;
    int year;
    String dayName;
    //String[] dayNames = new String[] {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};

    public Day(int theMonth, int theDay, int theYear)    {
        day = theDay;
        month = theMonth;
        year = theYear;
    }

    public void setDayName(Day date, String theDayName)    {
        this.dayName = theDayName;
    }

    public String getDayName(Day date) {
        return date.dayName;
    }

    public boolean isWorkDay(Day date)  {
        if (!date.getDayName(date).equals("Saturday") || !date.getDayName(date).equals("Saturday")) {
            date = new Workday(date.month, date.day, date.year);
            return true;

        }
        return false;
    }

    public boolean isNonWorkDay(Day date)  {
        if (date.getDayName(date).equals("Saturday") || date.getDayName(date).equals("Saturday")) {
            date = new NonWorkday(date.month, date.day, date.year, NWDtype.weekend);
            return true;

        }
        return false;
    }

}


