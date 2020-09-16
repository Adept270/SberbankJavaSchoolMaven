package com.jschool.Day4_Exceptions.Terminal;

import com.jschool.Day4_Exceptions.ClientAccount;
import com.jschool.Day4_Exceptions.Messages;
import com.jschool.Day4_Exceptions.MyExceptions.AccountException.AccountBalanceException;
import com.jschool.Day4_Exceptions.MyExceptions.TerminalException.TerminalAmountException;
import com.jschool.Day4_Exceptions.PinValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalImpl implements Terminal {
    private final TerminalServer server = TerminalServer.getInstance();
    private final PinValidator pinValidator = new PinValidator(server);

    public void startTerminal() {
        System.out.println("Введите ПИН-код для выполнения операции." +
                "Для выхода из терминала, нажмите Q.");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String s = reader.readLine().trim();
                if (isPIN(s)) {
                    ClientAccount clientAccount = pinValidator.validatePIN(Integer.parseInt(s));

                    System.out.println("Добро пожаловать!");
                    System.out.println("Для пополнения счета укажите +");
                    System.out.println("Для снятия наличных, укажите -");
                    System.out.println("Для запроса баланса, укажите 0");
                    System.out.println("Для выхода из терминала, нажмите Q.");

                    String clientAction = reader.readLine().trim();

                    switch (clientAction) {
                        case "+": {
                            //TODO
                            break;
                        }
                        case "-": {
                            //TODO:
                            System.out.println("описать");
                            break;
                        }
                        case "0": {
                            //TODO
                            System.out.println("Баланс");
                        }
                        case "Q": {
                            break;
                        }
                        default:
                            System.out.println("Символ не распознан.");

                    }

                } else {
                    Messages.printConsoleMessage("ПИН-код должен содержать только целые положительные числа. \n" +
                            "Введите код повторно. Для выхода из терминала, нажмите Q.");
                }
            }
        } catch (IOException e) {
            Messages.printDefaultConsoleErr();
        }
    }

    private static boolean isPIN(String s) {
        return s.matches("[0-9]+");
    }

    @Override
    public long checkAccount(ClientAccount clientAccount) {
        return server.checkAccount(clientAccount);
    }

    @Override
    public void plusBalance(ClientAccount clientAccount, long sum) {
        try {
            checkAmount(sum);
        } catch (TerminalAmountException e) {
            Messages.consoleExceptionPrinter(e);
        }
        server.plusBalance(clientAccount, sum);
    }

    @Override
    public void minusBalance(ClientAccount clientAccount, long sum) {
        try {
            checkAmount(sum);
            server.minusBalance(clientAccount, sum);
        } catch (AccountBalanceException | TerminalAmountException e) {
            Messages.consoleExceptionPrinter(e);
        }
    }

    private void checkAmount(long sum) throws TerminalAmountException {
        if ((sum % 100) > 0) throw new TerminalAmountException("Для выполнения операции, введите сумму, кратную 100");
    }
}
