public class Company {

   final String companyName = "drShaikInc";
   
   DayWithTime today;
   
   //We set the date here
   public void setDate(int newMonth, int newDay, int newYear, int newHour, int newMinute) {
         today.day.day = newDay;
         today.day.month = newMonth;
         today.day.year = newYear;
         today.hour = newHour;
         today.minute = newMinute;
   }
   
   
   
   //GETTER!!
   public DayWithTime getDate() {
         
      return today;
      
   }      
      
}     
   
      
   
      
   
    
