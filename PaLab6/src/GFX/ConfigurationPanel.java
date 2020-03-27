package GFX;

import javax.swing.*;
import java.awt.*;

public class ConfigurationPanel extends JPanel {
    private Integer[] sidesNo = { 0, 3, 4, 5, 6, 7, 8 };

    JLabel shapeNoLabel = new JLabel("Number: ");
    JLabel strokeLabel = new JLabel("Size: ");
    JLabel sideLabel = new JLabel("Sides:");

    JTextField shapesNo = new JFormattedTextField();
    JTextField shapesStroke = new JFormattedTextField();
    JComboBox sidesNoValue = new JComboBox(sidesNo);
    JButton drawButton = new JButton("Draw");

    public ConfigurationPanel(DrawingPanel frame) {
        this.setBorder(BorderFactory.createTitledBorder("Control Panel"));
        init();
        this.setLayout(new GridLayout(2,4, 20, 0));
    }

    private void init() {
        sidesNoValue.setSelectedIndex(3);
        shapesStroke.setText("3");
        shapesNo.setText("1");
        add(sideLabel);
        add(shapeNoLabel);
        add(strokeLabel);
        add(drawButton);
        add(sidesNoValue);
        add(shapesNo);
        add(shapesStroke);
    }

}

