import java.util.ArrayList;

public class PTODatabase {
   
   private ArrayList<Double> PTO;
   private int size = 0;

   public PTODatabase() {
      PTO = new ArrayList<Double>();
   }

   public int getNewID(Title title) {
      if ((title == Title.part_time) || (title == Title.contractor)) {
         PTO.add(null);
      }
      else if ((title == Title.full_time) || (title == Title.hr) || (title == Title.hr_executive) || (title == Title.executive)) {
         PTO.add(10.0);
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
      return (PTO.get(employeeID) >= amount) ? true : false;
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