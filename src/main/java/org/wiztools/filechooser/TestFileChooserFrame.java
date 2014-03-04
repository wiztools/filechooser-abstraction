package org.wiztools.filechooser;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author subwiz
 */
public class TestFileChooserFrame extends JFrame {
    
    public static void main(String[] arg) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestFileChooserFrame("Test FileChooser");
            }
        });
    }
    
    private final JButton jb_jfc = new JButton("JFileChooser");
    private final JButton jb_fd = new JButton("FileDialog");
    private final JLabel jl = new JLabel("     <<<Try>>>     ");

    public TestFileChooserFrame(String title) throws HeadlessException {
        super(title);
        
        jb_jfc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileChooser fc = new JFCFileChooser();
                process(fc);
            }
        });
        
        jb_fd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileChooser fc = new FDFileChooser();
                process(fc);
            }
        });
        
        setLayout(new BorderLayout());
        
        JPanel jp_center = new JPanel(new FlowLayout());
        jp_center.add(jb_jfc);
        jp_center.add(jb_fd);
        
        add(jp_center, BorderLayout.CENTER);
        
        JPanel jp_south = new JPanel();
        jp_south.add(jl);
        
        add(jp_south, BorderLayout.SOUTH);
        
        pack();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void process(FileChooser fc) {
        fc.setDialogTitle("JFileChooser");
        FileChooserResponse res = fc.showOpenDialog(this);
        if(res == FileChooserResponse.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            jl.setText(f.getName());
        }
        else {
            jl.setText("<CANCELLED>");
        }
    }
    
}
