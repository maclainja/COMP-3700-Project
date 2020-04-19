

public class DayWithTime {

   Day day;
   int hour;
   int minute;
   
   public DayWithTime(int newMonth, int newDay, int newYear, int newHour, int newMinute) {
        day = new Day(newMonth, newDay, newYear);
        hour = newHour;
        minute = newMinute;
    }
    
    public DayWithTime(Day newDay, int newHour, int newMinute) {
      day = newDay;
      hour = newHour;
      minute = newMinute;
    }
    
    public int compareTo(DayWithTime dwt) {
    
      if (this.day.year < dwt.day.year) {
         return -1;
      }
      else if (this.day.year > dwt.day.year) {
         return 1;
      }
      else {
         if (this.day.month < dwt.day.month) {
            return -1;
         }
         else if (this.day.month > dwt.day.month) {
            return 1;
         }
         else {
            if (this.day.day < dwt.day.day) {
               return -1;
            }
            else if (this.day.day > dwt.day.day) {
               return 1;
            }
            else {
               if (this.hour < dwt.hour) {
                  return -1;
               }
               else if (this.hour > dwt.hour) {
                  return 1;
               }
               else {
                  if (this.minute < dwt.minute) {
                     return -1;
                  }
                  else if (this.minute > dwt.minute) {
                     return 1;
                  }
                  else {
                     return 0;
                  }
               }
            }
         }
      }
    
    }
    

}