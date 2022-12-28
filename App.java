import controller.TabuleiroController;
import model.Player;
import model.Tabuleiro;
import util.ConsoleUIHelper;
import view.Print;

public class App {
    public static void main(String[] args) {
        Player player = new Player("player");
        Player bot = new Player("bot");
        
        Print.menu();
        if (TabuleiroController.lerRegras()){
            Print.regras();
        }

        Boolean whoStarts = TabuleiroController.option() != 0;

        do{
            if(whoStarts){ // vez do player jogar
                TabuleiroController.jogada(bot);
                Print.imprimirTabuleiro(bot.getTabuleiro());
                whoStarts = false;
            }else{
                TabuleiroController.jogada(player);
                whoStarts = true;
            }

        }while(true);

     
    }

    
    
}
