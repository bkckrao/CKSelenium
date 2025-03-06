
Param(
    [string]$Source,
    [string]$Destination
)

function Main {
    Param(
        [string]$Source,
        [string]$Destination
    )

    Import-Module "$PSScriptRoot\..\..\devops\modules\Module1.psm1"

# Write-Output "Importing the module general done"
copyFile -Source $Source -Destination $Destination
Write-Output "Copying file is done"

}

Main -Source $Source -Destination $Destination