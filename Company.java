public class Company {

   //This is the name of the Company
   final String companyName = "drShaikInc";
   
   //Sets today as a day data type
   Day today;
      
   
   //Seeing if we need a calendar??
  // Calendar obj = new Calendar();
  // obj.create_calendar();
   
   //We set the date here
   public void setDate(int newmonth, int newday, int newyear) {
   
     // if (obj.findDate(newmonth, newday, newyear) != null){
         today.day = newday;
         today.month = newmonth;
         today.year = newyear;
     // }
   }
   
   
   
   //GETTER!!
   public Day getDate() {
         
      return today;
      
   }      
      
}     
   
      
   
      
   
    
