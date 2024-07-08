package testdome.java;

import java.util.LinkedList;

//correct
public class TrainComposition {
    //Use LinkedList for accessing first and last objects
    LinkedList<Integer> wagons = new LinkedList<>();

    public void attachWagonFromLeft(int wagonId) {
        wagons.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        wagons.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
       int wagonId = wagons.getFirst();
       wagons.removeFirst();
       return wagonId;
    }

    public int detachWagonFromRight() {
        int wagonId = wagons.getLast();
        wagons.removeLast();
        return wagonId;
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}
