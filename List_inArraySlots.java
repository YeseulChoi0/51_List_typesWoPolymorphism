/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

public class List_inArraySlots {

    private int[]    intElements;
    private double[] doubleElements;
    private String[] stringElements;
    private int filledElements; // the number of elements in this list

    /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
    private int[] typeOfElements;

    private static final int INITIAL_CAPACITY = 10;

    private int intEnd;
    private int doubleEnd;
    private int stringEnd;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
      intElements = new int[INITIAL_CAPACITY];
      doubleElements = new double[INITIAL_CAPACITY];
      stringElements = new String[INITIAL_CAPACITY];
      typeOfElements = new int[INITIAL_CAPACITY * 3]
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
      return filledElements;
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
      String s = "[";
      int intCounter = 0;
      int doubleCounter = 0;
      int stringCounter = 0;
      for (int i = 0; i < filledElements; i++){
        if (typeOfElements[i] == 0){
          s += intElements[intCounter];
          intCounter++;
        }
        if (typeOfElements[i] == 1){
          s += doubleElements[doubleCounter];
          doubleCounter++;
        }
        if (typeOfElements[i] == 2){
          s += stringElements[stringCounter];
          stringCounter++;
        }
      }
      return s + "]";
    }


    /**
      Appends @value to the end of this list.
      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int type   // same meaning as in typeOfElements
                       , int    intValue
                       , double doubleValue
                       , String stringValue
                       ) {
        if (filledElements == typeOfElements.length
            || intEnd == intElements.length
            || doubleEnd == doubleElements.length
            || stringEnd == stringElements.length)
          expand();
        if (type == 0)
          add(intValue);
        if (type == 1)
          add(doubleValue);
        if (type == 2)
          add(stringValue);
        return true;
     }

     private boolean add(int n){
       typeOfElements[filledElements] = 0;
       filledElements++;
       intElements[intEnd] = n;
       intEnd++;
       //ASK IF WE CAN USE MORE PRIVATE VARIABLES TO STORE THE "FILLED ELEMENTS" OF EACH OR IF WE NEED TO COUNT
     }

     private boolean add(double n){
       typeOfElements[filledElements] = 1;
       filledElements++;
       doubleElements[doubleEnd] = n;
       doubleEnd++;
     }

     private boolean add(String s){
       typeOfElements[filledElements] = 2;
       filledElements++;
       stringElements[stringEnd] = s;
       stringEnd++;
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     // private void expand() {
        // System.out.println( "expand... (for debugging)");
           // /* S.O.P. rules for debugging:
              // Working methods should be silent. But during
              // development, the programmer must verify that
              // this method is called when that is appropriate.
              // So test using the println(), then comment it out.
              // */
     // }
}
