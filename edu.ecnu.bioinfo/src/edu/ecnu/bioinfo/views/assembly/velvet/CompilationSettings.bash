cd ~/velvet_1.1.06/
if [[ ${1} == ":" ]]
then make
fi
if [[ ${2} != ":" ]]
then   
make ${2}
fi
if [[ ${3} != ":" ]]
then make ${3}
fi
if [[ ${4} != ":" ]]
then make ${4}
fi
if [[ ${5} != ":" ]]
then make ${5}
fi
if [[ ${6} != ":" ]]
then make ${6}
fi
if [[ ${7} != ":" ]]
then make ${7}
fi