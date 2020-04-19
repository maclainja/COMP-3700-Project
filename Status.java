enum Status {
   
   approved{
         @Override
         public String toString() {
            return "approved";
         }
      },
      
      rejected {
         @Override
         public String toString() {
            return "rejected";
         }
      },
      
      pending{
         @Override
         public String toString() {
            return "pending";
         }
      },
      
      withdrawn {
         @Override
         public String toString() {
            return "withdrawn";
         }
      };
      
     

}