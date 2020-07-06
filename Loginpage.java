package movie;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
public class Loginpage extends JFrame implements ActionListener{
		JButton SUBMIT,SIGNUP;
		 public static long uid;
		 JPanel panel;
		 JLabel label1,label2,label3,label4;
		 JTextField text1;
		 JPasswordField  text2;
		 Font f=new Font("SANS_SERIF",Font.BOLD,15);
		 Font f1=new Font("SERIF",Font.BOLD,16);
		 Font f2=new Font("Times New Roman",Font.BOLD,20);
		  Loginpage()
		  {
		  label1 = new JLabel();
		  label3= new JLabel();
		  label4=new JLabel();
		  label3.setText("       WELCOME  TO ");
		  label4.setText("MOVIETIME");
		  label3.setFont(f2);
		  label4.setFont(f2);
		  label3.setForeground(Color.BLUE);
		  label4.setForeground(Color.RED);
		  label1.setText("   Userid:");
		  label1.setFont(f);
		  text1 = new JTextField(15); 
		  label2 = new JLabel();
		  label2.setText("   Password:");
		  label2.setFont(f);
		  text2 = new JPasswordField(15);
		  SUBMIT=new JButton("  LOGIN");
		  SIGNUP=new JButton("  SIGNUP");
		  SUBMIT.setFont(f1);
		  SUBMIT.setForeground(Color.red);
		  SIGNUP.setFont(f1);
		  SIGNUP.setForeground(Color.BLUE);
		  add(text1);
		  add(label2);
		  add(text2);
		  add(SUBMIT);
		  add(SIGNUP);
		  panel=new JPanel(new GridLayout(4,2,10,10));
		  panel.add(label3);
		  panel.add(label4);
		  panel.add(label1);
		  panel.add(text1);
		  panel.add(label2);
		  panel.add(text2);
		  panel.add(SUBMIT);
		  panel.add(SIGNUP);
		  add(panel,BorderLayout.CENTER);
		  SUBMIT.addActionListener(this);
		  SIGNUP.addActionListener(this);
		  setTitle("LOGIN FORM");
		  }


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDetails", "root", "lufi2412");
			Statement stmt=con.createStatement();ResultSet res=null;
		if(ae.getSource()==SUBMIT)
		{
		    uid=Long.parseLong(text1.getText());String pass=text2.getText();
			res=stmt.executeQuery("SELECT * from login where userid="+uid+"");
			res.next();
			if(pass.equals(res.getString("password")))
			{
				movies mov=new movies(uid);
				this.setVisible(false);
			
			}else {JOptionPane.showMessageDialog(this,"Incorrect Loginid/Password");}
		}
		else
		{
			this.setVisible(false);
			  SignUpPage page=new SignUpPage();
			  page.setVisible(true);
			  page.setSize(400,500);
		}
		}catch(Exception e) {System.out.println(e);}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loginpage login=new Loginpage();
		 login.setSize(400,400);
		 login.setVisible(true);
		 login.setResizable(false);
	}
}

class SignUpPage extends JFrame implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label1,label2,label4,label5;
	JTextField  text1,text2,text4;
	Choice gender;
	 Font f=new Font("SANS_SERIF",Font.BOLD,15);
	 Font f1=new Font("SERIF",Font.BOLD,20);
	JButton SUBMIT,BACK;
	JPanel panel;
	SignUpPage()
 {
		 label1 = new JLabel();
		  label1.setText("  Userid :");label1.setFont(f);
		  text1 = new JTextField(15);text1.setText("Enter Mobile num");
		  label2 = new JLabel();
		  label2.setText("  Password :");label2.setFont(f);
		  text2 = new JPasswordField(15);
		  label4 = new JLabel();
		  label4.setText("  U-Pin :");label4.setFont(f);
		  text4 = new JTextField(15);
		  label5=new JLabel("  Gender :");
		  label5.setFont(f);
		  gender =new Choice();
		  gender.add("M");
		  gender.add("F");
		  SUBMIT=new JButton("SUBMIT");
		  SUBMIT.setFont(f1);
		  SUBMIT.setForeground(Color.BLUE);
		  BACK=new JButton("BACK");
		  BACK.setFont(f1);
		  BACK.setForeground(Color.darkGray);
		  panel=new JPanel(new GridLayout(6,2,10,10));
		  panel.add(label1);
		  panel.add(text1);
		  panel.add(label2);
		  panel.add(text2);
		  panel.add(label4);
		  panel.add(text4);
		  panel.add(label5);
		  panel.add(gender);
		  panel.add(SUBMIT);
		  panel.add(BACK);
		  add(panel,BorderLayout.CENTER);
		  add(panel);
		  SUBMIT.addActionListener(this);
          BACK.addActionListener(this);
		  setTitle("Registration FORM");
		  
 setDefaultCloseOperation(javax.swing.
  WindowConstants.DISPOSE_ON_CLOSE);
  }
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==SUBMIT) {
			Connection con;
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDetails", "root", "lufi2412");
				Statement stmt=con.createStatement();
				stmt.executeUpdate("Insert into login values('"+text1.getText()+"','"+text2.getText()+"','"+gender.getItem(gender.getSelectedIndex())+"','"+text4.getText()+"')");
				JOptionPane.showMessageDialog(this,"Signup Successfull");this.setVisible(false);
				Loginpage login=new Loginpage();login.setVisible(true);login.setSize(400,400);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else
		{
			this.setVisible(false);
			Loginpage login=new Loginpage();login.setVisible(true);login.setSize(400,400);
		}
	}
}

