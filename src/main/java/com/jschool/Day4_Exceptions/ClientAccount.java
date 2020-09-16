package com.jschool.Day4_Exceptions;

import com.jschool.Day4_Exceptions.MyExceptions.AccountException.AccountBalanceException;

public class ClientAccount {
    private long balance;

    public ClientAccount() {
        this.balance = 0;
    }

    public long getBalance() {
        return balance;
    }

    private void setBalance(long balance) {
        this.balance = balance;
    }

    public void plusBalance(long sum) {
        setBalance(getBalance() + sum);
    }

    public void minusBalance(long sum) throws AccountBalanceException {

        if (getBalance() - sum < 0) {
            throw new AccountBalanceException("Недостаточно средств для выполнения операции. " +
                    "Необходимо пополнить счет или запросить меньшую сумму");
        } else {
            setBalance(getBalance() - sum);
        }
    }
}
