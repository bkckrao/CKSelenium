powershell Set-ItemProperty -Path "HKLM:\SOFTWARE\Policies\Microsoft\Windows\PowerShell" -Name ExecutionPolicy -Value RemoteSigned
powershell get-ExecutionPolicy
powershell $env:path