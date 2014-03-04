# WizTools.org FileChooser Abstraction Library

An abstraction library (adapter pattern) to easily switch between JFileChooser and FileDialog.

## Usage

Typical usage:

	import org.wiztools.filechooser.*;

	...

	FileChooser fc = new JFCFileChooser(); // To use JFileChooser
	FileChooser fc = new FDFileChooser();  // To use FileDialog

	...

	fc.setDialogTitle("JFileChooser");
	FileChooserResponse res = fc.showOpenDialog(this); // `this' could be Frame / Dialog
	if(res == FileChooserResponse.APPROVE_OPTION) {
		File f = fc.getSelectedFile();
		// your code
	}
	else if(res == FileChooserResponse.CANCEL_OPTION) {
		// your code
	}

Using FileFilter:

	import org.wiztools.filechooser.*;

	...

	// 1. Define FileChooser:
	FileChooser fc = ...;


	// 2. Define FileFilter:
	FileFilter ff = new FileFilter() {
		public boolean accept(File file) {
			if(file.getName().endsWith(".xml")) {
				return true;
			}
			return false;
		}
	
		public String getDescription() {
			return "XML";
		}
	};

	// 3. Assign the FileFilter to the FileChooser:
	fc.setFileFilter(ff);
