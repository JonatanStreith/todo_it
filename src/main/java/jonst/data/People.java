package jonst.data;

import jonst.model.Person;
import jonst.model.Todo;

import java.util.Arrays;

public class People {

    private static Person[] peopleArray = new Person[0];


    public int size() {

        return peopleArray.length;
    }


    public Person[] findAll() {

        return peopleArray;
    }

    public Person findById(int personId) {


        for (Person pers : peopleArray) {
            if(pers.getPersonId() == personId)
                return pers;

        }


        //int indexOf = Arrays.binarySearch(peopleArray, personId);       //Assuming the sequencer function is used, the array will be sorted, so binarySearch works

        return null;        //If it can't find that Id, return a null object. A method that invokes findById() must be prepared to get a null object and respond properly.
    }                                  //After all, it needs to return SOMETHING.

    public Person AddPerson(String firstName, String lastName) {

        Person newGuy = new Person(PersonSequencer.nextPersonId(), firstName, lastName);    //Creates a new guy, using the nextPersonId to get a fresh number


        peopleArray = Arrays.copyOf(peopleArray, peopleArray.length + 1);   //Increase the array size by one



        peopleArray[peopleArray.length-1] = newGuy;   //Puts the new guy last in the array

        return newGuy;
    }


    public void clear(){

        peopleArray = new Person[0];
        PersonSequencer.reset();        //We need to reset the Id counter if we clear the array, right?

    }




    public void RemovePerson(int removedId) {

        Person[] editedArray = new Person[peopleArray.length - 1];  //Get a fresh array to put stuff into; make it one space shorter
        int currentSpot = 0;                                  //Count which spot we're on right now.

        for (Person pers : peopleArray) {

            if (pers.getPersonId() != removedId) {
                editedArray[currentSpot] = pers;        //If an entry isn't the one we want to remove, save it to the new set.
                currentSpot++;                          //Then increase the counter so it'll know to use a fresh spot for the next iteration.
            }                                           //If an entry *is* the one we want to remove, it'll just skip over that.

            peopleArray = editedArray;    //COpy the results into the main array

        }


    }



}
