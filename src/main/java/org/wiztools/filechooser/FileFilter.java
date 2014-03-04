package org.wiztools.filechooser;

import java.io.File;

/**
 *
 * @author subwiz
 */
public interface FileFilter {
    public boolean accept(File file);
    
    public String getDescription();
}
