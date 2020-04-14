
public class Person{
   String name;
   String title;
   int employeeID;

   Gender gender;
   Person supervisor;
   Person[] supervisees;
   

   public Person(String newName, int ID, String  jobTitle, Gender fm, Person newSupervisor, Person[] newSupervisee)
   
   
   {
      name = newName;
      employeeID = ID;
      title = jobTitle;
      gender = fm;
      supervisor = newSupervisor;
      supervisees = newSupervisee;
   }

   public int getID()
   {
      return this.employeeID;
   }

   public Gender getGender()
   {
      return this.gender;
   }

   public String getTitle()
   {
      return this.title;
   }

   public Person getSupervisor()
   {
      return this.supervisor;
   }
   public void  newSupervisor(Person newSupervisor)
   {
      this.supervisor = newSupervisor;
   }
      public void newSupervisee(Person[] newSupervisee)
   {
      this.supervisees = newSupervisee;
   }
   
   public Person[] getSupervisees()
   {
   return this.supervisees;
   }
   public void promoteDemoteEmployee(String newTitle, Person newSupervisor, Person[] newSupervisees)
   {
      this.title = newTitle;
      this.supervisor = newSupervisor;
      this.supervisees = newSupervisees;
   
   }
   
   

}

enum Gender {
   male, female;
}
