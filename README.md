[Automation Framework](#Automation-Framework)

[DataDrivenFramework](#DataDrivenFramework)

[CKSelenium - Framework Introduction](#CKSelenium\--\-Automation-Framework)

[How to use this framework:](#How-to-use-this-framework:)

-	[How to write page Objects](How-to-write-page-Objects)

	-	[Sample Page Object Class](#Sample-Page-Object-Class)

	-	[Standards on Script writing](#Standards-on-Script-writing)

-	[How to get the data from Excel:](#How-to-get-the-data-from-Excel:)

	-	[Sample script of getting data from excel](#sample-script-of-getting-data-from-excel)

[Reporting](#Reporting)

-	[How to write Reporting](#How-to-write-Reporting)

	-	[Sample Report](#Sample-Report)

[Installation and Setup](/Installs/docs/Installation_and_Setup.md)

[Detailed Instructions](/Installs/docs/Get_MoreDetails_On_ckFramework.md)
## Automation Framework
Automation Framework is a set of guidelines	and rules for creating and designing test scripts. Framework executes the scripts by comparing actual outcome and expected outcome. It integrates testdata, object handling and library functions.


## DataDrivenFramework 
A data-driven approach is also possible, where the test framework supplies "inputs" and observes a series of corresponding "outputs."
This is the widely used type of framework. It separates test data from the scripts by which maintenance is easier.

# CKSelenium - Automation Framework
## Introduction:
*CKSelenium* is an Automation Framework based on Data Driven Approach used for web applications. This framework can be utilized by beginner, as we have provided the detailed process of documentation and examples for easy understanding. 

*Every beginner will love to use **CKSelenium** framework.*

CKSelenium is developed for selenium with Java. 

Note the tools:

 -	Eclipse	-	IDE for scripting
 -	Selenium	- Open source Automation tool for web applications
 -	TestNG	-	Testing framework for Java programming language
 -	Maven	-	Maven is a tool that can be used for building and managing any Java-based project. Maven is a powerful project management tool that is based on POM (project object model). It is used for projects build, dependency and documentation. It simplifies the build process
 -	Excel Plugins to read the data from Excel
 -	Basic HTML to get the reports 



**Config.properties** - Global configurations that can be used across the project are placed in this file like Testdatapath, ProjectDirectory, Reportspath etc.

**BaseTest**
- This class is responsible for reading the properties file, assigning the values to defined class variables
- Any framework class would like to make use of the members (variables, methods) of this class, needs to extends BaseTest.Java class.
- Webdriver object initializes in this class and traverse through framework classes and then scripts.

**Packages:** We are maintaining different packages for pages and scripts.
For ex: 
- com.Bachu.Selenium.Pages
- com.Bachu.Selenium.Scripts

# How to use this framework:


## How to write page Objects
Page Object is a Design Pattern which has become popular in test automation for enhancing test maintenance and reducing code duplication. A page object is an object-oriented classes

- Each webpage in the application should have a page object class in package **com.Bachu.Selenium.Pages**
- create a class with reasonable name, For example Naukri_HomePage.java, Naukri_LoginPage.java
-  Xpath is the default option and not required to specify. so if the element is not Xpath, it should be declared like type.ID where Type is the Enum.
- All elements should be declared static, Please see the Sample class below


## Sample Page Object Class

```
public class Naukri_Ids {

	public static Link loginLink = new Link("//div[contains(text(),'Login')]");
	public static Textfield usernametf = new Textfield("//input[@placeholder='Enter your active Email ID / Username']");
	public static Textfield passwordtf = new Textfield("//input[@placeholder='Enter your password']");
	public static Button loginButton = new Button("//button[@class='btn-primary loginButton']");
	public static Link myNaukriLink = new Link("//div[contains(text(),'My Naukri')]"); 
	public static Link editProfileLink = new Link("//a[contains(text(),'Edit Profile')]");
	public static Link logoutLink = new Link("//a[@class='logout-gnb'][@title='Logout']");
	public static Button updateResumeButton = new Button("#attachCV", Type.CSS);
	public static Label successmsg = new Label("//span[@id='attachCVMsgBox']");	
	public static Label uploadedon = new Label("//span[@class='updateOn']");
	public static SelectBox abc = new SelectBox((WebElement) By.xpath("xpath"));

}
```

Now we have elements of Username, Password, login button etc...

Now to write the script on usertextfield, Just call the object usertextfield that follows the methods used for the Textfield which are overridden methods of Selenium Webdriver.

Similarly same goes for Label, Link, Button etc. So you don't have to call the driver or mostly used webdriver commands are equipped with those elements.



## Standards on Script writing

- Naming convention of script class : **modulename_TS_01_Functionality**
- Every script should extend **FrameLib.java**
- Common functionalities of a module can be created as reusable methods and placed in class file as script_Library
- Variables declaration as sEnglishTitle, where s is the String.
- Class should start with Capital Letter 
- Methods, variables should start with small Letter
Reusable methods of Application can be created with naming **Modulename_Library** and make this as superclass for the script

sample of writing scripts:

	Naukri_Ids.loginLink.click();
	Naukri_Ids.usernametf.setText("name@email.com", "user name text field");
	Naukri_Ids.passwordtf.setText("Pass@123", "Password text field");
	Naukri_Ids.loginButton.click("Login Button");


## How to get the data from Excel:

Each test script should have these values

getdata(testdatafile,"Sheet1", getmethodname(new Object() {}), "Username"));

parameter1 - testdatafile is the name of testdata file
parameter2 - sheet1 is the name of the sheet with in the Excel workbook
paramter3 - getmethodname(new Object() {}) is the text in the row that filters the value horizontally, here by using the getmethod we are considering the method name and the sma method name should be passed in the excelsheet.
parameter4 - Username is the column heading in the testdata file that filters text


## sample script of getting data from excel

```
// getdata(sTestdataFile, sTestdataSheet, rowheading, columnHeading)
usernamevalue = getdata(sTestdataFile, sTestdataSheet, getmethodname(new Object() {}), "username")
passwordvalue = getdata(sTestdataFile, sTestdataSheet, getmethodname(new Object() {}), "password")

Naukri_Page_Ids.usertextfield.setText(usernamevalue, passwordvalue);
```
Naukri_Page_Ids - this is the class where elements are written
usertextfield  -  element in the class for the Username field
setText  -  Method in the Textfield class to write the data to username from hte excel.
getdata  -  This is the method to get data base on the column name and row name which are passed as parameters for this method
sTestdataFile - test data file name that can be retrieved from config.properties.
Sheet1 - Name of the sheet, incase of having multiple sheets in the work book
Username  -  this is the heading for the column
Naukri_ProfileUpdate	-	this is the row in the test data file
UsernameTextField  -  This is just a text for reference and it will display in the reports.

# Reporting
Report will be created in the Reports folder with a time stamp. So when you run the script again and again, it will not overwrite the report.



## How to write Reporting
Each test script should have the following line in initialize() method which is with TestNG annotation BeforeSuite
- **Reporting.startReporting(this.getClass().getSimpleName());**

So, name of the report can be taken as the class name append with date and time. For ex **Naukri_Login_24-09-2020_02.03.51**

Each method is considered as one Testscript and should have the following as the first line of code:
**Reporting.startTest(getmethodname(new Object() {}));**
Here we are considering the method name as the script name and the same name has been maintained in testdata sheet and the report.

## How to write the Pass and Fail reports

we have customized the reporting and the reporting can be written in the following ways:

```
Reporting.pass("Pass Description");
Reporting.fail("Fail Description");
Reporting.fail("Fail Description", Screencapture); 
```
-	Screencapture is a boolean and can show the screenshot incase of specified as true.

## Sample Report
![ReportScreenshot](Installs/docs/ReportScreenshot.png)







Update your naukri resume with our Framework:

We have created a sample script to update your resume on naukri.

