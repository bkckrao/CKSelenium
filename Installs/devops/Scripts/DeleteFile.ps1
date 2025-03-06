
Param(
    [string]$Path, #="C:\Program Files (x86)\Jenkins\workspace\DSP_Pipe\Reports",
    [string]$FileName #="report.html"
)

function Main {
    Param(
        [string]$Path, #="C:\Program Files (x86)\Jenkins\workspace\DSP_Pipe\Reports",
        [string]$FileName # ="report - Copy (2).html"
    )

# Import-Module "$PSScriptRoot\..\devops\General.psm1"
Import-Module "$PSScriptRoot\..\..\devops\modules\Module1.psm1"

# Write-Output "Importing the module general done"
deleteFile -Path $Path -Filename $FileName

}

Main -Path $Path -Filename $FileName