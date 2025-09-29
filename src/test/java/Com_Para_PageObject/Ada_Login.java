package Com_Para_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ada_Login {
	public static WebDriver driver;
	
	public Ada_Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginbtn;
	
	
	public void setusername(String uname) {
		username.sendKeys(uname);
	}
	
	public void setpassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickloginbtn() {
		loginbtn.click();
	}

}
