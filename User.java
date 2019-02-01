import java.util.Scanner;
public class User extends DataBase
{ 
   Scanner in =new Scanner(System.in);
   Scanner in1 =new Scanner(System.in);
    User (){
    super(); 
    }
    String username,password,acno=null,acno1=null;
public void login(){
	       System.out.println("*********************************");
           System.out.println("*---------  USER LOGIN ---------*");
           System.out.println("*********************************");
       System.out.print("Enter Username : ");
       username=in1.nextLine();
       System.out.print("Enter Password : ");
       password=in1.nextLine();  
       this.check();
}    
private void check(){
try{
       stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE username='"+username+"'AND password='"+password+"'");
       if(re.next()){
               acno=re.getString("acno");
               this.clearScreen();
               this.umenu();           
       }
       else{
		   this.clearScreen();
           System.out.println("*********************************");
           System.out.println("* Username Or Password is Wrong *");
           System.out.println("* TryAgain Or Contact Admin     *");
           System.out.println("*********************************");
           Login l=new Login();
       }
}catch(Exception e){
        System.out.println(e);
       }
}
public void umenu(){
    if((username!=null&&password!=null)||acno!=null){
int a=0;
System.out.println("\n********Welcome ************");
System.out.println("*         Menu             *");
System.out.println("* 1.Display Detials        *");
System.out.println("* 2.Balance Enquary        *");
System.out.println("* 3.Transaction History    *");
System.out.println("* 4.Money Transfer         *");
if(username==null&&password==null)
        {
System.out.println("* 5.Back                   *");       
        }
        else{
System.out.println("* 5.Change Password        *");
System.out.println("* 6.Logout                 *");
        }

System.out.println("****************************");
System.out.print("Enter Your Choise : ");
  a=in.nextInt();
switch(a){
    case 1: 
            this.display();
            break;
    case 2: 
            this.balanceEnquary();
            break;
    case 3: 
            this.accountHistory();
            break;
    case 4: 
            this.moneyTransfer();
            break;
    case 5 : if(username==null&&password==null)
        {
			this.clearScreen();
          Admin a1=new Admin();
          a1.amenu();
                }
        else{
            this.changePassword();
        } 
          break;
    case 6:
		if(username==null&&password==null)
        { 
       	 System.out.println("*****************");
          System.out.println("* Wrong  Choise *");
          System.out.println("*****************");
          this.umenu();
                }
        else{
			this.clearScreen();
		   username=null;
           password=null;
	   acno=null;
           Login l=new Login();
        } 
          break; 
        
    default:System.out.println("*****************");
            System.out.println("* Wrong  Choise *");
            System.out.println("*****************");
            this.umenu();
			break;
}
}
}
private void display(){
try{
       this.clearScreen();
	   stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acno+"'");
       if(re.next()){             
               System.out.println("***********************************************************");
               System.out.println("* Account Holder NAME \t: "+re.getString("name"));
               System.out.println("* Account Number\t: "+re.getString("acno"));
               System.out.println("* Email \t\t: "+re.getString("email"));
               System.out.println("* Phone Number \t\t: "+re.getString("phone"));
               System.out.println("* Adderss \t\t: "+re.getString("address"));
               System.out.println("* Account Type \t\t: "+re.getString("actype"));
               System.out.println("* Branch \t\t: "+re.getString("branch"));
               System.out.println("* Balance \t\t: "+re.getString("balance"));
               System.out.println("**********************************************************");
               this.umenu();         
       }
}catch(Exception e){
        System.out.println(e);
       }
}

private void balanceEnquary(){
try {
stm=con.createStatement();
re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acno+"'");
if(re.next()){
this.clearScreen();
System.out.println("*********************************************");
System.out.println("* Balance In Account  : "+re.getString("balance"));
System.out.println("*********************************************");
}
this.umenu();
} catch (Exception e) {
  System.out.println(e);
 }

}
private void accountHistory(){
 
       try {
		   this.clearScreen();
           stm=con.createStatement();
           re=stm.executeQuery("SELECT * FROM `"+acno+"`");
         System.out.println("*****************************************************************************************");
         System.out.println("Credited/Debited \t Reason \t\t Amount  \t Balance");
         while(re.next()){
         System.out.println(re.getString("cd")+"\t \t "+re.getString("reason")+"\t\t" +re.getString("amount")+" \t\t"+re.getString("balance"));
     }
         System.out.println("****************************************************************************************");
         this.umenu();
       } catch (Exception e) {
  System.out.println(e);
 }
}
private void moneyTransfer(){
   int balance=0,bal=0,balance1=0;
    System.out.print("Enter Account Number : ");
    acno1=in1.nextLine();
    try{ 
	if(acno.equals(acno1)){
		    this.clearScreen();
            System.out.println("*****************************************");
            System.out.println("* Same Account Transaction Not Possible *");
            System.out.println("*****************************************");
            this.umenu();
    }
    else{
  
       stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acno+"'");
       if(re.next()){
               balance=re.getInt("balance");
                    }
        re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acno1+"'");
       if(re.next()){
               balance1=re.getInt("balance");
               System.out.print("Enter Amount to be Transfered : ");
     bal=in.nextInt();               
       }
       else{
		    this.clearScreen();
            System.out.println("****************************");
            System.out.println("* Account Number Not Found *");
            System.out.println("****************************");
           this.umenu();
       }
       if(balance<bal)
       {
		   this.clearScreen();
       System.out.println("+++++++++++++++++++++++");
       System.out.println("+ Insufficent Balance +");
       System.out.println("+++++++++++++++++++++++");
       this.umenu();
       }
       else{
       balance=balance-bal;
       balance1=balance1+bal;
       stm.executeUpdate("UPDATE `users` SET `balance`='"+balance+"' WHERE acno='"+acno+"'");
       stm.executeUpdate("UPDATE `users` SET `balance`='"+balance1+"' WHERE acno='"+acno1+"'");
        st=con.prepareStatement("INSERT INTO `"+acno+"`( `cd`,`amount`,`reason`, `balance`) VALUES ('Debited.','"+bal+"','Transfer','"+balance+"')");
        st.executeUpdate();
        st=con.prepareStatement("INSERT INTO `"+acno1+"`( `cd`,`amount`,`reason`, `balance`) VALUES ('Credited','"+bal+"','Transfer','"+balance1+"')");    
       st.executeUpdate(); 
	    this.clearScreen();
        System.out.println("+++++++++++++++++++++++");       
        System.out.println("+ Transaction Success +");
        System.out.println("+++++++++++++++++++++++");
       this.umenu();
       }      
}
}catch(Exception e){
        System.out.println(e);
       }
}
private void changePassword(){
	   System.out.print("Enter Current Password : ");
       String password0=in1.nextLine();
       System.out.print("Enter New  Password : ");
       String password1=in1.nextLine();
       System.out.print("Confirm   Password : ");
       String password2=in1.nextLine();
  try{ if(password1.equals(password2))
 {
	 stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE username='"+username+"'AND password='"+password0+"'");
       if(re.next()){
		       this.clearScreen();
               stm.executeUpdate("UPDATE `users` SET `password`='"+password1+"'WHERE username='"+username+"'AND password='"+password0+"'");
               System.out.println("********************************");
               System.out.println("* Passwords Reset Successfully *");
               System.out.println("********************************");
			   password=password1;
			   this.umenu();
                }
		else{
			   this.clearScreen();
			   System.out.println("********************************");
               System.out.println("* CURRENT PASSWORD IS WRONG    *");
               System.out.println("********************************");
			   username=null;password=null;
               Login l=new Login();
		}
}
 else{
	   this.clearScreen();
		System.out.println("*********************************");
		System.out.println("* Two Passwords are not Matched *");
		System.out.println("*********************************");
		this.umenu(); 
 } 
   }catch(Exception ex){
      System.out.println(ex);
  }
 }
}
