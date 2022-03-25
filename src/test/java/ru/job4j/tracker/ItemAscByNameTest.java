package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void compare() {
        Item first = new Item("Reboot server");
        Item second = new Item("Fix bugs");
        Item third = new Item("Impl task");
        List<Item> items = new ArrayList<>();
        items.add(first);
        items.add(second);
        items.add(third);
        List<Item> expected = List.of(second, third, first);
        items.sort(new ItemAscByName());
        assertEquals(expected, items);
    }

    @Test
    public void compareRev() {
        Item first = new Item("Reboot server");
        Item second = new Item("Fix bugs");
        Item third = new Item("Impl task");
        List<Item> items = new ArrayList<>();
        items.add(first);
        items.add(second);
        items.add(third);
        List<Item> expected = List.of(first, third, second);
        items.sort(new ItemDescByName());
        assertEquals(expected, items);
    }
}