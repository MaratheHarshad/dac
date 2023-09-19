#!/bin/bash

echo "Program to  accept the number from user (>1 and <= 100) and print the PID currently running process"


read -p "Enter The Number between 1 to 100 : " number


if [[ $number -lt 1 ||  $number -gt 100 ]];
	then 
		echo "You entered the wrong number"

else 


	#using for loop
	#for (( i=$number ; i>=1 ; i-- ))
	#	do
	#		echo "$i"

	#done

	#using while loop
	
	i=$number
	while (( i>=1 ))
		do
			echo "$i"
			#i=$((i-1))
			i=`expr $i-1 | bc`

	done
	
fi

