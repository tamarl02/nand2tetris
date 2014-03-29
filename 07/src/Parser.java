public class Parser {

	public enum Command {
		C_ARITHMETIC, C_PUSH, C_POP, C_LABEL, C_GOTO, C_IF, C_FUNCTION, C_RETURN, C_CALL
	};

	/**
	 * opens the INPUT stream/file and gets ready to parse it
	 * 
	 * @param inputfile
	 */
	public Parser(String inputfile) {
	}

	/**
	 * @return if there are more commands in the input file
	 */
	public boolean hasMoreCommands() {
		return false;

	}

	/**
	 * reads the next command from the input and makes it the current command.
	 * is called ONLY if hasMoreCommands()==true initially there is no current
	 * command
	 */
	public void advance() {

	}

	/**
	 * @return the type of the current VM command . C_ARITHMETIC is returned for
	 *         all the arithmetic commands
	 */
	public Parser.Command commandType() {
		return null;

	}

	/**
	 * @return the first argument of the current command. in the case of
	 *         C_ARITHMETIC: the command itself ("add", "sub", etc...) SHOULD
	 *         NOT BE CALLED IF: commandType() == C_RETURN
	 */
	public String arg1() {
		return null;

	}

	/**
	 * @return the second argument of the current command . SHOULD BE CALLED
	 *         ONLY IF: commandType() == C_PUSH/C_POP/C_FUNCTION/C_CALL
	 */
	public int arg2() {
		return 0;

	}
}
