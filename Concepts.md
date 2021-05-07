### Selenium Questions and answers

## How to pass command line arguments using maven in selenium

Maven has the feasibility of passing arguments from command line when running the selenium suite using maven.



1. We have to add the *maven-surefire-plugin* in the pom file along with the tag **systemPropertyVariables** in which required variables are defined as below.
2. If you notice, Here we have three variables **username, password, domain** in starting and closing tags.

```
<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<!-- <version>2.17</version> -->
				<version>3.0.0-M5</version>
				<configuration>
				 	
	<systemPropertyVariables>
            	<username></username>
    		<password></password>
    		<domain></domain>
        </systemPropertyVariables>
					
					<useSystemClassLoader>false</useSystemClassLoader>
					<argLine>-Djdk.net.URLClassPath.disableClassPathURLCheck=true</argLine>
					<suiteXmlFiles>
						<suiteXmlFile>testng.xml</suiteXmlFile>
					</suiteXmlFiles>
				</configuration>
			</plugin>
```

3. Next step is to retrieve these values in the script by using system.getproperty. Please find the sample code below.

```
    		System.out.println("username :" + System.getProperty("username"));
		System.out.println("Password : " + System.getProperty("password"));
		System.out.println("Domain : " + System.getProperty("domain"));
```
4. Last step is running with the maven command as below:
```
mvn clean test -Dusername='bkckrao' -Dpassword=passwordvalue -Ddomain=ckdomain
```
5. Find the output below:

```
username :bkckrao
Password : passwordvalue
Domain : ckdomain
```
