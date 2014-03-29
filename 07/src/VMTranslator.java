import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VMTranslator {

	private static final int IS_FILE = 0;
	private static final int IS_DIR = 1;
	private static final String USAGE_ISSUE = "Input a .asm file, or a directory";
	private static final int BAD_INPUT = -1;
	private static final String VM_FILE = "(\\w*).vm$";
	private static final String ASM_EX = "asm";


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputFileName = args[0].trim();
		int res = IsVMFileOrDir(inputFileName);
		String asmFileName = getAsmFileName(inputFileName);
		CodeWriter codeWriter = new CodeWriter();
		codeWriter.setFileName(asmFileName);
		
		if (res == IS_FILE) {
			translate(inputFileName, codeWriter);

		} else if (res == IS_DIR) {
			ArrayList<String> filesInDir = getFilesNames(inputFileName);
			for (int i = 0; i < filesInDir.size(); i++) {
				translate(filesInDir.get(i), codeWriter);
			}
		} else {
			System.out.println(USAGE_ISSUE);
			return;
		}
		codeWriter.close();

	}

	private static String getAsmFileName(String fileName) {
		String tmpArr = fileName.substring(0, fileName.length() - 2);
		return tmpArr + ASM_EX;
	}

	private static void translate(String inputFileName, CodeWriter codeWriter) {
		Parser parse = new Parser(inputFileName);
		
		
	}

	private static ArrayList<String> getFilesNames(String string) {
		File f = new File(string);
		ArrayList<String> results = new ArrayList<String>();
		File[] files = f.listFiles();

		// Now create matcher object.
		for (File file : files) {
			if (file.exists() && file.isFile()) {
				file.getName().matches(VM_FILE);

				results.add(file.getPath());

			}
		}
		return results;
	}

	private static int IsVMFileOrDir(String filename) {
		File f = new File(filename);
		if (f.isDirectory()) {
			return IS_DIR;
		}
		// Create a Pattern object
		Pattern r = Pattern.compile(VM_FILE);

		// Now create matcher object.
		Matcher m = r.matcher(filename);
		if (m.find()) {
			if (f.exists() && f.isFile()) {
				return IS_FILE;
			}
		}
		return BAD_INPUT;
	}

}
