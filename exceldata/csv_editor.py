#!/usr/bin/python

import os

#   run with :: python csv_editor.py data.csv
#   will edit file to Mysql INSERT format
#   ie. ::     data1;data2;.....;dataN   >>   (data1,data2,....,dataN)


def editCSVFile(fileName):

    file = open(fileName, 'r+')
    lines = file.readlines()
    file.close()

    for index in range(0, len(lines)):
        lines[index]=lines[index].strip('\n')

        if (lines[index][0]!='('):                  #Add '(' to the beginning of each line
            lines[index] = "(" + lines[index]
        if (lines[index][-1]==';'):                 #Remove the dot-comma at the end of each line if needed
            lines[index] = lines[index][:-1]
        if (lines[index][-1]!=',' and lines[index][-2]!=')'):  #Add '),' to the end of each line, except for the last where only ')' is needed
            if(index!=len(lines)-1):
                lines[index] = lines[index] + '),'
            else:
                lines[index] = lines[index] + ')'

        lines[index]=lines[index].replace(';',',')          #Transforme semi_comma to comma
        lines[index]=lines[index]+"\n"                      #read the line return at each line

    file = open("csv_edited_"+fileName, "w+")
    file.write("".join(lines))
    file.close()

def main():

    fileNames = os.listdir()
    csvFileNames = list()

    for fileName in fileNames:
        if fileName.endswith(".csv") and not(fileName.startswith("csv_edited")):
            csvFileNames.append(fileName)

    for fileName in csvFileNames:
        editCSVFile(fileName)

    print("Be carefull : Mysql need to escape \"'\" by \"''\" char, you need to do it manually")


if (__name__ == "__main__"):
    main()
