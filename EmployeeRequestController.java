public class EmployeeRequestController {
   
   //we create instances of the other controllers to communicate with them
   PersonController pc;
   RequestController rc;
   
   //We Don't have RequestDatabaseController yet
   //RequestDatabaseController rbd;
   
   public EmployeeRequestController {
      pr = new PersonController();
      rc = new RequestController();
      //rbd = new RequestDatabaseController();
   }
   
   
   
   
   public void makeRequest(int newStartDay, int newStartMonth, int newStartYear, int newEndDay,int newEndMonth,int newEndYear,int newEndTime,Leave newLeaveType,int currentEmployeeID,int currentSupervisorID) {
   
      //We assign the instance created
      Request newRequest = rc.createRequest(newStartDay, newStartMonth,newStartYear, newEndDay, newEndMonth, newEndYear, newEndTime, newLeaveType, currentEmployeeID, currentSupervisorID);
      
      //We need to create an association between Gender the the instances of the request relating to the person
      Gender binary = pc.getGender(newRequest.employeeID);
      Title jobTitle = pc.getTitle(newRequest.employeeID);
      
      //We set the status of the request
      newRequest = rc.setStatus(newRequest, binary, jobTitle);
      
      //Here we will add the request to the database
      // rbd.addRequest(newRequest());
      
   } 
   
   public void withdrawRequest(int requestID){
   
      //we will change the request status to withdrawn in the database class
      //rbd.withdrawRequest(requestID);
   }
