# FeePortal
**This is a Mini-project developed where Technologies used:-**

1. JAVA SWING
2. MySQL
3. JDBC

**Software and tools used:-**

1. Eclipse
2. Xampp
3. MySQL

### **This Application is built for the purpose:**

- -Admin can review the fees status of students.
- -Students can pay their fees annually.
- -To add details of a new student.
- -To update details of the student.
- -Students can see their profiles.

**=============== Dummy Database Initialization =====================**

**Step 1:** Open Xampp, Start Apache server, and MySQl

**Step 2**:Type Localhost on your web browser.

**Step 3:** Create DataBase name portal

**Step 4:**Create first table of student details:

create table students(roll_number int , name varchar(255) , email varchar(255), branch varchar(255) , address varchar(255));

**Step 5:** Create  payments table for details of fees:

create table payments(roll_number int primary key, inyear int, bankName varchar(255) ,bankBranch varchar(255) );

**=============== Eclipse side work =====================**

 **Steps for connecting java project to mysql.**
 
Step 1:

Register the Driver first:

Class.forName("com.mysql.jdbc.Driver");

Step 2:

Set the connection using 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/portal","root","root");  
//here portal is database name, root is username and password  

Step 3:

Create Statement:
Statement stmt=con.createStatement();  

Step 4:

Fetch the rows using ResultSet from database:

ResultSet rs=stmt.executeQuery("select * from students");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

Step 5:

Close the connection:  
con.close();  

  

