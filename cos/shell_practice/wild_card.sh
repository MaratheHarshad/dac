#!/bin/bash

echo "Program to check whether entered character is alphabet character or not"

read -p "enter char : " char

if [[ $char =~ ^[[:alpha:]]+$ ]]
then

echo "entered char is alphabet character"

else

echo "not a alphabet character"

fi
