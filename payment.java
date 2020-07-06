package movie;
import java.awt.*;import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
public class payment extends Frame implements ActionListener{
Frame f,f1;
Button b;
Label seat1;
TextField t11,t12,t13,t14,t2;
String movie;int available;
payment()
{
	      f= new JFrame("Payment");
	      f.setBackground(Color.WHITE);
	      Font myFont1 = new Font("Times New Roman",Font.PLAIN,14);
	      Label l1=new Label("Card number"); 
	      Label l0=new Label("Pay-mode"); 
	      l0.setFont(myFont1);
	      l0.setBounds(70,60,90,60);
	      Choice ch=new Choice();
	      ch.add("Credit");
	      ch.add("Debit");
	      ch.setBounds(170,80,80,20);
	     l1.setBounds(70,110,90,60);
	     l1.setFont(myFont1);
	     t11=new TextField(4);t11.setText("");
	     t12=new TextField(4);t12.setText("");
	     t13=new TextField(4);t13.setText("");
	     t14=new TextField(4);t14.setText("");
	     t11.setBounds(170,130,40,20);
	     t12.setBounds(220,130,40,20);
	     t13.setBounds(270,130,40,20);
	     t14.setBounds(320,130,40,20);
	     Label l2=new Label("CVV");  
	     l2.setBounds(70,170,90,60);
	     l2.setFont(myFont1);
	     t2=new TextField();t2.setText("");
	     t2.setEchoChar('*');
	     t2.setBounds(170,190,30,20);
	     b =new Button("PAY");
	     b.setBounds(170,270,60,30);
	     b.addActionListener(this);
	     f.add(l0);
	     f.add(ch);f.add(l1); f.add(t11);f.add(t12); f.add(t13); f.add(t14);f.add(l2);  
	     f.add(t2);  f.add(b);  f.setSize(500,500);  f.setLayout(null);   f.setVisible(true);
	}
	public void actionPerformed(ActionEvent a) {
		try
		{
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDetails","root", "lufi2412");
		Statement stmt=con.createStatement();ResultSet res=null;
		if(a.getSource()==b)
		{
			this.setVisible(false);
         res=stmt.executeQuery("SELECT movie,available from Cinema_info WHERE showtime='"+Availability.time+"'and cinemas='"+Availability.cinemas+"'");
		System.out.println(Availability.time);
		res.next();
		available=res.getInt("available");movie=res.getString("movie");
		int start=available;
		int end=available-Integer.parseInt(Availability.text.getText());
		available=end;
         stmt.executeUpdate("update Cinema_info set available="+available+" where showtime='"+Availability.time+"'and cinemas='"+Availability.cinemas+"'");
		System.out.println("hi");	
		f.setVisible(false);
		f1= new JFrame("Thank you");
		Button b1=new Button("OK");
		Font myFont1 = new Font("Times New Roman",Font.BOLD,20);
		Font myFont2= new Font("SERIF",Font.BOLD,19);
		Font myFont = new Font("SANS-SERIF",Font.BOLD,16);
		Label l00=new Label("****THANK YOU****");l00.setForeground(Color.GREEN);
		Label l0=new Label("BOOKING SUCCESS");l0.setForeground(Color.GREEN);
		Label seat=new Label("Seatno :");
		Label mov=new Label("Movie :");Label mov1=new Label(Availability.movname);
Label user= new Label("Phone No:");Label user1=new Label(String.valueOf(Loginpage.uid));
		Label cin=new Label("Theatre :");
Label st=new Label("Show Time :");
Label amt=new Label("Amount Paid :");
Label cin1=new Label(Availability.cinemas);Label st1=new Label(Availability.time);Label amount1=new Label(String.valueOf(Availability.amount));
		l0.setForeground(Color.BLACK);
		l0.setFont(myFont1);
	              if(start-end!=1){
		seat1=new Label(String.valueOf(start+"-"+(end+1)));}
		else {
        seat1=new Label(String.valueOf(start));}
		l0.setBounds(100, 20, 200, 50);
		l00.setFont(myFont2);
		l00.setForeground(Color.BLACK);
		l00.setBounds(100,350,200,100);
		seat.setBounds(100,320,80,30);
		seat1.setBounds(200,320,80,30);
		mov.setBounds(100,270,80,30);mov1.setBounds(180,270,100 ,30);
		user.setBounds(100,70,100,30);user1.setBounds(200,70,100,30);
		cin.setBounds(100, 120, 100, 30);cin1.setBounds(200, 120, 150, 30);
		st.setBounds(100, 170, 100, 30);st1.setBounds(200, 170, 100, 30);
amt.setBounds(100, 220, 110, 30);
amount1.setBounds(210,220,100,30);  cin.setFont(myFont);cin1.setFont(myFont);st.setFont(myFont);seat.setFont(myFont);seat1.setFont(myFont);st1.setFont(myFont);amt.setFont(myFont);amount1.setFont(myFont);user.setFont(myFont);user1.setFont(myFont);mov.setFont(myFont);mov1.setFont(myFont);
		b1 = new Button("EXIT");
		b1.setForeground(Color.BLACK);
		b1.setBounds(350,410,60,30);
b1.addActionListener(this);		   f1.add(l0);f1.add(user);f1.add(user1);f1.add(cin);f1.add(cin1);f1.add(mov);f1.add(mov1);f1.add(st);f1.add(st1);f1.add(amt);f1.add(amount1);
		f1.add(l00);
		f1.add(seat1);
		f1.add(b1);f1.add(seat);
		f1.setSize(500,500);
		f1.setBackground(Color.white);
		f1.setLayout(null);
		f1.setVisible(true);}
		else{
		f1.setVisible(false);
		Loginpage login=new Loginpage();
        login.setSize(400,400);
		login.setVisible(true);
		login.setResizable(false);}
		}catch(Exception e)
		{System.out.println(e);}
		}
	}  

