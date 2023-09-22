#!/bin/bash

read -p "Enter Number 1 :" number1
read -p "Enter Number 2 :" number2


if [ $number1 -gt $number2 ];
then
echo "$number1 is greater than $number2"
elif [ $number2 -gt $number1 ];
then
echo "$number2 is greatwer than $number1"

else
	echo "Both numbers are same"

fi


