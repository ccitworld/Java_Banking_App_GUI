import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositPanel extends Panel implements ActionListener {
    Label l1,l2,l3;
    TextField t1,t2;
    Button b1;
    public DepositPanel()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        l1=new Label("Deposit Amount");
        l1.setFont(new Font("arial",Font.BOLD,20));
        l2=new Label("Accno ");
        l3=new Label("Amount ");
        t1=new TextField(20);
        t2=new TextField(20);
        b1=new Button("Submit");
        b1.addActionListener(this);
        gc.insets=new Insets(5,5,5,5);
        gc.gridx=1;
        gc.gridy=0;
        add(l1,gc);
        gc.gridx=0;
        gc.gridy=1;
        add(l2,gc);
        gc.gridx=1;
        gc.gridy=1;
        add(t1,gc);
        gc.gridx=0;
        gc.gridy=2;
        add(l3,gc);
        gc.gridx=1;
        gc.gridy=2;
        add(t2,gc);
        gc.gridx=1;
        gc.gridy=3;
        add(b1,gc);
    }

    public void actionPerformed(ActionEvent e)
    {
        int an=Integer.parseInt(t1.getText());
        int amt=Integer.parseInt(t2.getText());
        Account acc=MainFrame.search_Account(an);
        if(acc!=null)
        {
            acc.deposit(amt);
            JOptionPane.showMessageDialog(null,"Amount Deposit successfully");
        }
        else
            JOptionPane.showMessageDialog(null,"Account Not Found");
    }
}
