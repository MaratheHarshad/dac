#!/bin/bash

echo "Program to check accepted input is numeric or not"

read -p "Enter input : " input


if [[ $input =~ ^[[:digit:]]+$ ]];
	then

		echo "input contains all the digits $input" 

else 

	echo "input is not numeric : $input"
fi
