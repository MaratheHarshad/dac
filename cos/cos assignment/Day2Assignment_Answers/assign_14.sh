#!/bin/bash

read -p "Enter the string " string

input_file="input.txt"
output_file="output.txt"


grep -v "$string" "$input_file" > "$output_file"

charCount=$( wc -c $output_file )


echo "char count : $charCount"

