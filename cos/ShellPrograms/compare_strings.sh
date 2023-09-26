#!/bin/bash

echo "Shell Program to check the entered strings are equal or not"

read -p "Enter First String : " first
read -p "Enter Second String : " second

if [ $first = $second ];
	then
		echo "Both the strings are equal"
else
	echo "Strings are not equal"

fi
