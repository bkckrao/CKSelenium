function deleteFile {
    param (
        [String]$Path,
        [String]$Filename
    )
    
    Write-Output "Path : " $Path
    Write-Output "Filename : " $Filename
    Write-Output "Complete Path : " $Path/$Filename
    
    If(Test-Path "$Path/$Filename"){
        	 Remove-Item -path "$Path\$Filename"
            # Get-ChildItem -Path $Path -Name $Filename | Remove-Item
            # Get-ChildItem -Path $Path -Include $Filename 

        	Write-Output " File $Filename is deleted"
         }else{
        	Write-Output " Looks like file $Filename does not exist"
}

If(Test-Path "$Path/$Filename"){
Write-Output "File is not deleted."
}else {
    Write-Output "File is no more."
}

}

function copyFile{
    param(
        [String]$Source,
        [String]$Destination
    )
    Write-Output "copy Source : " $Source
    Write-Output "copy Destination : " $Destination
    Set-Location $Source
    # $file1 = Get-ChildItem -Path $Source | Sort-Object -Descending -Property CreationTime | Select-Object -First 1)
    copy-Item -Path (Get-ChildItem -Path $Source | Sort-Object -Descending -Property CreationTime | Select-Object -First 1) -Destination $Destination

}


function renameFile{
    param(
        [string]$Source,
        [string]$newName        
    )

    Write-Output "rename Source : " $Source
    Write-Output "rename newName : " $newName
    Set-Location $Source
    Rename-Item -Path (Get-ChildItem -Path $Source | Sort-Object -Descending -Property CreationTime | Select-Object -First 1) -NewName $newName

}
