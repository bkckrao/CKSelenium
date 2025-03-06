powershell Set-ItemProperty -Path "HKLM:\SOFTWARE\Policies\Microsoft\Windows\PowerShell" -Name ExecutionPolicy -Value AllSigned
powershell get-ExecutionPolicy