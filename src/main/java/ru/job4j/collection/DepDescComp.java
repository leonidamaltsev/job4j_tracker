package ru.job4j.collection;

import java.util.Comparator;

/**
 * @author Leonid Maltsev
 * @version 1.0
 */
public class DepDescComp implements Comparator<String> {
    /**
     * Method compares to string
     * splitting two strings and put them into arrays
     * comparing two first element
     * if they are equals ascending sorting is used
     * otherwise, a number that is greater or less than 0 is returned.
     * @param o1 first sting
     * @param o2 second string
     * @return result of comparing two strings
     */
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int result = second[0].compareTo(first[0]);
        return result == 0 ? o1.compareTo(o2) : result;
    }
}
