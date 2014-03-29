


public class CodeWriter {
	
	/**
	 *C'tor
	 *opens the OUTPUT file/stream and gets ready to write into it 
	 */
	public CodeWriter() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * informs the code writer  that the translation  of a new VM file has started
	 * @param fileName
	 */
	public void setFileName(String fileName){
		
	}
	
	/**
	 * writes the assembly code that is the translation of the given arithmetic command
	 * @param command
	 */
	public void writeArithmetic(String command){
		
	}
	
	/**
	 * writes the assembly code that is the translation of the given command
	 * @param command - either C_PUSH or C_POP
	 * @param segment
	 * @param index
	 */
	public void writePushPop(Parser.Command command, String segment, int index ){
		
	}
	
	/**
	 * closes the input file 
	 */
	public void close(){
		
		//check if the stream isn't null and close it
		
	}
	

}
