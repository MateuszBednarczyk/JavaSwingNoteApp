import javax.swing.*;

public class CreatorInfoWindow extends JDialog {
    private JPanel panel;
    private JLabel content;

    public CreatorInfoWindow() {
        this.setContentPane(panel);
        this.setAlwaysOnTop(true);
        this.setSize(300, 400);
        this.setModal(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
