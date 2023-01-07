import javax.swing.*;

public class Frame extends JFrame {
    public Frame(int width, int height) {
        ContentPanel contentPanel = new ContentPanel();
        JEditorPane editorPane = contentPanel.getTextPanel();
        this.setJMenuBar(new TopMenu(editorPane, this));
        this.setContentPane(contentPanel.getScrollPane());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setResizable(false);
        this.setVisible(true);
    }
}
