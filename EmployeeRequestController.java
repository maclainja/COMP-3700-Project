
import java.util.ArrayList;

public class EmployeeRequestController
{
   PersonController pc;
   RequestController rc;
   RequestDatabaseController rdc;

   public EmployeeRequestController() {}

   public void makeRequest(int newStartDay, int newStartMonth, int newStartYear, int newStartHour, int newStartMinute, int newEndDay, int newEndMonth, int newEndYear, int newEndHour, int newEndMinute, Leave newLeaveType, int currentEmployeeID, int currentSupervisorID)
   {
   
      Request newRequest = rc.createRequest( newStartDay, newStartMonth,  newStartYear,  newStartHour, newStartMinute,  newEndDay,  newEndMonth,  newEndYear,  newEndHour, newEndMinute,  newLeaveType,  currentEmployeeID,  currentSupervisorID);
      
      Gender fm = pc.getGender(newRequest.employeeID);
      Title jobTitle = pc.getTitle(newRequest.employeeID);
      
      rc.setStatus(newRequest, fm, jobTitle);
      rdc.addRequest(newRequest);
   }

   public void withdrawRequest(int requestID)
   {
      rdc.withdrawRequest(requestID);
   }
   
   public ArrayList<Request> getEmployeeRequests(int employeeID) {
      return rdc.getEmployeeRequests(employeeID);
   }

}