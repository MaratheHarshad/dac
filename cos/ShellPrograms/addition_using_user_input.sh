#!/bin/bash

#-p  stands for prompt
read -p "Enter Number 1 for addition: " number1
read -p "Enter Number 2 for addition: " number2

echo "Addition of $number1 and $number2 is $(($number1 + $number2))" 
echo "Addition of $number1 and $number2 is" $(`expr  $number1 + $number2`)
