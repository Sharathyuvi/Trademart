package Com_Para_TestCases;

import org.testng.annotations.Test;

import Com_Para_PageObject.Para_Registration_Page;

public class Tc_01_Registration_page extends Para_BaseClass{
	
	public Para_Registration_Page prp;
	@Test
	public void PararegistrationP() throws InterruptedException {
		prp = new Para_Registration_Page(driver);
		prp.linkreg();
		prp.setFirstname(rb.getString("FirstName"));
		log.info("Firstname Entered Successfully");
	    prp.setLastname(rb.getString("LastName"));
	    log.info("Lastname Entered Successfully");
	    prp.setaddress(rb.getString("Address"));
	    log.info("Address Entered Successfully");
	    prp.setcity(rb.getString("city"));		
	    log.info("City Entered Successfully");
		prp.setstate(rb.getString("state"));
		log.info("State Entered Successfully");
		prp.setzipcode(rb.getString("zipcode"));
		log.info("Zipcode Entered Successfully");
	    prp.setphonenum(rb.getString("phonenum"));
	    log.info("Phone number Entered Successfully");
	    prp.setssn(rb.getString("ssn"));
	    log.info("Ssn Number Entered Successfully");
	    
		prp.setusername(rb.getString("username"));
		log.info("Username Entered Successfully");
	    prp.setpassword(rb.getString("password"));
	    log.info("Password Entered Successfully");
	    prp.setCpassword(rb.getString("confirmpassword"));
	    log.info("Confirm password Entered Successfully");
	    
		Thread.sleep(3000);
	}
	
	

}
