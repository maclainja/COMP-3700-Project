

public class PTOController {

   PTODatabase PTODatabase;

   public PTOController() {
      PTODatabase = new PTODatabase();
   }

   public int getNewID(Title title) {
      return PTODatabase.getNewID(title);
   }

   public boolean verifyPTO(double amount, int employeeID) {
      return PTODatabase.verifyPTO(amount, employeeID);
   }

   public void addPTO(double amount, int employeeID) {
      PTODatabase.addPTO(amount, employeeID);
   }
   
   public void deductPTO(double amount, int employeeID) {
      PTODatabase.deductPTO(amount, employeeID);
   }
   
   public double getPTO(int employeeID) {
      return PTODatabase.getPTO(employeeID);
   }

   public void donatePTO(double amountRequested, int giverID, int receiverID) {
      PTODatabase.getPTO(giverID);
      PTODatabase.getPTO(receiverID);
      if (PTODatabase.verifyPTO(amountRequested, giverID)) {
         PTODatabase.deductPTO(amountRequested, receiverID);
         PTODatabase.addPTO(amountRequested, receiverID);
         return;
      }
      throw new IllegalArgumentException("Giver employee does not have the required PTO");
   }

}