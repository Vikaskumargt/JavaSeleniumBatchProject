package OrangeHRM;

import org.openqa.selenium.WebDriver;

public class OrangeHrmApp extends OrangeReuseableMethods {
    public static void main(String[] args) {
        loginlogout("chrome","https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    public static void loginlogout(String Browsername,String url){
        try{
            WebDriver oBrowser = launchBrowser(Browsername);
            boolean bln = loginToOrangeHRM(url,oBrowser);
            logoutOfOrangeHRM(oBrowser);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
