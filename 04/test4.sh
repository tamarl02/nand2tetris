#!/bin/bash

EX=4
TAR_FILE=project$EX.tar
FILE_LIST=' mult/Mult fill/Fill sort/Sort divide/Divide'

mkdir testTar
cp $TAR_FILE testTar/
cd testTar/

tar -xf $TAR_FILE

for ASM_FILE in $FILE_LIST; do
  if [ -r $ASM_FILE.asm ]; then
    echo File $ASM_FILE exists
  else
    echo File $ASM_FILE was not found
  fi
done

if [ -r README ]; then
  dos2unix README &> /dev/null
  logins=`head -1 README`
  echo Your logins are: $logins, is that ok?
else
  echo No README was found
fi

cd ../
rm -Rf testTar
