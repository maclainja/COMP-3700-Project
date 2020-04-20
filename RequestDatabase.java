import java.util.ArrayList;

public class RequestDatabase
{
   
   ArrayList<Request> requestDatabase;
   private int size = 0;
 
   public RequestDatabase() {
      requestDatabase = new ArrayList<Request>();
   }
   
   public int addRequest(Request newRequest) {
      newRequest.setRequestID(size);
      size++;
      requestDatabase.add(newRequest);
      return size - 1;
   }
   
   public void approveRequest(int ID) {
      requestDatabase.get(ID).setStatus(Status.approved);
   }
   
   public void rejectRequest(int ID) {
      requestDatabase.get(ID).setStatus(Status.rejected);
   }
   
   public void withdrawRequest(int ID) {
      requestDatabase.get(ID).setStatus(Status.withdrawn);
   }
   
   public void setTotalTime(int ID, double totalTime) {
      requestDatabase.get(ID).setTotalTime(totalTime);
   }
   
   public Request getRequest(int ID) {
      return requestDatabase.get(ID);
   }
   
   public ArrayList<Request> getRequestDatabase() {
      return requestDatabase;
   }
   
}
