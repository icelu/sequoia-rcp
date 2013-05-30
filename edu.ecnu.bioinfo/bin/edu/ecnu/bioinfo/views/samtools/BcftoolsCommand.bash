#!/bin/bash -x

#date  > ~/bowtietest
#pwd >> ~/bowtietest

#cd ~/bowtie-0.12.7
#bowtie --help >> ~/bowtietest
#format:bowtie [options]* <ebwt> {-1 <m1> -2 <m2> | --12 <r> | <s>} [<hit>]
#the parameres:
#main
#for $1 result
#for $2 index
#for $3	-1 file1,file
#for $4 -2 file2
#input
#for $5 -f:fasta
#for $6 --phred64-quals
#alignment
#for $7 -v <int> 2
#for $8 -l/--seedlen <int> 28
#for $9 -I/--minins <int> 0
#for $10 -X/--maxins <int> 250
#reporting
#for $11 -k <int> 1
#for $12 -a/--all
#for $13 --best
#Output
#for $14 --fullref
#SAM
#for $15 -S/--sam
#for $16 --mapq <int> 255
#for $17 --sam-nohead
#for $18 --sam-nosq
#for $19 --sam-RG <text> ID:IL7LANE2,SM:
#Performance
#for $20 -p/--threads <int> 1
#example:
#bowtie -f --phred64-quals -v 2 -l 30 -I 2 -X 100 -k 2(-a) --best --fullref -S --mapq 300 --sam-nohead --sam-nosq --sam-RG ID:IL7LANE2,SM:ssdsdsd -p 2 e_coli (reads/e_coli_1000.fq) -1 reads/e_coli_1000_1.fq -2 reads/e_coli_1000_1.fq) 
#echo $# >> ~/bowtietest
#for id
#do 
#	if [[ id -eq "" ]] 
#		then
#			echo "test"
#		else
#			echo "$id" >> ~/bowtietest
#	fi
#done
resultFile=${1}
index=${2}
file1=${3}
if [[ ${4} != ":" ]]
then
file2=${4}
fi
if [[ ${5} != ":" ]]
then
fasta=${5}
fi
if [[ ${6} != ":" ]]
then
phred64=${6}
fi
v=${7}
seedLen=${8}
maxInsert=${9}
minInsert=${10}
k=${11}
if [[ ${12} != ":" ]]
then
a=${12}
fi
if [[ ${13} != ":" ]]
then
best=${13}
fi
if [[ ${14} != ":" ]]
then
fullref=${14}
fi
if [[ ${15} != ":" ]]
then
sam=${15}
fi
mapq=${16}
if [[ ${17} != ":" ]]
then
nohead=${17}
fi
if [[ ${18} != ":" ]]
then
nosq=${18}
fi
if [[ ${19} != ":" ]]
then
rg="--sam-RG ${19}"
fi
thread=${20}
#cat $resultFile
#bowtie -f --phred64-quals -v 2 -l 28 -I 0 -X 250 -k 1 --best --fullref -S --mapq 255 --sam-nohead --sam-nosq --sam-RG ID:IL7LANE2,SM:ssdsdsd -p 2 e_coli -1 reads/e_coli_1000_1.fa -2 reads/e_coli_1000_2.fa
if [[ ${4} != ":" ]];
then
bowtie $fasta $phred64 -v $v -l $seedLen -I $maxInsert -X $minInsert -k $k $a $best $fullref $sam --mapq $mapq $nohead $nosq $rq -p $thread $index -1 $file1 -2 $file2  $resultFile
else
bowtie $fasta $phred64 -v $v -l $seedLen -I $maxInsert -X $minInsert -k $k $a $best $fullref $sam --mapq $mapq $nohead $nosq $rq -p $thread $index $file1  $resultFile
fi


