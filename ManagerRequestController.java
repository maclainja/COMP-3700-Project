import java.util.ArrayList;

public class ManagerRequestController {

   RequestDatabaseController rdb;

   public ManagerRequestController() {
      rdb = new RequestDatabaseController();
   }

   public void approveRequest(int ID) {
      rdb.approveRequest(ID);
   }
 
   public void rejectRequest(int ID) {
      rdb.rejectRequest(ID);
   }
   
   public ArrayList<Request> getCurrentRequests(int managerID) {
      return rdb.getSuperviseeRequests(managerID);      
   }
 

}
