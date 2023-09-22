#!/bin/bash

echo "Simple integer calculator"

read -p "Enter the number " iNum1
read -p "Enter the second number " iNum2

read -p "Enter the mathematical operator(+-*/) " operator

echo "You entered $iNum1 $operator $iNum2 its result is "

if [[ "$operator" == "+" ]];
	then
		result=$(( $iNum1 + $iNum2 ))


elif [[ "$operator" == "-" ]];
	then
		result=$(( $iNum1 - $iNum2 ))

#elif[ "$operator" == "*" ];
#then
#result=$(( $iNum1 * $iNum2 ))


fi

echo $result

