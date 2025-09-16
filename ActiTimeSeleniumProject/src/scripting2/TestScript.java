package scripting2;

import org.openqa.selenium.WebDriver;

public class TestScript extends ReuseableMethods {
    public static void main(String[] args) {
        //ts_LoginLogout();
        ts_CreateAndDeleteUser();
    }

    public static void ts_LoginLogout(){
        WebDriver oBrowser = null;
        try{
            oBrowser = launchBrowser("chrome");
            boolean blnRes = navigateURL(oBrowser,"http://localhost:8080/login.do");
            blnRes = loginToApplication(oBrowser,"admin","manager");
            blnRes = logoutFromActiTime(oBrowser);

        }catch(Exception e){
            System.out.println("Exception in ts_LoginLogout ");
        } finally{
            oBrowser.close();
            oBrowser = null;
        }
    }

    public static void ts_CreateAndDeleteUser(){
        WebDriver oBrowser = null;
        try{
            oBrowser = launchBrowser("chrome");
            boolean blnRes = navigateURL(oBrowser,"http://localhost:8080/login.do");
            blnRes = loginToApplication(oBrowser,"admin","manager");
            String userName = createUser(oBrowser);
            blnRes = deleteUser(oBrowser,userName);
            blnRes = logoutFromActiTime(oBrowser);

        }catch(Exception e){
            System.out.println("Exception in ts_LoginLogout ");
        } finally{
            oBrowser.close();
            oBrowser = null;
        }
    }
}
