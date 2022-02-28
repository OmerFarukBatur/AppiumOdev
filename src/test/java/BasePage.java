import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;


public class BasePage extends BaseTest{

    public Logger logger =Logger.getLogger(getClass());

    AndroidTouchAction action = new AndroidTouchAction(appiumDriver);

    @Step("<wait> saniye kadar bekle")
    public void waitForseconds(int wait) throws InterruptedException {
        Thread.sleep(1000*wait);
    }

    @Step("<id> li elementi dogrula ve tıkla")
    public void clickByidControl(String id){
        if (appiumDriver.findElement(By.id(id)).isDisplayed()) {
            appiumDriver.findElement(By.id(id)).click();
            System.out.println(id + "elementine tıklandı");
        }
    }

    @Step("<id> li elemente tıkla")
    public void clickById(String id){
            appiumDriver.findElement(By.id(id)).click();
    }

    @Step("<xpath> li elemente tıklama")
    public void clickByXpath(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();
    }

    @Step("Uygulama kontrol ediliyor")
    public void applicationStartControl(){
        if(appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/nav_cart")).isDisplayed()){
            System.out.println("Uygulama başarılı bir şekilde başlatılmıştır.");
            //Assert.assertNotEquals("Degerler eşit", 1, 2);
        }
    }

    @Step("x1:<x1> x2:<x2> y1:<y1> y2:<y2> Sayfayı bir kere asagi kaydir")
    public void pageScrol(int x1,int x2,int y1, int y2){
        (new AndroidTouchAction(appiumDriver)).press(new PointOption().withCoordinates(x2,y2))
                .moveTo(new PointOption().withCoordinates(x1,y1))
                .release().perform();
        logger.info("Sayfa Scroll edildi");
    }


    @Step("Rasgele bir ürün seç")
    public void selectRondamproduct(){
        Random random = new Random();
        List<MobileElement> urun = appiumDriver.findElements(By.xpath("//*[@resource-id = 'com.ozdilek.ozdilekteyim:id/recyclerView']/android.widget.FrameLayout"));
        MobileElement randomUrun =  urun.get(random.nextInt(urun.size()-1));
        randomUrun.click();
    }

    @Step("<id> İd'li elemente <text> değerini yaz")
    public void sendKeysid(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
    }


    /*
    @Step("Kadın seçenegine tıklama")
    public void menuSelectFemale(){
        appiumDriver.findElement(By.xpath("//*[@resource-id = 'com.ozdilek.ozdilekteyim:id/recyclerCategories']/android.widget.RelativeLayout[2]")).click();
    }

    @Step("Pantolon kategorisi açılır")
    public void menuSelectPants(){

        appiumDriver.findElement(By.xpath("//*[@resource-id = 'com.ozdilek.ozdilekteyim:id/recyclerCategories']/android.widget.RelativeLayout[12]")).click();
    }


    @Step("Sayfayı bir kere asagi kaydir")
    public void scrolOne(){
        (new AndroidTouchAction(appiumDriver)).press(new PointOption().withCoordinates(539,1602))
                .moveTo(new PointOption().withCoordinates(539,533))
                .release().perform();
        logger.info("Sayfa Scroll edildi");
    }

    @Step("Sayfayı ikinci defa asagi kaydir")
    public void scrolTwo(){
        (new AndroidTouchAction(appiumDriver)).press(new PointOption().withCoordinates(539,1560))
                .moveTo(new PointOption().withCoordinates(539,401))
                .release().perform();
        logger.info("Sayfa Scroll edildi");
    }

    @Step("Favoriler ekleme")
    public void productFavoriteAdd(){
        appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/relLayAddFav")).click();
    } */

}
