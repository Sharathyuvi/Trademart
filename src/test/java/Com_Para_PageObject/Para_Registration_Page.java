package Com_Para_PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Para_Registration_Page {
	public static WebDriver driver;
	
	
	//1) constructor	
	public Para_Registration_Page(WebDriver dr) {
		this.driver=dr;
		PageFactory.initElements(dr, this);
	}
	
	//elements
	@FindBy(xpath="//a[text()='Register']")
	WebElement linkRegistration;
	
	@FindBy(id="customer.firstName")
	WebElement txtFirstname;
	
	@FindBy(id="customer.lastName")
	WebElement txtLastname;
	
	@FindBy(id="customer.address.street")
	WebElement txtAddress;
	
	@FindBy(id="customer.address.city")
	WebElement txtCity;
	
	@FindBy(id="customer.address.state")
	WebElement txtState;
	
	@FindBy(id="customer.phoneNumber")
	WebElement txtphonenum;
	
	@FindBy(id="customer.address.zipCode")
	WebElement txtzipcode;
	
	@FindBy(id="customer.ssn")
	WebElement txtssn;
	
	@FindBy(id="customer.username")
	WebElement txtusername;
	
	@FindBy(id="customer.password")
	WebElement txtpassword;
	
	@FindBy(id="repeatedPassword")
	WebElement txtconfirmpassword;
	
	
	//actions
	
	public void linkreg() {

		linkRegistration.click();
	}
	
	public void setFirstname(String Fname) {
		txtFirstname.sendKeys(Fname);
	}
	
	public void setLastname(String Lname) {
		txtLastname.sendKeys(Lname);
	}
	
	public void setaddress(String Address) {
		txtAddress.sendKeys(Address);
	}
	
	public void setcity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void setstate(String state) {
		txtState.sendKeys(state);
	}
	
	public void setphonenum(String pnum) {
		txtphonenum.sendKeys(pnum);
	}
	
	public void setzipcode(String zip) {
		txtzipcode.sendKeys(zip);
	}
	
	public void setssn(String ssn) {
		txtssn.sendKeys(ssn);
	}
	
	public void setusername(String username) {
		txtusername.sendKeys(username);
	}
	
	public void setpassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void setCpassword(String conformationpassword) {
		txtconfirmpassword.sendKeys(conformationpassword);
	}
	
	}
