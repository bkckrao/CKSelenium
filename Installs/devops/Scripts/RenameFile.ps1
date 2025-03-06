
Param(
    [string]$name,
    [string]$newName
)

function Main {
    Param(
        [string]$Source, #="C:\Program Files (x86)\Jenkins\workspace\DSP_Pipe\Reports",
        [string]$newName # ="report - Copy (2).html"
    )

    # Import-Module "$PSScriptRoot\..\devops\General.psm1"
    Import-Module "$PSScriptRoot\..\..\devops\modules\Module1.psm1"

# Write-Output "Importing the module general done"
renameFile -Source $Source -newName $newName
Write-Output "Rename file is done"

}

Main -Path $Path -Filename $FileName