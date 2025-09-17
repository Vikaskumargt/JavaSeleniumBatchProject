package scripting4;

import org.openqa.selenium.WebDriver;
import scripting3_excel.ReuseableMethods;

import java.util.Map;

public class TestScript extends ReuseableMethods {
    public static void main(String[] args) {
        ts_LoginLogout();
        ts_CreateAndDeleteUser();
    }

    public static void ts_LoginLogout(){
        WebDriver oBrowser = null;
        Map<String,String> data = null;
        try{
            data = getExcelData("TestData","TestData","TC_ID_001");
            oBrowser = launchBrowser(data.get("browserName"));
            boolean blnRes = navigateURL(oBrowser,data.get("url"));
            blnRes = loginToApplication(oBrowser,data.get("userName"),data.get("password"));
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
        Map<String,String> data = null;
        try{
            data = getExcelData("TestData","TestData","TC_ID_002");
            oBrowser = launchBrowser(data.get("browserName"));
            boolean blnRes = navigateURL(oBrowser,data.get("url"));
            blnRes = loginToApplication(oBrowser,data.get("userName"),data.get("password"));
            String userName = createUser(oBrowser,data);
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
