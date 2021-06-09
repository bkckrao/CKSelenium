# How to get start with this framework

[Installation & Setup:](#-Installation-&-Setup)

-	[Cloning the Repository](#Cloning-the-Repository:)

-	[Tools Installation](#Tools-Installation:)
-	[Importing the cloned repository](#Importing-the-cloned-repository)

[Project folders Explanation](#Project-folders-Explanation:)

[Writing Page Object pages](#Writing-Page-Object-pages)

[Writing Scripts](#Writing-Scripts)

[Explaining the Sample class](#Explaining-the-above-class)

[Browser versions](#Browser-versions)

[How to run as TestNG](#How-to-run-as-TestNG)

### Prerequisite:
Engineer should have basic skills on Java and OOPS concepts.


## Installation & Setup:

Please click [here](/Installs/docs/Installation_and_Setup.md) for Installation instructions


### **Importing the cloned/downloaded repository**
1. Open the Eclipse
2. *File* --> *Import*
3. In the Import dialogue, select *Maven* --> *Existing Maven Projects*  and click *Next*
4. Browse to the repository
5. Click *Finish*

Notice the project created in Eclipse. Now, we are ready with Java, TestNG and Eclipse with maven project setup.

## **Project folders Explanation:** 

- *src/test/java*    -   It is the place to write the Automation scripts
-   *drivers*   -   Place to store the drivers of browsers
-   *Reports*   -   Reports are generated in this folder with the name of the class appending with data and time to avoid the override of report.
-   *Testdata*  -   Testdata is maintained in the Excel which are stored in this folder
-   *Config.properties* -   It is a properties file that stores global values:
    -   Browser -   Chrome, IE, FF
    -   url -   URL
    -   testdatafile    -   name of testdata file like DSP_Testdata.xlsx
    -   testdatasheet   -   name of sheet in the testdata file like sheet1, logininfo, registrtion

-   Scripting: 
While scripting, we have to use two pacakges, Package1 ends with *Pages* is used for maintaining Page Object Pages and Package2 ends with *Scripts* is used for writing functional scripts
Writing the first Page Object page 

## Writing Page Object pages
Create a new class in the package with the proper name like HomePage, LoginPage, RegistrationPage etc and write the all the elements in the page. 

Please see the example class below:

```
public class DSP_LoginPage {

    public static Textfield UserName = new Textfield("Username", Type.ID);
	public static Textfield Password = new Textfield("Password", Type.ID);
	public static Button LoginButton = new  Button("//button[@id = 'btnLogin']");
	public static Button PageinArabicButton = new Button("//span[@id='langChange']/i/span[contains(text(), 'English')]");
	public static Label Heading = new Label("//h3[contains(text(), 'DSP Document Signer')]");
	public static Label UsernameOrPasswordIsWrongLabel = new Label("//span[@class='field-validation-error text-danger' and contains(text(), 'Username and/or password is wrong')]");
	public static Label InboxLabel = new Label("//a[@href = '/DSPStarterKit/']/i/following-sibling::span[contains(text(),'Inbox')]");
	public static Link LogoutLink = new Link("//a[@class='LogoutLink']");
    public static SelectBox abc = new SelectBox((WebElement) By.xpath("xpath"));

}
```

To explain, *public static* remain same for all the elements to access across the project.

keyword *Textfield* is a class that represents we are dealing with a textfield. Siimilarly we have *Button, Label, Link and SelectBox* . The word *new Textfield* creates an object for the class Textfield as UserName.

("Username", Type.ID); - This text Username with in quotes is the ID of the element Username textfield by which selenium identifies.
Apart from ID, we have other options as Name, CSS and XPATH. But XPATH is the popular and widely used type across the industry. so we have note XPATH as a default option. Notice the elements from the third line for reference. 

while writing the elements, Please refer this section for each type of elements. Also above samples have different ways of writing simple and complex XPATHs

## Writing Scripts

Create a class in the Package and extends to FrameLib. See the sample below:

```
public class ClassName extends ClassName_Library{

	private String username = getdata("Username");
	
	@BeforeSuite
	public void initialize() {
		Reporting.startReporting(this.getClass().getSimpleName());
		sTestdataFile = getproperty("testdatafile");
		sTestdataSheet = getproperty("testdatasheet");
	}

	@BeforeTest
	public void setUp() throws Exception {
		//		Browser.openBrowser(Select_Browser.FF);
		Browser.openBrowser();
		Browser.getURL(BaseTest.sURL);
		maximizethewindow(); deletecookies();
	}

	@AfterMethod
	public void aftereachmethod() {
		System.out.println("     xxxxx-----End of Test Methd-----xxxxx");
		Reporting.endTest();
	}

	@AfterSuite
	public void teardowndriver() {
		driver.quit();
		Reporting.reportflush();
		Reporting.reportclose();
	}

    /**
	 * Start the scripting from here
	 */
```
### Explaining the above class: 

**public class ClassName extends ClassName_Library** -   Here *ClassName_Library* is a Library class to write down the reusable methods used in the class *ClassName* 

 **private String getdata**   -   This implementation is a supporting method helps in retrieving testdata 

 **public void initialize()** -   This method will initialize the reporting and retrieves the testdata file and testdata sheet values  provided in the *config.properties*

 **public void setUp()**  -   This method will opens with browser provided in the *config.properties* and navigates to the URL provided in the *config.properties*.

 **public void aftereachmethod()**    -   This method will execute after each method and helpful for reporting.

 **public void teardowndriver()** -   This method will quit and close the browser.

 Notice the comment *Start the scripting from this place* from which Engineer starts writing methods. Each method is one testscript that maps with the manual testcase.

 ### **Writing Methods :**
 -  Method name should start with small letter
 -  Method name should have numbering like TS01
 -  Method should have **@Test** annotation from TestNG.
 -  Preferred Method format -   \<ModuleName\>_TS01_\<Functionality_Name\>
 -  Sample Method name -   dsp_TS01_Login_with_Valid_Credentials
 -  Each method should have first line of code as *Reporting.startTest(getmethodname(new Object() {}));*. It will helps in reporting.
-   *Reporting.pass("pass Description")*    -    This line will print success line in the report.
-   *Reporting.fail("FailDescription")*     -   This line will print failure line in the report
-   *Reporting.fail("FailDescription", __true__)*     -   This line will print failure line in the report along with screenshot of the application.

### Browser versions

-	Chrome	-	84
-	Firefox	-	68
-	InternetExplorer - 11


### How to run as TestNG

-	Right click on the script file --> Run as --> TestNG Test
-	To Debug Right click -->	Debug as --> TestNG Test.