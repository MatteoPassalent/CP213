package cp213;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The GUI for the Order class.
 *
 * @author your name here
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2023-07-05
 */
@SuppressWarnings("serial")
public class OrderPanel extends JPanel {

    // Attributes
    // I wrote width/height
    public static final int WIDTH = 400;
    public static final int HEIGHT = 550;

    private Menu menu = null; // Menu attached to panel.
    private final Order order = new Order(); // Order to be printed by panel.
    // GUI Widgets
    private final JButton printButton = new JButton("Print");
    private final JLabel subtotalLabel = new JLabel("0");
    private final JLabel taxLabel = new JLabel("0");
    private final JLabel totalLabel = new JLabel("0");

    private JLabel nameLabels[] = null;
    private JLabel priceLabels[] = null;
    // TextFields for menu item quantities.
    private JTextField quantityFields[] = null;

    /**
     * Displays the menu in a GUI.
     *
     * @param menu The menu to display.
     */
    public OrderPanel(final Menu menu) {
        this.menu = menu;
        this.nameLabels = new JLabel[this.menu.size()];
        this.priceLabels = new JLabel[this.menu.size()];
        this.quantityFields = new JTextField[this.menu.size()];
        this.layoutView();
        this.registerListeners();
    }

    /**
     * Implements an ActionListener for the 'Print' button. Prints the current
     * contents of the Order to a system printer or PDF.
     */
    private class PrintListener implements ActionListener {
        // don't need constructor because ActionListener no arguement constructor is
        // called by default
        @Override
        public void actionPerformed(final ActionEvent e) {

            // your code here
            int result = order.print(getGraphics(), null, ABORT);

        }
    }

    /**
     * Implements a FocusListener on a JTextField. Accepts only positive integers,
     * all other values are reset to 0. Adds a new MenuItem to the Order with the
     * new quantity, updates an existing MenuItem in the Order with the new
     * quantity, or removes the MenuItem from the Order if the resulting quantity is
     * 0.
     */
    private class QuantityListener implements FocusListener {
        private MenuItem item = null;

        QuantityListener(final MenuItem item) {
            this.item = item;
        }

        // your code here
        // no @override needed cuz FocusListener has these as abstract methods
        public void focusGained(final FocusEvent e) {
        }

        public void focusLost(final FocusEvent e) {
            // downcasting should be fine as long as JTextField are only ones with this
            // listener
            JTextField quantityText = (JTextField) e.getSource();
            String quantityStr = quantityText.getText();
            int quanity = 0;
            try {
                quanity = Integer.parseInt(quantityStr);
                if (quanity < 0) {
                    quanity = 0;
                }
            } catch (NumberFormatException error) {
                quanity = 0;
            }

            order.update(item, quanity);

            subtotalLabel.setText(String.format("%.2f", order.getSubTotal().floatValue()));
            taxLabel.setText(String.format("%.2f", order.getTaxes().floatValue()));
            totalLabel.setText(String.format("%.2f", order.getTotal().floatValue()));

            String qToString = String.valueOf(quanity);
            quantityText.setText(qToString);
        }

    }

    /**
     * Layout the panel.
     */
    private void layoutView() {
        // your code here
        // should define what happens on close
        JFrame testWindow = new JFrame("WLU Foodorama");
        testWindow.setSize(WIDTH, HEIGHT);

        this.setSize(WIDTH, HEIGHT);
        this.add(printButton);
        this.add(subtotalLabel);
        this.add(taxLabel);
        this.add(totalLabel);

        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            nameLabels[i] = new JLabel(item.getName());
            // could be problem with string type as price, might be only way tho
            priceLabels[i] = new JLabel(item.getPrice().toString());
            quantityFields[i] = new JTextField("0", 5);

            this.add(nameLabels[i]);
            this.add(priceLabels[i]);
            this.add(quantityFields[i]);

        }

        this.setVisible(true);

        testWindow.add(this);
        testWindow.setVisible(true);

    }

    /**
     * Register the widget listeners.
     */
    private void registerListeners() {
        // Register the PrinterListener with the print button.
        this.printButton.addActionListener(new PrintListener());

        // your code here
        // Register the QuantityListener with the quantityFields.
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            quantityFields[i].addFocusListener(new QuantityListener(item));
        }
    }

}