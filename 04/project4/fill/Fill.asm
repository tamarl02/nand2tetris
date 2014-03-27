// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input. 
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel. When no key is pressed, the
// program clears the screen, i.e. writes "white" in every pixel.


(INIT)  	//initializes i - index that runs on the screen's pixels
	@8192	 // 32 * 256 number of 16 bit pixel lines to cover the entire screen
	D=A
	@i                   //initializes the index variable to 8192, this is the remaining address left to color onscreen
	M=D

(LOOP)	           //progresses the index backwards. 
	@i
	M=M-1
	D=M
	@INIT
	D;JLT               //if index<0 - go to INDEX INITIALIZER to reset it
	@KBD	            //loads the keyboard's address
	D=M
	@WHITE		        //if (Memory at keyboard address == 0) - meaning no key is pressed - go to WHITE, else go to BLACK
	D;JEQ
	@BLACK
	0;JMP

(BLACK)             
	@SCREEN            //loads the screen's first address - 16384 (0x4000)
	D=A
	@i
	A=D+M              //adds the current index to the screen's first address in order to color the current set of 16 pixels
	M=-1               //sets value in current address to -1, so that the whole word 1...1 (16bits long),  meaning - all 16 pixels will be "painted" black.
	@LOOP              //jumps back to indexer in order to progress the index backwards.
	0;JMP

(WHITE)
	@SCREEN            //loads the screen's first address - 16384 (0x4000)
	D=A                
	@i        
	A=D+M              //adds the current index to the screen's first address in order to color the current set of 16 pixels
	M=0                //sets value in current address to 0, so that the whole word will be 0....0 (16bits long), meaning - all 16 pixels will be "painted" white.
	@LOOP           //jumps back to indexer in order to progress the index backwards.
	0;JMP