package com.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void shouldDepositMoney() {

        // Arrange
        BankAccount account = new BankAccount("78945", "Diego Armando Maradona");

        // Act
        account.deposit(100);

        //Assert
        assertEquals(100,account.getBalance());
    }

    @Test
    void shouldNotDepositNegativeAmount() {
        // Arrange
        BankAccount account = new BankAccount("78945", "Diego Armando Maradona");

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50);
        });
    }

    @Test
    void shouldNotWithdrawMoreThanAvailableBalance() {
        // Arrange
        BankAccount account = new BankAccount("78945", "Diego Armando Maradona");

        // Act & Assert
        assertThrows(InsufficientFundsException.class, () -> {
            account.withdraw(100);
        });
    }

    @Test
    void shouldWithdrawMoneyWhenSufficientBalance() throws InsufficientFundsException {
        // Arrange
        BankAccount account = new BankAccount("78945", "Diego Armando Maradona");

        // Act
        account.deposit(100);
        account.withdraw(40);

        // Assert
        assertEquals(60.0, account.getBalance());
    }
}
