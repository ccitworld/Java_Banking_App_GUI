import java.io.Serializable;

public class Account implements Serializable
{
    private int accno,balance;
    public Account(int an,int bl)
    {
        accno=an;
        balance=bl;
    }
    public int getAccno()
    {
        return accno;
    }
    public int getBalance()
    {
        return balance;
    }
    public void deposit(int amt)
    {
        balance=balance+amt;
    }
    public Boolean withdraw(int amt)
    {
        if(balance>=amt) {
            balance = balance - amt;
            return true;
        }
        else
            return false;
    }
}
