
$reportPath="C:\Program Files (x86)\Jenkins\workspace\GitProj\Reports"
$fileName="Report.html"

Import-Module $PSScriptRoot\General.psm1
<# powershell '.\\devops\\DeleteFile.ps1' -Path $reportPath -Filename $fileName
 echo 'DeleteFile crossed'
 powershell '.\\devops\\CopyFile.ps1' -Source $reportPath -Destination $reportPath
 echo 'CopyFile crossed'
 powershell '.\\devops\\RenameFile.ps1' -Source $reportPath -newName $fileName
 echo 'RenameFile crossed'
 #>

 &"$PSScriptRoot\DeleteFile.ps1" -Path $reportPath -Filename $fileName
 echo 'DeleteFile crossed'
 &"$PSScriptRoot\CopyFile.ps1" -Source $reportPath -Destination $reportPath\$fileName
 echo 'CopyFile crossed'
 # &"$PSScriptRoot\RenameFile.ps1" -Source $reportPath -newName $fileName
 # echo 'RenameFile crossed'