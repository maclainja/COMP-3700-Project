import java.util.HashMap;
import java.util.Map;

public class PersonController{

   Map<Integer, Person> employeeIndex;

   public PersonController()
   {
      employeeIndex = new HashMap<Integer, Person>();
   
   }

   public Gender getGender(int ID)
   {
      return employeeIndex.get(ID).getGender();
   }

public void hireEmployee(String newTitle, Gender fm, String newName, int newSupervisorID, int[] newSuperviseeIDs)
{

}

}