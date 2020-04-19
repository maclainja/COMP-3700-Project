
public class Request
{
   
   int startDay;
   int startMonth;
   int startYear;
   int startHour;
   int startMinute;
   int endDay;
   int endMonth;
   int endYear;   
   int endHour;
   int endMinute;   
   Leave leaveType;   
   Status currentStatus;   
   int employeeID;   
   int supervisorID;   
   int requestID;   
   double totalTime;
   
   public Request  (int newStartDay, int newStartMonth, int newStartYear, int newStartHour, int newStartMinute, int newEndDay, int newEndMonth, int newEndYear, int newEndHour, int newEndMinute, Leave newLeaveType, int currentEmployeeID, int currentSupervisorID)
   {
   
      startDay = newStartDay;
      startMonth = newStartMonth;
      startYear = newStartYear;
      startHour = newStartHour;
      startMinute = newStartMinute;
      endDay = newEndDay;
      endMonth = newEndMonth;
      endYear = newEndYear;
      endHour = newEndHour;
      endMinute = newEndMinute;
      leaveType = newLeaveType;
      employeeID = currentEmployeeID;
      supervisorID = currentSupervisorID;
   
   
   
   }
   
   public void setStatus(Status newStatus)
   {
      this.currentStatus = newStatus;
   }
   
   
   
   public void setTotalTime(double newTotalTime)
   {
      this.totalTime = newTotalTime;
   }
   
   public void setRequestID(int requestID)
   {
      this.requestID = requestID;
   }

   public int getEmployeeID() 
   {
      return employeeID;
   }
   
   public double getTotalTime() 
   {
      return totalTime;
   }
}
