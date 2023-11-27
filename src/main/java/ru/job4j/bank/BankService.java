package ru.job4j.bank;

import java.util.*;

/**
 * класс является главным сервисом модели банковской системы
 * сервис может регистрировать и удалять пользователя из системы,
 * добавлять банковский счет пользователю, переводить деньги со счета на счет
 * @author LEONID MALTSEV
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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * @param passport метод ищет пользователя по номеру паспорта:
     * используется перебор всех элементов через цикл for-each и метод Map.keySet.
     * @return метод возвращает null если ничего не найдено.
     */
        public Optional<User> findByPassport(String passport) {
            return users.keySet()
                    .stream()
                    .filter(user -> user.getPassport().equals(passport))
                    .findFirst();
    }

    /**
     * @param passport Метод ищет счет пользователя по реквизитам
     * сначала ищется пользователь по паспорту с помощью метода findByPassport.
     * Потом получается список счетов этого пользователя и в нем ищется нужный счет.
     * При этом, прежде чем получать список аккаунтов проверяется,
     * что метод findByPassport вернул значение отличное от null.
     * @return возвращается список аккаунтов пользователя
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst());
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
            Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
            Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
            boolean rsl = false;
            if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                rsl = true;
            }
            return rsl;
        }
    }
