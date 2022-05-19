package presentation.view.Employee;

import Start.Start;
import bll.CompositeProduct;
import bll.DeliveryService;
import bll.Order;
import bll.MenuItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class EmployeeView extends JFrame implements Observer {

    private JFrame frame = this;
    private JTextArea textArea;
    private int ok = 0;

    @Override
    public void update(Observable o, Object arg) {

        if (ok == 1)
            JOptionPane.showMessageDialog(frame, "New Order");

        Map<Order, Collection<MenuItem>> orders = Start.getDeliveryService().sortOrders();

        String toWrite = "";
        for (Order order : orders.keySet()) {
            toWrite += "Order: " + order.getId() + "\n";
            toWrite += "Client: " + order.getIdClient() + "\n";
            toWrite += "Date: " + order.getOrderDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() + "\n";
            toWrite += "Hour: " + order.getOrderDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime() + "\n";
            toWrite += "Products: \n";

            for (MenuItem menuItem : orders.get(order)) {
                if (menuItem instanceof CompositeProduct) {
                    toWrite += "     -> " + menuItem.getTitle() + " : ";
                    for (MenuItem itm : ((CompositeProduct) menuItem).getMenuItemList())
                        toWrite += itm.getTitle() + " + ";
                    toWrite = toWrite.substring(0, toWrite.length() - 1) + "\n";
                } else {
                    toWrite += "     -> " + menuItem.getTitle() + "\n";
                }
            }

            toWrite += "\n---------------------------------------------------------------------------------------------------------------\n";
        }


        textArea.setText(toWrite);
        System.out.println(textArea.getText());
    }

    public EmployeeView() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Employee");
        setBackground(Color.WHITE);
        setBounds(100, 100, 729, 650);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Waiting orders");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel.setBounds(280, 5, 185, 53);
        contentPane.add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(20, 69, 680, 16);
        contentPane.add(separator);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 75, 680, 527);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);

        update(Start.getDeliveryService(), Start.getDeliveryService().getPlacedOrders());
        ok = 1;

        this.setVisible(true);
        this.setResizable(false);
    }


    public JTextArea getTextArea() {
        return textArea;
    }
}
