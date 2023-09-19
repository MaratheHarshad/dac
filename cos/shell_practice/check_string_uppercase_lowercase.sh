#!/bin/bash

echo "Program to check entered string is upper case or lower case or mixed"

read -p "Enter string : " string


if [[ $string = [[:upper:]]+$ ]]
	then
		echo "upper case string : $string"


fi

#if [ $string == [[:lower:]*] ]
#	then
#		echo "lower case string : $string"

#fi
