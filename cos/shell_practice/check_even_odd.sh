#!/bin/bash

echo  "Program to check even or odd"

read -p "Enter a number to check whether given number is even or odd : " number

#rem=$(($number % 2))
rem=`expr $number % 2`

if [ $rem -eq 0 ]
	then
		echo "$number is even"

else
	echo "$number is odd"

fi


