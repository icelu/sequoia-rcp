#!/bin/bash -x

refGenome=${1}
readFile1=${2}

if [[ ${4} != "singleMateInnerDis" ]]
	then
		mateInnerDis="-r"
		disValue=${4}
		readFile2=${3}
		if [[ ${5} != ":" ]]
			then
				mateStdDevOp="--mate-std-dev"
				mateStdDev=${5}
			else
				mateStdDevOp=""
				mateStdDev=""
		fi
	else
		mateInnerDis=""
		disValue=""
		readFile2="" 
fi
if [[ ${6} != ":" ]]
	then
		outputDesOp="-o"
		outputDes=${6}
	else
		outputDesOp=""
		outputDes=""
fi
if [[ ${7} = "custom" ]]
	then
		minIntroLenOp="--min-intron-length"
		minIntroLen=${8};
		maxIntroLenOp="--max-intron-length"
		maxIntroLen=${9};
		if [[ $[10] = "earlier" ]]
			then
				pipelineVer="--solexa-quals"
			else
				pipelineVer="--solexa1.3-quals"
		fi
		threadsCountOp="--num-threads"
		threadsCount=${11}
		maxMultihitsOp="--max-multihits"
		maxMultihits=${12}
		libTypeOp="--library-type"
		libType=${13}
		if [[ ${14} != "noGTP" ]]
			then
				GTPFileOp="--GTF"
				GTPFile=${14}
			else
			    GTPFileOp=""
				GTPFile=""
		fi
		if [[ ${15} != "noJunction" ]]
			then
				junctionFileOp="--raw-juncs"
				junctionFile=${15}
			else
				junctionFileOp=""
				junctionFile=""
		fi
		if [ ${15} != "noGTP&Junction" -a ${15} = "Yes"]
			then 
				noNovelJunction="--no-novel-juncs"
			else
				noNovelJunction=""
		fi
		if [ ${16} != "noIndel" ]
			then 
				indelFileOp="--insertions"
				indelFile=${16}
			else
				indelFileOp=""
				indelFile=""
		fi
				
	else
		minIntroLenOp=""
		minIntroLen=""
		maxIntroLenOp=""
		maxIntroLen=""
		pipelineVer=""
		threadsCountOp=""
		threadsCount=""
		maxMultihitsOp=""
		maxMultihits=""
		libTypeOp=""
		libType=""
fi
nohup tophat $indelFileOp $indelFile $noNovelJunction $junctionFileOp $junctionFile $GTPFileOp $GTPFile $maxMultihitsOp $libTypeOp $libType $maxMultihits $threadsCountOp $threadsCount $pipelineVer $minIntroLenOp $minIntroLen $maxIntroLenOp $maxIntroLen $mateStdDevOp $mateStdDev $mateInnerDis $disValue $outputDesOp $outputDes $refGenome $readFile1 $readFile2  2>&1 | tee tophatinfo  &