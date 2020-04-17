
public class RequestController
{

   public Request createRequest(int newStartDay, int newStartMonth, int newStartYear, int newStartTime, int newEndDay, int newEndMonth, int newEndYear, int newEndTime, Leave newLeaveType, int currentEmployeeID, int currentSupervisorID)
   {
   
      Request newRequest = new Request( newStartDay, newStartMonth,  newStartYear,  newStartTime,  newEndDay,  newEndMonth,  newEndYear,  newEndTime,  newLeaveType,  currentEmployeeID,  currentSupervisorID);
      return newRequest;
   }

   public Request setStatus(Request newRequest, Gender fm, Title jobTitle)
   {
      
      if(jobTitle != Title.part_time && jobTitle != Title.contractor)
      {
         if(newRequest.leaveType == Leave.paternity && fm == Gender.male)
         {
            newRequest.setStatus(Status.approved);
         
         }
         else if (newRequest.leaveType == Leave.maternity && fm == Gender.female)
         {
            newRequest.setStatus(Status.approved);
         
         }
         else if (newRequest.leaveType == Leave.emergency)
         {
            newRequest.setStatus(Status.approved);
         }
         else if (newRequest.leaveType == Leave.pto)
         {
            newRequest.setStatus(Status.pending);
         
         }
         else if (newRequest.leaveType == Leave.sick_leave)
         {
            newRequest.setStatus(Status.approved);
         
         }
         else 
      {
         newRequest.setStatus(Status.rejected);
      }
      }
      else 
      {
         newRequest.setStatus(Status.rejected);
      }
      return newRequest;
   }

}