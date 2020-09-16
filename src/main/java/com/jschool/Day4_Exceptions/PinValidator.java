package com.jschool.Day4_Exceptions;

import com.jschool.Day4_Exceptions.MyExceptions.AccountException.AccountLockedException;
import com.jschool.Day4_Exceptions.MyExceptions.AccountException.InvalidPinException;
import com.jschool.Day4_Exceptions.Terminal.TerminalServer;

import java.util.Date;

public class PinValidator {
    private static final int PIN_LIMIT = 3;
    private static final int TIME_DELAY = 10000;

    private TerminalServer terminalServer;
    private Date blockTime;
    private int errPINCounter;

    public PinValidator(TerminalServer terminalServer) {
        this.terminalServer = terminalServer;
        errPINCounter = 0;
    }

    public ClientAccount validatePIN(Integer pin) throws InvalidPinException, AccountLockedException {
        ClientAccount clientAccount = terminalServer.getClientByPIN(pin);

        if (blockTime == null || blockTime.before(new Date())) {
            if (clientAccount == null) {
                errPINCounter++;

                if (errPINCounter >= PIN_LIMIT) {
                    blockTime = new Date(new Date().getTime() + TIME_DELAY);
                    errPINCounter = 0;
                }
                throw new InvalidPinException("Некорректный ПИН. Попробуйте ввести код заново.");
            } else {
                return clientAccount;
            }
        } else {
            throw new AccountLockedException("Выполнено " + PIN_LIMIT + " некорректные попытки ввода ПИН-кода." +
                    "Дейстия с картой заблокированы на " + (blockTime.getTime() - new Date().getTime()) / 1000 + " секунд.");
        }
    }
}
