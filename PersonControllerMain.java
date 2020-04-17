
public class PersonControllerMain
{

   public static void main(String[] args)
   {
      
      EmployeeRequestController erc = new EmployeeRequestController();
      
      
      int[] b = {0};
      int[] d = {5,6};
      
      int c = 0;
      erc.pc.hireEmployee(Title.full_time, Gender.male, "Coulson", 0, b);
      erc.pc.hireEmployee(Title.full_time, Gender.male, "may", 1, b);
      erc.pc.hireEmployee(Title.full_time, Gender.female, "fitz", 2, b);
      erc.pc.hireEmployee(Title.full_time, Gender.male, "simmons", 2, b);
      erc.pc.hireEmployee(Title.full_time, Gender.male, "intern 1", 4, b);
      erc.pc.hireEmployee(Title.full_time, Gender.female, "intern 2", 4, b);
      erc.pc.hireEmployee(Title.part_time, Gender.female, "Skye", 2, d); 
   
     erc.makeRequest(1,1,2020, 7, 2,1,2020,17, Leave.pto, 3, 2  );
    
  //           public void makeRequest(int newStartDay, int newStartMonth, int newStartYear, int newStartTime, int newEndDay, int newEndMonth, int newEndYear, int newEndTime, Leave newLeaveType, int currentEmployeeID, int currentSupervisorID)

      Person temp = erc.pc.employeeIndex.get(1);
      Person temp1 = erc.pc.employeeIndex.get(2);
      Person temp2 = erc.pc.employeeIndex.get(3);
    
      Person temp4 = erc.pc.employeeIndex.get(1);
      
      Gender test = erc.pc.getGender(2);
      
      
   }

}