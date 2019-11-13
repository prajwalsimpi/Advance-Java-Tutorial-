package wel;

import java.sql.*;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

class MyFrame 
	extends JFrame 
	implements ActionListener { 

	// Components of the Form 
	private Container c; 
	private JLabel title; 
	private JLabel name; 
	private JTextField tname; 
	private JLabel mno; 
	private JTextField tmno; 
	private JButton sub; 
	private JButton bak;
	

	
	// constructor, to initialize the components 
	// with default values. 
	public MyFrame() 
	{ 
		setTitle("Registration Form"); 
		setBounds(300, 90, 900, 600); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Registration Form"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(300, 30); 
		title.setLocation(300, 30); 
		c.add(title); 

		name = new JLabel("username"); 
		name.setFont(new Font("Arial", Font.PLAIN, 20)); 
		name.setSize(100, 20); 
		name.setLocation(100, 100); 
		c.add(name); 

		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(190, 20); 
		tname.setLocation(200, 100); 
		c.add(tname); 

		mno = new JLabel("password"); 
		mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
		mno.setSize(100, 20); 
		mno.setLocation(100, 150); 
		c.add(mno); 

		tmno = new JTextField(); 
		tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tmno.setSize(150, 20); 
		tmno.setLocation(200, 150); 
		c.add(tmno); 
		JFrame f=new JFrame();//creating instance of JFrame  
      
		sub = new JButton("Submit"); 
      sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
      sub.setSize(100, 20); 
      sub.setLocation(150, 450); 
      sub.addActionListener(this); 
      c.add(sub); 
      bak = new JButton("Back"); 
      bak.setFont(new Font("Arial", Font.PLAIN, 15)); 
      bak.setSize(100, 20); 
      bak.setLocation(250, 450); 
      bak.addActionListener(this); 
      c.add(bak);
		

		setVisible(true); 
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sub) {
			String url = "jdbc:mysql://localhost:3306/userInfo";
			String pass = "prajwal";
			String username = "root";
			
			PreparedStatement stmt;
			Connection con;
			int res;
			ResultSet check;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, username, pass);
				
				String query2 = "select * from userAJ where uname =?"; 
				String query = "insert into userAJ values(?,?)"; 
				
				stmt =con.prepareStatement(query2);
				stmt.setString(1, tname.getText());
				check = stmt.executeQuery();
				if(check.next()) {
					
					System.out.println("Username taken");
					JOptionPane.showMessageDialog(this," username taken");
					
				}else {
					stmt =con.prepareStatement(query);
					stmt.setString(1, tname.getText());
					stmt.setString(2, tmno.getText());
					JOptionPane.showMessageDialog(this,"Registeration Successful");
					res = stmt.executeUpdate();
				}
				stmt.close();
				con.close();
				
			}catch(Exception ec) {
				//oops
				ec.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		else if(e.getSource() == bak) {
			dispose();
			new MyFrame2();
		}
		
	}

} 

//Driver Code 
class Registration { 

	public static void main(String[] args) throws Exception 
	{ 
		MyFrame f = new MyFrame(); 
		
		
	} 
} 


