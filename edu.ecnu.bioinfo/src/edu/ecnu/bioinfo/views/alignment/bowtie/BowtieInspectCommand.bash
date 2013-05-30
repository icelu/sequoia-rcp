#!/bin/bash -x

#date  > ~/bowtietest
#pwd >> ~/bowtietest

#cd ~/bowtie-0.12.7
#bowtie --help >> ~/bowtietest
#format:
#bowtie-inspect [options]* <ebwt_base>
#the parameres:
#$1 result
#$2 index
#example:
#bowtie-inspect e_coli
#cat $1
bowtie-inspect $2  > $1
