package com.cg.hotelBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPageFactory {
WebDriver driver;

//step 1:Identify element

public HotelBookingPageFactory(WebDriver driver) {
	super();
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(name="txtFN")
@CacheLookup
WebElement pffname;

//using how class

@FindBy(how=How.ID,using="btnPayment")
@CacheLookup
WebElement pfbutton;

@FindBy(xpath="//*[@id='txtLastName']")
@CacheLookup
WebElement pflname;

@FindBy(how=How.NAME,using="Email")
@CacheLookup
WebElement pfemail;

@FindBy(css="input[pattern='[789][0-9]{9}']")
@CacheLookup
WebElement pfmobile;

@FindBy(how=How.NAME,using="city")
@CacheLookup
WebElement pfcity;

@FindBy(how=How.NAME,using="state")
@CacheLookup
WebElement pfstate;

@FindBy(how=How.NAME,using="persons")
@CacheLookup
int pfpersons;

@FindBy(xpath="//*[@id='rooms']")
@CacheLookup
WebElement pfrooms;

@FindBy(how=How.ID,using="txtCardholderName")
@CacheLookup
WebElement pfcardholder;

@FindBy(id="txtDebit")
@CacheLookup
WebElement pfdebit;

@FindBy(name="cvv")
@CacheLookup
WebElement pfcvv;

@FindBy(name="month")
@CacheLookup
WebElement pfmonth;

@FindBy(name="year")
@CacheLookup
WebElement pfyear;

public void setPffname(String sfname)
{
	pffname.sendKeys(sfname);
}

public void setpfbutton() {
	pfbutton.click();
}

public void setPflname(String slname) {
	pflname.sendKeys(slname);
}

public void setPfemail(String semail) {
	pfemail.sendKeys(semail);
}

public void setPfmobile(String smobile) {
	pfmobile.sendKeys(smobile);
}

public void setPfcity(String scity) {
	Select drpCity=new Select(pfcity);
	drpCity.selectByVisibleText(scity);
}

public void setPfstate(String sstate) {
	Select drpState=new Select(pfstate);
	drpState.selectByVisibleText(sstate);
}

public void setPfpersons(int arg1)
{
	pfpersons=arg1;
}

public void setpfcardholder(String scardholder) {
	pfcardholder.sendKeys(scardholder);
}

public void setpfdebit(String sdebit) {
	pfdebit.sendKeys(sdebit);
}

public void setpfcvv(String scvv) {
	pfcvv.sendKeys(scvv);
}

public void setpfmonth(String smonth) {
	pfmonth.sendKeys(smonth);
}

public void setpfyear(String syear) {
	pfyear.sendKeys(syear);
}
//getters

public WebElement getPffname() {
	return pffname;
}

public WebElement getPfbutton() {
	return pfbutton;
}

public WebElement getPflname() {
	return pflname;
}

public WebElement getPfemail() {
	return pfemail;
}

public WebElement getPfmobile() {
	return pfmobile;
}

public WebElement getPfcity() {
	return pfcity;
}

public WebElement getPfstate() {
	return pfstate;
}

public int getPfpersons() {
	return pfpersons;
}

public WebElement getPfrooms() {
	return pfrooms;
}

public WebElement getPfcardholder() {
	return pfcardholder;
}

public WebElement getPfdebit() {
	return pfdebit;
}

public WebElement getPfcvv() {
	return pfcvv;
}

public WebElement getPfmonth() {
	return pfmonth;
}

public WebElement getPfyear() {
	return pfyear;
}

}