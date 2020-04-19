
public class EmployeeRequestController
{
PersonController pc;
RequestController rc;
//RequestDatabaseController rdb = new RequestDatabaseController();

public EmployeeRequestController()
{
   pc = new PersonController();
 rc = new RequestController();
}

      public void makeRequest(int newStartDay, int newStartMonth, int newStartYear, int newStartTime, int newEndDay, int newEndMonth, int newEndYear, int newEndTime, Leave newLeaveType, int currentEmployeeID, int currentSupervisorID)
   {
   
      Request newRequest = rc.createRequest( newStartDay, newStartMonth,  newStartYear,  newStartTime,  newEndDay,  newEndMonth,  newEndYear,  newEndTime,  newLeaveType,  currentEmployeeID,  currentSupervisorID);
      
      Gender fm = pc.getGender(newRequest.employeeID);
      Title jobTitle = pc.getTitle(newRequest.employeeID);
      
      newRequest = rc.setStatus(newRequest, fm, jobTitle);
      // rdb.addRequest(newRequest);
      }

 public void withdrawRequest(int requestID)
 {
 //rdb.withdrawRequest(requestID);
 }
}