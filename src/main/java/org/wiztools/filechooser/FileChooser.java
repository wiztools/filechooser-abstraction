package org.wiztools.filechooser;

import java.awt.Component;
import java.io.File;

/**
 *
 * @author subwiz
 */
public interface FileChooser {
    void setFileFilter(FileFilter ff);
    File getSelectedFile();
    File[] getSelectedFiles();
    void setDialogTitle(String title);
    void setMultiSelectionEnabled(boolean enable);
    
    void setCurrentDirectory(File dir);
    
    FileChooserResponse showOpenDialog(Component parent);
    FileChooserResponse showSaveDialog(Component parent);
}