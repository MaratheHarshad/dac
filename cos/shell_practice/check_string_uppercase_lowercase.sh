#!/bin/bash

echo "Program to check entered string is upper case or lower case or mixed"

read -p "Enter string : " string


# regular expression pattern should be check in double [] brackets
# =~ is an operator in bash to compare a string with a regular expression pattern
# ^ indicates start of the string
# + indicates one or more characters (without + only string with 1 char is matched)
# $ indicates end of the string

if [[ $string =~ ^[[:upper:]]+$ ]]
	then
		echo "upper case string : $string"


elif [[ $string =~ ^[[:lower:]]+$ ]]
	then
		echo "lower case string : $string"


else
	echo "string is mixed string : $string"
fi
