//
// The program sort the arr starting at the address in R14 with length specified in R15.
// The sort is in descending order - the largest number at the head of the arr.
//


	@outIndex     // init outer index
	M=0

(OUTER)
	@R15
	D=M
	@inIndex        // init the inner index
	M=D-1

(INNER)  	  		
	@R14      
	D=M
	@inIndex
	A=D+M           // goes to address arr[inIndex]
	D=A-1          
	@firstaddress   // stores the address of arr[inIndex]
	M=D

	D=D+1           // goes to address arr[inIndex - 1]
	@secondaddress  // stores the address of arr[inIndex - 1]
	M=D

	@firstaddress
	A=M
	D=M               // get the value arr[inIndex]
	@secondaddress
	A=M
	D=D-M             // calc val (arr[inIndex] - arr[inIndex - 1])
	@SWAP
	D;JGT             // if(arr[inIndex] - arr[inIndex - 1]) > 0 then swap values

	@inIndex                 
	M=M-1             // inIndex = inIndex - 1
	D=M
	@outIndex
	D=D-M
	@INNER            // if (inIndex > outIndex) jump to inner loop
	D;JGT

	@outIndex               
	M=M+1	
	D=M
	@R15                
	D=M-D
	@OUTER            // if (R14 - inIndex > 0) jump to outer loop
	D;JGT

	@END
	0;JMP



(SWAP)          	  // swaps arr[inIndex] and arr[inIndex-1]
	@firstaddress
	A=M
	D=M
	@firstvalue       // stores value of arr[inIndex]
	M=D

	@secondaddress
	A=M
	D=M
	@secondvalue       // stores the value of arr[inIndex-1]
	M=D

	@secondvalue       // stores the value of arr[inIndex-1] in arr[inIndex]
	D=M
	@firstaddress
	A=M
	M=D

	@firstvalue        // stores the value of arr[inIndex] in arr[inIndex-1]
	D=M
	@secondaddress
	A=M
	M=D
 
	@inIndex                 
	M=M-1          
	D=M
	@outIndex
	D=D-M
	@INNER              //if(inIndex - outIndex > 0) jump to INNER loop
	D;JGT

	@outIndex               
	M=M+1	   			
	D=M
	@R15                
	D=M-D
	@OUTER              //if(length - outIndex > 0) jump to outer loop 
	D;JGT

(END)