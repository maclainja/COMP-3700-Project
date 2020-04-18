
public class Request
{
   
   int startDay;
   int startMonth;
   int startYear;
   int startTime;
   int endDay;
   int endMonth;
   int endYear;   
   int endTime;   
   Leave leaveType;   
   Status currentStatus;   
   int employeeID;   
   int supervisorID;   
   int requestID;   
   int totalTime;
   
   public Request  (int newStartDay, int newStartMonth, int newStartYear, int newStartTime, int newEndDay, int newEndMonth, int newEndYear, int newEndTime, Leave newLeaveType, int currentEmployeeID, int currentSupervisorID)
   {
   
      startDay = newStartDay;
      startMonth = newStartMonth;
      startYear = newStartYear;
      startTime = newStartTime;
      endDay = newEndDay;
      endMonth = newEndMonth;
      endYear = newEndYear;
      endTime = newEndTime;
      leaveType = newLeaveType;
      employeeID = currentEmployeeID;
      supervisorID = currentSupervisorID;
   
   
   
   }
   
   public void setStatus(Status newStatus)
   {
      this.currentStatus = newStatus;
   }
   
   
   
   public void setTotal(int newTotalTime)
   {
      this.totalTime = newTotalTime;
   }
     
     
}
enum Leave {
   maternity, paternity, pto, sick_leave, emergency;
}

enum Status {
   approved, rejected, pending;
}