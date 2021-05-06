import model.Game;
import model.UnoGame;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {
        UnoGame game= new Game();
        MainFrame mainFrame= new MainFrame(game);
    }
}
