import javax.swing.*;

public class Window extends JFrame {

//ToDo - בדיקה שיש קישור,,שינוי תמונה ללא new, בדיקה שיש פרופיל

    public static void main(String[] args) {
        new Window();
    }

    public Window() {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT);
        MainPanel mainPanel = new MainPanel();
        this.add(mainPanel);
        this.setVisible(true);
    }
}