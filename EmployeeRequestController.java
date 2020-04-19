
import java.util.ArrayList;

public class EmployeeRequestController
{
   PersonController pc;
   RequestController rc;
   RequestDatabaseController rdb;

   public EmployeeRequestController()
   {
      pc = new PersonController();
      rc = new RequestController();
      rdb = new RequestDatabaseController();
   }

   public void makeRequest(int newStartDay, int newStartMonth, int newStartYear, int newStartHour, int newStartMinute, int newEndDay, int newEndMonth, int newEndYear, int newEndHour, int newEndMinute, Leave newLeaveType, int currentEmployeeID, int currentSupervisorID)
   {
   
      Request newRequest = rc.createRequest( newStartDay, newStartMonth,  newStartYear,  newStartHour, newStartMinute,  newEndDay,  newEndMonth,  newEndYear,  newEndHour, newEndMinute,  newLeaveType,  currentEmployeeID,  currentSupervisorID);
      
      Gender fm = pc.getGender(newRequest.employeeID);
      Title jobTitle = pc.getTitle(newRequest.employeeID);
      
      rc.setStatus(newRequest, fm, jobTitle);
      rdb.addRequest(newRequest);
   }

   public void withdrawRequest(int requestID)
   {
      rdb.withdrawRequest(requestID);
   }
   
   public ArrayList<Request> getEmployeeRequests(int employeeID) {
      return rdb.getEmployeeRequests(employeeID);
   }

}