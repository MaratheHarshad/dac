#!/bin/bash

echo "Program to compare 2 string (case in-sensitive)"

read -p "Enter string 1 : "  string_1
read -p "Enter string 2 : "  string_2


# ${string_1,,} -> return the lowercase version of current string (but does not modify the original string
# == -> checks if two strings are equal
# ${string_2^^} -> returns the uppercase version of current string (but does not modify the original string

if [[ ${string_1,,} == ${string_2,,} ]];
	then
		echo "Both strings are equal"

else
	echo "strings are not equal"

fi

