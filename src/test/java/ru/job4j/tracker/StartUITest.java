package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0.Exit Program"
                        + System.lineSeparator()
                        + "=== have a nice day ==="
                        + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0.Edit item" + ln
                        + "1.Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0.Edit item" + ln
                        + "1.Exit Program" + ln
                        + "=== have a nice day ===" + ln
        ));
    }

    @Test
    public void whenFindAllTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Item three = tracker.add(new Item("test3"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0.Show all items" + ln
                        + "1.Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + two + ln
                        + three + ln
                        + "Menu:" + ln
                        + "0.Show all items" + ln
                        + "1.Exit Program" + ln
                        + "=== have a nice day ===" + ln
        ));
    }

    @Test
    public void whenFindByNameActionIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", one.getName(), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0.Find items by name" + ln
                        + "1.Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0.Find items by name" + ln
                        + "1.Exit Program" + ln
                        + "=== have a nice day ===" + ln
        ));
    }

    @Test
    public void whenFindByIdActionIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0.Find item by id" + ln
                        + "1.Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0.Find item by id" + ln
                        + "1.Exit Program" + ln
                        + "=== have a nice day ===" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1", "0"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = new UserAction[] {new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, List.of(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0.Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0.Exit Program" + ln
                        + "=== have a nice day ===" + ln
                )
        );
    }
}