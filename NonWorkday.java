public class NonWorkday extends Day{

    NWDtype type;
    public NonWorkday(int theMonth, int theDay, int theYear, NWDtype theType)   {
        super(theMonth, theDay, theYear);
        type = theType;
    }
}

enum NWDtype {
    holiday, weekend;
}