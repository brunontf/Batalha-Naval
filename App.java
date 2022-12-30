import controller.TabuleiroController;
import model.Player;
import util.ConsoleUIHelper;
import view.Print;

public class App {
    public static void main(String[] args) {

        Print.menu();
        if (TabuleiroController.lerRegras()) {
            Print.regras();
        }
        int autoPosicionar = ConsoleUIHelper.askChooseOption("Deseja posicionar as embarcações manualmente ?", "Sim", "Não");
        Player player = new Player("player", autoPosicionar);
        Player bot = new Player("bot", 1);
        Boolean whoStarts = TabuleiroController.option() == 0;

        do {
            if (whoStarts) { // vez do player jogar
                // Print.imprimirTabuleiro(bot.getTabuleiro()); // TEMP CHEAT - DELETE AFTER
                Print.printOwnerTabuleiro(bot);
                Print.imprimirTabuleiro(bot.getTabuleiroEmBranco());
                TabuleiroController.jogada(bot);
                whoStarts = false;
            } else {
                TabuleiroController.jogada(player);
                Print.printOwnerTabuleiro(player);
                Print.imprimirTabuleiro(player.getTabuleiro());
                whoStarts = true;
            }
        } while (true);
    }


}
