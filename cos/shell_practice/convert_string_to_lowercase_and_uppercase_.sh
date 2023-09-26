
#!/bin/bash

echo "Program to convert input string into lowercase and uppercase"
echo
read -p "Enter string : " input


#below both syntaxes are valid

lowercase_string=$( echo $input | tr [:upper:] [:lower:] )
uppercase_string=$( echo $input | tr '[:lower:]' '[:upper:]' )

echo 
echo "input is : $input"
echo 
echo "lowercase : $lowercase_string"
echo
echo "uppercase : $uppercase_string"
echo
