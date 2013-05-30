#!/bin/bash -x

#pwd >> ~/cufflinks ~~

#cd ~/cufflinks-1.1.0.Linux_x86_64
#./cufflinks --help >> ~/cufflinkshelptest
#format:cufflinks [options]<hits.sam>
#the parameres:
#main
#for $1 -o/ file directory
#for $2 -p/ threads num
#for $3	-seed value of generate
#for $4 -G/GTF
#for $5 -g/GTF
#for $6 -M/mask-file
#for $7 -b/frag
#for $8 -u/multi
#Estimate
#for $9 -m:SeedLen <int>
#for $10 -s:FraDev <int>
#for $11 -ImpSam:number important sample <int>
#for $12 -Iter:max mle iterations <int>
#for $13 --FragIn 
#for $14 --FragAll
#for $15 --FragDev
#for $16 --FragCom
#Assembly
#for $17 --MinIso
#for $18 --PreM
#for $19 --JucA
#for $20 --SmaA
#for $21 --TrimDr
#for $22 -MaxIn<int>
#for $23 -MinFra<int>
#for $24 -OverT<int>
#for $25 -MaxBun<int>
#for $26 -MaxBunF<int>
#for $27 -MinInt<int>
#for $28 -Trim<int>
#for $29 --GTF
#RABT
#for $30 -Overhang <int> 
#for $31 -Intron<int>
#for $32 --RABT
#Output
#for $33 --radio
#for $34 --fullref
#APBO
#for $35 --APBO
#for $36 --Quite
#for $37 --Update
#Input
#for $38 --SAM or BAM
#example:
#cufflinks -
#echo $# >> ~/cufflinks
#done

#main
IndexDir=${1}
if [[ ${2} != ":" ]]
then
Perform=${2}
fi
if [[ ${3} != ":" ]]
then
Help=${3}
fi
if [[ ${4} != ":" ]]
then
GTFG=${4}
fi
if [[ ${5} != ":" ]]
then
gGTF=${5}
fi
if [[ ${6} != ":" ]]
then
Mask=${6}
fi
if [[ ${7} != ":" ]]
then
FraB=${7}
fi
if [[ ${8} != ":" ]]
then
Multi=${8}
fi
#Estimate
if [[ ${9} != ":" ]]
then
SeedLen=${9}
fi
if [[ ${10} != ":" ]]
then
FraDev=${10}
fi
if [[ ${11} != ":" ]]
then
ImpSam =${11} 
fi
if [[ ${12} != ":" ]]
then
Iter  = ${12}
fi
if [[ ${13} != ":" ]]
then
FragIn = ${13} 
fi
if [[ ${14} != ":" ]]
then
FragAll=${14}
fi
if [[ ${15} != ":" ]]
then
FragDev=${15}
fi
if [[ ${16} != ":" ]]
then
FragCom=${16}
fi
#Assembly
if [[ ${17} != ":" ]]
then
MinIso =${17}
fi
if [[ ${1813} != ":" ]]
then
PreM =  ${18}
fi
if [[ ${19} != ":" ]]
then
JucA =  ${19}
fi
if [[ ${20} != ":" ]]
then
SmaA =  ${20}
fi
if [[ ${21} != ":" ]]
then
TrimDr= ${21}
fi
if [[ ${22} != ":" ]]
then
MaxIn = ${22}
fi
if [[ ${23} != ":" ]]
then
MinFra= ${23}
fi
if [[ ${24} != ":" ]]
then
OverT = ${24}
fi
if [[ ${25} != ":" ]]
then
MaxBun= ${25}
fi
if [[ ${26} != ":" ]]
then
MaxBunF=${26}
fi
if [[ ${27} != ":" ]]
then
MinInt =${27}
fi
if [[ ${28} != ":" ]]
then
Trim =  ${28} 
fi
if [[ ${29} != ":" ]]
then
GTF  =  ${29}
fi
#RABT
if [[ ${30} != ":" ]]
then
Overhang=${30} 
fi
if [[ ${31} != ":" ]]
then
Intron  =${31}
fi
if [[ ${32} != ":" ]]
then
RABT = ${32}
fi
#Output
if [[ ${33} != ":" ]]
then
radio  = ${33}
fi
if [[ ${34} != ":" ]]
then
fullref= ${34}
fi
#APBO
if [[ ${35} != ":" ]]
then
APBO = ${35}
fi
if [[ ${36} != ":" ]]
then
Quite= ${36}
fi
if [[ ${37} != ":" ]]
then
Update=${37}
fi
#Input
if [[ ${38} != ":" ]]
then
form = ${38}
fi
./cufflinks $IndexDir -$Perform -$Help -$GTFG -$gGTF -$Mask -$FraB -$Multi $SeedLen $FragDeb $ImpSam $Iter $FragIn
 $FragAll $FragDev $FragCom $MinIso $PreM $JucA $SmaA $TrimDr $MaxIn $MinFra $OverT $MaxBun $MaxBunF $MinInt $Trim
 -$GTF -$Overhang -$Intron -$RABT -$radio -$fullref -$APBO -$Quite -$Update -$form



