# WizTools.org FileChooser Abstraction Library

An abstraction library (adapter pattern) to easily switch between JFileChooser and FileDialog.

## Usage

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
