package DSD;

import lombok.*;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DesignPanel extends JPanel {
    final MainFrame frame;
    BufferedImage image;
    Graphics2D graphics;
    List<Component> componentList;

    /**
     * Constructor DesignPanel
     * In frame se creeaza un designPanel de 500/300 in care vom desena butoanele
     *
     * @param frame
     */
    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        this.createOffscreenImage();
        this.setPreferredSize(new Dimension(500, 300));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.componentList = new ArrayList();
        this.setLayout((LayoutManager) null);
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
     *
     * @param g
     */
    protected void paintComponent(Graphics g) {
        g.drawImage(this.image, 0, 0, this);
    }

    /**
     * Functia de returnare a listei de componente
     *
     * @return this.componentList
     */
    public List<Component> getComponentList() {
        return this.componentList;
    }

    /**
     * Functia care arata proprietatile componentei
     *
     * @param component
     */
    public void addFocusListenerToComponent(Component component) {
        component.addFocusListener(new FocusListener() {
            @SneakyThrows
            @Override
            public void focusGained(FocusEvent e) {
                Class<?> componentClass = component.getClass();
                BeanInfo info = Introspector.getBeanInfo(componentClass);
                int i = 0;
                DefaultTableModel model = (DefaultTableModel) frame.getPropertiesController().getPropertiesTable().getModel();
                for (PropertyDescriptor propertyDescriptor : info.getPropertyDescriptors()) {
                    model.setValueAt(String.valueOf(propertyDescriptor.getPropertyType()), i, 0);
                    model.setValueAt(String.valueOf(propertyDescriptor.getName()), i, 1);
                    ++i;
                }
            }
        });
    }
}
