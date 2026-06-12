package pages;

import org.openqa.selenium.*;
import java.util.*;

public class DiaryPage {

    WebDriver driver;

    public DiaryPage(WebDriver driver){

        this.driver=driver;
    }

    public List<WebElement> rows(){

        return driver.findElements(By.xpath("//table/tbody/tr"));
    }

    public int totalRows(){

        return rows().size();
    }

    public boolean verifyDreamTypes(){

        for(WebElement row:rows()){

        //	String type=row.findElement(By.xpath("//*[@id=\"dreamsDiary\"]/tbody")).getText();

            String type=row.findElements(By.tagName("td")).get(2).getText();

            if(!(type.equals("Good") || type.equals("Bad"))){

                return false;
            }
        }

        return true;
    }

    public boolean verifyColumns(){

        for(WebElement row:rows()){

        	List<WebElement> cols=row.findElements(By.tagName("td"));

            for(WebElement c:cols){

                if(c.getText().trim().isEmpty()){

                    return false;
                }
            }
        }

        return true;
    }

    public int recurringDreams(){

        Map<String,Integer> map=new HashMap<>();

        for(WebElement row:rows()){

        	 String name=row.findElements(By.tagName("td")).get(0).getText();

            map.put(name,map.getOrDefault(name,0)+1);
        }

        int recurring=0;

        for(String key:map.keySet()){

            if(map.get(key)>1)

                recurring++;
        }

        return recurring;
    }

}