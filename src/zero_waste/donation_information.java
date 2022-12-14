
package zero_waste;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

 

public class donation_information extends JFrame{
    
     private Container c;
    private JLabel uperlbl,lowerlbl,piclbl,piclbl2,underlbl,detailslbl;
    private JPanelGradient panel2,panel1;
    private ImageIcon img1,img2,img3,img4;
    JMenu m1,m2,m3,m4,m5,m6;
    JMenuBar menuBar;
    JScrollPane scroll;
    String username,userid;
    
    class JPanelGradient extends JPanel {

        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            Color color1 = new Color(156,222,185);
          
          //  Color color2 = new Color(245,245,220);
          Color color2 = new Color(177, 193, 216);
            GradientPaint gp = new GradientPaint(0, 0, color1, 180, height, color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
    
    donation_information(final String username, final String userid){
        this.username = username;
        this.userid=userid;
        this.setBounds(600,200,600,680);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         c =this.getContentPane();
          setResizable(false);
         c.setLayout(null);
         //c.setBackground(Color.black);
         c.setBackground(new Color(177,193,216));
         
         uperlbl = new JLabel();
         uperlbl.setBounds(10,20,570,155);
         uperlbl.setBorder(new LineBorder(new Color(125,149,185),4));
         c.add(uperlbl);
         
         detailslbl = new JLabel("ALL DONATION INFORMATION");
         detailslbl.setBounds(150,65,300,35);
         detailslbl.setForeground(Color.black);
         detailslbl.setFont(new Font("Arial",Font.BOLD,20));
         uperlbl.add(detailslbl);
         
    /*   img1 = new ImageIcon(getClass().getResource("design\\d_picture\\kaptai_lake.jpg"));
         piclbl = new JLabel(img1);
         piclbl.setBounds(280,-5,280,150);
         //piclbl.setBackground(Color.yellow);
         piclbl.setBorder(new LineBorder(Color.black));
         uperlbl.add(piclbl);   */
         
      /*  underlbl = new JLabel("Kaptai Lake");
         underlbl.setBounds(390,175,100,25);
         underlbl.setForeground(Color.white);
         c.add(underlbl); */
         
         img3 = new ImageIcon(getClass().getResource("design\\d_info.png"));
         lowerlbl = new JLabel(img3);
         lowerlbl.setBounds(10,190,570,420);
         lowerlbl.setBorder(new LineBorder(new Color(125,149,185),4));
         scroll = new JScrollPane(lowerlbl);
         scroll.setBounds(10,200,570,420);
         scroll.setBorder(new LineBorder(new Color(125,149,185),4));
         c.add(lowerlbl);
         
         
         
         
         menuBar = new JMenuBar();
         menuBar.setBackground(Color.WHITE);
	setJMenuBar(menuBar);
		
        m1 = new JMenu("Donation's Information");
        m1.setForeground(Color.BLACK);
        m1.setBorder(new LineBorder(Color.BLACK,1));
	menuBar.add(m1);

        
        JMenuItem mi2 = new JMenuItem("On Events");
	m1.add(mi2);
        mi2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                dispose();
                new retriveOwnDonation(username).setVisible(true);
            }
        });
        
        
        
         JMenuItem mi3 = new JMenuItem("Donation's to Organization");
	m1.add(mi3);
        mi3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                dispose();
                new retriveOrgDonation(username,userid).setVisible(true);
            }
        });
       
       
      /*   JMenuItem mi2 = new JMenuItem("PACKAGES");
	m1.add(mi2);
        mi2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                  dispose();
                 new ViewPackage().setVisible(true);
                }catch(Exception e){ }
            }
	});*/
        
     /*   m2 = new JMenu("Event-2");
        m2.setForeground(Color.white);
        m2.setBorder(new LineBorder(Color.white,2));
	menuBar.add(m2);
        
        JMenuItem evnt1 = new JMenuItem("Own Events");
        m2.add(evnt1);
        evnt1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                try{
                  //dispose();
                 new userEvntDonationNum().setVisible(true);
                }catch(Exception e){ }
            }
	});*/
        
            
      /*  m3 = new JMenu("Donations information");
        m3.setForeground(Color.white);
        m3.setBorder(new LineBorder(Color.white,2));
	menuBar.add(m3);
         JMenuItem mi9 = new JMenuItem("Donations' to Organization");
        m3.add(mi9);
           mi9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                //new BookPackage().setVisible(true);
            }
	});
           */
        
        
          m4 = new JMenu("Remained Food");
        m4.setForeground(Color.BLACK);
        m4.setBorder(new LineBorder(Color.BLACK,1));
	menuBar.add(m4);
        JMenuItem remain = new JMenuItem(" Details of Remained Food");
        m4.add(remain);
           remain.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                dispose();
                new retriveRmingFoodInfo(username).setVisible(true);
                //new BookPackage().setVisible(true);
                // there will be the information of remaining food from the database
            }
	});
           
        
           m6 = new JMenu("Add Information for Remaning Food");
        m6.setForeground(Color.BLACK);
        m6.setBorder(new LineBorder(Color.BLACK,1));
	menuBar.add(m6);
        JMenuItem Event1 = new JMenuItem("Event-1");
        m6.add(Event1);
           Event1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                dispose();
                new remainingFoodInfo(username).setVisible(true);
            }
	});
           
         JMenuItem Event2 = new JMenuItem("Event-2");
        m6.add(Event2);
           Event2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                dispose();
               new remainingFoodInfo(username).setVisible(true);
            }
	});   
           
         JMenuItem Event3 = new JMenuItem("Event-3");
        m6.add(Event3);
           Event3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                dispose();
               new remainingFoodInfo(username).setVisible(true);
            }
	});   
           
           

        m5=new JMenu("UTILITY");
        m5.setForeground(Color.BLACK);
        m5.setBorder(new LineBorder(Color.BLACK,1));
	menuBar.add(m5);
         
        JMenuItem mi6 = new JMenuItem("NOTEPAD");
	m5.add(mi6);
        
        JMenuItem mi7 = new JMenuItem("CALCULATOR");
	m5.add(mi7);
        
         JMenuItem mi8 = new JMenuItem("Back");
	m5.add(mi8);
        
    
        
        mi6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                     Runtime.getRuntime().exec("notepad");
                }catch(Exception e){ }
            }
	});
        
        mi7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    Runtime.getRuntime().exec("calc.exe");
                }catch(Exception e){ }
            }
	});
        
        mi8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                dispose();
                try {
                    new dashBoard(username).setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(donation_information.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	});
        
        
        
        
        
    }
    public static void main(String[] args) {
        
        
         donation_information frame = new  donation_information("","");
        frame.setVisible(true);
    }
    
}
