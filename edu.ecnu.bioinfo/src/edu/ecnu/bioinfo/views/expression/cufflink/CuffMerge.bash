#!/bin/bash -x

#date  > ~/cuffmerge
#pwd >> ~/cuffmerge

#cd ~/cufflinks-1.1.0.Linux_x86_64
#cuffmerge --help >> ~/cuffmerge
#format:
#./cuffmerge [Options] <assembly_GTF_list.txt>
#the parameres:
#$1 -o/Files  <output_dir>   Directory where merged assembly will be written [default: ./merged_asm]
#$3 -p/Numt--num-threads       <int>           Use this many threads to merge assemblies.default:1 
#$5 -h/--help                              Prints the help message and exits
#$4 -g/OutP--ref-gtf                           An optional "reference" annotation GTF.
#$2 -s/Refer--ref-sequence      <seq_dir>/<seq_fasta> Genomic DNA sequences for the reference.
#$6 --min-isoform-fraction double<0-1.0>  Discard isoforms with abundance below this.default:0.05
#$7 --keep-tmp                             Keep all intermediate files during merge
#example:
#cuffmerge [Options] <assembly_GTF_list.txt>
if [[ ${1} != ":"]]
then
file = ${1}
fi
if [[ ${2} != ":" ]]
then
file0= ${2}
fi
if [[ ${3} != ":" ]]
then
NumT = ${3}
fi
if [[ ${4} != ":" ]]
then
OutP = ${4}
fi
if [[ ${5} != ":" ]]
then
Help = ${5}
fi

if [[ ${6} != ":" ]]
then
Tmp  = ${6}
fi
if [[ ${7} != ":" ]]
then
MinIso=${7}
fi
./cuffmerge -$file $NumT $Help $OutP $file0 $Tmp $MinIso


