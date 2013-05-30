#!/bin/bash -x

#echo $#
#for id
#do 
#	if [[ id -eq "" ]] 
#		then
#			echo "test"
#		else
#			echo "$id"
#	fi
#done

#cd 
#samtools view [-bchuHS] [-t in.refList] [-o output] [-f reqFlag] [-F skipFlag] [-q minMapQ] [-l library] [-r readGroup] [-R rgFile] <in.bam>|<in.sam> [region1 [...]]
#total 14,+infile=15
#6 bool b,h,H,S,c,u
#3 int f,F,q
#2 str l,r
#3 file R,t,o 

if [[ ${1} = "view" ]]
then

if [[ ${2} != ":" ]]
then
vb=${2}
fi

if [[ ${3} != ":" ]]
then
vh=${3}
fi

if [[ ${4} != ":" ]]
then
vH=${4}
fi

if [[ ${5} != ":" ]]
then
vS=${5}
fi

if [[ ${6} != ":" ]]
then
vc=${6}
fi

if [[ ${7} != ":" ]]
then
vu=${7}
fi

#l,r
if [[ ${11} != ":" ]]
then
vl="-l ${11}"
fi

if [[ ${12} != ":" ]]
then
vr="-r ${12}"
fi

#R,t
if [[ ${13} != ":" ]]
then
vR="-R ${13}"
fi

if [[ ${14} != ":" ]]
then
vt="-t ${14}"
fi

#6 bool b,h,H,S,c,u
#3 int f,F,q
#2 str l,r
#3 file R,t,o 
samtools view  $vb  $vh  $vH  $vS  $vc  $vu  -f ${8}  -F ${9}  -q ${10}  $vl  $vr  $vR  $vt  -o ${15}  ${16} 

#samtools mpileup [-EBug] [-C capQcoef] [-r reg] [-f in.fa] [-l list] [-M capMapQ] [-Q minBaseQ] [-q minMapQ] in.bam [in2.bam [...]] 
#total 22,+infile n 
#input 12
#4 bool 6,A,B,E
#4 int C,d,q,Q
#1 str r
#3 file b,f,l
#output 4
#4 bool D,g,S,u
#genotype 6
#1 bool I
#4 int e,h,L,o
#1 str P

else
if [[ ${1} = "mpileup" ]]
then
#4 bool 6,A,B,E
if [[ ${2} != ":" ]]
then
m6=${2}
fi
if [[ ${3} != ":" ]]
then
mA=${3}
fi
if [[ ${4} != ":" ]]
then
mB=${4}
fi
if [[ ${5} != ":" ]]
then
mE=${5}
fi
#1 str r
#3 file b,f,l
if [[ ${10} != ":" ]]
then
mr="-r ${10}"
fi
if [[ ${11} != ":" ]]
then
mb="-b ${11}"
fi
if [[ ${12} != ":" ]]
then
mf="-f ${12}"
fi
if [[ ${13} != ":" ]]
then
ml="-l ${13}"
fi
#4 bool D,g,S,u
#1 bool I
#1 str P
if [[ ${14} != ":" ]]
then
mD=${14}
fi
if [[ ${15} != ":" ]]
then
mg=${15}
fi
if [[ ${16} != ":" ]]
then
mS=${16}
fi
if [[ ${17} != ":" ]]
then
mu=${17}
fi
if [[ ${18} != ":" ]]
then
mI=${18}
fi
if [[ ${23} != ":" ]]
then
mP="-P ${23}"
fi

match=":"
repl=" "
bamFile=${24}
bamFile=${bamFile//$match/$repl}

echo $bamFile
samtools mpileup  $m6 $mA $mB $mE -C $6 -d $7 -q $8 -Q $9  $mr  $mb $mf  $ml $mD $mg $mS $mu $mI -e  ${19} -h ${20} -L ${21} -o ${22}  $mP $bamFile > ${25}

#samtools sort [-no] [-m maxMem] <in.bam> <out.prefix> 

else 
if [[ ${1} = "sort" ]]
then

if [[ ${2} != ":" ]]
then
sn=${2}
fi

samtools sort $sn  -m $3  $4 $5

fi
fi
fi