package jonst.data;

public class PersonSequencer {

    private static int personId;

    public static int nextPersonId(){
        personId++;

        return personId;                //Yes, I *could* just write "return ++personId;" and have it done with one line.
                                        //But this is better for comprehension.

    }

    public static void reset(){
        personId = 0;
    }

}
