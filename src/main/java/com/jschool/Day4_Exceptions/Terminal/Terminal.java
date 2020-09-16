package com.jschool.Day4_Exceptions.Terminal;

import com.jschool.Day4_Exceptions.ClientAccount;
import com.jschool.Day4_Exceptions.MyExceptions.AccountException.AccountBalanceException;


public interface Terminal {
    long checkAccount(ClientAccount clientAccount);

    public void plusBalance(ClientAccount clientAccount, long sum);

    public void minusBalance(ClientAccount clientAccount, long sum) throws AccountBalanceException;
}