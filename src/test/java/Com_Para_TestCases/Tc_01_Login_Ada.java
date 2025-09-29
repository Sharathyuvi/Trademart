package Com_Para_TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com_Para_PageObject.Ada_Login;
import Com_Para_Utilities.ExcellUtils;

public class Tc_01_Login_Ada extends Para_BaseClass{
	
	@Test(dataProvider = "Ada_LoginData")
	public void loginTest(String username,String pass) throws InterruptedException {
		Ada_Login al = new Ada_Login(driver);
		al.setusername(username);
		Thread.sleep(2000);
		al.setpassword(pass);
		Thread.sleep(2000);
		al.clickloginbtn();
		Thread.sleep(2000);
	}
	
	@DataProvider(name="Ada_LoginData")
	String [][] getData() throws IOException{
		String path = "C:\\Users\\Dell\\Desktop\\jp\\EMS_LMS\\src\\test\\java\\Com_Para_TestData\\Adactine_TestData.xlsx";
		
		//identify the row count
		int rownum = ExcellUtils.getRowCount(path, "Sheet1");
		
		//identify the cell count
		int cellnum = ExcellUtils.getcellcount(path, "Sheet1", 1);
		
		String Logindata [][] = new String [rownum][cellnum];
		for(int i=1;i<=rownum;i++) {	//it represent the row
			for(int j=0;j<cellnum;j++) {
				Logindata [i-1][j] = ExcellUtils.getcelldata(path, "Sheet1", i, j);
			}
		}
		
		return Logindata;
		
	}

}
