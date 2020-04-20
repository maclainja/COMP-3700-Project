
public class Company {

   final String companyName = "drShaikInc";
   DayWithTime today;
   
   EmployeeRequestController erc;
   ManagerRequestController mrc;
   PersonController pc;
   PTOController ptoc;
   RequestController rc;
   RequestDatabaseController rdc;
   CalendarController cc;
   
   public Company() {
      erc = new EmployeeRequestController();
      mrc = new ManagerRequestController();
      pc = new PersonController();
      ptoc = new PTOController();
      rc = new RequestController();
      rdc = new RequestDatabaseController();
      cc = new CalendarController();
      
      erc.pc = pc;
      erc.rc = rc;
      erc.rdc = rdc;
      
      mrc.rdc = rdc;
      
      pc.ptoc = ptoc;
      
      rdc.cc = cc;
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
   
   public void addQuarterlyPTO(int year, int quarter) {
      int startMonth, endDay, endMonth;
      switch (quarter) {
         case 1:
            startMonth = 1;
            endMonth = 3;
            endDay = 31;
            break;
         case 2:
            startMonth = 4;
            endMonth = 6;
            endDay = 30;
            break;
         case 3:
            startMonth = 7;
            endMonth = 9;
            endDay = 30;
            break;
         case 4:
            startMonth = 10;
            endMonth = 12;
            endDay = 31;
            break;
         default:
            return;
      }
      Request quarterTime = new Request(1, startMonth, year, 9, 0, endDay, endMonth, year, 17, 0, Leave.pto, 0, 0);
      double totalQuarterTime = cc.getWorkingTime(quarterTime);
      double employeeLeaveTime = 0;
      double partitionedLeaveTime = 0;
      double employeeWorkingTime = 0;
      double employeePTOAccrued = 0;
      DayWithTime requestStart;
      DayWithTime requestEnd;
      DayWithTime quarterStart = new DayWithTime(startMonth, 1, year, 9, 0);
      DayWithTime quarterEnd = new DayWithTime(endMonth, endDay, year, 17, 0);
      for (Person p : pc.employeeIndex.values()) {
         if ((p.getTitle() == Title.full_time) || (p.getTitle() == Title.hr) || (p.getTitle() == Title.hr_executive) || (p.getTitle() == Title.executive)) {
            for (Request r : rdc.rd.requestDatabase) {
               if ((r.getEmployeeID() == p.getID()) && (r.currentStatus == Status.approved)) {
                  requestStart = new DayWithTime(r.startMonth, r.startDay, r.startYear, r.startHour, r.startMinute);
                  requestEnd = new DayWithTime(r.endMonth, r.endDay, r.endYear, r.endHour, r.endMinute);
                  if ((requestStart.compareTo(quarterStart) >= 0) && (requestEnd.compareTo(quarterEnd) <= 0)) {
                     employeeLeaveTime += r.getTotalTime();
                  }
                  else if (requestEnd.compareTo(quarterEnd) <= 0) {
                     Request partitionedRequest = new Request(quarterStart.day.day, quarterStart.day.month, quarterStart.day.year, quarterStart.hour, quarterStart.minute, requestEnd.day.day, requestEnd.day.month, requestEnd.day.year, requestEnd.hour, requestEnd.minute, Leave.pto, 0, 0);
                     partitionedLeaveTime = cc.getWorkingTime(partitionedRequest);
                     employeeLeaveTime += partitionedLeaveTime;
                  }
                  else if (requestStart.compareTo(quarterStart) >= 0) {
                     Request partitionedRequest = new Request(requestStart.day.day, requestStart.day.month, requestStart.day.year, requestStart.hour, requestStart.minute, quarterEnd.day.day, quarterEnd.day.month, quarterEnd.day.year, quarterEnd.hour, quarterEnd.minute, Leave.pto, 0, 0);
                     partitionedLeaveTime = cc.getWorkingTime(partitionedRequest);
                     employeeLeaveTime =+ partitionedLeaveTime; 
                  }
                  else {}
               }
         
            }
            employeeWorkingTime = totalQuarterTime - employeeLeaveTime;
            employeePTOAccrued = employeeWorkingTime / 40;
            ptoc.addPTO(employeePTOAccrued, p.getID());
         }
      }
   }
   
   
}     

