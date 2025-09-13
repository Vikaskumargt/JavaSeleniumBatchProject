package vaildation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckBox {
    public static void main(String[] args) {
        //checkboxValidations();
        //textFieldValidations();
        dropdownValidations();
    }

    public static void checkboxValidations(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///D:/VIKAS_JAVA_WORKSPACE/HTML/SampleWebPage.html");
            Thread.sleep(2000);

            //1. Exist Or not?
            System.out.println("*****************Verify element exist OR not**********************");
            if(oBrowser.findElement(By.xpath("//input[@id='chk1_id']")).isDisplayed()){
                System.out.println("The checkbox exist");
            }else{
                System.out.println("Failed to find the checkbox");
            }

            if(oBrowser.findElements(By.xpath("//input[@id='chk1_id']")).size() > 0){
                System.out.println("The Text Field exist");
            }else{
                System.out.println("Failed to find the Text Field");
            }


            //2. Select the checkbox/radio
            System.out.println("*****************Select the checkbox/radio**********************");
            oBrowser.findElement(By.xpath("//input[@id='chk1_id']")).click();
            Thread.sleep(2000);

            //3. Verify checkbox/radio button is selected/not?
            System.out.println("*****************Verify checkbox/radio button is selected/not?**********************");
            if(oBrowser.findElement(By.xpath("//input[@id='chk1_id']")).isSelected()){
                System.out.println("Checkbox is selected");
            }else{
                System.out.println("Failed to select the checkbox");
            }


            //4. unselect the checkbox/radio
            //5. Unselected/not
            System.out.println("****************unselect the checkbox/radio & Unselected/not**********************");
            oBrowser.findElement(By.xpath("//input[@id='chk1_id']")).click();
            Thread.sleep(2000);
            if(oBrowser.findElement(By.xpath("//input[@id='chk1_id']")).isSelected()){
                System.out.println("Failed to unselect the Checkbox");
            }else{
                System.out.println("The checkbox is unselected successful");
            }


            //6. How many checkboxes/radio? Select the second checkbox
            System.out.println("****************How many checkboxes/radio? Select the second checkbox**********************");
            List<WebElement> oEles = oBrowser.findElements(By.xpath("//input[@type='checkbox']"));
            System.out.println("No. of checkboxes are: "+ oEles.size());
            Thread.sleep(2000);
            oEles.get(1).click();
            if(oEles.get(1).isSelected()) System.out.println("Second checkbox is selected");
            else System.out.println("Failed to select the second checkbox");
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser.close();
            oBrowser = null;
        }
    }

    public static void textFieldValidations(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///D:/VIKAS_JAVA_WORKSPACE/HTML/SampleWebPage.html");
            Thread.sleep(2000);

            //1. Exist Or not?
            System.out.println("*****************Verify element exist OR not**********************");
            if(oBrowser.findElement(By.xpath("//input[@id='frm1_un_id']")).isDisplayed()){
                System.out.println("The Text Field exist");
            }else{
                System.out.println("Failed to find the Text Field");
            }

            if(oBrowser.findElements(By.xpath("//input[@id='frm1_un_id']")).size() > 0){
                System.out.println("The Text Field exist");
            }else{
                System.out.println("Failed to find the Text Field");
            }


            //2. Enter the value
            oBrowser.findElement(By.xpath("//input[@id='frm1_un_id']")).sendKeys("adminnnnnnnnn");
            Thread.sleep(2000);

            //3. Read the entered value
            String strText = oBrowser.findElement(By.xpath("//input[@id='frm1_un_id']")).getAttribute("value");
            System.out.println(strText);

            //4. Clear the value
            oBrowser.findElement(By.xpath("//input[@id='frm1_un_id']")).clear();
            Thread.sleep(2000);


            //5. Read the placeholder value
            strText = oBrowser.findElement(By.xpath("//input[@id='frm1_un_id']")).getDomAttribute("placeholder");
            System.out.println(strText);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser.close();
            oBrowser = null;
        }
    }

    public static void dropdownValidations(){
        WebDriver oBrowser = null;
        Select oSelect = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///D:/VIKAS_JAVA_WORKSPACE/HTML/SampleWebPage.html");
            Thread.sleep(2000);

            //1. Exist Or not?
            System.out.println("*****************Verify element exist OR not**********************");
            if(oBrowser.findElement(By.xpath("//select[@id='list1']")).isDisplayed()){
                System.out.println("The Dropdown exist");
            }else{
                System.out.println("Failed to find the Dropdown");
            }

            if(oBrowser.findElements(By.xpath("//select[@id='list1']")).size() > 0){
                System.out.println("The Dropdown exist");
            }else{
                System.out.println("Failed to find the Dropdown");
            }


            //6. What are the different ways we can select the dropdown values?
            //7. How to read the selected value from the dropdown?
            System.out.println("*****************What are the different ways we can select the dropdown values & read them?**********************");
            WebElement oEle = oBrowser.findElement(By.xpath("//select[@id='list1']"));
            oSelect = new Select(oEle);
            oSelect.selectByIndex(1);
            System.out.println(oSelect.getFirstSelectedOption().getText());
            Thread.sleep(2000);

            oSelect.selectByValue("hbl");
            System.out.println(oSelect.getFirstSelectedOption().getText());
            Thread.sleep(2000);

            oSelect.selectByVisibleText("Bangalore");
            System.out.println(oSelect.getFirstSelectedOption().getText());
            Thread.sleep(2000);


            //3. How many dropdowns present?
            System.out.println("*******************How many dropdowns present?**************");
            List<WebElement> oEles = oBrowser.findElements(By.xpath("//select[@id]"));
            System.out.println("No. of dropdowns are: " + oEles.size());


            //4. What are the values(options) present in the dropdown?
            System.out.println("*******************What are the values(options) present in the dropdown?**************");
            oEle = oBrowser.findElement(By.xpath("//select[@id='list1']"));
            oSelect = new Select(oEle);
            List<WebElement> oItems = oSelect.getOptions();
            for(int i=0; i<oItems.size(); i++){
                System.out.println(oItems.get(i).getText());
            }


            //5. Verify Given value is present in the dropdown?
            System.out.println("********************Verify Given value is present in the dropdown?*****************");
            oSelect = new Select(oBrowser.findElement(By.xpath("//select[@id='list1']")));
            String cityName = "Goa";
            oItems = oSelect.getOptions();
            int flag = 0;
            for(int i=0; i<oItems.size(); i++){
                if(oItems.get(i).getText().equalsIgnoreCase(cityName)){
                    flag++;
                    break;
                }
            }
            if(flag==0) System.out.println("The city '"+cityName+"' doesnot exist");
            else System.out.println("The city '"+cityName+"' exist");

            //8. How to select the multiple values from multi-select dropdown?
            System.out.println("************How to select the multiple values from multi-select dropdown?************");
            oSelect = new Select(oBrowser.findElement(By.xpath("//select[@id='list1'][@multiple]")));
            oSelect.selectByVisibleText("Raichur");
            oSelect.selectByVisibleText("Bangalore");
            oSelect.selectByVisibleText("Hubballi");
            Thread.sleep(2000);

            //9. How to read all the multiple value selected from multi-select dropdown?
            System.out.println("***********How to read all the multiple value selected from multi-select dropdown?**********");
            List<WebElement> allItems = oSelect.getAllSelectedOptions();
            for(int i=0; i<allItems.size(); i++){
                System.out.println(allItems.get(i).getText());
            }


            //10. How to unselect the multiselect values from multi-select dropdown?
            System.out.println("************How to unselect the multiselect values from multi-select dropdown?********");
            oSelect.deselectAll();
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser.close();
            oBrowser = null;
        }
    }
}
