package wel;



import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 

class MyFrame1 
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
	public MyFrame1() 
	{ 
		setTitle("Login"); 
		setBounds(300, 90, 900, 600); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 

		c = getContentPane(); 
		c.setLayout(null); 

		title = new JLabel("Login"); 
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
	public void actionPerformed(ActionEvent ae) {
		
		
		
		// TODO Auto-generated method stub
		String userName = tname.getText();
        String password = tmno.getText();    
        
        if(ae.getSource() == sub) {
			String url = "jdbc:mysql://localhost:3306/userInfo";
			String pass = "prajwal";
			String username = "root";
			PreparedStatement stmt;
			Connection con;
			ResultSet res;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, username, pass);
				String query = "select * from userAJ where uname = ? and upass = ?";
				
				stmt =con.prepareStatement(query);
				stmt.setString(1, tname.getText());
				stmt.setString(2, tmno.getText());
				
				res = stmt.executeQuery();
				if(res.next()) {
					JOptionPane.showMessageDialog(this,"Login Suceessful");
				}else {
					JOptionPane.showMessageDialog(this,"Login Fail");
				}
				stmt.close();
				con.close();
			}catch(Exception ec) {
				//oops
				ec.printStackTrace();
			}
			
	} else if(ae.getSource() == bak) {
		dispose();
		new MyFrame2();
	}

}

	// method actionPerformed() 
	// to get the action performed 
	// by the user and act accordingly 
	 
} 

class Login { 

	public static void main(String[] args) throws Exception 
	{ 
		MyFrame1 f = new MyFrame1(); 
	} 
} 



