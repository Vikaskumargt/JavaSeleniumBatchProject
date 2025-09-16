package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class OrangeReuseableMethods {
    public static void main(String[] args) {

    }

    public static WebDriver launchBrowser(String browsername) {
        WebDriver oBrowser = null;
        try {
            switch (browsername.toLowerCase()) {
                case "chrome":
                    oBrowser = new ChromeDriver();
                    break;
                case "firefox":
                    oBrowser = new FirefoxDriver();
                    break;
                case "edge":
                    oBrowser = new EdgeDriver();
                    break;
                default:
                    System.out.println("browsername is mentioned Incorrect");
                    return null;
            }

            if (oBrowser != null) {
                oBrowser.manage().window().maximize();
                System.out.println("The " + browsername + " launched Successfully");
                return oBrowser;
            } else {
                System.out.println("The " + browsername + " failed to launch");
                return null;
            }

        } catch (Exception e) {
            System.out.println("Exception in Browser " + e);
            return null;
        }
    }
    public static  Boolean loginToOrangeHRM(String url,WebDriver oBrowser){
        try{
            oBrowser.navigate().to(url);
            Thread.sleep(3000);
            if(oBrowser.getCurrentUrl().equalsIgnoreCase(url)){
                System.out.println("launched the url successfull");
            } else {
                System.out.println("failed to launch");
                return false;
            }
            oBrowser.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
            oBrowser.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
            oBrowser.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(3000);
            if(oBrowser.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")){
                System.out.println("login successful");
                return true;
            } else{
                System.out.println("login unsuccessful");
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public static void logoutOfOrangeHRM(WebDriver oBrowser){
        try{
           oBrowser.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
           oBrowser.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
           Thread.sleep(2000);
           if(oBrowser.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")){
               System.out.println("logout Successful");
           }else{
               System.out.println("logout unSuccessful");
           }
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            oBrowser.close();
            oBrowser = null;
        }

    }
}
