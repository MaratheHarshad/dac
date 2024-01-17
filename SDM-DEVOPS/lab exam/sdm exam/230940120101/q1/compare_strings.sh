#1/bin/bash

read -p "Enter first string : "  first
read -p "Enter second string : " second

if [ "$first" = "$second" ]; then
	echo "The two strings match";
else 
	echo "The two strings do not match";
fi;
	
