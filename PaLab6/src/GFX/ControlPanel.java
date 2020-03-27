package GFX;

import javax.swing.*;

public class ControlPanel extends JPanel {
    private final DrawingPanel frame;
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton resetButton = new JButton("Reset");
    JButton exitButton = new JButton("Exit");

    public ControlPanel(DrawingPanel frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);
    }
}

