import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TopMenu extends JMenuBar {

    public TopMenu(JEditorPane editorPane, Frame frame) {
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem newItem = new JMenuItem("New");

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(frame);
                fileDialog.setMode(FileDialog.LOAD);
                fileDialog.setTitle("Choose file");
                fileDialog.setVisible(true);
                String file = fileDialog.getFile();
                String directory = fileDialog.getDirectory();
                if (file != null) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(directory + file));
                        StringBuilder fileContent = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            fileContent.append(line);
                        }
                        editorPane.setText(fileContent.toString());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile(editorPane, frame);
            }
        });

        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane confirmWindow = new JOptionPane();
                int result = JOptionPane.showConfirmDialog(null, "Save file?");
                if (result == 0) {
                    saveFile(editorPane, frame);
                }
            }
        });

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(newItem);

        JMenu formatMenu = new JMenu("Format");
        JMenuItem formatItem = new JMenuItem("Format options");

        formatItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormatWindow formatWindow = new FormatWindow(editorPane);
            }
        });

        formatMenu.add(formatItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem creatorInfoItem = new JMenuItem("Creator");
        creatorInfoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreatorInfoWindow creatorInfoWindow = new CreatorInfoWindow();
            }
        });

        helpMenu.add(creatorInfoItem);

        this.add(fileMenu);
        this.add(formatMenu);
        this.add(helpMenu);

        fileMenu.setSize(50, 800);
        fileMenu.setVisible(true);
    }

    private static void saveFile(JEditorPane editorPane, Frame frame) {
        try {
            FileDialog fileDialog = new FileDialog(frame);
            fileDialog.setMode(FileDialog.SAVE);
            fileDialog.setTitle("Choose path file");
            fileDialog.setVisible(true);
            String path = fileDialog.getDirectory();
            String file = fileDialog.getFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/" + file + ".txt"));
            writer.write(editorPane.getText());
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
