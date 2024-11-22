package Hostel;

import javax.swing.*;

public class HostelMain {
    public static void main(String s[])
    {
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> new Splash_Sc());
    }

}
