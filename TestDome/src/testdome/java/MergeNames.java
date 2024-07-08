package testdome.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {

        List<String> newNames = new ArrayList<>(Arrays.asList(names1));
        newNames.addAll(Arrays.asList(names2));
        List<String> distintNames =  newNames.stream().distinct().toList();
        String[] namesArray = new String[distintNames.size()];

        int i = 0;
        for(String name : distintNames){
            namesArray[i] = name;
            i++;
        }
       return namesArray;

    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
