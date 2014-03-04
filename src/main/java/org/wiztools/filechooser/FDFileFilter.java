package org.wiztools.filechooser;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author subwiz
 */
public final class FDFileFilter implements FilenameFilter, FileFilter {

    private final FileFilter ff;
    
    public FDFileFilter(FileFilter ff) {
        this.ff = ff;
    }

    @Override
    public boolean accept(File file) {
        return ff.accept(file);
    }
    
    @Override
    public boolean accept(File dir, String name) {
        return accept(new File(dir, name));
    }

    @Override
    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
