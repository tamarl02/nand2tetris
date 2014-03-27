//The program input will be at R13,R14 while the result R13/R14 will be store at R15.
//The program should have a running time logarithmic with respect to the input size.


@curr
M=1 //curr=1

@R15
M=0 // R15=0


@R14
D=M
@denom
M=D

@R13
D=M
@dev
M=D


// if denom==0: finish
@denom
D=M 
@END
D;JEQ // IF(R14==0)

// if denom > dividend: finish
@denom
D=M //D=*(denom)
@dev // dividend
D=D-M // denom - dividend
@END
D;JGT // denom > dividend (denom - dividend>0) : return 0


// if denom == dividend: finish
@denom
D=M
@dev // dividend
D=D-M // denom - dividend
@EQUAL
D;JEQ // denom == dividend (denom - dividend = 0) : return 1

	
(LOOP1)	
	@dev // dividend
	D=M //D=*(R13)
	@denom // denom
	D=D-M // D =  dividend - denom
	@LOOP2
	D;JLT // if(denom > dividend): jump to loop2
	
	@denom 
	D=M<<
	@LOOP3
	D;JLE //stop before overflow and don't do LOOP2
	
	@denom 
	M=M<< // denom * 2
	@curr 
	M=M<< // curr * 2
	
	@LOOP1
	0;JMP
	
(LOOP2)
	@denom 
	M=M>> // denom / 2
	@curr 
	M=M>> // curr / 2

(LOOP3)
	@curr
	D=M 
	@END
	D;JEQ // IF(curr == 0): finish
	
	// IF(dividend >= denom)
	@dev
	D=M 
	@denom
	D=D-M // D = dividend - denom
	@LOOP4
	D;JGE 
	
	@LOOP3_B
	0;JMP
	
	
(LOOP3_B)	
	@curr
	M=M>> // curr / 2
	@denom
	M=M>>// denom / 2
	
	@LOOP3
	0;JMP

(LOOP4)
	
	@denom
	D=M 
	@dev
	M = M-D // dividend = dividend - denom
	
	
	@curr
	D=M 
	@R15
	M=D+M // R15 = answer+curr
	
	@LOOP3_B
	0;JMP

(EQUAL)
	@R15
	M=1 // set result to 1
		
(END)

