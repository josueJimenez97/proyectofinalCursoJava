package view.panels;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {
    private String name;
    private JLabel lblName;
    boolean myTurn;
    public PlayerPanel(String name){
        myTurn=false;
        this.name=name;
        setLayout(new BorderLayout());
        ImageIcon imgPlayer= new ImageIcon("playerUno.png");
        JLabel lblPlayer= new JLabel("",SwingConstants.CENTER);
        lblPlayer.setIcon(imgPlayer);
        add(lblPlayer, BorderLayout.CENTER);
        lblName= new JLabel(name,SwingConstants.CENTER);
        lblName.setOpaque(true);
        add(lblName,BorderLayout.SOUTH);
    }

    public void yourTurn(boolean flag){
        if(flag)
            lblName.setBackground(Color.CYAN);
        else
            lblName.setBackground(new Color(238,239,172));
    }

    public String getName(){
        return name;
    }
}
