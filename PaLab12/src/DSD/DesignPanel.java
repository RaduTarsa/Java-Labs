package DSD;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DesignPanel extends JPanel {
    final MainFrame frame;
    BufferedImage image;
    Graphics2D graphics;
    List<Component> componentList;

    /**
     * Constructor DesignPanel
     * In frame se creeaza un designPanel de 500/300 in care vom desena butoanele
     * @param frame
     */
    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        this.createOffscreenImage();
        this.setPreferredSize(new Dimension(500, 300));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.componentList = new ArrayList();
        this.setLayout((LayoutManager)null);
    }

    /**
     * Imaginea de care avem nevoie ca si canvas
     */
    private void createOffscreenImage() {
        this.image = new BufferedImage(500, 300, 2);
        this.graphics = this.image.createGraphics();
        this.graphics.setColor(Color.WHITE);
        this.graphics.fillRect(0, 0, 500, 300);
    }

    /**
     * Pe g deseneaza un obiect
     * @param g
     */
    protected void paintComponent(Graphics g) {
        g.drawImage(this.image, 0, 0, this);
    }

    /**
     * functia de returnare a listei de componente
     * @return this.componentList
     */
    public List<Component> getComponentList() {
        return this.componentList;
    }
}
