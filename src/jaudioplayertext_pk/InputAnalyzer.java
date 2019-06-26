package jaudioplayertext_pk;

import java.io.File;

public class InputAnalyzer {

	private File file; 

	protected boolean pathValidator(String path) {

		if (path.matches(".*[/\n\r\t\0\f`?*\\<>|\":].*")) {

			return true;

		} else {

			return false;

		}

	}

	protected boolean isDirectory(String path) {

		file = new File(path);

		if (file.isDirectory()) {

			return true;

		} else if (!file.isDirectory()) {

			return false;

		}

		return false;

	}

	protected boolean isValidFile(String path) {

		file = new File(path);

		if ((file.exists() == true) && (file.isFile() == true) && (file.canExecute() == true)) {

			return true;

		} else if ((file.exists() == false) && (file.isFile() == false) && (file.canExecute() == false)) {

			return false;

		}

		return false;

	}

	protected File createFile(String path) {

		this.file = new File(path);
		return file;

	}

	protected String getName() {

		return this.file.getName();

	}
	
}
