import javax.swing.*;

public class ContentPanel {
    private JPanel panel;
    private JEditorPane textPanel;
    private JScrollPane scrollPane;

    public ContentPanel() {
        scrollPane = new JScrollPane(textPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVisible(true);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JEditorPane getTextPanel() {
        return textPanel;
    }
}
