#!/bin/bash

echo "Program For Calculator"


count=1
while [ $count -lt 10 ]
do

read -p "Enter First Number : " number1
read -p "Enter Second Number : " number2

echo  "Enter + for addition"
echo  "Enter - for sub"
echo  "Enter / for div"
echo  "Enter * for mul"

read symbol


if [ "$symbol" = "+" ];
	then
		echo $number1 + $number2 | bc

elif [ "$symbol" = "-" ];
	then 
		echo $number1 - $number2 | bc

elif [ "$symbol" = "/" ];
	then 
		echo "scale=2; $number1 / $number2" | bc
		#res=$(( $number1 * 1.0 / $number2 ))
		#echo "$res"

elif [ "$symbol" =  "*" ];
	then
		echo $number1 \* $number2 | bc

else
	echo "Enter a valid character"

fi

count=$(( $count + 1 ))

done




