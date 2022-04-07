package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * класс является главным сервисом модели банковской системы
 * сервис может регистрировать и удалять пользователя из системы,
 * добавлять банковский счет пользователю, переводить деньги со счета на счет
 * @author LEONID MFLTSEV
 * @version 1.0
 */
public class BankService {
    /**
     * поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * @param user пользователь, который добавляется в систему методом put
     * к этому user добавляется пустой список - new ArrayList<Account>()
     * в методе осуществляется проверка наличия пользователя в системе
     * если он есть, то новый пользователь не добавляется
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод add добавляет новый счет к пользователю
     * первоначально пользователь ищется по паспорту методом findByPassport
     * после этого мы получаем список всех счетов пользователя, и добавляем новый счет к ним.
     * В этом методе проверяется, что такого счета у пользователя еще нет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }

    }

    /**
     * @param passport метод ищет пользователя по номеру паспорта:
     * используется перебор всех элементов через цикл for-each и метод Map.keySet.
     * @return метод возвращает null если ничего не найдено.
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * @param passport Метод ищет счет пользователя по реквизитам
     * сначала ищется пользователь по паспорту с помощью метода findByPassport.
     * Потом получается список счетов этого пользователя и в нем ищется нужный счет.
     * При этом, прежде чем получать список аккаунтов проверяется,
     * что метод findByPassport вернул значение отличное от null.
     * @return возвращается список аккаунтов пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод putIfAbsent проверяет, если ли такой ключ в карте или нет и если его нет,
     * то производится вставка данных.
     * Метод List.contains проверяет содержит ли наш список элемент,
     * который мы передаем в качестве аргумента в этот метод.
     * При этом метод возвращает true, когда в списке такой элемент присутствует,
     * а иначе возвращается false.
     * @return метод предназначен для перечисления денег с одного счёта на другой счёт
     * если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     * то метод возвращает false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
