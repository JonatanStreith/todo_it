package jonst.data;

import jonst.model.Person;

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

        return null;        //POTENTIAL RISK: If nonexistent Id is given, proper return won't work and error will happen. Address later.
    }                                       //Perhaps function that checks if an Id is valid, and use it before trying to return a Person?

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


}
