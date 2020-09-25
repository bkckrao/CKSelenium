step by step process of creating a script and executing.


-   write url and the following in  the config file

        url = https://www.naukri.com/
        testdatafile = Naukri_test_data.xlsx
        testdatasheet= Sheet1
        browser = Chrome
   Please find the same in the [config](/../../Config.properties)

-   Place the Naukri_test_data.xlsx in Testdata folder.
-   Place your resume in the Testdata folder

-   write the page object file *Naukri_Ids* which is in **src/main/java/com.Bachu.Pages**

-   write the script like *NaukriUpdate.java* which is in
**src/main/java/com.Bachu.Scripts**

-    Reports can be seen in the *Reports* folder