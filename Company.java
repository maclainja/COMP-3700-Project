
public class Company {

   final String companyName = "drShaikInc";
   DayWithTime today;
   
   EmployeeRequestController erc;
   ManagerRequestController mrc;
   PersonController pc;
   PTOController ptoc;
   RequestController rc;
   RequestDatabaseController rdc;
   //CalendarController cc;
   
   public Company() {
      erc = new EmployeeRequestController();
      mrc = new ManagerRequestController();
      ptoc = new PTOController();
      pc = new PersonController(ptoc);
   
      rc = new RequestController();
      rdc = new RequestDatabaseController();
      //cc = new CalendarController();
      
      erc.pc = pc;
      erc.rc = rc;
      erc.rdc = rdc;
      
      mrc.rdc = rdc;
      
      
      
      //rdc.cc = cc;
      rdc.ptoc = ptoc;
      rdc.c = this;
      today = new DayWithTime(1,1,2020,9,0);
      
      
   }

   public void setDate(int newMonth, int newDay, int newYear, int newHour, int newMinute) {
      today.day.day = newDay;
      today.day.month = newMonth;
      today.day.year = newYear;
      today.hour = newHour;
      today.minute = newMinute;
   }
  
   public DayWithTime getDate() {
         
      return today;
      
   }      
      
   
}     

