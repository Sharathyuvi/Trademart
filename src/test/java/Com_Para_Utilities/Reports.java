package Com_Para_Utilities;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com_Para_TestCases.Para_BaseClass;

public class Reports implements ITestListener   // interface
{

	//declare some varible
		public ExtentSparkReporter report;
		//It provides the Basic info about Document(ReportName,Document title,theme)
		public ExtentReports extent;
		//It will provide the info about users(username,OS,Browser,Environment,HostName)
		public ExtentTest test;
		//It will provide the abisc info about testCases(Pass,Faild,Skipped)
		
		//pre defined methods(OnStart,OnTestSuccess,OnTestFailure,OnTestSkipped,OnFinish)
		public void onStart(ITestContext tr) 
		{
			
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String reportname= "ParaBank_Reg "+timestamp +".html";
			
			report = new ExtentSparkReporter("C:\\Users\\Dell\\Desktop\\jp\\EMS_LMS\\extentreports\\" + reportname);
			report.config().setReportName("ParaBank");
			report.config().setDocumentTitle("ParaBankRegistrationFunctionality");
			report.config().setTheme(Theme.STANDARD);
			
			extent = new ExtentReports();
			extent.attachReporter(report);
			extent.setSystemInfo("UserName", "Sharath");
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("Environment", "QA Environment");
			extent.setSystemInfo("HostName", "Local Host");
		}
		
		public void onTestSuccess(ITestResult tr) {
			test = extent.createTest(tr.getName());
			test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		}
		
		public void onTestFailure(ITestResult tr)
		{
			test = extent.createTest(tr.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
			
			//  If you want a testcase to get failed and generate in reports uncomment below lines and in data class comment any line 
			
			/*   try {
			     String img=new Para_BaseClass().capturescreenshot(tr.getName());
			     test.addScreenCaptureFromPath(img);
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}   */
		
		
		}
			
		
		public void onTestSkipped(ITestResult tr) {
			test = extent.createTest(tr.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
		}

		public void onFinish(ITestContext context) {	
			extent.flush();				//It will remove the un-neccessary data
		}
		}



