#!/bin/bash

EX=5
TAR_FILE=project$EX.tar
FILE_LIST='CPU Computer Memory ExtendAlu CpuMul'

mkdir testTar
cp $TAR_FILE testTar/
cd testTar/

tar -xf $TAR_FILE

for CHIP in $FILE_LIST; do
  if [ ! -r $CHIP.hdl ]; then
    echo Chip $CHIP was not found
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