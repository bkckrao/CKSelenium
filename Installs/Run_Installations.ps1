


# Eclipse Installation
Write-Host
do{
$Install_Eclipse = Read-Host "Do you want to install Eclipse ? (Y/N)"
}while($Install_Eclipse -ne "Y" -and $Install_Eclipse -ne "N")


# java Installation
Write-Host
do {
$Install_Openjdk = Read-Host "Do you want to install Openjdk ? (Y/N)"
} while($Install_Openjdk -ne "Y" -and $Install_Openjdk -ne "N")


# Git Installation
Write-Host
do {
$Install_Git = Read-Host "Do you want to install Git ? (Y/N)"
} while($Install_Git -ne "Y" -and $Install_Git -ne "N") 

# Verifies the chocolatey installed, If not it will install
 if(-Not(Get-Command "choco" -ErrorAction SilentlyContinue)){
 &"$PSScriptRoot\Scripts\Install_Chocolatey.ps1"
 }

if ($Install_Eclipse -eq "Y"){
&"$PSScriptRoot\Scripts\Install_Eclipse.ps1"
}

if ($Install_Openjdk -eq "Y") {
&"$PSScriptRoot\Scripts\Install_Openjdk.ps1"
}

if ($Install_Git -eq "Y"){
&"$PSScriptRoot\Scripts\Install_Git.ps1"
}