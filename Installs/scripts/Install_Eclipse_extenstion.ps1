Add-Type -AssemblyName System.IO.Compression.FileSystem

[string]$localchocopath = "AppData\Local\Temp\chocolatey"
[string]$package = "eclipse-java-oxygen"

$buildnum = Get-ChildItem ($env:USERPROFILE + "\" + $localchocopath + "\" + $package) | where { $_.Name -cmatch "\d*" } | select -First 1
Write-Output "buildnum : $buildnum"

$buildpath = $env:USERPROFILE | Join-Path -ChildPath $localchocopath | Join-Path -ChildPath $package | Join-Path -ChildPath $buildnum
Write-Output "buildpath = $buildpath"

$packagezip = Get-ChildItem ($buildpath | where { $_.Name -cmatch "\d*" } | select -First 1)
Write-Output "packagezip : $packagezip"

$fullpath = ($buildpath | Join-Path -ChildPath $packagezip)
Write-Output "Full path :" $fullpath

# This will extract the eclipse zip from the choco downloaded folder to C:\users\<User>
  [System.IO.Compression.ZipFile]::ExtractToDirectory($fullpath, $env:USERPROFILE)

  # This line will copy the eclipse shortcut to Desktop
  # Copy-Item -Path ($env:USERPROFILE | Join-Path -ChildPath \eclipse\eclipse.exe) -Destination ($env:USERPROFILE | Join-Path -ChildPath \Desktop\)

$linkPath        = Join-Path ($env:USERPROFILE | Join-Path -ChildPath Desktop) "Myshortcut.lnk"
$targetPath      = ($env:USERPROFILE | Join-Path -ChildPath \eclipse\eclipse.exe)
$link            = (New-Object -ComObject WScript.Shell).CreateShortcut($linkPath)
$link.targetPath = $targetPath      

$link.Save()