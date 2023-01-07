import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormatWindow extends JDialog {

    private JPanel panel;
    private JList fontFamilyList;
    private JList fontSizeList;
    private JComboBox fontStyleCombo;

    public FormatWindow(JEditorPane editorPane) {
        String[] fonts = {"Verdana", "Arial", "SansSerif", "Serif"};
        fontFamilyList.setListData(fonts);

        Integer[] sizes = {12, 14, 16, 18, 20, 48, 72};
        fontSizeList.setListData(sizes);

        fontStyleCombo.addItem("Plain");
        fontStyleCombo.addItem("Italic");
        fontStyleCombo.addItem("Bold");

        fontFamilyList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Font actualFont = editorPane.getFont();
                editorPane.setFont(new Font(fontFamilyList.getSelectedValue().toString(), actualFont.getStyle(), actualFont.getSize()));
            }
        });

        fontSizeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Font actualFont = editorPane.getFont();
                editorPane.setFont(new Font(actualFont.getName(), actualFont.getStyle(), Integer.parseInt(fontSizeList.getSelectedValue().toString())));
            }
        });

        fontStyleCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font actualFont = editorPane.getFont();
                int fontStyle = 0;
                switch (fontStyleCombo.getSelectedItem().toString()){
                    case "Italic" -> fontStyle = 2;
                    case "Bold" -> fontStyle = 1;
                    case "Plain" -> fontStyle = 0;
                }
                editorPane.setFont(new Font(actualFont.getName(), fontStyle, actualFont.getSize()));
            }
        });


        this.setContentPane(panel);
        this.setAlwaysOnTop(true);
        this.setSize(300, 400);
        this.setModal(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
