import model.GUIOptions;
import model.GUIPlayer;

public class GUIApp {

    public static void main(String[] args) {

        GUIPlayer player = new GUIPlayer("player",0);
        GUIPlayer bot = new GUIPlayer("bot",600);
        GUIOptions options = new GUIOptions(player,bot);

    }
}