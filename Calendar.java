public class Calendar {

    Day[] cal = new Day[366];
    String[] dayNames = new String[] {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};

    public Calendar()   {
    }

    public static void main(String[] args) {
        Calendar obj = new Calendar();
        obj.create_calendar();
        for (int i=0; i <366; i++) {
            System.out.println("calendar at " + i + " is month: " + obj.cal[i].month + " day: " + obj.cal[i].day + " year: " + obj.cal[i].year
                    + " the day is: " + obj.cal[i].getDayName(obj.cal[i]));
        }

    }

    public Day[] create_calendar()    {
        int year = 2020;
        int counter = 0;

        for (int i = 1; i<13; i++)  {
            if (i == 2) {
                for (int a = 1; a < 30; a++) {  //leap year
                    cal[counter] = new Day(i, a, year);
                    counter++;
                }
            }

            else if (i == 4 || i == 6 || i == 9 || i == 11) {  //april, june, sep, nov - 30 days
                for (int c=1; c<31; c++)    {
                    cal[counter] = new Day(i, c, year);
                    counter++;
                }
            }

            else    {   //31 days
                for (int b = 1; b < 32; b++) {
                    cal[counter] = new Day(i, b, year);
                    counter++;
                }
            }

        }
        int k = 0;
        for (int j = 0; j<366; j++) {
            if (k >= dayNames.length)    {
                k = 0;
            }
            cal[j].setDayName(cal[j], dayNames[k]);
            k++;
        }
        return cal;

    }

    /*
        Finds Day object in array that corresponds to particular day
     */
    public Day findDate(int month, int day, int year)   {
        for (int i =0; i <366; i++){
            if (cal[i].month == month && cal[i].day == day && cal[i].year == year)
                return cal[i]
        }
        return null;
    }

    /*

        would this be start day @ start time to end day @ end time
     */
    public int getWorkingTime(int startTime, int endTime, Day startDate, Day endDate){
        //should i change Day startdate to a string 001122 and parse it then call find day instead

    }

    public void addTempHoliday(String name, Day startDate, Day endDate) {

    }

    /*
        find index in array?
        delete?
     */
    public int getDayNumbers(Day startDate, Day endDate)    {
        return -1;
    }

    public void addRemoveNationalHoliday(String name, Day startDate, Day endDate, boolean type) {

    }

}


