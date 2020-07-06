package movie;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class movies extends JFrame implements ActionListener{
	long uid;
	 JLabel l1 =new JLabel("NOW SHOWING");
	 Button ninesix =new Button("BOOK");
	 Button sarkar =new Button("BOOK");
	 Button viswasam =new Button("BOOK");
	 Button petta =new Button("BOOK");
	 Button kgf =new Button("BOOK");
	  public movies(long uid) {
		  this.uid=uid;
	   l1.setForeground(Color.red);
	   this.add(l1);
	   l1.setBounds(190,40,100,20);
	   this.add(ninesix);
	   ninesix.setBounds(40,180,60,20);
	   this.add(sarkar);
	   sarkar.setBounds(210,183,60,20);
	   this.add(viswasam);
	   viswasam.setBounds(380,183,60,20);
	   this.add(petta);
	   petta.setBounds(100,365,60,20);
	   this.add(kgf);
	   kgf.setBounds(290,365,60,20);
	   ninesix.addActionListener(this);
	   sarkar.addActionListener(this);
	   viswasam.addActionListener(this);
	   petta.addActionListener(this);
	   kgf.addActionListener(this);
	    this.setTitle("Picture");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel panel1 = new JPanel();
	    panel1.setSize(500,500);
	    ImageIcon pic = new ImageIcon("screenshot.png");
	    panel1.add(new JLabel(pic));
	    this.add(panel1);
	    this.pack();
	    this.setVisible(true);
	    this.setSize(500,500);
	  }
	  public void actionPerformed(ActionEvent e)
	  {
	   if (e.getSource()==ninesix)
	   {
	  Availability a = new Availability("96",uid);
	   }
	   if (e.getSource()==sarkar)
	   {
	  Availability a = new Availability("Sarkar",uid);
	   }
	   if (e.getSource()==viswasam)
	   {
	  Availability a= new Availability("Viswasam",uid);
	   }
	   if (e.getSource()==petta)
	   {
	  Availability a= new Availability("Petta",uid);
	   }
	   if (e.getSource()==kgf)
	   {
	  Availability a =new Availability("KGF",uid);
	   }
	   this.setVisible(false);
	  }
	}

