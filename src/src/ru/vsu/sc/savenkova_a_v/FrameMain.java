package src.ru.vsu.sc.savenkova_a_v;

import src.ru.vsu.sc.savenkova_a_v.util.ArrayUtils;
import src.ru.vsu.sc.savenkova_a_v.util.JTableUtils;
import src.ru.vsu.sc.savenkova_a_v.util.ListUtils;
import src.ru.vsu.sc.savenkova_a_v.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FrameMain extends JFrame {
    private JPanel PanelMain;
    private JTable tableSource;
    private JButton buttonLoadFromFile;
    private JButton buttonRun;
    private JTable tableResult;
    private JButton buttonSaveIntoFile;

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public FrameMain() {
        this.setTitle("Task 3");
        this.setContentPane(PanelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableSource, 150, false, false, false, false, 25, 15);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        buttonLoadFromFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(PanelMain) == JFileChooser.APPROVE_OPTION) {
                    String[] symbols = ArrayUtils.readLinesFromFile(fileChooserOpen.getSelectedFile().getPath());
                    JTableUtils.writeArrayToJTable(tableSource, symbols);
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        buttonSaveIntoFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(PanelMain) == JFileChooser.APPROVE_OPTION) {
                    String[] symbols = JTableUtils.readStringArrayFromJTable(tableResult);
                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }

                    ArrayUtils.writeArrayToFile(file, symbols);
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        buttonRun.addActionListener(actionEvent -> {
            try {
                String str = Arrays.toString(JTableUtils.readStringArrayFromJTable(tableSource));
                str = str.replace("[", "");
                str = str.replace("]", "");
                String result = ReversingElementsOfStack.reverseStandardStack(str);
                String[] resultArr = {result};
                JTableUtils.writeArrayToJTable(tableResult, resultArr);

            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });
    }
}
