package com.cg.stepDefs;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import com.cg.hotelBean.HotelBookingPageFactory;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class HotelBookingStepDefs1 {

    static WebDriver driver;
    private HotelBookingPageFactory hotelBookingPageFactory;

    @Before
    public void openBrowser() {
    //  driver = new FirefoxDriver();
        String driverPath = "D:\\\\\\\\Selenium\\\\\\\\chromedriver_win32\\\\\\\\";
        System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");   
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //  hotelBookingPageFactory=new HotelBookingPageFactory(driver);
    //  driver.get("file:///D:/Selenium/Lesson%205-HTML%20Pages/App/hotelbooking.html");

    }

    @Given("^User is on hotel booking page$")
    public void user_is_on_hotel_booking_page() throws Throwable {
        hotelBookingPageFactory = new HotelBookingPageFactory(driver);
        driver.get("file:///D:/mmuthuva_Madhu/hotelbooking.html");
    }

    @Then("^check the title of the page$")
    public void check_the_title_of_the_page() throws Throwable {
        String title=driver.getTitle();
        if(title.contentEquals("Hotel Booking")) System.out.println("****** Title Matched");
        else System.out.println("****** Title NOT Matched");
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        
    }
    
    @When("^user enters all valid data$")
    public void user_enters_all_valid_data() throws Throwable {
        hotelBookingPageFactory.setPffname("madhu");  Thread.sleep(100);
        hotelBookingPageFactory.setPflname("M");   Thread.sleep(100);
        hotelBookingPageFactory.setPfemail("madhu@gmail.com");  Thread.sleep(100);
        hotelBookingPageFactory.setPfmobile("7834567372");  Thread.sleep(100);
        hotelBookingPageFactory.setPfcity("Pune");  Thread.sleep(100);
        hotelBookingPageFactory.setPfstate("Maharashtra");  Thread.sleep(100);
        hotelBookingPageFactory.setPfpersons(5);    Thread.sleep(1000);
        hotelBookingPageFactory.setpfcardholder("madhu M");  Thread.sleep(100);
        hotelBookingPageFactory.setpfdebit("5678567867897890"); Thread.sleep(100);
        hotelBookingPageFactory.setpfcvv("067");    Thread.sleep(100);
        hotelBookingPageFactory.setpfmonth("5");    Thread.sleep(100);
        hotelBookingPageFactory.setpfyear("2020"); 
    //  driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
        hotelBookingPageFactory.setpfbutton();
    }

    @Then("^navigate to welcome page$")
    public void navigate_to_welcome_page() throws Throwable {
        driver.navigate().to("file:///D:/Lesson%205-HTML%20Pages/success.html");
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
    }
    
    @When("^user leaves first Name blank$")
    public void user_leaves_first_Name_blank() throws Throwable {
        hotelBookingPageFactory.setPffname(""); 
    }

    @When("^clicks the button$")
    public void clicks_the_button() throws Throwable {
        hotelBookingPageFactory.setpfbutton();
    }

    @Then("^display alert msg$")
    public void display_alert_msg() throws Throwable {
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println("******" + alertMessage);
       
    }
    @When("^user leaves last Name blank and clicks the button$")
    public void user_leaves_last_Name_blank_and_clicks_the_button() throws Throwable {
    
        hotelBookingPageFactory.setPffname("madhu");  
        hotelBookingPageFactory.setPflname(""); 
        hotelBookingPageFactory.setpfbutton();
    }
    @When("^user enters all data$")
    public void user_enters_all_data() throws Throwable {
        hotelBookingPageFactory.setPffname("madhu");  Thread.sleep(100);
        hotelBookingPageFactory.setPflname("M");   Thread.sleep(100);
        hotelBookingPageFactory.setPfemail("madhu@gmail.com");  Thread.sleep(100);
        hotelBookingPageFactory.setPfmobile("7834567372");  Thread.sleep(100);
        hotelBookingPageFactory.setPfcity("Pune");  Thread.sleep(100);
        hotelBookingPageFactory.setPfstate("Maharashtra");  Thread.sleep(100);
        hotelBookingPageFactory.setPfpersons(5);    Thread.sleep(100);
        hotelBookingPageFactory.setpfcardholder("madhu M");  Thread.sleep(100);
        hotelBookingPageFactory.setpfdebit("5671234567899876"); Thread.sleep(100);
        hotelBookingPageFactory.setpfcvv("056");    Thread.sleep(100);
        hotelBookingPageFactory.setpfmonth("9");    Thread.sleep(100);
        hotelBookingPageFactory.setpfyear("2020");  Thread.sleep(100);
    }

    @When("^user enters incorrect email format and clicks the button$")
    public void user_enters_incorrect_email_format_and_clicks_the_button() throws Throwable {
        hotelBookingPageFactory.setPfemail("Ma7@.com"); Thread.sleep(100);
        hotelBookingPageFactory.setpfbutton();
    }
    
    @When("^user leaves MobileNo blank and clicks the button$")
    public void user_leaves_MobileNo_blank_and_clicks_the_button() throws Throwable {
        hotelBookingPageFactory.setPffname("madhu");  Thread.sleep(100);
        hotelBookingPageFactory.setPflname("M");   Thread.sleep(100);
        hotelBookingPageFactory.setPfemail("madhu@gmail.com");  Thread.sleep(100);
        hotelBookingPageFactory.setPfmobile("");    Thread.sleep(100);
        hotelBookingPageFactory.setpfbutton();
    }

    @When("^user enters incorrect mobileNo format and clicks the button$")
    public void user_enters_incorrect_mobileNo_format_and_clicks_the_button(DataTable arg1) throws Throwable {
        hotelBookingPageFactory.setPffname("madhu");  Thread.sleep(100);
        hotelBookingPageFactory.setPflname("M");   Thread.sleep(100);
        hotelBookingPageFactory.setPfemail("madhu@gmail.com");  Thread.sleep(100);
                
        List<String> objList = arg1.asList(String.class);
        //objhbpg.setPfmobile(objList); Thread.sleep(1000);
        hotelBookingPageFactory.setpfbutton();
        
        for(int i=0; i<objList.size(); i++) {
            if(Pattern.matches("^[7-9]{1}[0-9]{9}$", objList.get(i))) {
            System.out.println("***** Matched" + objList.get(i) + "*****");
            }
            else {
                System.out.println("***** NOT Matched" + objList.get(i) + "*****");
            }
        }
    }
    @When("^user doesnot select city$")
    public void user_doesnot_select_city() throws Throwable {
        hotelBookingPageFactory.setPffname("madhu");  Thread.sleep(100);
        hotelBookingPageFactory.setPflname("M");   Thread.sleep(100);
        hotelBookingPageFactory.setPfemail("madhu@gmail.com");  Thread.sleep(100);
        hotelBookingPageFactory.setPfmobile("7722005480");  Thread.sleep(100);
        hotelBookingPageFactory.setPfcity("Select City");   Thread.sleep(100);
        hotelBookingPageFactory.setpfbutton();
    }

    @When("^user doesnot select state$")
    public void user_doesnot_select_state() throws Throwable {
        hotelBookingPageFactory.setPffname("madhu");  Thread.sleep(100);
        hotelBookingPageFactory.setPflname("M");   Thread.sleep(100);
        hotelBookingPageFactory.setPfemail("madhu@gmail.com");  Thread.sleep(100);
        hotelBookingPageFactory.setPfmobile("7722005480");  Thread.sleep(100);
        hotelBookingPageFactory.setPfcity("Pune");  Thread.sleep(100);
        hotelBookingPageFactory.setPfstate("Select State"); Thread.sleep(100);
        hotelBookingPageFactory.setpfbutton();
    }
    @When("^user enters (\\d+)$")
    public void user_enters(int arg1) throws Throwable {
        hotelBookingPageFactory.setPffname("madhu");  Thread.sleep(100);
        hotelBookingPageFactory.setPflname("M");   Thread.sleep(100);
        hotelBookingPageFactory.setPfemail("madhu@gmail.com");  Thread.sleep(100);
        hotelBookingPageFactory.setPfmobile("7722005480");  Thread.sleep(100);
        hotelBookingPageFactory.setPfcity("Pune");  Thread.sleep(1000);
        hotelBookingPageFactory.setPfstate("Maharashtra");  Thread.sleep(100);
        hotelBookingPageFactory.setPfpersons(arg1); Thread.sleep(2000);
    
    }

    @Then("^allocate rooms such that (\\d+) room for minimum (\\d+) guests$")
    public void allocate_rooms_such_that_room_for_minimum_guests(int arg1, int arg2) throws Throwable {
        if(arg2 <=3) {
            System.out.println("***** 1 room");
            assertEquals(1, arg1);
        }
        else if(arg2 <=6){
            System.out.println("***** 2 rooms");
            assertEquals(2, arg1);  
        }    
        else if(arg2 <=9){
            System.out.println("***** 3 rooms");
            assertEquals(3, arg1);  
        }
    }

    @When("^user leaves CardHolderName blank and clicks the button$")
    public void user_leaves_CardHolderName_blank_and_clicks_the_button() throws Throwable {
        hotelBookingPageFactory.setPffname("madhu");  Thread.sleep(100);
        hotelBookingPageFactory.setPflname("M");   Thread.sleep(100);
        hotelBookingPageFactory.setPfemail("madhu@gmail.com");  Thread.sleep(100);
        hotelBookingPageFactory.setPfmobile("7722005480");  Thread.sleep(100);
        hotelBookingPageFactory.setPfcity("Pune");  Thread.sleep(100);
        hotelBookingPageFactory.setPfstate("Maharashtra");  Thread.sleep(100);
        hotelBookingPageFactory.setPfpersons(7);    Thread.sleep(100);
        hotelBookingPageFactory.setpfcardholder("");    Thread.sleep(100);
        hotelBookingPageFactory.setpfbutton();
    }

    @When("^user leaves DebitCardNo blank and clicks the button$")
    public void user_leaves_DebitCardNo_blank_and_clicks_the_button() throws Throwable {
        hotelBookingPageFactory.setPffname("madhu");  Thread.sleep(100);
        hotelBookingPageFactory.setPflname("M");   Thread.sleep(100);
        hotelBookingPageFactory.setPfemail("madhu@gmail.com");  Thread.sleep(100);
        hotelBookingPageFactory.setPfmobile("7722005480");  Thread.sleep(100);
        hotelBookingPageFactory.setPfcity("Pune");  Thread.sleep(100);
        hotelBookingPageFactory.setPfstate("Maharashtra");  Thread.sleep(100);
        hotelBookingPageFactory.setPfpersons(7);    Thread.sleep(100);
        hotelBookingPageFactory.setpfcardholder("madhu M");  Thread.sleep(100);
        hotelBookingPageFactory.setpfdebit(""); Thread.sleep(100);
        hotelBookingPageFactory.setpfbutton();
    } 

    @When("^user leaves expirationMonth blank and clicks the button$")
    public void user_leaves_expirationMonth_blank_and_clicks_the_button() throws Throwable {
        hotelBookingPageFactory.setPffname("madhu");  Thread.sleep(100);
        hotelBookingPageFactory.setPflname("M");   Thread.sleep(100);
        hotelBookingPageFactory.setPfemail("madhu@gmail.com");  Thread.sleep(100);
        hotelBookingPageFactory.setPfmobile("7722005680");  Thread.sleep(100);
        hotelBookingPageFactory.setPfcity("Pune");  Thread.sleep(100);
        hotelBookingPageFactory.setPfstate("Maharashtra");  Thread.sleep(100);
        hotelBookingPageFactory.setPfpersons(7);    Thread.sleep(100);
        hotelBookingPageFactory.setpfcardholder("madhu M");  Thread.sleep(100);
        hotelBookingPageFactory.setpfdebit("8765431234567898"); Thread.sleep(100);
        hotelBookingPageFactory.setpfcvv("098");    Thread.sleep(100);
        hotelBookingPageFactory.setpfmonth(""); Thread.sleep(100);
        hotelBookingPageFactory.setpfbutton();
    }

    @When("^user leaves expirationYr blank and clicks the button$")
    public void user_leaves_expirationYr_blank_and_clicks_the_button() throws Throwable {
        hotelBookingPageFactory.setPffname("madhu");  Thread.sleep(100);
        hotelBookingPageFactory.setPflname("M");   Thread.sleep(100);
        hotelBookingPageFactory.setPfemail("madhu@gmail.com");  Thread.sleep(100);
        hotelBookingPageFactory.setPfmobile("7722005680");  Thread.sleep(100);
        hotelBookingPageFactory.setPfcity("Pune");  Thread.sleep(100);
        hotelBookingPageFactory.setPfstate("Maharashtra");  Thread.sleep(100);
        hotelBookingPageFactory.setPfpersons(7);    Thread.sleep(100);
        hotelBookingPageFactory.setpfcardholder("madhu M");  Thread.sleep(100);
        hotelBookingPageFactory.setpfdebit("7678567867897890"); Thread.sleep(100);
        hotelBookingPageFactory.setpfcvv("056");    Thread.sleep(100);
        hotelBookingPageFactory.setpfmonth("8");    Thread.sleep(100);
        hotelBookingPageFactory.setpfyear("");  Thread.sleep(100);
        hotelBookingPageFactory.setpfbutton();
    }


    @After
    public void closeBrowser() {
        driver.close();
    }
}


