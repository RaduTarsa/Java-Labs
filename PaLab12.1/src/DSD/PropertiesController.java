package DSD;

import lombok.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;

@Getter
public class PropertiesController extends JPanel {
    private final MainFrame frame;
    private final JTable propertiesTable;

    /**
     * Constructor PropertiesController
     * @param frame
     */
    public PropertiesController(MainFrame frame) {
        this.frame = frame;
        this.propertiesTable = new JTable(new DefaultTableModel(new String[]{"Type", "Name"}, 100));
        init();
    }

    /**
     * Initializarea panelului cu proprietati
     */
    private void init() {
        setLayout(new BorderLayout());
        propertiesTable.setFillsViewportHeight(true);
        JScrollPane scrollTable = new JScrollPane(propertiesTable);
        add(scrollTable, BorderLayout.CENTER);
    }
}
