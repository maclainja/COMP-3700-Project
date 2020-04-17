
public class ManagerRequestController {

   PersonController pc;
   RequestController rc;

   public ManagerRequestController() {
      pc = new PersonController();
      rc = new RequestController();
   }

   // public void approveRequest() {
   // 
   // }
// 
   // public void rejectRequest() {
   // 
   // }
   
   public void setStatus(Request newRequest, Gender fm, Title jobTitle)
   {
      Request newRequest = rc.setStatus(newRequest, fm, jobTitle)
      
      Gender fm = pc.getGender(newRequest.empployeeID);
      Title jobTitle = pc.getTitle(newRequest.employeeID);
   
   }

}