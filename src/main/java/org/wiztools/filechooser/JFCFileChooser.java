package org.wiztools.filechooser;

import java.awt.Component;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileView;

/**
 *
 * @author subwiz
 */
public class JFCFileChooser implements FileChooser {
    
    private final JFileChooser jfc = new JFileChooser();
    
    private final Map<javax.swing.filechooser.FileFilter, FileFilter> filterMap = new HashMap<>();

    @Override
    public void addChoosableFileFilter(FileFilter ff) {
        javax.swing.filechooser.FileFilter jfcFF = new JFCFileFilter(ff);
        filterMap.put(jfcFF, ff);
        jfc.addChoosableFileFilter(jfcFF);
    }    

    @Override
    public void setFileFilter(FileFilter ff) {
        jfc.setFileFilter(new JFCFileFilter(ff));
    }

    @Override
    public FileFilter getFileFilter() {
        javax.swing.filechooser.FileFilter jfcFF = jfc.getFileFilter();
        return filterMap.get(jfcFF);
    }

    @Override
    public File getSelectedFile() {
        return jfc.getSelectedFile();
    }

    @Override
    public File[] getSelectedFiles() {
        return jfc.getSelectedFiles();
    }

    @Override
    public void setSelectedFile(File f) {
        jfc.setSelectedFile(f);
    }

    @Override
    public void setDialogTitle(String title) {
        jfc.setDialogTitle(title);
    }

    @Override
    public void setMultiSelectionEnabled(boolean enable) {
        jfc.setMultiSelectionEnabled(enable);
    }

    @Override
    public void setCurrentDirectory(File dir) {
        jfc.setCurrentDirectory(dir);
    }

    @Override
    public FileChooserResponse showOpenDialog(Component component) {
        int ret = jfc.showOpenDialog(component);
        if(ret == JFileChooser.APPROVE_OPTION) {
            return FileChooserResponse.APPROVE_OPTION;
        }
        return FileChooserResponse.CANCEL_OPTION;
    }

    @Override
    public FileChooserResponse showSaveDialog(Component parent) {
        int ret = jfc.showSaveDialog(parent);
        if(ret == JFileChooser.APPROVE_OPTION) {
            return FileChooserResponse.APPROVE_OPTION;
        }
        return FileChooserResponse.CANCEL_OPTION;
    }
    
    public void setFileView(FileView fv) {
        jfc.setFileView(fv);
    }
}
