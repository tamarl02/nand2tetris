// This file is part of www.nand2tetris.org

load Sort.asm,
output-file Sort.out,
compare-to Sort.cmp,
output-list RAM[90]%D2.6.2 RAM[91]%D2.6.2 RAM[92]%D2.6.2 RAM[93]%D2.6.2 RAM[94]%D2.6.2 RAM[95]%D2.6.2 RAM[96]%D2.6.2 RAM[97]%D2.6.2;

set RAM[14] 90,
set RAM[15] 8,

set RAM[90] 54,
set RAM[91] 5,
set RAM[92] 2154,
set RAM[93] 65,
set RAM[94] 76,
set RAM[95] 1,
set RAM[96] 7,
set RAM[97] 58,
repeat 5000 {
  ticktock;
}

output;

set PC 0,
set RAM[90] 5465,
set RAM[91] -5,
set RAM[92] 24654,
set RAM[93] 6554,
set RAM[94] 71,
set RAM[95] 0,
set RAM[96] 65,
set RAM[97] 8,
repeat 5000 {
  ticktock;
}

output;

set PC 0,
set RAM[90] 6576,
set RAM[91] 876,
set RAM[92] 24,
set RAM[93] 6875,
set RAM[94] 787,
set RAM[95] 65,
set RAM[96] -543,
set RAM[97] -65,
repeat 5000 {
  ticktock;
}

output;

set PC 0,
set RAM[90] -54,
set RAM[91] -5,
set RAM[92] -2154,
set RAM[93] -65,
set RAM[94] -76,
set RAM[95] -1,
set RAM[96] -7,
set RAM[97] -58,
repeat 5000 {
  ticktock;
}

output;

set PC 0,
set RAM[90] 876,
set RAM[91] 87,
set RAM[92] 7654,
set RAM[93] 654,
set RAM[94] -65,
set RAM[95] -1,
set RAM[96] 70,
set RAM[97] -9,
repeat 5000 {
  ticktock;
}

output;

