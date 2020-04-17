
public class ManagerRequestController {

   RequestDatabaseController rdb;

   public ManagerRequestController() {
      rdb = new RequestDatabaseController();
   }

   public void approveRequest() {
      rdb.approveRequest(requestID);
   }
 
   public void rejectRequest() {
      rdb.rejectRequest(requestID);
   }
 

}
