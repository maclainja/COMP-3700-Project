
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
      pc = new PersonController();
      ptoc = new PTOController();
      rc = new RequestController();
      rdc = new RequestDatabaseController();
      //cc = new CalendarController();
      
      erc.pc = pc;
      erc.rc = rc;
      erc.rdc = rdc;
      
      mrc.rdc = rdc;
      
      pc.ptoc = ptoc;
      
      //rdc.cc = cc;
      rdc.ptoc = ptoc;
      rdc.c = this;
      
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

