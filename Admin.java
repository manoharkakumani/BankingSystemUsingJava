public class Admin extends User{
    Admin(){
    super();
    } 
    static String adminname,adminpass;
     String acn1=null;
public void adminlogin(){
           System.out.println("*********************************");
           System.out.println("*--------- ADMIN LOGIN ---------*");
           System.out.println("*********************************");
       System.out.print("Enter Username : ");
       adminname=in1.nextLine();
       System.out.print("Enter Password : ");
       adminpass=in1.nextLine();
       this.clearScreen();  
       this.admincheck();
}    
private void admincheck(){
try{
       stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `admin` WHERE username='"+adminname+"'AND password='"+adminpass+"'");
       if(re.next()){
               this.amenu();           
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
public void amenu(){
    if(adminname !=null&&adminpass !=null){
int a=0;
System.out.println("\n****************  ADMIN  ************************");
System.out.println("*                  Menu                         *");
System.out.println("* 1.Display Name AND Account NO Of All Customer *");
System.out.println("* 2.Perform Operation on Certain Customer       *");
System.out.println("* 3.Deposit Money to Customer Account           *");
System.out.println("* 4.With Draw Money from Customer Account       *");
System.out.println("* 5.Open New Account                            *");
System.out.println("* 6.Update Customer Information                 *");
System.out.println("* 7.Close Customer Account                      *");
System.out.println("* 8.Logout                                      *");
System.out.println("*************************************************");
System.out.print("Enter Your Choise : ");
  a=in.nextInt();
switch(a){
    case 1: 
            this.display1();
            break;
    case 2: System.out.print("Enter  Account Number Of Customer: ");
            acn1=in1.nextLine();
            try{
            stm=con.createStatement();
            re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
            if(re.next()){
            super.acno=acn1;
			this.clearScreen();
            this.umenu();
              }
             else{
				 this.clearScreen();
           System.out.println("****************************");
           System.out.println("* Account Number Not Found *");
           System.out.println("****************************");
           this.amenu();
              }}catch(Exception e)
               {
            System.out.print(e);
               }
            break;
    case 3: System.out.print("Enter  Account Number Of Customer: ");
            acn1=in1.nextLine();
            try{
            stm=con.createStatement();
            re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
            if(re.next()){
            this.deposit();
              }
             else{
				 this.clearScreen();
            System.out.println("****************************");
            System.out.println("* Account Number Not Found *");
            System.out.println("****************************");
           this.amenu();
              }}catch(Exception e)
               {System.out.print(e);}
            break;
    case 4: System.out.print("Enter  Account Number Of Customer: ");
            acn1=in1.nextLine();
            try{
            stm=con.createStatement();
            re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
            if(re.next()){
            this.drawmoney();
              }
             else{
				 this.clearScreen();
            System.out.println("****************************");
            System.out.println("* Account Number Not Found *");
            System.out.println("****************************");
           this.amenu();
              }}catch(Exception e)
               {System.out.print(e);}
            break;
    case 5: 
          OpenAccount o=new OpenAccount();
          o.openAccount();
          break;
    case 6: System.out.print("Enter  Account Number Of Customer: ");
            acn1=in1.nextLine();
            try{
            stm=con.createStatement();
            re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
            if(re.next()){
				this.clearScreen();
            this.updateInfo();
              }
             else{
				 this.clearScreen();
           System.out.println("****************************");
           System.out.println("* Account Number Not Found *");
           System.out.println("****************************");
           this.amenu();
              }}catch(Exception e)
               {System.out.print(e);}
            break;
    case 7:	System.out.print("Enter  Account Number Of Customer: ");
            acn1=in1.nextLine();
            try{
            stm=con.createStatement();
            re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
            if(re.next()){
            this.delete();
              }
             else{
				 this.clearScreen();
           System.out.println("****************************");
           System.out.println("* Account Number Not Found *");
           System.out.println("****************************");
           this.amenu();
              }}catch(Exception e)
               {System.out.print(e);}
            break;		
    case 8: 
			this.clearScreen();
		   adminname=null;
           adminpass=null;
           Login l=new Login();
           break;
           
    default:
            System.out.println("*****************");
            System.out.println("* Wrong  Choise *");
            System.out.println("*****************");
            this.amenu();
            break;
}
}
}
private void updateInfo(){
int a=0;
System.out.println("\n****************************");
System.out.println("*         Menu             *");
System.out.println("* 1.Name  Chanage          *");
System.out.println("* 2.Change Password        *");
System.out.println("* 3.Phone Number Change    *");
System.out.println("* 4.Email Change           *");
System.out.println("* 5.Occupation Change      *");
System.out.println("* 6.Change Address         *");
System.out.println("* 7.Back                   *");
System.out.println("****************************");
System.out.print("Enter Your Choise : ");
  a=in.nextInt();
switch(a){
    case 1: 
            this.nameChange();
            break;
    case 2:
           this.apasschnge();
           break;
    case 3:
           this.pnoChange();
           break;
    case 4:
           this.emailChange();
           break;
    case 5:
           this.occupChange();
           break;
    case 6:
           this.addrChange();
           break;
    case 7:
			this.clearScreen();
			this.amenu();
            break;
    default:
            System.out.println("*****************");
            System.out.println("* Wrong  Choise *");
            System.out.println("*****************");
            this.updateInfo();
            break;
} }

private void apasschnge(){
       System.out.print("Enter New  Password : ");
       String password1=in1.nextLine();
       System.out.print("Confirm   Password : ");
       String password2=in1.nextLine();
  try{
	  if(password1.equals(password2))
 {

 stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
       if(re.next()){
               stm.executeUpdate("UPDATE `users` SET `password`='"+password1+"'WHERE acno='"+acn1+"'");
               this.clearScreen();
			   System.out.println("**********************************");
               System.out.println("* Passwords Updated Successfully *");
               System.out.println("**********************************");
               this.updateInfo();           
       }

 }
 else{
	  this.clearScreen();
 System.out.println("*********************************");
 System.out.println("* Two Passwords are not Matched *");
 System.out.println("*********************************");
 this.apasschnge(); 
 }
 }
  catch(Exception ex){
      System.out.println(ex);
  }
}
private void nameChange(){
       System.out.print("Enter New Name : ");
       String name1=in1.nextLine();
   try{
 stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
       if(re.next()){
               stm.executeUpdate("UPDATE `users` SET `name`='"+name1+"'WHERE acno='"+acn1+"'");
				 this.clearScreen();
			  System.out.println("+++++++++++++++++++++++++++++");
               System.out.println("+ Name Updated Successfully +");
               System.out.println("+++++++++++++++++++++++++++++");
               this.updateInfo();           
       }}
  catch(Exception ex){
      System.out.println(ex);
  } }
private void pnoChange(){
       System.out.print("Enter New Phone Number : ");
       String name1=in1.nextLine();
   try{
 stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
       if(re.next()){
               stm.executeUpdate("UPDATE `users` SET `phone`='"+name1+"'WHERE acno='"+acn1+"'");
               this.clearScreen();  			   
               System.out.println("+++++++++++++++++++++++++++++++++++++");
               System.out.println("+ Phone Number Updated Successfully +");
               System.out.println("+++++++++++++++++++++++++++++++++++++");
               this.updateInfo();           
       }}
  catch(Exception ex){
      System.out.println(ex);
  } }
private void emailChange(){
       System.out.print("Enter New Email : ");
       String name1=in1.nextLine();
   try{
 stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
       if(re.next()){
               stm.executeUpdate("UPDATE `users` SET `email`='"+name1+"'WHERE acno='"+acn1+"'"); 
                this.clearScreen();
			   System.out.println("++++++++++++++++++++++++++++++");
               System.out.println("+ Email Updated Successfully +");
               System.out.println("++++++++++++++++++++++++++++++");
               this.updateInfo();           
       }}
  catch(Exception ex){
      System.out.println(ex);
  } }
private void occupChange(){
       System.out.print("Enter New Occupation : ");
       String name1=in1.nextLine();
   try{
 stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
       if(re.next()){
               stm.executeUpdate("UPDATE `users` SET `occupation`='"+name1+"'WHERE acno='"+acn1+"'");
               this.clearScreen();			   
               System.out.println("+++++++++++++++++++++++++++++++++++");
               System.out.println("+ Occupation Updated Successfully +");
               System.out.println("+++++++++++++++++++++++++++++++++++");
               this.updateInfo();           
       }}
  catch(Exception ex){
      System.out.println(ex);
  } }
private void addrChange(){
       System.out.print("Enter New Address : ");
       String name1=in1.nextLine();
   try{
 stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
       if(re.next()){
		        this.clearScreen();
               stm.executeUpdate("UPDATE `users` SET `address`='"+name1+"'WHERE acno='"+acn1+"'"); 
               System.out.println("++++++++++++++++++++++++++++++++");
               System.out.println("+ Address Updated Successfully +");
               System.out.println("++++++++++++++++++++++++++++++++");
               this.updateInfo();           
       }}
  catch(Exception ex){
      System.out.println(ex);
  } }
private void display1(){
     
       try {
		    this.clearScreen();
         stm=con.createStatement();
         re=stm.executeQuery("SELECT * FROM `users`");
         System.out.println("**********************************************************************************************************************");
         System.out.println("Name \t\tAccount No \t\t Phone NO \t\t Address \t\t Balance");
         while(re.next()){
         System.out.println(re.getString("name")+"\t\t "+re.getString("acno")+"\t\t" +re.getString("phone")+" \t\t"+re.getString("address")+" \t\t"+re.getString("balance"));
          }
         System.out.println("***********************************************************************************************************************");
         this.amenu();
       } catch (Exception e) {
  System.out.println(e);
 }}
private void deposit(){
    int balance=0;
    System.out.print("Enter Amount to be Deposited : ");
    int amount=in.nextInt();
   try{
       stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
       if(re.next()){
               balance=re.getInt("balance");
       balance=balance+amount;
       stm.executeUpdate("UPDATE `users` SET `balance`='"+balance+"' WHERE acno='"+acn1+"'");
       st=con.prepareStatement("INSERT INTO `"+acn1+"`( `cd`,`amount`,`reason`, `balance`) VALUES ('Credited','"+amount+"','Self Deposit','"+balance+"')");    
       st.executeUpdate();
	    this.clearScreen();
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("+ Successfully Deposited +");
        System.out.println("++++++++++++++++++++++++++");
       this.amenu();
       }      
       }catch(Exception e){
        System.out.println(e);
       }
}
private void drawmoney(){
    int balance=0;
    System.out.print("Enter Amount to be WithDraw : ");
    int amount=in.nextInt();
     try{
       stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acn1+"'");
       if(re.next()){
               balance=re.getInt("balance");
               if(balance>amount){
       balance=balance-amount;
       stm.executeUpdate("UPDATE `users` SET `balance`='"+balance+"' WHERE `acno`='"+acn1+"'");
       st=con.prepareStatement("INSERT INTO `"+acn1+"`( `cd`,`amount`,`reason`, `balance`) VALUES ('Debited ','"+amount+"','WithDrawal','"+balance+"')");    
       st.executeUpdate();
	    this.clearScreen();
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("+ Successfully WithDrawn +");
        System.out.println("++++++++++++++++++++++++++");
        this.amenu();
       }else{
		 this.clearScreen();
       System.out.println("+++++++++++++++++++++++");
       System.out.println("+ Insufficent Balance +");
       System.out.println("+++++++++++++++++++++++");
       this.amenu();
            }
         }   
       }catch(Exception e){
        System.out.println(e);
       }
}
private void delete(){
	 try{
        stm=con.createStatement();
	    stm.executeUpdate("Delete from `users` WHERE `acno`='"+acn1+"'");
	    stm.executeUpdate("DROP TABLE `"+acn1+"`");
		 this.clearScreen();
	    System.out.println("++++++++++++++++++++++++++");
        System.out.println("+  Successfully Closed   +");
        System.out.println("++++++++++++++++++++++++++");
        this.amenu();
 }catch(Exception e){
        System.out.println(e);
       }	
}
}
