import controller.TabuleiroController;
import model.Player;
import util.ConsoleUIHelper;
import view.Print;

public class App {
    public static void main(String[] args) {
        Player player = new Player();
        Player bot = new Player();
        Print.menu();
        if (TabuleiroController.option() == 0){
            System.out.println("player começa");
        } else {
            System.out.println("Bot começa");
        }

     
    }

    
    
}
