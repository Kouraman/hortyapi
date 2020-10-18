#!/usr/bin/python

import sys

#   run with :: python csv_editor.py data.csv
#   will edit file to Mysql INSERT format
#   ie. ::     data1;data2;.....;dataN   >>   (data1,data2,....,dataN)


def main(fileName):

    file = open(fileName, 'r+')
    lines = file.readlines()
    file.close()

    for index in range(0, len(lines)):
        lines[index]=lines[index].strip('\n')
        lines[index]=lines[index].replace(';',',')
        if (lines[index][0]!='('):                  #Add '(' to the beginning of each line
            lines[index] = "(" + lines[index]
        if (lines[index][-1]==','):                 #Remove the comma at the end of each line if needed
            lines[index] = lines[index][:-1]
        if (lines[index][-1]!=')'):                 #Add ')' to the end of each line
            lines[index] =  lines[index]+')'

        lines[index]=lines[index]+"\n"              #read the line return at each line

    file = open(fileName, "w")
    file.write("".join(lines))
    file.close()

if (__name__ == "__main__"):
    main(sys.argv[1])
