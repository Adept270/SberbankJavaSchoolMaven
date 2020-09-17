package com.jschool.Day4_Exceptions.Terminal;

import com.jschool.Day4_Exceptions.ClientAccount;
import com.jschool.Day4_Exceptions.MyExceptions.AccountException.AccountBalanceException;


public interface Terminal {
    int checkAccount(ClientAccount clientAccount);

    public void plusBalance(ClientAccount clientAccount, int sum);

    public void minusBalance(ClientAccount clientAccount, int sum) throws AccountBalanceException;
}