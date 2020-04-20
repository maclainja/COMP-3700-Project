enum Title {
      part_time{
         @Override
         public String toString() {
            return "part_time";
         }
      },
      
      contractor {
         @Override
         public String toString() {
            return "contractor";
         }
      },
      
      full_time{
         @Override
         public String toString() {
            return "full_time";
         }
      },
      
      hr {
         @Override
         public String toString() {
            return "hr";
         }
      },
      
      hr_executive{
         @Override
         public String toString() {
            return "hr_executive";
         }
      },
      
      executive{
         @Override
         public String toString() {
            return "hr_executive";
         }
      };


}
