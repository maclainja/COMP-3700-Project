import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

//controller class


public class PersonController{

   Map<Integer, Person> employeeIndex;
   
   PTOController ptoc;

   public PersonController(PTOController newptoc)
   {
      ptoc = newptoc;
      employeeIndex = new HashMap<Integer, Person>();
      hireEmployee(Title.hr_executive, Gender.male, "admin", 0 , new int[0], "password");
      employeeIndex.get(0).supervisor = employeeIndex.get(0);
      employeeIndex.get(0).supervisees = new Person[] {employeeIndex.get(0)};
   }

   public Gender getGender(int ID)
   {
      return employeeIndex.get(ID).getGender();
   }

   public String getPassword(int ID)
   {
      return employeeIndex.get(ID).getPassword();
   }


   public void hireEmployee(Title newTitle, Gender fm, String newName, int newSupervisorID, int[] newSuperviseeIDs, String newPassword)
   {
   
      int ptoID = ptoc.getNewID(newTitle);
      Person[] newSupervisees = new Person[newSuperviseeIDs.length];
      if (newSuperviseeIDs.length > 0)
      {
         
        
         for (int i = 0; i < newSuperviseeIDs.length; i++)
         {
            newSupervisees[i] = employeeIndex.get(newSuperviseeIDs[i]);
         }
      }
      
      Person newSupervisor = employeeIndex.get(newSupervisorID);
      Person newEmployee = new Person( newName, ptoID, newTitle,  fm,  newSupervisor,  newSupervisees, newPassword);
   
   
      Person[] supervisees = newEmployee.getSupervisees();
      if (newSupervisor != null)
      {
         newEmployee.getSupervisor().addSupervisee(newEmployee);
      }
      
      if (newSupervisees.length > 0)
      {
         for (Person temp: supervisees)
         {
            if (temp != null)
            {
               if(temp.supervisor != null)
               {
                  temp.supervisor.removeSupervisee(temp);
               }
               temp.newSupervisor(newEmployee);
            }
         }
      }
      employeeIndex.put((Integer)ptoID, newEmployee);
   
   }



   public void fireEmployee(int ID)
   {
     // employeeIndex.get(employeeIndex.get(ID).supervisor.employeeID).removeSupervisee(employeeIndex.get(ID));
      promoteDemoteEmployee( ID,  Title.hr, 0, new int[0] );
      employeeIndex.get(0).removeSupervisee(employeeIndex.get(ID));
      employeeIndex.remove(ID);
   }

   public void promoteDemoteEmployee(int ID, Title newTitle, int newSupervisorID, int[] newSuperviseeIDs)
   {
      Person currentPerson = employeeIndex.get(ID);
      Person oldSupervisor = currentPerson.supervisor;
      for (Person temp: currentPerson.supervisees)
      {
         oldSupervisor.addSupervisee(temp);
         temp.supervisor = oldSupervisor;
      }
   
      currentPerson.title = newTitle;
      currentPerson.supervisor.removeSupervisee(currentPerson);
      currentPerson.supervisor = employeeIndex.get(newSupervisorID);
      currentPerson.supervisor.addSupervisee(currentPerson);
      
   
      Person[] newSupervisees = new Person[newSuperviseeIDs.length];
      if (newSuperviseeIDs.length > 0)
      {
         
        
         for (int i = 0; i < newSuperviseeIDs.length; i++)
         {
            newSupervisees[i] = employeeIndex.get(newSuperviseeIDs[i]);
            if( employeeIndex.get(newSuperviseeIDs[i]).supervisor != null)
            {
               employeeIndex.get(newSuperviseeIDs[i]).supervisor.removeSupervisee(employeeIndex.get(newSuperviseeIDs[i]));
            }
            employeeIndex.get(newSuperviseeIDs[i]).supervisor = currentPerson;
         }
      }
   
      currentPerson.supervisees = newSupervisees;
   
   }

   public Person[] getSupervisees(int ID)
   {
      Person[] temp = employeeIndex.get(ID).getSupervisees();
      return temp;
   }
   
   
   public Person getSupervisor(int ID)
   {
      return employeeIndex.get(ID).getSupervisor();
   }
 
   public Title getTitle(int ID)
   {
      return employeeIndex.get(ID).getTitle();
   }

}