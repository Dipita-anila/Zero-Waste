
package zero_waste;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class retriveRmingFoodInfo extends JFrame {

    private JPanel panel1, panel2;
    private JLabel txtlb1, txtlb2, txtlb3, imgl, imgl2, imgl3;
    private JTextField textfld;
    private JLabel textfld2, textfld3;
    private JPasswordField pass;
    private JButton button1, button2, button3, button4;
    private Font fn;
    private ImageIcon img, img2, img3;
    private Container c;
    String name;
    String username;

    retriveRmingFoodInfo(final String username) {

        this.username = username;
        this.setBounds(700, 300, 460, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.white);
        fn = new Font("Arial", Font.BOLD, 20);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(177, 193, 216));
        panel2.setBounds(10, 10, 420, 365);
        panel2.setBorder(new LineBorder(Color.black, 5));
        c.add(panel2);

        txtlb1 = new JLabel("FOOD INFORMATION");
        txtlb1.setBounds(100, 10, 220, 30);
        txtlb1.setBorder(new LineBorder(Color.BLACK,3));
        txtlb1.setFont(fn);
        txtlb1.setBackground(Color.black);
        txtlb1.setForeground(Color.BLACK);
        panel2.add(txtlb1);

        txtlb2 = new JLabel("Event  ID :");
        txtlb2.setBounds(50, 45, 200, 50);
        txtlb2.setFont(fn);
        txtlb2.setForeground(Color.black);
        txtlb2.setBackground(Color.black);
        panel2.add(txtlb2);

        textfld = new JTextField();
        textfld.setBounds(50, 85, 300, 30);
        textfld.setForeground(Color.BLACK);
        textfld.setBorder(new LineBorder(Color.BLACK,2));
        //textfld.setBorder(BorderFactory.createEmptyBorder());
        textfld.setFont(new Font("SAN_SARIF", Font.PLAIN, 25));
        panel2.add(textfld);

        txtlb3 = new JLabel("Remaining Food");
        txtlb3.setBounds(50, 140, 270, 50);
        txtlb3.setFont(fn);
        txtlb3.setForeground(Color.black);
        panel2.add(txtlb3);

        textfld2 = new JLabel();
        textfld2.setBounds(50, 180, 300, 30);
        textfld2.setForeground(Color.BLACK);
        textfld2.setBorder(new LineBorder(Color.BLACK,3));
        //textfld2.setBorder(BorderFactory.createEmptyBorder());
        textfld2.setFont(new Font("SAN_SARIF", Font.PLAIN, 25));
        panel2.add(textfld2);

        txtlb3 = new JLabel("Amount of Wasted Food");
        txtlb3.setBounds(50, 220, 270, 50);
        txtlb3.setFont(fn);
        txtlb3.setForeground(Color.black);
        panel2.add(txtlb3);

        textfld3 = new JLabel();
        textfld3.setBounds(50, 260, 300, 30);
        textfld3.setForeground(Color.BLACK);
        textfld3.setBorder(new LineBorder(Color.BLACK,3));
        textfld3.setFont(new Font("SAN_SARIF", Font.PLAIN, 25));
        panel2.add(textfld3);

        button1 = new JButton("Get");
        button1.setBackground(new Color(125, 149, 185));
        button1.setForeground(Color.black);
        button1.setBorder(new LineBorder(Color.black));
        button1.setBounds(70, 320, 80, 30);
        button1.setFont(fn);
        panel2.add(button1);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Conn con = new Conn();
                    String sql = "select * from remained_food_info where user_event_id=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textfld.getText());
                    ResultSet rs = st.executeQuery();

                    while (rs.next()) {
                        textfld2.setText(rs.getString("remained_food"));
                        textfld3.setText(rs.getString("wasted_food"));
                    }

                } catch (Exception ep) {
                    System.out.println(ep);
                }
            }
        });

        button2 = new JButton("Back");
        button2.setBackground(new Color(125, 149, 185));
        button2.setForeground(Color.black);
        button2.setBorder(new LineBorder(Color.black));
        button2.setBounds(250, 320, 80, 30);
        button2.setFont(fn);
        panel2.add(button2);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new donation_information(username,"").setVisible(true);
            }
        });

    }

    public static void main(String[] args) {

        retriveRmingFoodInfo frame = new retriveRmingFoodInfo(" ");

        frame.setVisible(true);

    }

}
