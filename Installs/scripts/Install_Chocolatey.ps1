<############################################

    Installing Chocolatey Package manager

###############################################>

# set UI buffer to 1024 characters wide so writing to the output log doesn't split output lines
        $host.UI.RawUI.BufferSize = new-object System.Management.Automation.Host.Size(1024,50)

 
 # Verify the existence of logfile and creates if not found.

 $LogFolder = "$env:WINDIR\Temp\Auto\Logs"

 if(!(Test-Path $LogFolder)) {New-Item -ItemType Directory -Force -Path $LogFolder | Out-Null}

 Start-Transcript -Path "$LogFolder\choco-install.log"


 # trap any uncaught errors, log them and continue
#trap { 
#  Write-Output "UNCAUGHT ERROR: $($_.ToString().Replace("`r`n","<CRLF>").Replace("`n","<CRLF>")) ScriptStackTrace:$($_.ScriptStackTrace.ToString().Replace("`r`n","<CRLF>").Replace("`n","<CRLF>"))#;"; 
#  continue; 
#}

# Exit code
$ExitCode = 0

# Install chocolatey

$startdate = Get-Date


# [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
powershell.exe Set-ExecutionPolicy Bypass -Scope Process -Force -ErrorAction SilentlyContinue


if ( (Invoke-Expression ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))) -like '*Could not create SSL/TLS secure 
channel*'){

Write-Host -ForegroundColor DarkRed "Security Protocol before setting" 
[Net.ServicePointManager]::SecurityProtocol

[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
refreshenv
Write-Host -ForegroundColor DarkGreen "Security Protocol after setting"
[Net.ServicePointManager]::SecurityProtocol

}else{
Invoke-Expression ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
}

Write-Host -ForegroundColor cyan "Installing chocolatey"
# powershell.exe -ExecutionPolicy Bypass -Command 


$path = [System.Environment]::GetEnvironmentVariable("Path","Machine") + [System.Environment]::GetEnvironmentVariable("Path","User")

$Runtime = New-TimeSpan -Start $startdate -End $(Get-Date)

if(Get-Command "choco" -ErrorAction SilentlyContinue)
    { Write-Output "Chocolatey installation successful with Runtime = $($Runtime.Seconds) seconds"}
else
    { Write-Output "Failed the Chocolatey installation with Runtime = $($Runtime.Seconds) seconds"
    $ExitCode =1
    }


Stop-Transcript
Exit $ExitCode