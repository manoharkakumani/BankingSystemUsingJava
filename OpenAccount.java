import java.util.Scanner;
public class OpenAccount extends Admin{
 Scanner in =new Scanner(System.in);
 String name,username,password, occupation,email,acno,actype,balance,phone,branch,address,ano=null,un = null;
 OpenAccount(){
 super();
 }
     public void openAccount()
    {
       System.out.print("Enter Account Holder FULL NAME : ");
       name=in.nextLine();
       System.out.print("Enter Account Holder Phone Number : ");
       phone=in.nextLine();
       System.out.print("Enter Account Holder Occupation : ");
       occupation=in.nextLine();
       System.out.print("Enter Account Holder Email : ");
       email=in.nextLine();
       System.out.print("Enter Account Holder Address : ");
       address=in.nextLine();
       System.out.print("Enter NEW Account Number : ");
       acno=in.nextLine();
       System.out.print("Enter  Account Type : ");
       actype=in.nextLine();
       System.out.print("Enter Account Holder Branch : ");
       branch=in.nextLine();
       System.out.print("Enter Amount Is going to Crideted : ");
       balance=in.nextLine();       
       System.out.print("Enter Account Holder Username : ");
       username=in.nextLine();
       System.out.print("Enter Account Holder Password : ");
       password=in.nextLine();
       this.insert();
    }
public void insert( ){

try{
       stm=con.createStatement();
       re=stm.executeQuery("SELECT * FROM `users` WHERE username='"+username+"'");
       if(re.next()){
        un=re.getString("username");
       }
       re=stm.executeQuery("SELECT * FROM `users` WHERE acno='"+acno+"'");
       if(re.next()){
       ano=re.getString("acno");
       }  
        if(username.equalsIgnoreCase(un)&&acno.equalsIgnoreCase(ano)){
           System.out.println("Username And Acount Number are Alredy in Use");
           System.out.print("Enter New Username : ");
           username=in.nextLine();
           System.out.print("Enter New Account Number : ");
           acno=in.nextLine();
           this.insert();
         }
        else if(username.equalsIgnoreCase(un)){
     System.out.println("\n**************************");
     System.out.println("*Username is Alredy in Use*");
     System.out.println("***************************\n");
     System.out.print("Enter New Username : ");
     username=in.nextLine();
     this.insert();
     }
     else if(acno.equals(ano)){
      System.out.println("\n********************************");
      System.out.println("*Acount Number is Alredy in Use*");
      System.out.println("********************************\n");
        System.out.print("Enter New Account Number : ");
         acno=in.nextLine();
         this.insert();
        }
else{
     try{
     String q= "INSERT INTO `users`(`name`, `username`, `password`, `occupation`, `email`, `acno`, `actype`, `balance`, `branch`,`phone`,`address`)"
             + "VALUES('"+name+"','"+username+"','"+password+"','"+ occupation+"','"+email+"','"+acno+"','"+actype+"','"+balance+"','"+branch+"','"+phone+"','"+address+"')";
         st=con.prepareStatement(q);
        st.executeUpdate();
        q="CREATE TABLE `"+acno+"`(id INTEGER not NULL  AUTO_INCREMENT,PRIMARY KEY (id),cd varchar(255) not NULL,amount INTEGER(11) NOT NULL,reason varchar(255) not NULL,balance INTEGER(11) not NULL)";
        st=con.prepareStatement(q);
        st.executeUpdate();
        q= "INSERT INTO `"+acno+"`(`cd`,`amount`,`reason`,`balance`)VALUES('Credited','"+balance+"','Self Deposit','"+balance+"')";
         st=con.prepareStatement(q);
        st.executeUpdate();
		this.clearScreen();
        System.out.println("*********************************");
        System.out.println("*     New   Account  Created    *");
        System.out.println("*********************************");		 
		     this.amenu();
     }
    catch(Exception e){
    System.out.println(e);
    } 
    }
 }catch(Exception e){
        System.out.println(e);
       }
    }

}

