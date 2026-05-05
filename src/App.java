import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        int rowCount = 21, columCount = 19;
        int tileSize = 32;
        int boardWidth = columCount * tileSize;
        int boardHeight = rowCount * tileSize;

        JFrame frame = new JFrame("Pac Man");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PacMan pacmangame = new PacMan();
        frame.add(pacmangame);
        frame.pack();
        pacmangame.requestFocus();
        frame.setVisible(true);
    }

}
