import java.util.ArrayList;

public class ManagerRequestController {

   RequestDatabaseController rdc;

   public ManagerRequestController() {}

   public void approveRequest(int ID) {
      rdc.approveRequest(ID);
   }
 
   public void rejectRequest(int ID) {
      rdc.rejectRequest(ID);
   }
   
   public ArrayList<Request> getCurrentRequests(int managerID) {
      return rdc.getSuperviseeRequests(managerID);      
   }
 

}
