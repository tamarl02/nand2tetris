// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[3], respectively.)

	  @R2
	  M = 0 //R2=0

      @R0
      D=M
      @END
      D;JEQ //if R0=0 => R2=R0*R1=0
    
      @R1
      D=M
      @END
      D;JEQ  //if R1=0 => R2=R0*R1=0

(LOOP)
	  @R0
	  D = M
	  @END
	  D;JEQ // if(R0 = 0) 

	  @R1 // M=R1
	  D = M // D=R1
	  @R2 //M=R2
	  M = D + M //R2 = R1 + R2

	  @R0 //M = R0
	  M = M - 1; // R0 = R0 - 1
	  
	  @LOOP
	  0;JMP
(END)
	  @END
	  0;JMP


