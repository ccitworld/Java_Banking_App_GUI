import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class MainFrame extends Frame implements ActionListener
{
    public static ArrayList<Account> arrayList;
    Panel p1;
    public MainFrame()
    {
        setTitle("Bank App");
        arrayList=new ArrayList<>();
        TopPanel topPanel=new TopPanel();
        add(topPanel,"North");
        topPanel.b1.addActionListener(this);
        topPanel.b2.addActionListener(this);
        topPanel.b3.addActionListener(this);
        topPanel.b4.addActionListener(this);
        topPanel.b5.addActionListener(this);
        topPanel.b6.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String btnLabel=e.getActionCommand();
        System.out.println(btnLabel);
        if(p1!=null)
            remove(p1);
        if(btnLabel.equals("Open Account"))
        {
            p1=new OpenAccountPanel();
            add(p1,"Center");
        }
        if(btnLabel.equals("Show Balance"))
        {
            p1=new ShowBalancePanel();
            add(p1,"Center");
        }
        if(btnLabel.equals("Deposit"))
        {
            p1=new DepositPanel();
            add(p1,"Center");
        }
        if(btnLabel.equals("Withdraw"))
        {
            p1=new WithdrawPanel();
            add(p1,"Center");
        }
        if(btnLabel.equals("Save"))
        {
            try {
                FileOutputStream fos = new FileOutputStream("data.obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(arrayList);
                oos.close();
                JOptionPane.showMessageDialog(this,"Data Saved...");
            }
            catch (IOException exception)
            {
                System.out.println(exception);
            }
        }
        if(btnLabel.equals("Load"))
        {
            try {
                FileInputStream fis=new FileInputStream("data.obj");
                ObjectInputStream ois=new ObjectInputStream(fis);
                arrayList=(ArrayList<Account>) ois.readObject();
                ois.close();
                JOptionPane.showMessageDialog(this,"Data Loaded...");
            }
            catch (IOException exception)
            {
                System.out.println(exception);
            }
            catch (ClassNotFoundException exception)
            {
                System.out.println(exception);
            }
        }
        revalidate();
        repaint();
    }
    public static void create_Account(int an,int bl)
    {
        Account a=new Account(an,bl);
        arrayList.add(a);
        System.out.println(arrayList);
    }
    public static Account search_Account(int an)
    {
        for(Account a: arrayList)
        {
            if(a.getAccno()==an)
                return  a;
        }
        return null;
    }
}
