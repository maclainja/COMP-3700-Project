public class Day {
    int day;
    int month;
    int year;
    String dayName;

    //String[] dayNames = new String[] {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};

    public Day(int theMonth, int theDay, int theYear) {
        day = theDay;
        month = theMonth;
        year = theYear;
    }

    public void setDayName(String theDayName) {
        this.dayName = theDayName;
    }

    public String getDayName() {
        return this.dayName;
    }



    public boolean isWorkDay(Day date) {
        return !isNonWorkDay(date);
    }


    public boolean isNonWorkDay(Day date) {
        //check weekend & holiday
        return isWeekend(date) || isHoliday(date);
    }

    public boolean isWeekend(Day date) {
        return date.getDayName().equals("Saturday") || date.getDayName().equals("Sunday");
    }

    public boolean isHoliday(Day date)  {
        int i = 0;
        while (i < Calendar.holis.size())   {
            if (Calendar.holis.get(i).month == date.month && Calendar.holis.get(i).day == date.day && Calendar.holis.get(i).year == date.year)  {
                return true;
            }
            i++;
        }
        return false;
    }





}


