package DSD;

import javax.swing.JFrame;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;

    /**
     * Constructor MainFrame
     * Deschide un frame cu titlul Lab 12 si il initializeaza
     */
    public MainFrame() {
        super("Lab 12");
        this.init();
    }

    /**
     * Initializarea frame-ului cu setarile de rigoare: un controlPanel N si un designPanel S
     */
    public void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.controlPanel = new ControlPanel(this);
        this.designPanel = new DesignPanel(this);
        add(controlPanel, BorderLayout.NORTH);
        add(designPanel, BorderLayout.CENTER);
        this.pack();
    }
}
