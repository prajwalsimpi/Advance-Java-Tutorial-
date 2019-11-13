package wel;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.awt.image.*;
 class MyFrame2 
	extends JFrame 
	implements ActionListener { 

	// Components of the Form 
	private Container c; 
	private JLabel title; 
	private JLabel name; 
	
	private JButton sub; 
	
	JButton reg;

	// constructor, to initialize the components 
	// with default values. 
	public MyFrame2() 
	{ 
		setTitle("Welcome"); 
		setBounds(300, 90, 900, 600); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(true); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Dayananda Sagar College of Engineering"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(1000, 35); 
		title.setLocation(150, 50); 
		c.add(title); 

		
		
		name = new JLabel("Computer Science Engneering"); 
		name.setFont(new Font("Arial", Font.PLAIN, 27)); 
		name.setSize(1000, 40); 
		name.setLocation(100, 200); 
		c.add(name); 
		
		JLabel name1 = new JLabel("<html><br>The Department of Computer Science and Engineering is <br>positioned to create the<br> technological leaders of tomorrow.<br> Our goal is to ensure that our engineering <br>graduates are well prepared to<br> play the roles of problem solvers, project<br> leaders, entrepreneurs, <br>and above all ethical citizens of a global society.</html> "); 
		name1.setFont(new Font("Arial", Font.PLAIN, 20)); 
		name1.setSize(10000, 500); 
		name1.setLocation(100, 100); 
		c.add(name1); 

		
		
		sub = new JButton("register"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(800, 50); 
        sub.addActionListener(this);
        
        c.add(sub); 
        reg = new JButton("login"); 
        reg.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reg.setSize(100, 20); 
        reg.setLocation(700,50); 
        reg.addActionListener(this);
        
        c.add(reg); 
        
        
        ImageIcon imgIcon  = new ImageIcon("C:\\Users\\Pheonix\\Desktop\\dsi.jpg");
        
        JLabel imgg = new JLabel(imgIcon);
        imgg.setSize(100,100);
        imgg.setLocation(30,30);
        c.add(imgg);
        
        //Image newimg = image.setScaledInstance(120,120); 
        //c.add(new JLabel(new ImageIcon("C:\\Users\\Pheonix\\Desktop\\dsi.jpg")));
		setVisible(true); 
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == reg) {
			dispose();
			new MyFrame1();
		}else if(e.getSource() == sub) {
			dispose();
			new MyFrame();
		}
		
	}



	
	
} 

class PanelTitles { 

	public static void main(String[] args) throws Exception 
	{ 
		MyFrame2 f2 = new MyFrame2(); 
	} 
} 



