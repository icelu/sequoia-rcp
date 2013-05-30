#!/bin/bash -x

runMode=${1}
inputPath=${2}
preprocessOp=${3}
preprocessOutputOp=${4}
preprocessOutput=${5}
qualityEncodingOp=${6}
qualityEncoding=${7}
reference=${8}
output=${9}
cpus=${10}
keepIntermediates=${11}
intermediatesOutput=${12}
keepAll=${13}
bowtieArgsOp=${14}
bowtieArgs=${15}
soapSNPArgsOp=${16}
soapSNPArgs=${17}
hapsoapSNPArgsOp=${18}
hapsoapSNPArgs=${19}
dipsoapSNPArgsOp=${20}
dipsoapSNPArgs=${21}
maxSortRecords=${221}
maxSortFiles=${23}


 $CROSSBOW_HOME/cb_local $runMode $inputPath $preprocessOp $preprocessOutputOp $preprocessOutput $qualityEncodingOp $qualityEncoding $reference $output $cpus $keepIntermediates $intermediatesOutput \
 $keepAll $bowtieArgsOp $bowtieArgsOp $bowtieArgs $hapsoapSNPArgsOp $hapsoapSNPArgs $dipsoapSNPArgsOp $hapsoapSNPArgs $dipsoapSNPArgsOp $dipsoapSNPArgs --max-sort-records $maxSortRecords --max-sort-files $maxSortFiles \
 maxSortFiles2>&1 | tee crossbowInfo.txt &