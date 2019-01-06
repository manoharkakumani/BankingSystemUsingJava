import java.util.Scanner;
class Login extends Admin{
    public Login(){
int a=0; 
Scanner in =new Scanner(System.in);
System.out.println("\n****************************");
System.out.println("*         Menu             *");
System.out.println("*     1.User  Login        *");
System.out.println("*     2.Admin Login        *");
System.out.println("*     3.To Exit            *");
System.out.println("****************************");
System.out.print("Enter Your Choise : ");
a=in.nextInt();
switch(a){
    case 1: this.clearScreen();
				User u=new User();
                 u.login();
                 break;
    case 2:this.clearScreen();
				Admin a2=new Admin();
                  a2.adminlogin();
    case 3: try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
	        System.exit(0);
	        break;			 
    default:this.clearScreen();
            System.out.println("*****************");
            System.out.println("* Wrong  Choise *");
            System.out.println("*****************");
            Login l=new Login();
            break;
}     
}
public Login(int a){
this.clearScreen();
 }
}
public class Main{
public static void main( String []args){
       Login l1=new Login(1);
       Login l=new Login();
}
}
