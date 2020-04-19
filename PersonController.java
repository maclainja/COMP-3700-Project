import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

//controller class


public class PersonController{

   int newID = 1;

   Map<Integer, Person> employeeIndex;

   public PersonController()
   {
      employeeIndex = new HashMap<Integer, Person>();
     
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
   
      int ptoID = newID;
   //int ptoID = PTOCONTROLLER.getNewID();
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
      newID++;
   
   }



   public void fireEmployee(int ID)
   {
      
      employeeIndex.get(employeeIndex.get(ID).supervisor.employeeID).removeSupervisee(employeeIndex.get(ID));
   
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
      currentPerson.supervisor = employeeIndex.get(newSupervisorID);
   
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
   /*
      Person currentPerson = employeeIndex.get(ID);
      Person oldSupervisor = currentPerson.getSupervisor();
      Person[] oldSupervisees = currentPerson.getSupervisees();
      Person[] supervisorSupervisees = oldSupervisor.getSupervisees();
            
     
            
      for ( int i = 0; i < oldSupervisees.length; i++)
      {
         oldSupervisor.addSupervisee(oldSupervisees[i]);
         oldSupervisees[i].supervisor = oldSupervisor;
         
      }
   
      currentPerson.newSupervisor(employeeIndex.get(newSupervisorID));
      
      Person[] newSupervisees = new Person[newSuperviseeIDs.length];
      if (newSuperviseeIDs.length > 0)
      {
         
        
         for (int i = 0; i < newSuperviseeIDs.length; i++)
         {
            newSupervisees[i] = employeeIndex.get(newSuperviseeIDs[i]);
         }
      }
      currentPerson.newSupervisee(newSupervisees);
      
      
      if (newSupervisees.length > 0)
      {
         for (Person temp: newSupervisees)
         {
            if (temp != null)
            {
               temp.newSupervisor(currentPerson);
            }
         }
      }
   
   
   }
   */

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