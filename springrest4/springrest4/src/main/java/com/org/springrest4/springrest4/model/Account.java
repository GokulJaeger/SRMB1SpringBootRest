package com.org.springrest4.springrest4.model;
/**
 * Composite Key Mapping
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
@IdClass(AccountId.class)
public class Account implements Serializable {

    @Id
    private String accountNumber;

    @Id
    private String accountType;

    private double balance;

    private String accountname;

    public Account() {
    }

    public Account(String accountNumber, String accountType, double balance, String accountname) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.accountname = accountname;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    @Override
    public String toString() {
        return "Account{" + "accountNumber='" + accountNumber + '\'' + ", accountType='" + accountType + '\''
                + ", balance=" + balance + ", accountName" + accountname + '}';
    }
}
