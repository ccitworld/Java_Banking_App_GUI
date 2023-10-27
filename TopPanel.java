import java.awt.*;

public class TopPanel extends Panel
{
    Button b1,b2,b3,b4,b5,b6;
    public TopPanel()
    {
        b1=new Button("Open Account");
        b2=new Button("Show Balance");
        b3=new Button("Deposit");
        b4=new Button("Withdraw");
        b5=new Button("Save");
        b6=new Button("Load");
        add(b1);add(b2);
        add(b3);add(b4);
        add(b5);add(b6);
    }
}
