package src.ru.vsu.sc.savenkova_a_v;

import java.util.Locale;

public class GUIMain {

    public static void main(String[] args) throws Exception {
        winMain();
    }

    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);

        java.awt.EventQueue.invokeLater(() -> new FrameMain().setVisible(true));
    }
}
