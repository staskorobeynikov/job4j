package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class Bank предназначен для добавления/удаления счетов, перевода денег со счета
 * на счет
 * @author Stas Korobeynikov
 * @since 14.12.2019
 * @version 1
 */
public class Bank {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить пользователя
     * @param user пользователь которого добавляют
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод позволяет удалить пользователя
     * @param user пользователь которого необходимо удалить
     */
    public void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * Метод позволяет добавить счет пользователю
     * @param passport идентификатор пользователя
     * @param account счет, который необходимо добавить
     */
    public void addAccountToUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод позволяет удалить счет пользователя
     * @param passport идентификатор пользователя
     * @param account счет, который необходимо удалить
     */
    public void deleteAccountToUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null) {
            int index = users.get(user).indexOf(account);
            if (index >= 0) {
                users.get(user).remove(index);
            }
        }
    }

    /**
     * Метод позволяет отразить список счетов пользователя
     * @param passport идентификатор пользователя
     * @return список счетов пользователя с идентификатором passport
     */
    public List<Account> getUserAccounts(String passport) {
        User user = findUserByPassport(passport);
        return user != null ? users.get(user) : new ArrayList<>();
    }

    /**
     * Метод позволяет перевести средства с одного счета на другой
     * @param srcPassport идентификатор пользователя счета с которого
     *                    необходимо перевести
     * @param srcRequisite реквизиты счета с которого переводят
     * @param destPassport идентификатор пользователя счета на который
     *                     переводят
     * @param destRequisite реквизиты счета на который переводят
     * @param amount сумма перевода
     * @return false - перевод не был проведен, true - перевод выполнен успешно
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean result = false;
        Account srcAccount = findAccountByRequisite(srcRequisite,
                getUserAccounts(srcPassport));
        Account destAccount = findAccountByRequisite(destRequisite,
                getUserAccounts(destPassport));
        if (srcAccount != null && destAccount != null) {
            if (srcAccount.withdraw(amount)) {
                destAccount.depositToAccount(amount);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод позволяет определить пользователя по полю passport
     * @param passport идентификатор пользователя
     * @return пользователя с идентификатором passport
     */
    private User findUserByPassport(String passport) {
        User result = users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findAny().orElse(null);
        return result;
    }

    /**
     * Метод позволяет определить счет пользователя по его реквизитам
     * @param requisites реквизиты искомого счета
     * @param accounts список счетов по которому осуществляется поиск
     * @return Account который необходимо найти
     */
    private Account findAccountByRequisite(String requisites,
                                          List<Account> accounts) {
        Account result = accounts.stream()
                .filter(a -> a.getRequisites().equals(requisites))
                .findAny().orElse(null);
        return result;
    }
}
