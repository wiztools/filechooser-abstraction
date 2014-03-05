package org.wiztools.filechooser;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author subwiz
 */
public class FDFileChooser implements FileChooser {
    

    private FilenameFilter ff;
    private File selectedFile;
    private File setSelectedFile;
    private File[] selectedFiles;
    private String title;
    private boolean multipleMode = false;
    private File currentDir;

    @Override
    public void addChoosableFileFilter(FileFilter ff) {
        setFileFilter(ff);
    }
    
    @Override
    public void setFileFilter(FileFilter ff) {
        this.ff = new FDFileFilter(ff);
    }

    @Override
    public File getSelectedFile() {
        return selectedFile;
    }

    @Override
    public File[] getSelectedFiles() {
        return selectedFiles;
    }

    @Override
    public void setSelectedFile(File f) {
        this.setSelectedFile = f;
    }

    @Override
    public void setDialogTitle(String title) {
        this.title = title;
    }

    @Override
    public void setMultiSelectionEnabled(boolean enable) {
        this.multipleMode = enable;
    }

    @Override
    public void setCurrentDirectory(File dir) {
        currentDir = dir;
    }
    
    private void setFDOptions(FileDialog fd) {
        if(currentDir != null) fd.setDirectory(currentDir.getAbsolutePath());
        fd.setMultipleMode(multipleMode);
        if(title != null) fd.setTitle(title);
        if(ff != null) fd.setFilenameFilter(ff);
        if(setSelectedFile != null) {
            fd.setFile(setSelectedFile.getAbsolutePath());
            setSelectedFile = null;
        }
    }
    
    private FileDialog getFileDialog(Component parent) throws IllegalArgumentException {
        final FileDialog fd;
        if(parent instanceof Dialog) {
            fd = new FileDialog((Dialog) parent);
        }
        else if(parent instanceof Frame) {
            fd = new FileDialog((Frame) parent);
        }
        else {
            throw new IllegalArgumentException("FileDialog accepts only Dialog / Frame component!");
        }
        return fd;
    }
    
    private FileChooserResponse returnResponse(FileDialog fd) {
        if(multipleMode) {
            selectedFiles = fd.getFiles();
            return selectedFiles.length == 0?
                    FileChooserResponse.CANCEL_OPTION: FileChooserResponse.APPROVE_OPTION;
        }
        else {
            final String fileStr = fd.getFile();
            selectedFile = fileStr!=null? new File(fileStr): null;
            return selectedFile == null?
                    FileChooserResponse.CANCEL_OPTION: FileChooserResponse.APPROVE_OPTION;
        }
    }

    @Override
    public FileChooserResponse showOpenDialog(Component parent) {
        final FileDialog fd = getFileDialog(parent);
        setFDOptions(fd);
        
        fd.setMode(FileDialog.LOAD);
        fd.setVisible(true);
        
        return returnResponse(fd);
    }

    @Override
    public FileChooserResponse showSaveDialog(Component parent) {
        final FileDialog fd = getFileDialog(parent);
        setFDOptions(fd);
        
        fd.setMode(FileDialog.SAVE);
        fd.setVisible(true);
        
        return returnResponse(fd);
    }
    
}
