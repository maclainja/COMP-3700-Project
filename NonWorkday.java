public class NonWorkday extends Day{

    String name;
    NWDtype type;


    public NonWorkday(int theMonth, int theDay, int theYear, NWDtype theType)   {
        super(theMonth, theDay, theYear);
        type = theType;
    }


    public void setName(String theName)    {
        this.name = theName;
    }


}
enum NWDtype {
    holiday, weekend
}

