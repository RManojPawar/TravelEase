package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkPackages;
    JButton calculators, notepad, deletePersonalDetails, bookpackage, viewpackage, viewhotels;
    JButton bookhotel, viewbookhotel, destinations, payments, about;

    Dashboard(String username) {
        this.username = username;

        setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        // Top Panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        JLabel icon = new JLabel(new ImageIcon(i2));
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        // Side Panel
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        addPersonalDetails = createButton("Add Personal Details", 0, p2);
        updatePersonalDetails = createButton("Update Personal Details", 50, p2);
        viewPersonalDetails = createButton("View Details", 100, p2);
        deletePersonalDetails = createButton("Delete Personal Details", 150, p2);
        checkPackages = createButton("Check Package", 200, p2);
        bookpackage = createButton("Book Package", 250, p2);
        viewpackage = createButton("View Package", 300, p2);
        viewhotels = createButton("View Hotels", 350, p2);
        bookhotel = createButton("Book Hotels", 400, p2);
        viewbookhotel = createButton("View Booked Hotels", 450, p2);
        destinations = createButton("Destinations", 500, p2);
        payments = createButton("Payments", 550, p2);
        calculators = createButton("Calculator", 600, p2);
        notepad = createButton("Notepad", 650, p2);
        about = createButton("About", 700, p2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i5));
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        setVisible(true);
    }

    private JButton createButton(String text, int y, JPanel panel) {
        JButton button = new JButton(text);
        button.setBounds(0, y, 300, 50);
        button.setBackground(new Color(0, 0, 102));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.PLAIN, 22));
        button.setMargin(new Insets(0, 0, 0, 60));
        button.addActionListener(this);
        panel.add(button);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            new AddCustomer(username);
        } else if (ae.getSource() == viewPersonalDetails) {
            new ViewCustomer(username);
        } else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (ae.getSource() == checkPackages) {
            new CheckPackage(username);
        } else if (ae.getSource() == calculators) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}
