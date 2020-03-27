package GFX;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class DrawingPanel extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int height = screenSize.height / 3;
    int width = screenSize.width / 4;
    static ConfigurationPanel form;
    MainFrame canvas;
    ControlPanel control;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == control.resetButton) {
                canvas.clear();
            } else if (e.getSource() == control.loadButton) {
                try {
                    load();
                } catch (IOException e1) {
                    System.out.println("No file found...");
                }
            } else if (e.getSource() == control.saveButton) {
                try {
                    save();
                } catch (IOException e1) {
                    System.out.println("Wrong path or you can't save this...");
                }
            } else if (e.getSource() == form.drawButton) {
                int repeat = Integer.parseInt(form.shapesNo.getText());
                int sides = Integer.valueOf((Integer) form.sidesNoValue.getSelectedItem());
                canvas.drawShapeRandom(repeat, sides);
                repaint();
            } else if (e.getSource() == control.exitButton) {
                close();
            }
        }
    };

    public DrawingPanel() {
        super("Lab 6");
        rootPane.setBorder(BorderFactory.createTitledBorder("Panel"));
        rootPane.setPreferredSize(new Dimension(width, height));
        init();
        addComponents();
        this.pack();
    }

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        form = new ConfigurationPanel(this);
        canvas = new MainFrame();
        control = new ControlPanel(this);
        form.drawButton.addActionListener(actionListener);
        control.resetButton.addActionListener(actionListener);
        control.saveButton.addActionListener(actionListener);
        control.loadButton.addActionListener(actionListener);
    }

    private void addComponents() {
        add(form, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);
    }

    public void save() throws IOException {
        ImageIO.write(canvas.getImage(), "PNG", new File("demo.png"));
    }

    public void load() throws IOException {
        canvas.setImage(ImageIO.read(new File("demo.png")));
        repaint();
    }

    public void close() {
        System.out.println("Sal");
        System.exit(0);
    }
}
