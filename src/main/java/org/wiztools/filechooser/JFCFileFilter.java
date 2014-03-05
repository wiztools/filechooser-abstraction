package org.wiztools.filechooser;

import java.io.File;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.ff.getDescription());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JFCFileFilter other = (JFCFileFilter) obj;
        if (!Objects.equals(this.ff.getDescription(), other.ff.getDescription())) {
            return false;
        }
        return true;
    }
}
