import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowBalancePanel extends Panel implements ActionListener
{
    Label l1,l2;
    TextField t1;
    Button b1;
    public ShowBalancePanel()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        l1=new Label("Check Account Balance");
        l1.setFont(new Font("arial",Font.BOLD,20));
        l2=new Label("Accno ");
        t1=new TextField(20);
        b1=new Button("Show");
        b1.addActionListener(this);
        gc.gridx=1;
        gc.gridy=0;
        add(l1,gc);
        gc.gridx=0;
        gc.gridy=1;
        add(l2,gc);
        gc.gridx=1;
        gc.gridy=1;
        add(t1,gc);
        gc.gridx=1;
        gc.gridy=2;
        add(b1,gc);
    }
    public void actionPerformed(ActionEvent e)
    {
        int accno=Integer.parseInt(t1.getText());
        Account acc=MainFrame.search_Account(accno);
        if(acc!=null)
        {
            int bal=acc.getBalance();
            JOptionPane.showMessageDialog(null,"Accno: "+accno+" Balance: "+bal);
        }
        else
            JOptionPane.showMessageDialog(null,"Account Not Found");
    }
}
