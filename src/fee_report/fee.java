package fee_report;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class fee implements ActionListener {
	JFrame f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,frame,fee1st,fee2nd,fee3rd,viewpaymentdetails,viewpaymentfromacc,checkyearfee;
	JButton b,b1,adm,stu,b2,b3,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8,sub,stusub,usub,update,pay1,pay2,pay3,viewpayment,viewfromacc,clickyearfee;
	JTextArea j1,j2,j3,j4,j5,Nj1,Nj2,Nj3,Nj4,Nj5,sj[],jf,ustu,upd[],bank_1[],bank_2[],bank_3[],enterroll,enteryear;
	JTable table;
	JLabel l[];
	JButton pay[]=new JButton[3];
	int count=0;
	Font font=new Font("Times New Roman",Font.ITALIC,20);
	Font ft=new Font("Times New Roman",Font.ITALIC,35);
	Font fo=new Font("Times New Roman",Font.ITALIC,14);
	Connection conn;
	Statement stmt;
	PreparedStatement psmt,pst;
	
	
	static int getroll=0,curr_year=0;
	static String getname="";
	
	
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==clickyearfee) {
		curr_year=Integer.parseInt(""+enteryear.getText());
		checkyearfee.dispose();
		slide13();
	}
else	if(e.getSource()==ab8) {
		checkyearfee=new JFrame("DETAILS");
		clickyearfee=new JButton("SUBMIT");
		enteryear=new JTextArea();
		enteryear.setBounds(100,100, 300, 50);
		clickyearfee.setBounds(150, 200, 200, 50);
		enteryear.setFont(font);
		clickyearfee.setFont(font);
		clickyearfee.addActionListener(this);
		checkyearfee.setSize(500, 500);
		checkyearfee.add(clickyearfee);
		checkyearfee.add(enteryear);
		checkyearfee.setLayout(null);
		checkyearfee.setVisible(true);
	}
else if(e.getSource()==ab7) {
		viewpaymentfromacc=new JFrame("FEES DETAILS");
		JLabel nam=new JLabel("Enter Name");
		JLabel rolnum=new JLabel("Enter Roll Number");
		JTextArea entername=new JTextArea();
	     enterroll=new JTextArea();
		viewfromacc=new JButton("SUBMIT");
		
		nam.setBounds(100, 100, 200, 50);
		entername.setBounds(300, 100, 200, 50);
		rolnum.setBounds(100, 200, 200, 50);
		enterroll.setBounds(300, 200, 200, 50);
		
		viewfromacc.setBounds(200, 300, 200, 50);
		viewfromacc.setFont(font);
		viewfromacc.addActionListener(this);
		
		entername.setFont(font);
		enterroll.setFont(font);
		rolnum.setFont(font);
		nam.setFont(font);
		
		viewpaymentfromacc.setSize(600, 600);
		viewpaymentfromacc.add(nam);
		viewpaymentfromacc.add(rolnum);
		viewpaymentfromacc.add(entername);
		viewpaymentfromacc.add(enterroll);
		viewpaymentfromacc.add(viewfromacc);
		
		viewpaymentfromacc.setLayout(null);
		viewpaymentfromacc.setVisible(true);
	}
	else if(e.getSource()==viewfromacc) {
		getroll=Integer.parseInt(""+enterroll.getText());
	    viewpaymentfromacc.dispose();
		slide12();
	}
	else if(e.getSource()==viewpayment)
		slide12();
	else if(e.getSource()==pay1) {
		int roll=getroll;
		int year=1;
		String cardnum=bank_1[2].getText();
		String bankname=bank_1[0].getText();
		String bankbranch=bank_1[1].getText();
		int cardnumber=Integer.parseInt(cardnum);
String query="INSERT INTO payment(roll_number,inyear,bankName,bankBranch,cardNumber)VALUES(?,?,?,?,?)";
try {
 pst=conn.prepareStatement(query);
pst.setInt(1, roll);
pst.setInt(2, year);
pst.setString(3, bankname);
pst.setString(4, bankbranch);
pst.setInt(5, cardnumber);

pst.execute();

}catch(Exception ex) {
	
}
JOptionPane.showMessageDialog(fee1st, "UPDATED SUCCESSFULLY "+getname+" RECORDS");
fee1st.dispose();
f9.remove(pay[0]);
l[13].setText("PAID");
	}
	else if(e.getSource()==pay2) {
		int roll=getroll;
		int year=2;
		String cardnum=bank_2[2].getText();
		String bankname=bank_2[0].getText();
		String bankbranch=bank_2[1].getText();
		int cardnumber=Integer.parseInt(cardnum);
String query="INSERT INTO payment(roll_number,inyear,bankName,bankBranch,cardNumber)VALUES(?,?,?,?,?)";
try {
 pst=conn.prepareStatement(query);
pst.setInt(1, roll);
pst.setInt(2, year);
pst.setString(3, bankname);
pst.setString(4, bankbranch);
pst.setInt(5, cardnumber);

pst.execute();

}catch(Exception ex) {
	
}
JOptionPane.showMessageDialog(fee2nd, "UPDATED SUCCESSFULLY "+getname+" RECORDS");
fee2nd.dispose();
f9.remove(pay[1]);
l[14].setText("PAID");

	}
	else if(e.getSource()==pay3) {
		int roll=getroll;
		int year=3;
		String cardnum=bank_3[2].getText();
		String bankname=bank_3[0].getText();
		String bankbranch=bank_3[1].getText();
		int cardnumber=Integer.parseInt(cardnum);
String query="INSERT INTO payment(roll_number,inyear,bankName,bankBranch,cardNumber)VALUES(?,?,?,?,?)";
try {
 pst=conn.prepareStatement(query);
pst.setInt(1, roll);
pst.setInt(2, year);
pst.setString(3, bankname);
pst.setString(4, bankbranch);
pst.setInt(5, cardnumber);

pst.execute();

}catch(Exception ex) {
	
}
JOptionPane.showMessageDialog(fee3rd, "UPDATED SUCCESSFULLY "+getname+" RECORDS");
fee3rd.dispose();
f9.remove(pay[2]);
l[15].setText("PAID");
     }
	else if(e.getSource()==pay[0]) {
		slide9();
	  }
	else if(e.getSource()==pay[1]) {
		slide10();
	}
	else if(e.getSource()==pay[2]) {
		slide11();
	}
	else if(e.getSource()==b1) {
		if(j1.getText().equals("HBTU") && j2.getText().equals("rohit")) {
		slide1();
	
		}
		else
		{
			j1.setText("");
			j2.setText("");
			JOptionPane.showMessageDialog(f1,"WRONG INPUT !! TRY AGAIN!!");
		}
	}
	
	//if button click for student login then
	else if(e.getSource()==stu) {
		f2.dispose();
		slide2();
	}
	//if button click for accountant login then
	else if(e.getSource()==adm) {
		f2.dispose();
		slide3();
	}
	//if add accountant click
	else if(e.getSource()==ab1) {
		slide4();
	}
	//if new accountant details submit button click to save in database
	else if(e.getSource()==sub) {
		int id=Integer.parseInt(Nj1.getText());
		String name=Nj2.getText();
		String password=Nj3.getText();
		String email=Nj4.getText();
		int number=Integer.parseInt(Nj5.getText());
		String query="INSERT INTO ACCOUNTANT(id,name,password,email,phone_number)VALUES(?,?,?,?,?)";
		try {
		psmt =conn.prepareStatement(query);
		psmt.setInt(1, id);
		psmt.setString(2, name);
		psmt.setString(3, password);
		psmt.setString(4, email);
		psmt.setInt(5, number);
		psmt.execute();
		count++;
		}catch(Exception ex) {
			
		}
		Nj1.setText("");
		Nj2.setText("");
		Nj3.setText("");
		Nj4.setText("");
		Nj5.setText("");
		JOptionPane.showMessageDialog(f5, "UPDATED SUCCESSFULLY "+name+" RECORDS");
	}
	//to add new student details
	else if(e.getSource()==ab2) {
	    slide5();	
		}
	//when we click on submit button on add student this if statement to update these records on database
	else if(e.getSource()==stusub) {
		int roll=Integer.parseInt(sj[0].getText());
				String name=sj[1].getText();
				String branch=sj[2].getText();
				String email=sj[3].getText();
				String address=sj[4].getText();
		String query="INSERT INTO STUDENT(roll_number,name,branch,email,address)VALUES(?,?,?,?,?)";
		try {
		 pst=conn.prepareStatement(query);
		pst.setInt(1, roll);
		pst.setString(2, name);
		pst.setString(3, branch);
		pst.setString(4, email);
		pst.setString(5, address);
		
		pst.execute();
		
		}catch(Exception ex) {
			
		}
		sj[0].setText("");
		sj[1].setText("");
		sj[2].setText("");
		sj[3].setText("");
		sj[4].setText("");
		JOptionPane.showMessageDialog(f7, "UPDATED SUCCESSFULLY "+name+" RECORDS");
		
}
	// if we want to update records from accountant login
	else if(e.getSource()==ab3) {
		slide7();
	}
	// now to update record when we click submit after entering roll number of student in slide_7
	else if(e.getSource()==usub) {
		f10.dispose();
		int found=0;

		int roll =Integer.parseInt(ustu.getText());
		String name="",branch="",email="",address="";
	
		try {
			ResultSet rs=stmt.executeQuery("select *from student");
						while(rs.next()) {
				if(rs.getInt("roll_number")==roll) {
					name=rs.getString("name");
					branch=rs.getString("branch");
					email=rs.getString("email");
					address=rs.getString("address");
					found=1;
					break;
				}
			}
		}catch(Exception ex) {
			
		}
		if(found==0) {
			JOptionPane.showMessageDialog(f10, "WRONG INPUT");
			
		}else
		{
			slide8(name,branch,email,address);
		}
	}
	//when we edit data of student then click on update button
	else if(e.getSource()==update) {
		int roll=Integer.parseInt(ustu.getText());
		
		try {
			String n=upd[0].getText();
			String b=upd[1].getText();
			String em=upd[2].getText();
			String a=upd[3].getText();
			
			String sql="UPDATE student "
			+"SET name= ?,branch= ?,email= ?,address= ?"
					+" WHERE roll_number= ?";
			PreparedStatement pt=conn.prepareStatement(sql);
		
			
			pt.setString(1, n);
			pt.setString(2, b);
			pt.setString(3, em);
			pt.setString(4, a);
			pt.setInt(5, roll);
		
			int ans=pt.executeUpdate();
			
			JOptionPane.showMessageDialog(frame, "UPDATED SUCCESSFULLY");
		
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	frame.dispose();	
	}
		
	//to view accountant when we click on view accountant button
	else if(e.getSource()==ab4) {
		f6=new JFrame("ACCCOUNTANT LISTS");
		JScrollPane sp;
		try {
		ResultSet rs=stmt.executeQuery("select *from accountant");
		String details[][]=new String[40][5];
		int i=0;
		while(rs.next()) {
			details[i][0]=""+rs.getInt("id");
			details[i][1]=rs.getString("name");
			details[i][2]=rs.getString("password");
			details[i][3]=rs.getString("email");
			details[i][4]=""+rs.getInt("phone_number");
			i++;
		}
		String column[]= {"ID","NAME","PASSWORD","EMAIL","CONTACT_NUMBER"};
		table=new JTable(details,column);
		 
//		table.setBounds(30, 30, 800, 800);
		
		}catch(Exception ex) {
			
		}
		sp=new JScrollPane(table);
		
		f6.add(sp);
		f6.setSize(1300, 1000);
		
		
		f6.setVisible(true);
	}
	//to view all student click on 5th button on accountant login slide
	else if(e.getSource()==ab5) {
		slide6();
	}
	//to view student after entering roll number and name of student in student login
	else if(e.getSource()==b3) {
		f3.dispose();
        ResultSet rs=null; 
		String na=j3.getText();
		
		boolean ans=false;
         int rol=Integer.parseInt(j4.getText());
         try {
         rs=stmt.executeQuery("select *from student");
         while(rs.next()) {
         if(rs.getString("name").equals(na) && rs.getInt("roll_number")==rol)
        	 ans=true;
         }
         }catch(Exception ex) {
        	 
         }
         
         if(ans) {
		f9=new JFrame("STUDENT DETAILS");
		l=new JLabel[16];
		for(int i=0;i<16;i++)
			l[i]=new JLabel();
		
		l[0].setText("ROLL NUMBER");
		l[1].setText("NAME");
		l[2].setText("BRANCH");
		l[3].setText("EMAIL");
		l[4].setText("ADDRESS");
		l[5].setText("FIRST YEAR");
		l[6].setText("SECOND YEAR");
		l[7].setText("THIRD YEAR");
		
		for(int i=0;i<3;i++) {
		pay[i]=new JButton("PAY NOW");
		pay[i].addActionListener(this);
		}
		//int roll=Integer.parseInt(jf.getText());
		try {
		ResultSet r=stmt.executeQuery("select *from student");
		while(r.next()) {
			getroll=r.getInt("roll_number");
			getname=r.getString("name");
			if(getroll==rol) {
		l[8].setText(""+getroll);
		l[9].setText(getname);
		l[10].setText(r.getString("branch"));
		l[11].setText(r.getString("email"));
		l[12].setText(r.getString("address"));
		l[13].setText("DUE");
		l[14].setText("DUE");
		l[15].setText("DUE");
			}
		}
		}catch(Exception ex) {
			
		}
		l[0].setBounds(100, 100, 250, 50);
		l[8].setBounds(400, 100, 300, 50);
		
		l[1].setBounds(100, 200, 250, 50);
		l[9].setBounds(400, 200, 300, 50);
		
		l[2].setBounds(100, 300, 250, 50);
		l[10].setBounds(400, 300, 300, 50);
		
		l[3].setBounds(100, 400, 250, 50);
		l[11].setBounds(400, 400, 300, 50);
		
		l[4].setBounds(100, 500, 250, 50);
		l[12].setBounds(400, 500, 300, 50);
		
		l[5].setBounds(100, 600, 250, 50);
		l[13].setBounds(400, 600, 300, 50);
		
		pay[0].setBounds(750, 600, 120, 50);
		pay[1].setBounds(750, 700, 120, 50);
		pay[2].setBounds(750, 800, 120, 50);
		
		l[6].setBounds(100, 700, 250, 50);
		l[14].setBounds(400, 700, 300, 50);
		
		l[7].setBounds(100, 800, 250, 50);
		l[15].setBounds(400, 800, 300, 50);
		
		for(int i=0;i<16;i++) {
			l[i].setFont(font);
			l[i].setOpaque(true);
			
		}
		for(int i=0;i<16;i++)
			f9.add(l[i]);
	
		boolean p1=false,p2=false,p3=false;
		
		try {
			ResultSet r=stmt.executeQuery("select *from payment where inyear=1");
			while(r.next()) {
				//System.out.println("hb");
				if(r.getInt("roll_number")==getroll)
				p1=true;
			}
			 rs=stmt.executeQuery("select *from payment where inyear=2");
				while(rs.next()) {
					if(rs.getInt("roll_number")==getroll)
					p2=true;
				}
				 rs=stmt.executeQuery("select *from payment where inyear=3");
					while(rs.next()) {
						if(rs.getInt("roll_number")==getroll)
						p3=true;
					}
		}
		catch(Exception ex) {
			
		}
		
		if(!p1 && !p2 && !p3) {
			f9.add(pay[0]);
		}
		else if(p1 && !p2 && !p3) {
			f9.add(pay[1]);
			l[13].setText("PAID");
		}
		else if(p1 && p2 && !p3) {
			f9.add(pay[2]);
			l[13].setText("PAID");
			l[14].setText("PAID");
		}
		else {
			l[13].setText("PAID");
			l[14].setText("PAID");
			l[15].setText("PAID");
		}
		
		  viewpayment=new JButton("PAYMENT DETAILS");
		 viewpayment.setBounds(300, 900, 300, 50);
		 viewpayment.setFont(font);
		 viewpayment.addActionListener(this);
		 f9.add(viewpayment);
		f9.add(new iron());
//		f9.setLayout(null);
		f9.setSize(900, 1000);
		
		f9.setVisible(true);
         
         }
         
         else
         {
        	 JOptionPane.showMessageDialog(f9, "WRONG INPUT");
         }

         
	}
	//to logout the accountant login
	else if(e.getSource()==ab6) {
		f4.dispose();
	}
}
//in this function check details of students who submitted their fees
public void slide13() {
	JFrame fra=new JFrame("DETAILS");
	String row[][]=new String[60][5];
	int i=0;
	String colu[]= {"ROLL NUMBER","NAME","BRANCH","BANK NAME","BANK BRANCH"};
	try {
		ResultSet rs=null;
		if(curr_year==1)
				rs=stmt.executeQuery("select student.roll_number,student.name,student.branch,payment.bankName,payment.bankBranch from payment INNER JOIN student on student.roll_number=payment.roll_number where inyear=1;");
		else if(curr_year==2)
			rs=stmt.executeQuery("select student.roll_number,student.name,student.branch,payment.bankName,payment.bankBranch from payment INNER JOIN student on student.roll_number=payment.roll_number where inyear=2;");
		else
			rs=stmt.executeQuery("select student.roll_number,student.name,student.branch,payment.bankName,payment.bankBranch from payment INNER JOIN student on student.roll_number=payment.roll_number where inyear=3;");
		
		while(rs.next()) {
			row[i][0]=""+rs.getInt("roll_number");
			row[i][1]=""+rs.getString("name");
			row[i][2]=""+rs.getString("branch");
			row[i][3]=""+rs.getString("bankName");
			row[i][4]=""+rs.getString("bankBranch");
			i++;
		}
	}catch(Exception e) {
		
	}
	JTable table=new JTable(row,colu);
	table.setFont(fo);
	JScrollPane sp=new JScrollPane(table);
	fra.add(sp);
	fra.setSize(1700, 1100);
	fra.setVisible(true);
}
//in this function details of view payment
public void slide12() {
	viewpaymentdetails=new JFrame("DETAILS");
	JLabel det[]=new JLabel[24];
	
	for(int i=0;i<24;i++) {
		det[i]=new JLabel();
		det[i].setFont(font);
	}
	
	det[0].setText("FIRST YEAR");
	det[0].setBounds(100, 50, 200, 50);
	
	det[1].setText("NOT PAID");
	det[1].setBounds(500, 50, 200, 50);
	
	det[2].setText("BANK NAME");
	det[2].setBounds(100, 100, 200, 50);
	
	det[3].setText("BANK BRANCH");
	det[3].setBounds(100, 150, 200, 50);
	
	det[4].setText("CARD NUMBER");
	det[4].setBounds(100, 200, 200, 50);
	
	det[5].setText("NULL");
	det[5].setBounds(400, 100, 200, 50);
	
	det[6].setText("NULL");
	det[6].setBounds(400, 150, 200, 50);
	
	det[7].setText("NULL");
	det[7].setBounds(400, 200, 200, 50);
	
	det[8].setText("SECOND YEAR");
	det[8].setBounds(100, 300, 200, 50);
	
	det[9].setText("NOT PAID");
	det[9].setBounds(500, 300, 200, 50);
	
	det[10].setText("BANK NAME");
	det[10].setBounds(100, 350, 200, 50);
	
	det[11].setText("BANK BRANCH");
	det[11].setBounds(100, 400, 200, 50);
	
	det[12].setText("CARD NUMBER");
	det[12].setBounds(100, 450, 200, 50);
	
	det[13].setText("NULL");
	det[13].setBounds(400, 350, 200, 50);
	
	det[14].setText("NULL");
	det[14].setBounds(400, 400, 200, 50);
	
	det[15].setText("NULL");
	det[15].setBounds(400, 450, 200, 50);
	
	det[16].setText("THIRD YEAR");
	det[16].setBounds(100, 550, 200, 50);
	
	det[17].setText("NOT PAID");
	det[17].setBounds(500, 550, 200, 50);
	
	det[18].setText("BANK NAME");
	det[18].setBounds(100, 600, 200, 50);
	
	det[19].setText("BANK BRANCH");
	det[19].setBounds(100, 650, 200, 50);
	
	det[20].setText("CARD NUMBER");
	det[20].setBounds(100, 700, 200, 50);
	
	det[21].setText("NULL");
	det[21].setBounds(400, 600, 200, 50);
	
	det[22].setText("NULL");
	det[22].setBounds(400, 650, 200, 50);
	
	det[23].setText("NULL");
	det[23].setBounds(400, 700, 200, 50);
	try {
		ResultSet rs=stmt.executeQuery("select *from payment where inyear=1");
		//System.out.println("yes");
		while(rs.next()) {
			if(rs.getInt("roll_number")==getroll) {
				det[1].setText("PAID");
		det[5].setText(rs.getString("bankName"));
		det[6].setText(rs.getString("bankBranch"));
		det[7].setText(""+rs.getInt("cardNumber"));
			}	
		}
		rs=stmt.executeQuery("select *from payment where inyear=2");
		//System.out.println("yes");
		while(rs.next()) {
			if(rs.getInt("roll_number")==getroll) {
				det[9].setText("PAID");
		det[13].setText(rs.getString("bankName"));
		det[14].setText(rs.getString("bankBranch"));
		det[15].setText(""+rs.getInt("cardNumber"));
			}
		}
		rs=stmt.executeQuery("select *from payment where inyear=3");
		//System.out.println("yes");
		while(rs.next()) {
			if(rs.getInt("roll_number")==getroll) {
				det[17].setText("PAID");
		det[23].setText(rs.getString("bankName"));
		det[22].setText(rs.getString("bankBranch"));
		det[21].setText(""+rs.getInt("cardNumber"));
			}
		}
	} catch (SQLException e) {
		
	}
	viewpaymentdetails.setSize(800, 900);
	for(int i=0;i<24;i++)
		viewpaymentdetails.add(det[i]);
	viewpaymentdetails.setLayout(null);
	viewpaymentdetails.setVisible(true);
}
//in this function we take information of payment of third year
public void slide11() {
	fee3rd=new JFrame("First year");
	JLabel fl[]=new JLabel[9];
    bank_3=new JTextArea[3];
    for(int i=0;i<fl.length;i++) {
    	fl[i]=new JLabel();
         fl[i].setFont(font);
    }    
    for(int i=0;i<3;i++) {
    	bank_3[i]=new JTextArea();
    	bank_3[i].setFont(font);
    }
    
    pay3=new JButton("PAY");
    pay3.addActionListener(this);
    
    fl[0].setText("ROLL NUMBER");
    fl[0].setBounds(100, 100, 150, 50);
    
    fl[6].setText(""+getroll);
    fl[6].setBounds(450, 100, 300, 50);
    
    fl[1].setText("STUDENT NAME");
    fl[1].setBounds(100, 200, 150, 50);
    
    fl[7].setText(""+getname);
    fl[7].setBounds(450, 200, 300, 50);
    
    fl[2].setText("AMOUNT");
    fl[2].setBounds(100, 300, 150, 50);
    
    fl[8].setText("1,10,000");
    fl[8].setBounds(450, 300, 300, 50);
    
    fl[3].setText("ENTER BANK NAME");
    fl[3].setBounds(100, 400, 250, 50);
    
    bank_3[0].setBounds(450, 400, 300, 50);
    
    fl[4].setText("ENTER BANK BRANCH");
    fl[4].setBounds(100, 500, 250, 50);
    
    bank_3[1].setBounds(450, 500, 300, 50);
    
    
    fl[5].setText("ENTER CARD NUMBER");
    fl[5].setBounds(100, 600, 250, 50);
    
    bank_3[2].setBounds(450, 600, 300, 50);
    
    pay3.setBounds(300, 700, 250, 50);
    fee3rd.setSize(900, 800);
    for(int i=0;i<9;i++)
    	fee3rd.add(fl[i]);
    for(int i=0;i<3;i++)
    	fee3rd.add(bank_3[i]);
    pay3.setFont(font);
    fee3rd.add(pay3);
    fee3rd.setLayout(null);
    fee3rd.setVisible(true);
}
//in this function we take information of payment of second year
public void slide10() {
	fee2nd=new JFrame("Second year");
	JLabel fl[]=new JLabel[9];
    bank_2=new JTextArea[3];
    for(int i=0;i<fl.length;i++) {
    	fl[i]=new JLabel();
         fl[i].setFont(font);
    }    
    for(int i=0;i<3;i++) {
    	bank_2[i]=new JTextArea();
    	bank_2[i].setFont(font);
    }
    
    pay2=new JButton("PAY");
    pay2.addActionListener(this);
    
    fl[0].setText("ROLL NUMBER");
    fl[0].setBounds(100, 100, 150, 50);
    
    fl[6].setText(""+getroll);
    fl[6].setBounds(450, 100, 300, 50);
    
    fl[1].setText("STUDENT NAME");
    fl[1].setBounds(100, 200, 150, 50);
    
    fl[7].setText(""+getname);
    fl[7].setBounds(450, 200, 300, 50);
    
    fl[2].setText("AMOUNT");
    fl[2].setBounds(100, 300, 150, 50);
    
    fl[8].setText("1,10,000");
    fl[8].setBounds(450, 300, 300, 50);
    
    fl[3].setText("ENTER BANK NAME");
    fl[3].setBounds(100, 400, 250, 50);
    
    bank_2[0].setBounds(450, 400, 300, 50);
    
    fl[4].setText("ENTER BANK BRANCH");
    fl[4].setBounds(100, 500, 250, 50);
    
    bank_2[1].setBounds(450, 500, 300, 50);
    
    
    fl[5].setText("ENTER CARD NUMBER");
    fl[5].setBounds(100, 600, 250, 50);
    
    bank_2[2].setBounds(450, 600, 300, 50);
    
    pay2.setBounds(300, 700, 250, 50);
    fee2nd.setSize(900, 800);
    for(int i=0;i<9;i++)
    	fee2nd.add(fl[i]);
    for(int i=0;i<3;i++)
    	fee2nd.add(bank_2[i]);
    pay2.setFont(font);
    fee2nd.add(pay2);
    fee2nd.setLayout(null);
    fee2nd.setVisible(true);
}

//in this function we take information of payment of first year
public void slide9() {
	int found=0;
	fee1st=new JFrame("First year");
	JLabel fl[]=new JLabel[9];
    bank_1=new JTextArea[3];
    for(int i=0;i<fl.length;i++) {
    	fl[i]=new JLabel();
         fl[i].setFont(font);
    }    
    for(int i=0;i<3;i++) {
    	bank_1[i]=new JTextArea();
    	bank_1[i].setFont(font);
    }
    
    pay1=new JButton("PAY");
    pay1.addActionListener(this);
    
    fl[0].setText("ROLL NUMBER");
    fl[0].setBounds(100, 100, 150, 50);
    
    fl[6].setText(""+getroll);
    fl[6].setBounds(450, 100, 300, 50);
    
    fl[1].setText("STUDENT NAME");
    fl[1].setBounds(100, 200, 150, 50);
    
    fl[7].setText(""+getname);
    fl[7].setBounds(450, 200, 300, 50);
    
    fl[2].setText("AMOUNT");
    fl[2].setBounds(100, 300, 150, 50);
    
    fl[8].setText("1,10,000");
    fl[8].setBounds(450, 300, 300, 50);
    
    fl[3].setText("ENTER BANK NAME");
    fl[3].setBounds(100, 400, 250, 50);
    
    bank_1[0].setBounds(450, 400, 300, 50);
    
    fl[4].setText("ENTER BANK BRANCH");
    fl[4].setBounds(100, 500, 250, 50);
    
    bank_1[1].setBounds(450, 500, 300, 50);
    
    
    fl[5].setText("ENTER CARD NUMBER");
    fl[5].setBounds(100, 600, 250, 50);
    
    bank_1[2].setBounds(450, 600, 300, 50);
    
    pay1.setBounds(300, 700, 250, 50);
    fee1st.setSize(900, 800);
    for(int i=0;i<9;i++)
    	fee1st.add(fl[i]);
    for(int i=0;i<3;i++)
    	fee1st.add(bank_1[i]);
    pay1.setFont(font);
    fee1st.add(pay1);
    fee1st.setLayout(null);
    fee1st.setVisible(true);
}
//to update records frame
public void slide8(String name,String branch,String email,String address) {
	frame=new JFrame("UPDATE");
	
	JLabel l[]=new JLabel[4];
	
	for(int i=0;i<4;i++)
		l[i]=new JLabel();
	
	for(int i=0;i<4;i++)
		l[i].setFont(font);
	
	l[0].setText("NAME");
	l[1].setText("BRANCH");
	l[2].setText("EMAIL");
	l[3].setText("ADDRESS");
	
	upd=new JTextArea[4];
	for(int i=0;i<4;i++)
		upd[i]=new JTextArea();
	
	for(int i=0;i<4;i++)
		upd[i].setFont(font);
	
	update=new JButton("UPDATE");
	update.addActionListener(this);
	
	upd[0].setText(name);
	upd[1].setText(branch);
	upd[2].setText(email);
	upd[3].setText(address);
	
	l[0].setBounds(50, 100, 220, 50);
	upd[0].setBounds(300, 100, 350, 50);
	
	l[1].setBounds(50, 200, 220, 50);
	upd[1].setBounds(300, 200, 350, 50);
	
	l[2].setBounds(50, 300, 220, 50);
	upd[2].setBounds(300, 300, 350, 50);
	
	l[3].setBounds(50, 400, 220, 50);
	upd[3].setBounds(300, 400, 350, 50);
	
	
	
	update.setBounds(300, 700, 200, 50);
	update.setFont(font);
	
	for(int i=0;i<4;i++) {
		frame.add(l[i]);
		frame.add(upd[i]);
	}
	frame.add(update);
	frame.setSize(800, 900);
	frame.setLayout(null);
	frame.setResizable(false);
	frame.setVisible(true);
}
// we want to update records of student then firstly we take roll number of student
public void slide7() {
	f10 =new JFrame("UPDATE STUDENT RECORDS");
	
	JLabel l1=new JLabel("Enter Roll Number");
	ustu=new JTextArea();
	l1.setFont(font);
	ustu.setFont(font);
	
	usub=new JButton("Submit");
	usub.addActionListener(this);
	usub.setFont(font);
	
	
	l1.setBounds(150, 200, 200, 50);
	ustu.setBounds(400, 200, 200, 50);
	usub.setBounds(300, 300, 200, 50);
	
	f10.add(usub);
	f10.add(ustu);
	f10.add(l1);
	
	f10.add(new update());
//	f10.setLayout(null);
	f10.setResizable(false);
	f10.setSize(800, 600);
	f10.setVisible(true);
}
// enter roll number in this frame to view any student details
public void slide6() {
	f8=new JFrame("VIEW STUDENT DETAILS");
	
	ResultSet rs=null;
	try {
		rs=stmt.executeQuery("select *from student");
	}catch(Exception ex) {
		
	}
	String row[][]=new String[60][5];
	try {
	ResultSet r=stmt.executeQuery("select *from student order by roll_number ASC;");
int i=0;
while(r.next()) {
	row[i][0]=""+r.getInt("roll_number");
	row[i][1]=r.getString("name");
	row[i][2]=r.getString("branch");
	row[i][3]=r.getString("email");
	row[i][4]=r.getString("address");
	
	i++;
}
	}catch(Exception e) {
		
	}
   String column[]= {"ROLL NUMBER","NAME","BRANCH","EMAIL","ADDRESS"};
   
   JTable table=new JTable(row,column);
//   table.setBounds(100, 100, 800, 800);
   table.setFont(fo);
   JScrollPane sp=new JScrollPane(table);
   
	f8.add(sp);
	
	f8.setSize(1700, 1100);
	f8.setVisible(true);
}
// to add new student details
public void slide5() {
	f7=new JFrame("ADD STUDENT");
	JLabel l[]=new JLabel[5];
	for(int i=0;i<5;i++)
		l[i]=new JLabel();
	
	sj=new JTextArea[5];
	for(int i=0;i<5;i++)
		sj[i]=new JTextArea();
	
	l[0].setText("ROLL NUMBER");
	l[1].setText("NAME");
	l[2].setText("BRANCH");
	l[3].setText("EMAIL");
	l[4].setText("ADDRESS");
	
	JButton ad=new JButton("ADD STUDENT RECORD");
	
for(int i=0;i<5;i++) {
	l[i].setFont(font);
	sj[i].setFont(font);
}
	
	ad.setFont(ft);
	
	ad.setBounds(350, 100, 600, 50);
	
	l[0].setBounds(200, 200, 200, 40);
	sj[0].setBounds(400, 200, 800, 40);
	
	l[1].setBounds(200, 300, 200, 40);
	sj[1].setBounds(400, 300, 800, 40);
	
	l[2].setBounds(200, 400, 200, 40);
	sj[2].setBounds(400, 400, 800, 40);
	
	l[3].setBounds(200, 500, 200, 40);
	sj[3].setBounds(400, 500, 800, 40);
	
	l[4].setBounds(200, 600, 200, 40);
	sj[4].setBounds(400, 600, 800, 40);
	
	
	
	
	stusub=new JButton("SUBMIT");
	stusub.addActionListener(this);
	stusub.setFont(ft);
	stusub.setBounds(500, 900, 300, 50);
	
	
	f7.add(stusub);
	f7.add(ad);
	for(int i=0;i<5;i++) {
		f7.add(l[i]);
		f7.add(sj[i]);
	}
	
	
	f7.setBackground(Color.black);
	f7.setLayout(null);
	f7.setSize(1300, 1000);
	f7.setVisible(true);
}
//add accountant method
public void slide4() {
	f5=new JFrame("ADD ACCOUNTANT");
	
	JLabel l1=new JLabel("ENTER NEW ACCOUNTANT DETAILS");
	JLabel l2=new JLabel("UNIQUE ID");
	JLabel l3=new JLabel("NAME");
	JLabel l4=new JLabel("PASSWORD");
	JLabel l5=new JLabel("EMAIL");
	JLabel l6=new JLabel("CONTACT NUMBER");
	
	Nj1=new JTextArea();
	Nj2=new JTextArea();
	Nj3=new JTextArea();
	Nj4=new JTextArea();
	Nj5=new JTextArea();
	
	sub=new JButton("SUBMIT");
	sub.addActionListener(this);
	
	l1.setFont(ft);
	l2.setFont(ft);
	l3.setFont(ft);
	l4.setFont(ft);
	l5.setFont(ft);
	l6.setFont(ft);
	Nj1.setFont(ft);
	Nj2.setFont(ft);
	Nj3.setFont(ft);
	Nj4.setFont(ft);
	Nj5.setFont(ft);
	sub.setFont(ft);
	
	l1.setBounds(140, 100, 700, 60);
	l2.setBounds(100, 200, 400, 60);
	l3.setBounds(100, 300, 400, 60);
	l4.setBounds(100, 400, 400, 60);
	l5.setBounds(100, 500, 400, 60);
	l6.setBounds(100, 600, 400, 60);
	
	sub.setBounds(400, 700, 200, 60);
	
	Nj1.setBounds(550, 200, 400, 60);
	Nj2.setBounds(550, 300, 400, 60);
	Nj3.setBounds(550, 400, 400, 60);
	Nj4.setBounds(550, 500, 400, 60);
	Nj5.setBounds(550, 600, 400, 60);
	
	f5.add(l1);
	f5.add(l2);
	f5.add(l3);
	f5.add(l4);
	f5.add(l5);
	f5.add(l6);
	f5.add(Nj1);
	f5.add(Nj2);
	f5.add(Nj3);
	f5.add(Nj4);
	f5.add(Nj5);
	f5.add(sub);
	
	f5.add(new addac());
	f5.setSize(1000, 1000);
//	f5.setLayout(null);
	f5.setVisible(true);
	f5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
//method for accountant side where 6 options are visible
public void slide3() {
	f4=new JFrame("Accountant Login");
	
	ab1=new JButton("ADD ACCOUNTANT");
	ab2=new JButton("ADD STUDENT");
	ab3=new JButton("UPDATE STUDENT RECORDS");
	ab4=new JButton("VIEW ACCOUNTANT");
	ab5=new JButton("VIEW STUDENT");
	ab6=new JButton("LOG OUT");
	ab7=new JButton("VIEW STUDENT FEE DETAILS");
	ab8=new JButton("STUDENTS WHO SUBMITTED");
	
	ab1.addActionListener(this);
	ab2.addActionListener(this);
	ab3.addActionListener(this);
	ab4.addActionListener(this);
	ab5.addActionListener(this);
	ab6.addActionListener(this);
	ab7.addActionListener(this);
	ab8.addActionListener(this);
	
	ab1.setBounds(230, 200, 400, 60);
	ab2.setBounds(1100, 200, 400, 60);
	
	ab3.setBounds(230, 400, 400, 60);
	ab4.setBounds(1100, 400, 400, 60);
	
	ab5.setBounds(230, 600, 400, 60);
	ab7.setBounds(1100, 600, 400, 60);
	
	ab8.setBounds(230, 800, 400, 60);
	ab6.setBounds(1100, 800, 400, 60);
	
	accountant ac=new accountant();
	
	
	ab1.setFont(font);
	ab2.setFont(font);
	ab3.setFont(font);
	ab4.setFont(font);
	ab5.setFont(font);
	ab6.setFont(font);
	ab7.setFont(font);
	ab8.setFont(font);
	f4.add(ab1);
	f4.add(ab2);
	f4.add(ab3);
	f4.add(ab4);
	f4.add(ab5);
	f4.add(ab6);
	f4.add(ab7);
	f4.add(ab8);
	f4.add(ac);
//	f4.setLayout(null);
	f4.setSize(1709, 1080);
	f4.setVisible(true);
}
//method for student side where student can login and view their profile
public void slide2() {
	f3=new JFrame("STUDENT LOGIN");
	
	b2=new JButton("Student Login");
	
	JLabel l1=new JLabel("NAME");
	JLabel l2=new JLabel("PASSWORD");
	
	j3=new JTextArea();
	j4=new JTextArea();
	
	b3=new JButton("SUBMIT");
	
	b2.setBounds(530, 300, 500, 80);
	
	l1.setBounds(550, 400, 150, 50);
	j3.setBounds(720, 400, 250, 50);
	l2.setBounds(550, 500, 150, 50);
	
	j4.setBounds(720, 500, 250, 50);
	
	b3.setBounds(700, 600, 150, 50);
	b3.addActionListener(this);
	
	b2.setFont(ft);
	l1.setFont(font);
	l2.setFont(font);
	b3.setFont(font);
	j3.setFont(ft);
	j4.setFont(ft);
	
	f3.add(b2);
	f3.add(l1);
	f3.add(l2);
	f3.add(j3);
	f3.add(j4);
	f3.add(b3);
	
	student s=new student();
	f3.add(s);
	
	f3.setSize(1709, 1080);
//	f3.setLayout(null);
	f3.setVisible(true);
}
// home page
public void slide1() {
	f2=new JFrame("Portal");
	
	adm=new JButton("Accountant Login");
	adm.setBounds(620, 350, 400, 50);
	
	stu=new JButton("Student Login");
	stu.setBounds(620, 450, 400, 50);
	
	adm.setFont(ft);
	stu.setFont(ft);
	adm.addActionListener(this);
	stu.addActionListener(this);
	
	f2.add(adm);
	f2.add(stu);
	f2.add(new slide1());
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	f2.setSize(1709, 1080);
	f2.setVisible(true);
}
// constructor call
	public fee() {
		GraphicsEnvironment graphics =
			      GraphicsEnvironment.getLocalGraphicsEnvironment();
			      
		GraphicsDevice device = graphics.getDefaultScreenDevice();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost/rohit","root","");
		System.out.println("Connected");
		stmt=conn.createStatement();
		}catch(Exception e) {
		
		}
		
		
		
		
		f1=new JFrame("PORTAL") ;
			
		 b=new JButton("Welcome To HBTU Fee Portal");
		 b1=new JButton("SUBMIT");
		
		JLabel l1=new JLabel("COLLEGE CODE");
		JLabel l2=new JLabel("PASSWORD");
		
		 j1=new JTextArea();
		 j2=new JTextArea();
		
		
		
		b.setFont(ft);
		b1.setFont(font);
		l1.setFont(font);
		l2.setFont(font);
		j1.setFont(ft);
		j2.setFont(ft);
		
		b.setBounds(500, 300, 550, 100);
		l1.setBounds(540, 430, 180, 45);
		j1.setBounds(740, 430, 300, 45);
		
		l2.setBounds(540, 500, 180, 45);
		j2.setBounds(740, 500, 300, 45);
		
		b1.setBounds(700, 600, 150, 60);
		b1.addActionListener(this);
		l1.setForeground(Color.red);
		l1.setBackground(Color.black);
		l2.setBackground(Color.black);
		
		l2.setForeground(Color.red);
		
		im m=new im();
		f1.add(b);
		f1.add(b1);
		f1.add(l1);
		f1.add(l2);
		f1.add(j1);
		f1.add(j2);
		f1.add(m);
		f1.setSize(1709, 1080);
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
		f1.setVisible(true);
//		device.setFullScreenWindow(f1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         fee f=new fee();
	}

}
class im extends Canvas{
	public void paint(Graphics g) {
		try {
			Toolkit t=Toolkit.getDefaultToolkit();
			Image image=t.getImage("D:\\books.jpg");
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		    System.out.println(screenSize.width+"  "+ screenSize.height);
			g.drawImage(image,0, 0,this);

		}catch(Exception e) {
			
		}
	}
}
class slide1 extends Canvas{
	public void paint(Graphics g) {
		try {
			Toolkit t=Toolkit.getDefaultToolkit();
			Image image=t.getImage("D:\\slide1.jpg");
			g.drawImage(image, 0, 0,this);
		}catch(Exception e) {
			
		}
		}
}
class accountant extends Canvas{
	public void paint(Graphics g) {
		try {
		Toolkit t=Toolkit.getDefaultToolkit();
		Image image=t.getImage("D:\\accountant.jpg");
		g.drawImage(image, 0, 0,this);
		}catch(Exception e) {
			
		}
	}
}
class student extends Canvas{
	public void paint(Graphics g) {
		try {
			Toolkit t=Toolkit.getDefaultToolkit();
			Image image=t.getImage("D:\\student.jpg");
			g.drawImage(image, 0, 0,this);
		}catch(Exception e) {
			
		}
	}
}
class iron extends Canvas{
	public void paint(Graphics g) {
		try {
			Toolkit t=Toolkit.getDefaultToolkit();
		    Image image=t.getImage("D:\\ironman.jpg");
		    g.drawImage(image, 0, 0,this);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
class addac extends Canvas{
	public void paint(Graphics g) {
		try {
			Toolkit t=Toolkit.getDefaultToolkit();
			Image image=t.getImage("D:\\acc.jpg");
			g.drawImage(image,0,0,this);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
class addstu extends Canvas{
	public void paint(Graphics g) {
		try {
			Toolkit t=Toolkit.getDefaultToolkit();
			Image image=t.getImage("D:\\ac.jpg");
			g.drawImage(image,0,0,this);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
class update extends Canvas{
	public void paint(Graphics g) {
		try {
			Toolkit t=Toolkit.getDefaultToolkit();
			Image image=t.getImage("D:\\aac.jpg");
			g.drawImage(image,0,0,this);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
class updatein extends Canvas{
	public void paint(Graphics g) {
		try {
			Toolkit t=Toolkit.getDefaultToolkit();
			Image image=t.getImage("D:\\aacc.jpg");
			g.drawImage(image,0,0,this);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}