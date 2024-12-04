# PowerShell

param (
    [Parameter(Mandatory = $true)]
    [string]$typeName
)

# 设置工作目录为与 pom.xml 同级
$baseDir = Get-Location

# 定义目录列表
$directories = @(
    "src/main/java/com/zys/elec/controller",
    "src/main/java/com/zys/elec/service",
    "src/main/java/com/zys/elec/service/impl",
    "src/main/java/com/zys/elec/mapper",
    "src/main/java/com/zys/elec/entity",
    "src/main/resources/mapper"
)

# 创建目录
foreach ($dir in $directories) {
    $fullDir = Join-Path $baseDir $dir
    if (-not (Test-Path $fullDir)) {
        New-Item -ItemType Directory -Path $fullDir | Out-Null
    }
}

# 定义文件列表
$files = @(
    "src/main/java/com/zys/elec/controller/${typeName}Controller.java",
    "src/main/java/com/zys/elec/service/${typeName}Service.java",
    "src/main/java/com/zys/elec/service/impl/${typeName}ServiceImpl.java",
    "src/main/java/com/zys/elec/mapper/${typeName}Mapper.java",
    "src/main/java/com/zys/elec/entity/${typeName}.java",
    "src/main/resources/mapper/${typeName}Mapper.xml"
)

# 创建文件
foreach ($file in $files) {
    $fullFile = Join-Path $baseDir $file
    if (-not (Test-Path $fullFile)) {
        New-Item -ItemType File -Path $fullFile | Out-Null
    }
}