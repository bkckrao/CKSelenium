<############################################

    Installing GIT Package manager

###############################################>

# set UI buffer to 1024 characters wide so writing to the output log doesn't split output lines
        $host.UI.RawUI.BufferSize = new-object System.Management.Automation.Host.Size(1024,50)

 
 # Verify the existence of logfile and creates if not found.

 $LogFolder = "$env:WINDIR\Temp\Auto\Logs"

 if(!(Test-Path $LogFolder)) {New-Item -ItemType Directory -Force -Path $LogFolder | Out-Null}

 Start-Transcript -Path "$LogFolder\git-install.log" -Append

# Verifies the chocolatey installed, If not it will install
 if(-Not(Get-Command "choco" -ErrorAction SilentlyContinue)){
 &"$PSScriptRoot\Install_Chocolatey.ps1"
 }


 # trap any uncaught errors, log them and continue
trap { 
  Write-Output "UNCAUGHT ERROR: $($_.ToString().Replace("`r`n","<CRLF>").Replace("`n","<CRLF>")) ScriptStackTrace:$($_.ScriptStackTrace.ToString().Replace("`r`n","<CRLF>").Replace("`n","<CRLF>"))#;"; 
  continue; 
}

# Exit code
$ExitCode = 0


# Install chocolatey

$startdate = Get-Date

Write-Output "Installing Git ..."

choco upgrade git -Y
refreshenv

$path = [System.Environment]::GetEnvironmentVariable("Path","Machine") +";"+ [System.Environment]::GetEnvironmentVariable("Path","User")
refreshenv

$Runtime = New-TimeSpan -Start $startdate -End $(Get-Date)
<#
if(Get-Command code -ErrorAction SilentlyContinue)
    { Write-Output "VS code installation successful with Runtime = $($Runtime.Seconds) seconds"}
else
    { Write-Output "Failed the VS code installation with Runtime = $($Runtime.Seconds) seconds"
    $ExitCode =1
    }
#>
    Stop-Transcript
Exit $ExitCode