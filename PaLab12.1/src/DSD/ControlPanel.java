package DSD;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JTextField className;
    JTextField elementName;
    JButton createComponent;
    JButton loadElem;
    JButton saveElem;
    JButton exit;
    JLabel classNameText;
    JLabel elementNameText;
    JButton button;
    JLabel label;
    JTextField textField;
    JTextArea textArea;

    /**
     * Constructor ControlPanel
     * In frame se creeaza un controlPanel in care avem text field-urile pentru clasa si numele elementului
     * si 2 butoane, draw element care deseneaza elementul pe canvas si exit care inchide aplicatia
     * @param frame
     */
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        this.setPreferredSize(new Dimension(500, 100));
        this.className = new JTextField(45);
        this.elementName = new JTextField(45);
        this.classNameText = new JLabel("Class");
        this.elementNameText = new JLabel("Name");
        this.createComponent = new JButton("Draw");
        this.loadElem = new JButton("Load");
        this.saveElem = new JButton("Save");
        this.exit = new JButton("Exit");
        this.add(this.classNameText);
        this.add(this.className);
        this.add(this.elementNameText);
        this.add(this.elementName);
        this.add(this.createComponent);
        this.add(this.loadElem);
        this.add(this.saveElem);
        this.add(this.exit);
        this.createComponent.addActionListener(this::actionPerformed);
        this.loadElem.addActionListener(this::loadFrame);
        this.saveElem.addActionListener(this::saveFrame);
        this.exit.addActionListener(this::closeApp);
    }

    /**
     * Dupa apasarea butonului, testeaza daca clasa este valida si daca elementul are un nume si deseneaza elementul
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        String classType = this.className.getText();
        String className = this.elementName.getText();
        try {
            Class clazz = Class.forName(classType);
            Component component = (Component) clazz.newInstance();
            component.setPreferredSize(new Dimension(100, 50));
            int componentHeight = this.frame.designPanel.getComponentList().size() / 4 * 50;
            int componentWidth = this.frame.designPanel.getComponentList().size() % 4 * 100;
            if (component instanceof JButton) {
                this.button = (JButton) component;
                this.button.setText(className);
                this.frame.designPanel.getComponentList().add(this.button);
                this.button.setBounds(10 + componentWidth, 10 + componentHeight, 100, 50);
                this.frame.designPanel.add(this.button);
            } else if (component instanceof JLabel) {
                this.label = (JLabel) component;
                this.label.setText(className);
                this.frame.designPanel.getComponentList().add(this.label);
                this.label.setBounds(10 + componentWidth, 10 + componentHeight, 100, 50);
                this.frame.designPanel.add(this.label);
            } else if (component instanceof JTextArea) {
                this.textArea = (JTextArea) component;
                this.textArea.setText(className);
                this.frame.designPanel.getComponentList().add(this.textArea);
                this.textArea.setBounds(10 + componentWidth, 10 + componentHeight, 100, 50);
                this.frame.designPanel.add(this.textArea);
            } else if (component instanceof JTextField) {
                this.textField = (JTextField) component;
                this.textField.setText(className);
                this.frame.designPanel.getComponentList().add(this.textField);
                this.textField.setBounds(10 + componentWidth, 10 + componentHeight, 100, 50);
                this.frame.designPanel.add(this.textField);
            } else {
                component.setName(className);
                this.frame.designPanel.getComponentList().add(component);
                component.setBounds(10 + componentWidth, 10 + componentHeight, 100, 50);
                this.frame.designPanel.add(component);
            }
            this.frame.designPanel.revalidate();
            this.frame.designPanel.repaint();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException var8) {
            System.out.println("Nu a fost gasita clasa");
        }
        this.revalidate();
    }

    /**
     * Functia care inchide aplicatia cand butonul este apasat
     * @param e
     */
    public void closeApp(ActionEvent e) {
        System.out.println("CLOSED!!!");
        System.exit(0);
    }

    /**
     * Functia care incarca frame-ul in format xml
     */
    private void loadFrame(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Select an xml document");
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML documents", "xml");
        fileChooser.addChoosableFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getPath());
            try {
                XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
                DesignPanel designPanel = (DesignPanel) decoder.readObject();
                decoder.close();
                this.frame.updateDesignPanel(designPanel);
            } catch (FileNotFoundException exception) {
                System.out.println(exception);
            }
        }
    }

    /**
     * Functia care salveaza frame-ul in format xml
     */
    private void saveFrame(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Choose directory: ");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile() + "\\frame.xml");
            try {
                XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
                encoder.writeObject(this.frame.getDesignPanel());
                encoder.close();
            } catch (FileNotFoundException exception) {
                System.out.println(exception);
            }
        }
    }
}
