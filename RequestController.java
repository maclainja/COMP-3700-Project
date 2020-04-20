
public class RequestController
{

   public Request createRequest(int newStartDay, int newStartMonth, int newStartYear, int newStartHour, int newStartMinute, int newEndDay, int newEndMonth, int newEndYear, int newEndHour, int newEndMinute, Leave newLeaveType, int currentEmployeeID, int currentSupervisorID)
   {
   
      Request newRequest = new Request(newStartDay, newStartMonth,  newStartYear,  newStartHour, newStartMinute,  newEndDay,  newEndMonth,  newEndYear,  newEndHour, newEndMinute,  newLeaveType,  currentEmployeeID,  currentSupervisorID);
      return newRequest;
   }

   public void setStatus(Request newRequest, Gender fm, Title jobTitle)
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
      else if (newRequest.leaveType == Leave.sick_leave)
      {
         newRequest.setStatus(Status.approved);
         
      }
      
      else 
      {
         newRequest.setStatus(Status.rejected);
      }
   }

}