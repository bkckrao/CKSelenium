# Automation_framework
====================================================

[Overview](#Overview)

[PageObjects](#Page-Objects)

[How to write page Objects](#How-to-write-page-Objects)

[How to maintain Testdata](#How-to-maintain-Testdata)

[How to write Reporting](#How-to-write-Reporting)

[How to write scripts](#How-to-write-scripts)

[Tools Installation by Script](#Tools-Installation-by-Script)

[Get start with this framework](/Installs/docs/More_On_ckFramework.md)

[Autoit](/Installs/docs/Autoit.md)

**Overview:**

Automation Framework is a set of guidelines	and rules used for scripting and controlling the execution of tests  comparison of actual outcomes and expected outcomes. It integrates testdata, object handling and library functions.

**Prerequisite:**
Automation engineer need to have basic knowledge on Java, Xpath.



**DataDrivenFramework:** This is the widely used type of framework. It separates test data from the scripts by which maintenance is easier.

**PageObjectModel:** Each webpage in the application has a corresponding class that holds elements of that webpage. It is maintenance of objects in a class and naming them as corresponding Pages

**Language :** In our Selenium Project we are using Java language. Even though Selenium supports multiple languages, we have chosen Java language just because most of the automation developers have knowledge on Java

**Config.properties** - Global configurations that can be used across the project are placed in this file like Browser, TestdataFile, TimeOutPeriod etc.

**BaseTest**
- This class is responsible for reading the properties file, assigning the values to defined class variables
- Any framework class would like to make use of the members (variables, methods) of this class, needs to extends BaseTest.Java class.
- Webdriver object initializes in this class and traverse through framework classes and then scripts.

**Packages:** We are maintaining different packages for pages and scripts.
For ex: 
- com.Diyar.ProjectName.pages
- com.Diyar.ProjectName.Scripts





# Page Objects
## How to write page Objects
Page Object is a Design Pattern which has become popular in test automation for enhancing test maintenance and reducing code duplication. A page object is an object-oriented classes

- Each webpage in the application should have a page object class.
- create a class with reasonable name, For example DSP_HomePage.java, DSP_LoginPage.java
-  Xpath is the default option and not required to specify. so if the element is not Xpath, it should be declared like type.ID where Type is the Enum.
- All elements should be declared static, Sample below
```
public static Textfield UserName = new Textfield("Username", Type.ID);
public static Textfield Password = new Textfield("Password", Type.ID);
public static Button LoginButton = new  Button("//button[@id = \"btnLogin\"]");
public static Button PageinArabic = new Button("//span[@id='langChange']/i/span[contains(text(), 'English')]");
public static Label Heading = new Label("//h3[contains(text(), 'DSP Document Signer')]");
public static SelectBox pagesize = new SelectBox("//select[@id='sdrpPageSize']");
```

# How to write scripts

- Naming convention of script class : **modulename_TS_01_Functionality**
- Every script should extend **FrameLib.java**
- Common functionalities of a module can be created as reusable methods and placed in class file as script_Library
- Variables declaration as sEnglishTitle, where s is the String.
- Class should start with Capital Letter 
- Methods, variables should start with small Letter
Reusable methods of Application can be created with naming **Modulename_Library** and make this as superclass for the script




# How to maintain Testdata
------------------------------------------------------
test data is maintained in Excel sheets 
Testdata file should be placed in the folder **Testdata**
Testdata file name, sheet name should be declared in config.properties

Each script should have the following lines in initialize() to get the names of Testdata file and sheet name, See example below:
- sTestdataFile = getproperty("testdatafile");
- sTestdataSheet = getproperty("testdatasheet");

sample test data creation:
| TestScriptName                        | Username | Password   |
|---------------------------------------|----------|------------|
| dsp_TS01_Login_with_Valid_Credentials | DspUser1 | Gl0bl3@d$P |
| dsp_TS02_Login_with_Invalid_UserName  | Invalid  | Gl0bl3@d$P |
| dsp_TS03_Login_with_Invalid_Password  | DspUser1 | Invalid    |

dsp_TS01_Login_with_Valid_Credentials - this is the test script name 
Username - this is the field used to get the value 

Excel workbook name should be written in Config.properties
- testdatafile = DSP_Testdata.xlsx


**Each test script should have these values**

getdata("Username");

-   Testscript name should be written in first column 
-	You can organize test data in sheets, how ever not required to specify the sheet name. Our framework can identify the Testscript name and get the data
in the testdata sheet that filters the value horizontally, here our framework dynamically captures the method name and assigns to the variable sThisMethod.
-   parameter4 - Username is the column heading in the testdata file that filters text

## Sample of getdata methods.
	System.out.println("user value 2 : " + getdata("Username"));
	System.out.println("user value 3 : " + getdata("Password"));
	

# Reporting
## How to write Reporting

Report generation is built in our automation framework. 
Name of the report can be taken as the class name append with date and time. For ex **DSP_Login_03-09-2020_02.03.51**

Each method is considered as one TestScript and report is generated for each script. 
Here we are considering the method name as the script name and the same name has been maintained in testdata sheet and the report.
As an engineer your job is just to write the reporting statements where required. Sample [here](#How-to-write-the-Pass-and-Fail-reports)

## How to write the Pass and Fail reports

we have customized the reporting that can be written in the following ways:

The second boolean parameter represents to take screenshot or not. Screenshot will be displayed in the report as below

```
Reporting.pass("Pass Description");
Reporting.pass("Pass Description", true);
Reporting.fail("Fail Description");
Reporting.fail("Fail Description", true);
Reporting.Info("Information");
Reporting.Info("Information", true); 
```
![ReportScreenshot](Installs/docs/ReportScreenshot.png)

**Tools Installation by Script:**

- Download the GitHub repository provided to your project
- Go to **Installs** folder
- Double click the Batch file **Enable_To_Run.bat**
- Run the file **Run_Installations** in Administrator Powershell and provide your options for the softwares:


		
		Do you want to install Eclipse ? (Y/N)

		Do you want to install OpenJDk	? (Y/N)

		Do you want to install Git	? (Y/N)


**Manual Installations:**

- *Eclipse*  : Eclipse can be downloaded from the [link](https://www.eclipse.org/downloads/packages/release/2018-09/r/eclipse-ide-java-ee-developers)
- *Java*   : Copy the folder Installs to the local and run the Install_Openjdk.ps1 in Elevated shell.
- *TestNG* : This can be handled with pom.xml
- *Extent* : This can be handled with pom.xml
- *Git*	   : Copy the folder from docs/Scripts to the local folder and run the Install_Git.ps1 in Elevated shell.
