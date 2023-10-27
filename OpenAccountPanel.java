import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenAccountPanel extends Panel implements ActionListener
{
    Label l1,l2,l3;
    TextField t1,t2;
    Button b1;
    public OpenAccountPanel()
    {
        GridBagLayout gbl=new GridBagLayout();
        GridBagConstraints gc=new GridBagConstraints();
        setLayout(gbl);
        l1=new Label("Create New Account");
        l1.setFont(new Font("arial",Font.BOLD,20));
        l2=new Label("accno: ");
        l3=new Label("Balance: ");
        t1=new TextField(20);
        t2=new TextField(20);
        b1=new Button("Create");
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
        int accno=Integer.parseInt(t1.getText());
        int balance=Integer.parseInt(t2.getText());
        MainFrame.create_Account(accno,balance);
        JOptionPane.showMessageDialog(null,"Account created successfully");
    }
}
