import java.util.*;
import java.util.ArrayList;
import java.math.*;

public class Calendar {

    Day[] cal = new Day[366];
    String[] dayNames = new String[] {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
    public static List<NonWorkday> holis = new ArrayList<NonWorkday>();

    public Calendar()   {
    }

    public static void main(String[] args) {
        Calendar obj = new Calendar();
        obj.create_Calendar();
        for (int i=0; i <366; i++) {
            System.out.println("Calendar at " + i + " is month: " + obj.cal[i].month + " day: " + obj.cal[i].day + " year: " + obj.cal[i].year
                    + " the day is: " + obj.cal[i].getDayName());
        }

        obj.createWeekends();
        obj.createWorkdays();


    }

    /*
        Realized everyday has two day instances - ex. if a day is a Saturday it has a Day instance and a nonworkday instance
        Code works just redundant and not the most efficient

     */
    public Day[] create_Calendar()    {
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
            cal[j].setDayName(dayNames[k]);
            k++;
        }
        return cal;

    }

    public void createWeekends()    {
        for (int i =0; i < 366; i++)    {
            if (cal[i].isWeekend(cal[i]))   {
                String tempDayName = cal[i].dayName;
                cal[i] = new NonWorkday(cal[i].month, cal[i].day, cal[i].year, NWDtype.weekend);
                cal[i].dayName = tempDayName;
            }
        }
    }

    public void createWorkdays()    {
        for (int i =0; i < 366; i++)    {
            if (cal[i].isWorkDay(cal[i]))   {
                String tempDayName = cal[i].dayName;
                cal[i] = new Workday(cal[i].month, cal[i].day, cal[i].year);
                cal[i].dayName = tempDayName;
            }
        }
    }


    /*
        Finds Day object in array that corresponds to particular day
     */
    public int findDate(int month, int day, int year)   {
        for (int i =0; i <366; i++){
            if (cal[i].month == month && cal[i].day == day && cal[i].year == year)
                return i;
        }
        return -1;
    }


    public double getWorkingTime(Request request){
        //int startHour, int startMin, int endHour, int endMin, int startDay_index, int endDate_index
        int startDay_index = findDate(request.startMonth, request.startDay, request.startYear);
        int endDate_index = findDate(request.endMonth, request.endDay, request.endYear);
        int startHour = request.startHour;
        int endHour = request.endHour;
        int startMin = request.startMinute;
        int endMin = request.endMinute;

        int total_work_days = 0;
        double total_work_min = 0;
        int total_work_hours = 0;
        double totalWorkTime;
        
        DayWithTime startDWT = new DayWithTime(request.startMonth, request.startDay, request.startYear, request.startHour, request.startMinute);
        DayWithTime endDWT = new DayWithTime(request.endMonth, request.endDay, request.endYear, request.endHour, request.endMinute);
        if (startDWT.compareTo(endDWT) == 1) {
           return 0;
        }
        
        if (startDay_index == endDate_index)    {

            total_work_hours += endHour - (startHour + 1);

            total_work_min += 60 - startMin;
            total_work_min += endMin;

        }

        else {
            //add all full work days up
            for (int i = startDay_index + 1; i < endDate_index - 1; i++) {
                if (cal[i].isWorkDay(cal[i])) {
                    total_work_days++;
                }
            }

            total_work_hours += total_work_days * Workday.totalTime;

            //add in start day
            if (startHour >= 9) {
                if (cal[startDay_index].isWorkDay(cal[startDay_index])) {
                    total_work_hours += Workday.endTime - (startHour + 1);
                    total_work_min += 60 - startMin;
                }
            }

            if (endHour <= 17) {
                if (cal[endDate_index].isWorkDay(cal[endDate_index])) {
                    total_work_hours += endHour - Workday.startTime;
                    total_work_min += endMin;
                }
            }

        }

        if (total_work_min >= 60) {
            total_work_min = total_work_min - 60;
            total_work_hours++;
        }

        total_work_min = total_work_min / 60;
        totalWorkTime = total_work_hours + total_work_min;
        BigDecimal bd = new BigDecimal(Double.toString(totalWorkTime));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        totalWorkTime = bd.doubleValue();

        return totalWorkTime;

    }


    public void addTempHoliday(String name, Day startDate, Day endDate) {
        int start = findDate(startDate.month, startDate.day, startDate.year);
        int end = findDate(endDate.month, endDate.day, endDate.year);
        for (int i = start; i <= end; i++) {
            NonWorkday holi = new NonWorkday(cal[i].month, cal[i].day, cal[i].year, NWDtype.holiday);
            holi.setName(name);
            holi.setDayName(cal[i].getDayName());
            holis.add(holi);
            cal[i] = holi;
        }

    }


    public void addRemoveNationalHoliday(String name, Day startDate, Day endDate, String type) {
        int start = findDate(startDate.month, startDate.day, startDate.year);
        int end = findDate(endDate.month, endDate.day, endDate.year);

        if (type.equals("remove")) {
            for (int i= start; i <= end; i++)    {
                int j=0;
                while (j < holis.size())    {
                    if (Calendar.holis.get(j).month == cal[i].month && Calendar.holis.get(j).day == cal[i].day && Calendar.holis.get(j).year == cal[i].year)  {
                        holis.remove(holis.get(j));
                        Workday wd = new Workday(cal[i].month, cal[i].day, cal[i].year);
                        wd.setDayName(cal[i].getDayName());
                        cal[i] = wd;
                    }
                    else    {
                        j++;
                    }
                }

            }
        }

        if (type.equals("add"))  {
            for (int i = start; i <= end; i++) {
                NonWorkday holi = new NonWorkday(cal[i].month, cal[i].day, cal[i].year, NWDtype.holiday);
                holi.setName(name);
                holi.setDayName(cal[i].getDayName());
                holis.add(holi);
                cal[i] = holi;
            }
        }

    }

}


