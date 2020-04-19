import java.util.ArrayList;

public class PTODatabase {
   
   private ArrayList<Double> PTO;
   private int size = 0;

   public PTODatabase() {
      PTO = new ArrayList<Double>();
   }

   public int getNewID(String type) {
      if (type == "partTime") {
         PTO.add(null);
      }
      else if (type == "fullTime") {
         PTO.add(0.0);
      }
      else {
         throw new IllegalArgumentException("Invalid employee type");
      }
      size++;
      return PTO.size() - 1;
   }

   public boolean verifyPTO(double amount, int employeeID) {
      if (PTO.get(employeeID) == null) {
         throw new IllegalArgumentException("Employee is not full-time and does not have PTO");
      }
      return (PTO.get(employeeID) > amount) ? true : false;
   }

   public void addPTO(double amount, int employeeID) {
      if (PTO.get(employeeID) == null) {
         throw new IllegalArgumentException("Employee is not full-time and does not have PTO");
      }
      double currentPTO = PTO.get(employeeID);
      double newPTO = currentPTO + amount;
      PTO.set(employeeID, newPTO);
   }
   
   public void deductPTO(double amount, int employeeID) {
      if (PTO.get(employeeID) == null) {
         throw new IllegalArgumentException("Employee is not full-time and does not have PTO");
      }
      double currentPTO = PTO.get(employeeID);
      double newPTO = currentPTO - amount;
      PTO.set(employeeID, newPTO);
   }
   
   public double getPTO(int employeeID) {
      if (PTO.get(employeeID) == null) {
         throw new IllegalArgumentException("Employee is not full-time and does not have PTO");
      }
      return PTO.get(employeeID);
   }
   

}