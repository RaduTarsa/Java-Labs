package DSD;

import lombok.*;

import javax.swing.JFrame;
import java.awt.*;

@Getter
public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;
    PropertiesController propertiesController;

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
        this.propertiesController = new PropertiesController(this);
        add(controlPanel, BorderLayout.NORTH);
        add(designPanel, BorderLayout.CENTER);
        add(propertiesController, BorderLayout.EAST);
        this.pack();
    }

    /**
     * Functia care face update la designPanel
     * @param designPanel
     */
    public void updateDesignPanel(DesignPanel designPanel) {
        remove(this.designPanel);
        this.designPanel = designPanel;
        add(designPanel, BorderLayout.CENTER);
        pack();
    }
}
