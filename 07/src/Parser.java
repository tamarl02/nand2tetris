import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	private static final String COMMENT = "//";
	private static final Object CALL = "call";
	private static final Object PUSH = "push";
	private static final Object POP = "pop";
	private static final Object FUNCTION = "function";
	private static final Object IF_GOTO = "if-goto";
	private static final Object RETURN = "return";
	private static final Object LABEL = "label";

	public enum Command {
		C_ARITHMETIC, C_PUSH, C_POP, C_LABEL, C_GOTO, C_IF, C_FUNCTION, C_RETURN, C_CALL
	}

	private BufferedReader _br = null;
	private String _currentLine;
	private String _currCommand;
	private String _arg1;
	private int _arg2;

	/**
	 * opens the INPUT stream/file and gets ready to parse it
	 * 
	 * @param inputfile
	 */
	public Parser(String inputfile) {
		try {
			_br = new BufferedReader(new FileReader(inputfile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return if there are more commands in the input file
	 */
	public boolean hasMoreCommands() {
		try {

			_currentLine = _br.readLine();
			// if there is a current line, but it's a comment or a space-line ,
			// keep reading the file
			if (_currentLine != null) {
				while (_currentLine.startsWith(COMMENT)
						|| _currentLine.trim().length() == 0) {
					_currentLine = _br.readLine();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		if (_currentLine != null) {
			return true;
		}
		// if there are no more lines in the .vm file, close the stream
		if (_br != null) {
			try {
				_br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	/**
	 * reads the next command from the input and makes it the current command.
	 * is called ONLY if hasMoreCommands()==true initially there is no current
	 * command
	 */
	public void advance() {
		_currCommand = _currentLine.trim();
	}

	/**
	 * @return the type of the current VM command . C_ARITHMETIC is returned for
	 *         all the arithmetic commands
	 */
	public Parser.Command commandType() {
		String[] spiltLine = _currCommand.split(" ");

		if (spiltLine.length == 1) {
			_arg1 = spiltLine[0];
			return Command.C_ARITHMETIC;
		}
		if (spiltLine.length > 1) {
			_arg1 = spiltLine[1];
		}
		if (spiltLine.length > 2) {
			_arg2 = Integer.parseInt(spiltLine[2]);
		}
		String command = spiltLine[0];
		if (command.equals(CALL)) {
			return Command.C_CALL;
		}
		if (command.equals(PUSH)) {
			return Command.C_PUSH;
		}
		if (command.equals(POP)) {
			return Command.C_POP;
		}
		if (command.equals(FUNCTION)) {
			return Command.C_FUNCTION;
		}
		if (command.equals(IF_GOTO)) {
			return Command.C_IF;
		}
		if (command.equals(RETURN)) {
			return Command.C_RETURN;
		}
		if (command.equals(LABEL)) {
			return Command.C_LABEL;
		}
		return null;

	}

	/**
	 * @return the first argument of the current command. in the case of
	 *         C_ARITHMETIC: the command itself ("add", "sub", etc...) SHOULD
	 *         NOT BE CALLED IF: commandType() == C_RETURN
	 */
	public String arg1() {
		return _arg1;

	}

	/**
	 * @return the second argument of the current command . SHOULD BE CALLED
	 *         ONLY IF: commandType() == C_PUSH/C_POP/C_FUNCTION/C_CALL
	 */
	public int arg2() {
		return _arg2;

	}
}
