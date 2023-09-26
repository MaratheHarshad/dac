#!/bin/bash

echo  "Program to execute terminal command inside shell scripting"


echo "Enter the name of file to read the content"

read filename


cat  <  $filename
