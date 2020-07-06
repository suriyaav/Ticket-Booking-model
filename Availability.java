package movie;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Availability extends JFrame implements ActionListener {
	 Font f=new Font("SANS_SERIF",Font.BOLD,15);JLabel ticketno;static JTextField text;JButton next;public static String time;static String cinemas;static int amount;
	 Choice cinema=new Choice();Long userid;JLabel j;static String movname;
	 Availability(String movie,Long userid)
	{
		 this.userid=userid;this.movname=movie;
		 setTitle("Booking Availability");
		setSize(500,500);
		setVisible(true);setResizable(true);
	    ticketno=new JLabel("No of Tickets :");ticketno.setFont(f);text=new JTextField();
		getCinemas(movie);
	}

	private void getCinemas(String moviename) {
		// TODO Auto-generated method stub
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDetails", "root", "lufi2412");
			Statement stmt=con.createStatement();ResultSet res=null;
	    	res=stmt.executeQuery("SELECT * from Cinema_info where movie='"+moviename+"'");
			this.setLayout(new GridLayout(8,3,10,10));
			while(res.next()) {
			JLabel c1=new JLabel(res.getString("cinemas"));JButton b1=new JButton(res.getString("showtime"));JLabel c2=new JLabel("Available - "+res.getInt("available")+"");
			c1.setFont(f);b1.setFont(f);b1.addActionListener(this);cinema.add(res.getString("cinemas"));
			this.add(c1);this.add(b1);this.add(c2);}JLabel c=new JLabel("Confirm Theatre");c.setFont(f);
			this.add(ticketno);this.add(text);this.add(new JLabel(""));this.add(c);this.add(cinema);next=new JButton("NEXT");this.add(new JLabel());j=new JLabel("Amount-"+amount+"");this.add(j); this.add(next);
			next.addActionListener(this);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==next)
		{
			this.setVisible(false);
			cinemas=cinema.getSelectedItem();
			payment pay=new payment();
		}
		else
		{
			time=e.getActionCommand();
			amount=200 * Integer.parseInt(text.getText());
			j.setText(" Amount -"+String.valueOf(amount));
		
		}
	}

}
