# AutoIT

## Overview
Autoit is used to automate the windows GUI. It will be helpful to deal with windows dialogues which are not possible with Selenium.

## How to install Autoit
Run the [Install_autoit](/Installs/Install_autoit.ps1) file as Administrator.

Once installation is finished, we can see SciTE script editor, Autoit installed in the system.

## Autoit Instructions:
-	SciTE is the IDE used for scripting of window based GUI.
-	Autoit is used to identify the elements in the windows GUI
	-	In Autoit, there is a section called *Finder Tool* which we have to point on the element we have to identify by drag and drop.
	- Auto it commands [list](https://www.autoitscript.com/wiki/Function_list)
	- Autoit script file should have extension as au3, so file looks like *scriptname.au3*
	- When scripting is completed, we have the compile the script file that generates exe file. To compile Right click --> Compile
	-	*scriptname.exe* will be generated.
	-	pass the path of generated exe file as parameter to the method *runAutoit(String autoitexepath)* in Util.
	-	If exists parameter, use the method *runAutoit(String autoitexepath, String param1)*. Remember to pass the parameter in the script as $cmdline[1].
