#!/bin/bash -x

#date  > ~/bowtietest
#pwd >> ~/bowtietest

#cd ~/bowtie-0.12.7
#bowtie --help >> ~/bowtietest
#format:
#bowtie-build [options]* <reference_in> <ebwt_base>
#the parameres:
#example:
#bowtie-build NC_002127.fna e_coli_O157_H7 
#$1 index
#$2 file
bowtie-build $2 $1 
