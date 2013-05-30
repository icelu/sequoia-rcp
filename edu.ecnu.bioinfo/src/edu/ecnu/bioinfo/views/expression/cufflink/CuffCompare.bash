#!/bin/bash -x

#date  > ~/cuffcompare
#pwd >> ~/cuffcompare

#cd ~/cufflinks-1.1.0.Linux_x86_64
#cuffcompare --help >> ~/cuffcompare
#format:
#./cuffcompare [-r <reference_mrna.gtf>] [-R] [-T] [-V] [-s <seq_path>] 
    [-o <outprefix>] [-p <cprefix>] 
    {-i <input_gtf_list> | <input1.gtf> [<input2.gtf> .. <inputN.gtf>]} 
#the parameres:
#$1 -i provide a text file with a list of Cufflinks GTF files to process instead
   of expecting them as command line arguments         ///output
#$2 -s:Files  <seq_path> can be a multi-fasta file with all the genomic sequences or 
    a directory containing multiple single-fasta files ///input 
#$3 -r:  a set of known mRNAs to use as a reference for assessing 
    the accuracy of mRNAs or gene models given in <input.gtf>
#$4 -R  for -r option, reduce the set of reference transcripts to 
    only those found to overlap any of the input loci
#$5 -M  discard (ignore) single-exon transfrags and reference transcripts
#$6 -N:Ign  discard (ignore) single-exon reference transcripts
#$7 -d  max distance (range) for grouping transcript start sites (100)
#$8 -p  the name prefix to use for consensus transcripts in the 
    <outprefix>.combined.gtf file (default: 'TCONS')
#$9 -C  include the "contained" transcripts in the .combined.gtf file
#$10 -G  generic GFF input file(s) (do not assume Cufflinks GTF)
#$11 -T  do not generate .tmap and .refmap files for each input file
#$12 -V  verbose processing mode (showing all GFF parsing warnings)
#example:
#cat $1

if [[ ${1} != ":" ]]
then
index = ${1}
fi
if [[ ${2} != ":" ]]
then
file = ${2}
fi
if [[ ${3} != ":" ]]
then
mRNA  = ${3}
fi
if [[ ${4} != ":" ]]
then
Red   = ${4}
fi
if [[ ${5} != ":" ]]
then
Refer = ${5}
fi
if [[ ${6} != ":" ]]
then
Ign   = ${6}
fi
if [[ ${7} != ":" ]]
then
MaxDis= ${7}
fi
if [[ ${8} != ":" ]]
then
OutP  = ${8}
fi
if [[ ${9} != ":" ]]
then
Cont  = ${9}
fi
if [[ ${10} != ":" ]]
then
IntP  = ${10}
fi
if [[ ${11} != ":" ]]
then
NoTR  = ${11}
fi
if [[ ${12} != ":" ]]
then
Verb  = ${12}
fi

./cuffcompare -$index -$file -$mRNA -$Red -$Refer -$Ign $MaxDis -$OutP -$Cont -$IntP -$NoTR -$Verb


