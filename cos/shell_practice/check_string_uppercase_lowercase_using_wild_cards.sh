#!/bin/bash

echo "Program to check input string is UPPER CASE , lower case , or Mixed UPPER ANd lower case"

read -p "Enter input string : " input

#THIS IS A CORRECT PROGRAM 
#in last slide(ppt) of COS  -> on page 3 -> wrong approach is given

if [[ $input =~ ^[A-Z]+$ ]]
	then
		echo "UPPER CASE STRING : $input"

elif [[ $input =~ ^[a-z]+$ ]];
	then
		echo "lower case string : $input"

else 

	echo "mixed case string : $input"
fi
