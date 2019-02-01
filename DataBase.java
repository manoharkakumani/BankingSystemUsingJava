import java.sql.*;
public class DataBase {
       Connection con=null;
       PreparedStatement st;
       Statement stm; 
       ResultSet re;
      public DataBase()
      {
    try{
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankserver","root","");
	          }
    catch(Exception e){
    System.out.println(e);
    }  
      } 
	public void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
        System.out.println("============================================================================");
        System.out.println("***************************     JAVA PROJECT    ****************************");
	System.out.println("******************                   ON                  *******************");
        System.out.println("*************************      BANKING SYSTEM        ***********************");
        System.out.println("******************                   BY                  *******************");
        System.out.println("***************               KAKUMANI MANOHAR                **************");
    	System.out.println("============================================================================\n");
    }       
    }
 
