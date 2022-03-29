package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenSortAscByName() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 1));
        list.add(new Job("Fix bug", 2));
        list.sort(new JobAscByName());
        assertThat(list.get(0).getName(), is("Fix bug"));
    }

    @Test
    public void whenSortAscByPriority() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 1));
        list.add(new Job("Fix bug", 2));
        list.sort(new JobAscByPriority());
        assertThat(list.get(0).getPriority(), is(1));
    }

    @Test
    public void whenSortDescByName() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 1));
        list.add(new Job("Fix bug", 2));
        list.sort(new JobDescByName());
        assertThat(list.get(0).getName(), is("Impl task"));
    }

    @Test
    public void whenSortDescByPriority() {
        List<Job> list = new ArrayList<>();
        list.add(new Job("Impl task", 1));
        list.add(new Job("Fix bug", 2));
        list.sort(new JobDescByPriority());
        assertThat(list.get(0).getPriority(), is(2));
    }
}