public class CalendarController {

    Calendar theCal;

    public CalendarController() {
        theCal = new Calendar();
        theCal.create_Calendar();
        theCal.createWeekends();
        theCal.createWorkdays();
    }

    public void addTempHoliday(String name, int startMonth, int startDay, int startYear, int endMonth, int endDay, int endYear)   {
        int holidayStart = theCal.findDate(startMonth, startDay, startYear);
        int holidayEnd = theCal.findDate(endMonth, endDay, endYear);
        theCal.addTempHoliday(name, theCal.cal[holidayStart], theCal.cal[holidayEnd]);
    }

    public void addRemoveNationalHoliday(String name, int startMonth, int startDay, int startYear, int endMonth, int endDay, int endYear, String type)   {
        int holidayStart = theCal.findDate(startMonth, startDay, startYear);
        int holidayEnd = theCal.findDate(endMonth, endDay, endYear);
        theCal.addRemoveNationalHoliday(name, theCal.cal[holidayStart], theCal.cal[holidayEnd], type);
    }

    public double getWorkingTime(Request request){
        return theCal.getWorkingTime(request);
    }

}
