Add-Type -AssemblyName System.IO.Compression.FileSystem

# Install TestNG plugin to eclipse through script

$FileNameZip = "C:/org.testng.eclipse.updatesite.zip"
$FileName = "C:/org.testng.eclipse.updatesite"
$zipdest = $PSScriptRoot

# downlod the zip from the link https://dl.bintray.com/testng-team/testng-eclipse-release/zipped/7.3.0.202008060412/org.testng.eclipse.updatesite.zip
# iex ((New-Object Net.Webclient).DownloadString('https://dl.bintray.com/testng-team/testng-eclipse-release/zipped/7.3.0.202008060412/org.testng.eclipse.updatesite.zip'))


Invoke-WebRequest -Uri "https://dl.bintray.com/testng-team/testng-eclipse-release/zipped/7.3.0.202008060412/org.testng.eclipse.updatesite.zip" -UseBasicParsing -OutFile $FileNameZip

# Unzipping the file

# This will extract the eclipse zip from the choco downloaded folder to C:\users\<User>
      [System.IO.Compression.ZipFile]::ExtractToDirectory($FileNameZip , $FileName)

# This file contains two folders named as “features” and “plugins“.

    Copy-Item -Path "$FileName/plugins" -Recurse -Destination "$env:USERPROFILE/eclipse/dropins/testng-eclipse-7.3.0/plugins"
    Copy-Item -Path "$FileName/features" -Recurse -Destination "$env:USERPROFILE/eclipse/dropins/testng-eclipse-7.3.0/features"

# Each folder have two jar files.

# copy the two folders to the dropins folder of eclipse.


 # source : https://www.techbeamers.com/install-testng-in-eclipse-ide/