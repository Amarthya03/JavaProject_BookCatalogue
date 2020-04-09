package app;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

class Search2 implements ActionListener {
	JFrame jf;
	JPanel jp;

	JLabel jal; // Attribute
	JLabel jvl; // Value 

	JTextField jvt; // Value
	JComboBox<String> jat; // Attribute


	JButton un;

	String attribute[] = {"Book", "Author", "Month", "Year", "JC", "Scopus", "SJR"};

	Search2() {
		jf = new JFrame("Search entries");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp = new JPanel(new GridBagLayout());


		// ? Attribute
		jal = new JLabel("Select an attribute: ");
		jal.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jal.setForeground(Color.WHITE);

		jat = new JComboBox<String>(attribute);
		jat.setBackground(new Color(37, 51, 65));
		jat.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jat.setForeground(Color.WHITE);
		jat.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));


		// ? New Value
		jvl = new JLabel("Enter the value: ");
		jvl.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jvl.setForeground(Color.WHITE);

		jvt = new JTextField(5);
		jvt.setToolTipText("Enter a value: ");
		jvt.setBackground(new Color(37, 51, 65));
		jvt.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jvt.setForeground(Color.WHITE);
		jvt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jvt.setCaretColor(Color.WHITE);


		// ? Update button
		un = new JButton("Search");
		un.addActionListener(this);
		un.setBackground(new Color(29, 161, 242));
		un.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		un.setForeground(Color.WHITE);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		

		constraints.gridx = 0;
		constraints.gridy = 0;
		jp.add(jal, constraints); 

		constraints.gridx = 1;
		jp.add(jat, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		jp.add(jvl, constraints); 

		constraints.gridx = 1;
		jp.add(jvt, constraints);

	
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		jp.add(un, constraints);

		jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search entries!"));
		jp.setBackground(new Color(21, 32, 43));

		jf.add(jp);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent eu) {
		// TODO Auto-generated method stub
		if(eu.getSource()==un){
			System.out.println("Search pressed!");
			String v = jvt.getText();
			String a = jat.getItemAt(jat.getSelectedIndex());
			try {
				String query4 = "select * from lib where "+a.toLowerCase()+" like '%"+v+"%'";
				String url = "jdbc:mysql://localhost:3306/dummy", user = "root", password = "password";
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query4);
				JTable ts = new JTable();
				ts.setModel(DbUtils.resultSetToTableModel(rs));
				JFrame fs = new JFrame("Search results");
				ts.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
				ts.setBackground(new Color(21, 32, 43));
				ts.setForeground(Color.WHITE);
				fs.add(new JScrollPane(ts));
				fs.setVisible(true);
				fs.pack();
				fs.setLocationRelativeTo(null);
				

				con.close();
			}
			catch (SQLException ex) {
			}
		}
	}

}



class Update implements ActionListener {
	JFrame jf;
	JPanel jp;

	JLabel jnl; // Name
	JLabel jal; // Attribute
	JLabel jvl; // Value 


	JTextField jnt; // Name
	JTextField jvt; // Value
	JComboBox<String> jat; // Attribute


	JButton un;

	String attribute[] = {"Author", "Month", "Year", "JC", "Scopus", "SJR"};

	Update() {
		jf = new JFrame("Update details");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp = new JPanel(new GridBagLayout());


		// ? Book name
		jnl = new JLabel("Enter the book name: ");
		jnl.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jnl.setForeground(Color.WHITE);

		jnt = new JTextField(15);
		jnt.setToolTipText("Book Name");
		jnt.setBackground(new Color(37, 51, 65));
		jnt.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jnt.setForeground(Color.WHITE);
		jnt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jnt.setCaretColor(Color.WHITE);

		// ? Attribute
		jal = new JLabel("Select the attribute to be updated: ");
		jal.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jal.setForeground(Color.WHITE);

		jat = new JComboBox<String>(attribute);
		jat.setBackground(new Color(37, 51, 65));
		jat.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jat.setForeground(Color.WHITE);
		jat.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));


		// ? New Value
		jvl = new JLabel("Enter new value: ");
		jvl.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jvl.setForeground(Color.WHITE);

		jvt = new JTextField(5);
		jvt.setToolTipText("Enter new value: ");
		jvt.setBackground(new Color(37, 51, 65));
		jvt.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jvt.setForeground(Color.WHITE);
		jvt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jvt.setCaretColor(Color.WHITE);


		// ? Update button
		un = new JButton("Update");
		un.addActionListener(this);
		un.setBackground(new Color(29, 161, 242));
		un.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		un.setForeground(Color.WHITE);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		jp.add(jnl, constraints);

		constraints.gridx = 1;
		jp.add(jnt, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		jp.add(jal, constraints); 

		constraints.gridx = 1;
		jp.add(jat, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		jp.add(jvl, constraints); 

		constraints.gridx = 1;
		jp.add(jvt, constraints);

	
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		jp.add(un, constraints);

		jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Update details!"));
		jp.setBackground(new Color(21, 32, 43));

		jf.add(jp);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent eu) {
		// TODO Auto-generated method stub
		if(eu.getSource()==un){
			String n = jnt.getText();
			String v = jvt.getText();
			String a = jat.getItemAt(jat.getSelectedIndex());
			try {
				String query4 = "update lib set "+ a.toLowerCase() +" = '"+ v +"' where book like '%"+n+"%'";
				String url = "jdbc:mysql://localhost:3306/dummy", user = "root", password = "password";
				Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement st = con.prepareStatement(query4);
				int count = st.executeUpdate();
				System.out.println(count + " rows affected");
				con.close();
				JOptionPane.showMessageDialog(null, "Data updated\nBook: "+n+"\n"+a.toUpperCase()+": "+v, "Alert", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (SQLException ex) {
			}
		}
	}

}

public class App implements ActionListener {
	JFrame jf;
	JPanel jp;

	JLabel jbl;
	JLabel jal;
	JLabel jyl;
	JLabel jml;
	JLabel jjcl;
	JLabel jsnl;
	JLabel jsjrl;

	JTextField jbt;
	JTextField jat;
	JTextField jyt;
	JComboBox<String> jmt;
	JComboBox<String> jjct;
	JComboBox<String> jsnt;
	JComboBox<String> jsjrt;
	
	JButton jb;
	JButton jbd;
	JButton jbs;
	JButton jbu;

	String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	String check[] = {"Yes", "No"};
	String jc[] = {"Journal", "Conference"};

	String columns[] = {"Name", "Book", "Author"};
	App() {
		jf = new JFrame("Library");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jp = new JPanel(new GridBagLayout());
		jbl = new JLabel("Enter the book title: ");
		jbl.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jbl.setForeground(Color.WHITE);
		jal = new JLabel("Enter the author's name: ");
		jal.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jal.setForeground(Color.WHITE);
		jyl = new JLabel("Enter the year of publication: ");
		jyl.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jyl.setForeground(Color.WHITE);
		jml = new JLabel("Enter the month of publication: ");
		jml.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jml.setForeground(Color.WHITE);
		jjcl = new JLabel("Select journal/conference: ");
		jjcl.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jjcl.setForeground(Color.WHITE);
		jsnl = new JLabel("Scopus: ");
		jsnl.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jsnl.setForeground(Color.WHITE);
		jsjrl = new JLabel("SJR: ");
		jsjrl.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jsjrl.setForeground(Color.WHITE);

		jbt = new JTextField(15);
		jbt.setToolTipText("Book Name");
		jbt.setBackground(new Color(37, 51, 65));
		jbt.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jbt.setForeground(Color.WHITE);
		jbt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jbt.setCaretColor(Color.WHITE);

		jat = new JTextField(15);
		jat.setToolTipText("Author");
		jat.setBackground(new Color(37, 51, 65));
		jat.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jat.setForeground(Color.WHITE);
		jat.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jat.setCaretColor(Color.WHITE);

		jyt = new JTextField(5);
		jyt.setToolTipText("Year");
		jyt.setBackground(new Color(37, 51, 65));
		jyt.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jyt.setForeground(Color.WHITE);
		jyt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		jyt.setCaretColor(Color.WHITE);

		jmt = new JComboBox<String>(months);
		jmt.setBackground(new Color(37, 51, 65));
		jmt.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jmt.setForeground(Color.WHITE);
		jmt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		jjct = new JComboBox<String>(jc);
		jjct.setBackground(new Color(37, 51, 65));
		jjct.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jjct.setForeground(Color.WHITE);
		jjct.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		jsnt= new JComboBox<String>(check);
		jsnt.setBackground(new Color(37, 51, 65));
		jsnt.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jsnt.setForeground(Color.WHITE);
		jsnt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		jsjrt = new JComboBox<String>(check);
		jsjrt.setBackground(new Color(37, 51, 65));
		jsjrt.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jsjrt.setForeground(Color.WHITE);
		jsjrt.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		
		jb = new JButton("Submit!");
		jb.addActionListener(this);
		jb.setBackground(new Color(29, 161, 242));
		jb.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jb.setForeground(Color.WHITE);
		jb.setToolTipText("Click to submit!");
		

		jbd = new JButton("Display Entries");
		jbd.addActionListener(this);
		jbd.setBackground(new Color(29, 161, 242));
		jbd.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jbd.setForeground(Color.WHITE);
		jbd.setToolTipText("Click to display all entries");
		

		jbs = new JButton("Search Entries");
		jbs.addActionListener(this);
		jbs.setBackground(new Color(29, 161, 242));
		jbs.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jbs.setForeground(Color.WHITE);
		jbs.setToolTipText("Click to search entries based on different attributes");

		jbu = new JButton("Update");
		jbu.addActionListener(this);
		jbu.setBackground(new Color(29, 161, 242));
		jbu.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		jbu.setForeground(Color.WHITE);
		jbu.setToolTipText("Update the attribute values");
		

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		jp.add(jbl, constraints);

		constraints.gridx = 1;
		jp.add(jbt, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		jp.add(jal, constraints); 

		constraints.gridx = 1;
		jp.add(jat, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		jp.add(jml, constraints); 

		constraints.gridx = 1;
		jp.add(jmt, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		jp.add(jyl, constraints); 

		constraints.gridx = 1;
		jp.add(jyt, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 4;
		jp.add(jjcl, constraints); 

		constraints.gridx = 1;
		jp.add(jjct, constraints);

		constraints.gridx = 0;
		constraints.gridy = 5;
		jp.add(jsnl, constraints); 

		constraints.gridx = 1;
		jp.add(jsnt, constraints);

		constraints.gridx = 0;
		constraints.gridy = 6;
		jp.add(jsjrl, constraints); 

		constraints.gridx = 1;
		jp.add(jsjrt, constraints);

		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		jp.add(jb, constraints);

		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		jp.add(jbd, constraints);

		constraints.gridx = 0;
		constraints.gridy = 9;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		jp.add(jbs, constraints);

		constraints.gridx = 0;
		constraints.gridy = 10;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		jp.add(jbu, constraints);
		

		jp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Enter your details!"));
		jp.setBackground(new Color(21, 32, 43));

		jf.add(jp);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	  
		
	}
	
	public static void main(String[] args) throws Exception {
		new App();
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==jb) {
			String b = jbt.getText();
			String a = jat.getText();
			String m = jmt.getItemAt(jmt.getSelectedIndex());
			String y = jyt.getText();
			String jc = jjct.getItemAt(jjct.getSelectedIndex());
			String sn = jsnt.getItemAt(jsnt.getSelectedIndex());
			String sjr = jsjrt.getItemAt(jsjrt.getSelectedIndex());
			System.out.println(b+" "+a+" "+m+" "+y+" "+jc+" "+sn+" "+sjr);
			try {
				String query = "insert into lib values(?, ?, ?, ?, ?, ?, ?)";
				String url = "jdbc:mysql://localhost:3306/dummy", user = "root", password = "password";
				Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement st = con.prepareStatement(query);
				st.setString(1, b);
				st.setString(2, a);
				st.setString(3, m);
				st.setString(4, y);
				st.setString(5, jc);
				st.setString(6, sn);
				st.setString(7, sjr);

				int count = st.executeUpdate();
				System.out.println(count + " rows affected");

				con.close();
				JOptionPane.showMessageDialog(null, "Data inserted\nBook: "+b+"\nAuthor "+a, "Alert", JOptionPane.INFORMATION_MESSAGE);
			}
			catch (SQLException ex) {
			}
		}
		else if(e.getSource()==jbd) {
			try {
				String query2 = "select * from lib";
				String url = "jdbc:mysql://localhost:3306/aliens", user = "root", password = "root";
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query2);
				
				JTable jt = new JTable();
				jt.setModel(DbUtils.resultSetToTableModel(rs));
				jt.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
				jt.setBackground(new Color(21, 32, 43));
				jt.setForeground(Color.WHITE);
				JFrame fr2 = new JFrame("Books available");
				fr2.add(new JScrollPane(jt));
				fr2.setVisible(true);
				fr2.pack();
				fr2.setLocationRelativeTo(null);
				fr2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				con.close();
				
			}
			catch (SQLException ex2) {
			}
		}
		else if(e.getSource()==jbs) {
			System.out.println("Search!");
			new Search2();
		}
		else if(e.getSource()==jbu) {
			System.out.println("Update clicked!");
			new Update();
		}
	}
}