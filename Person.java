//done i think
public class Person{
   String name;
   Title title;
   int employeeID;

   Gender gender;
   Person supervisor;
   Person[] supervisees;
   

   public Person(String newName, int ID, Title  jobTitle, Gender fm, Person newSupervisor, Person[] newSupervisee)
   
   
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

   public Title getTitle()
   {
      return this.title;
   }

   public Person getSupervisor()
   {
      return this.supervisor;
   }
   public void  newSupervisor(Person newSupervisor)
   {
      if(this.supervisor != null && this.supervisor.supervisees.length > 1)
      {
         Person[] newList = new Person[this.supervisor.supervisees.length -1];
         int i =0;
         for (Person temp: this.supervisor.supervisees)
         {
            if (temp != this)
            {
               newList[i] = temp; 
            }
         
         }
         this.supervisor.supervisees = newList;
      }
     
      this.supervisor = newSupervisor;
   }
   public void newSupervisee(Person[] newSupervisee)
   {
      this.supervisees = newSupervisee;
   }
   
   public void addSupervisee(Person newSupervisee)
   {
      Person[] newList = new Person[this.supervisees.length +1];
      for( int i = 0; i < this.supervisees.length; i++)
      {
         newList[i] = this.supervisees[i];      
      }
      newList[this.supervisees.length] = newSupervisee;
      
      this.supervisees = newList;
      
      
   }
   
   public void removeSupervisee(Person oldSupervisee)
   {
      Person[] newList = new Person[this.supervisees.length -1];
      int t = 0;
      if (this.supervisees.length > 0)
      {
         for( int i = 0; i < this.supervisees.length; i++)
         {
            if (this.supervisees[i] != oldSupervisee)
            {
               newList[t] = this.supervisees[i];      
               t++;
            }
         }
      }
      
      
      this.supervisees = newList;
      
      
   }

   
   public Person[] getSupervisees()
   {
      return this.supervisees;
   }
   public void promoteDemoteEmployee(Title newTitle, Person newSupervisor, Person[] newSupervisees)
   {
      this.title = newTitle;
      this.supervisor = newSupervisor;
      this.supervisees = newSupervisees;
   
   }
   
   

}

enum Gender {
   male, female;
}

enum Title {
   part_time, contractor, full_time, hr, hr_executive, executive;
}
