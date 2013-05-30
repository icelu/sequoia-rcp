#!/bin/bash -x

#date  > ~/cuffdiff
#pwd >> ~/cuffdiff

#cd ~/cufflinks-1.1.0.Linux_x86_64
#cuffdiff --help >> ~/cuffdiff
#format:
#./cuffdiff-[options]* 
#the parameres:
#cuffdiff [options] <transcripts.gtf> <sample1_hits.sam> <sample2_hits.sam> [... sampleN_hits.sam]
#General Options:
#$1  -o/--output-dir           write all output files to this directory              [ default:     ./ ]
#$2  --seed                    value of random number generator seed                 [ default:      0 ]
#$3  -T/--time-series          treat samples as a time-series                        [ default:  FALSE ]
#$4  -c/--min-alignment-count  minimum number of alignments in a locus for testing   [ default:   10 ]
#$5  --FDR                     False discovery rate used in testing                  [ default:   0.05 ]
#$6  -M/--mask-file            ignore all alignment within transcripts in this file  [ default:   NULL ]
#$7  -b/--frag-bias-correct    use bias correction - reference fasta required        [ default:   NULL ]
#$8  -u/--multi-read-correct   use 'rescue method' for multi-reads (more accurate)   [ default:  FALSE ]
#$9  -N/--upper-quartile-norm  use upper-quartile normalization                      [ default:  FALSE ]
#$10  -L/--labels              comma-separated list of condition labels
#$11  -p/--num-threads         number of threads used during quantification          [ default:      1 ]

#Advanced Options:
#$12  --library-type           Library prep used for input reads                     [ default:  below ]
#$13  -m/--frag-len-mean       average fragment length (unpaired reads only)         [ default:    200 ]
#$14  -s/--frag-len-std-dev    fragment length std deviation (unpaired reads only)   [ default:     80 ]
#$15  --num-importance-samples number of importance samples for MAP restimation      [ default:   1000 ]
#$16  --num-bootstrap-samples  Number of bootstrap replications                      [ default:     20 ]
#$17  --bootstrap-fraction     Fraction of fragments in each bootstrap sample        [ default:    1.0 ]
#$18  --max-mle-iterations     maximum iterations allowed for MLE calculation        [ default:   5000 ]
#$19  --compatible-hits-norm   count hits compatible with reference RNAs only        [ default:   TRUE ]
#$20  --total-hits-norm        count all hits for normalization                      [ default:  FALSE ]
#$21  --poisson-dispersion     Don't fit fragment counts for overdispersion          [ default:  FALSE ]
#$22  --v/--verbose             log-friendly verbose processing (no progress bar)     [ default:  FALSE ]
#$23  --q/--quiet                log-friendly quiet processing (no progress bar)       [ default:  FALSE ]
#$24  --no-update-check        do not contact server to check for update availability[ default:  FALSE ]
#$25  --emit-count-tables      print count tables used to fit overdispersion         [ default:  FALSE ]
#$26  --max-bundle-frags       maximum fragments allowed in a bundle before skipping [ default: 500000 ]

#example:
#cuffDiff
file = ${1}
if [[ ${2} != ":" ]]
then
Numth = ${2}
fi
if [[ ${3} != ":" ]]
then
SeedN= ${3}
fi
if [[ ${4} != ":" ]]
then
MinAli= ${4}
fi
if [[ ${5} != ":" ]]
then
FDR   = ${5}
fi
if [[ ${6} != ":" ]]
then
MaskF = ${6}
fi
if [[ ${7} != ":" ]]
then
Time  = ${7}
fi
if [[ ${8} != ":" ]]
then
FragB  = ${8}
fi
if [[ ${9} != ":" ]]
then
MulR  = ${9}
fi
if [[ ${10} != ":" ]]
then
Upp   = ${10}
fi
if [[ ${11} != ":" ]]
then
Label = ${11} 
fi

#Advance
if [[ ${12} != ":" ]]
then
FragM = ${12}
fi
if [[ ${13} != ":" ]]
then
FraS  = ${13} 
fi
if [[ ${14} != ":" ]]
then
NumIm = ${14}
fi
if [[ ${15} != ":" ]]
then
NumBoot=${15}
fi
if [[ ${16} != ":" ]]
then
Boots = ${16}
fi
if [[ ${17} != ":" ]]
then
MaxMle =${17}
fi
if [[ ${18} != ":" ]]
then
MaxBu  =${18}
fi
if [[ ${19} != ":" ]]
then
Cnorm  =${19}
fi
if [[ ${20} != ":" ]]
then
Tnorm  =${20}
fi
if [[ ${21} != ":" ]]
then
Poiss = ${21}
fi
if [[ ${22} != ":" ]]
then
Ver   = ${22}
fi
if [[ ${23} != ":" ]]
then
Qui   = ${23}
fi
if [[ ${24} != ":" ]]
then
NUpdate=${24}
fi
if [[ ${25} != ":" ]]
then
Emit  = ${25}
fi

./cuffdiff -$file $NumTh $SeedLn $MinAli -$FDR -$MaskF -$Time -$FraB -$MulR -$Upp -$Label $FragM $FraS $NumIn $NumBoot $Boots $MaxMle $MaxBu -$Cnorm -$Tnorm -$Poiss -$Ver -$Qui -$NUpdate -$Emit


