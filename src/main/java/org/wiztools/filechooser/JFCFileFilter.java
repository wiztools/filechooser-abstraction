package org.wiztools.filechooser;

import java.io.File;

/**
 *
 * @author subwiz
 */
public final class JFCFileFilter extends javax.swing.filechooser.FileFilter implements FileFilter {

    private final FileFilter ff;
    
    public JFCFileFilter(FileFilter ff) {
        this.ff = ff;
    }

    @Override
    public boolean accept(File f) {
        return ff.accept(f);
    }

    @Override
    public String getDescription() {
        return ff.getDescription();
    }
    
}
