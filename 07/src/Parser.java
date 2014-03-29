import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
	private static final String COMMENT = "//";

	public enum Command {
		C_ARITHMETIC, C_PUSH, C_POP, C_LABEL, C_GOTO, C_IF, C_FUNCTION, C_RETURN, C_CALL
	}

	private BufferedReader _br = null;
	private String _currentLine;
	private String _currCommand;

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
			// if there is a current line, but it's a comment or a space-line , keep reading the file
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
