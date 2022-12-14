package zero_waste;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class createEvent extends JFrame implements ActionListener {

    private JPanel contentpane;
    private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    private JButton b1, b2;
    String username;

    createEvent(final String username) {
        this.username = username;
        this.setBounds(400, 220, 850, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentpane = new JPanel();
        setContentPane(contentpane);
         setResizable(false);
        contentpane.setLayout(null);
        contentpane.setBackground(new Color(177, 193, 216));
        this.setTitle("Create Event");

        ImageIcon i1 = new ImageIcon(getClass().getResource("design\\createE.jpg"));

        JLabel l1 = new JLabel(i1);
        l1.setBorder(new LineBorder(Color.BLACK, 3));
        l1.setBounds(410, 40, 400, 250);

        add(l1);

        JLabel lb1 = new JLabel("     Event Details:");
        lb1.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lb1.setBounds(118, 11, 220, 53);
        lb1.setBackground(new Color(125, 149, 185));
        lb1.setBorder(new LineBorder(Color.black, 3));
        contentpane.add(lb1);

        
        JLabel lb6 = new JLabel("Event Name :");
        lb6.setBounds(35, 80, 200, 14);
        contentpane.add(lb6);

        t6 = new JTextField();
        t6.setBounds(150, 80, 150, 20);
        contentpane.add(t6);

        JLabel lb7 = new JLabel("Event For :");
        lb7.setBounds(35, 110, 200, 14);
        contentpane.add(lb7);

        t7 = new JTextField();
        t7.setBounds(150, 110, 150, 20);
        contentpane.add(t7);

        JLabel lb8 = new JLabel("Food Type:");
        lb8.setBounds(35, 140, 200, 14);
        contentpane.add(lb8);

        t8 = new JTextField();
        t8.setBounds(150, 140, 150, 20);
        contentpane.add(t8);

        JLabel lb9 = new JLabel("Date and time :");
        lb9.setBounds(35, 170, 200, 14);
        contentpane.add(lb9);

        t9 = new JTextField();
        t9.setBounds(150, 170, 150, 20);
        contentpane.add(t9);

        JLabel lb10 = new JLabel("Location :");
        lb10.setBounds(35, 200, 200, 14);
        contentpane.add(lb10);

        t10 = new JTextField();
        t10.setBounds(150, 200, 150, 20);
        contentpane.add(t10);

        JLabel lb11 = new JLabel("Quantity :");
        lb11.setBounds(35, 230, 200, 14);
        contentpane.add(lb11);

        t11 = new JTextField();
        t11.setBounds(150, 230, 150, 20);
        contentpane.add(t11);

        b1 = new JButton("Create ");
        b1.setBackground(new Color(125, 149, 185));
        b1.setForeground(Color.black);
        b1.setBounds(40, 260, 100, 25);
        add(b1);
        b1.addActionListener(this);

        b2 = new JButton("Back");
        b2.setBackground(new Color(125, 149, 185));
        b2.setForeground(Color.black);
        b2.setBounds(200, 260, 100, 25);
        add(b2);
        b2.addActionListener(this);

       
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                try {
                    new admin_dashBoard(username).setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(createEvent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // }
    }

    public static void main(String[] args) {

        createEvent frame = new createEvent(" ");
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            Conn con = new Conn();

            if (e.getSource() == b1) {
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to create an event?", "confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {

                    String sql = "insert into event(event_name,event_for,food_type,date_time,location,quantity) values(?, ?, ?, ?,?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, t6.getText());
                    st.setString(2, t7.getText());
                    st.setString(3, t8.getText());
                    st.setString(4, t9.getText());
                    st.setString(5, t10.getText());
                    st.setString(6, t11.getText());
                   
                   
                    String event_name = t6.getText();
                    String event_for = t7.getText();
                    String food_type = t8.getText();
                    String date_time = t9.getText();
                    String location = t10.getText();
                    String quantity = t11.getText();

                    if (event_name.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out Event Name feild");
                    } else if (event_for.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out Event For feild");
                    } else if (food_type.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out the Food Type  feild");
                    } else if (date_time.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out Date and Time feild");
                    } else if (location.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out Location feild");
                    } else if (quantity.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill out Quantity  feild");
                    } else {

                        int i = st.executeUpdate();
                        if (i > 0) {
                            JOptionPane.showMessageDialog(null, "Event Created Successfully ");
                        }

                      
                        t6.setText("");
                        t7.setText("");
                        t8.setText("");
                        t9.setText("");
                        t10.setText("");
                        t11.setText("");

                    }

                }
                //if(e.getSource()== b2){
                //dispose();
                // new dashBoard("").setVisible(true);
                //}

            }
        } catch (Exception e2) {
            System.out.println(e2);
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}