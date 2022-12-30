import controller.TabuleiroController;
import model.Player;
import util.ConsoleUIHelper;
import view.Print;

public class App {
    public static void main(String[] args) {
        System.out.println("\uD83D\uDCA5"); //explosion
        System.out.println("\u26F5");//boat
        System.out.println("\uD83C\uDF0A");
        System.out.println(	"\uD83E\uDD16");//robot
        System.out.println(	"\uD83C\uDF00");// ciclone
        //System.out.println(	"\uD83D\uDD30");//simbolo iniciante
        System.out.println(	"\u2620".toUpperCase());//pirate 1

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
                //Print.imprimirTabuleiro(bot.getMatriz()); // TEMP CHEAT - DELETE AFTER
                Print.printOwnerTabuleiro(bot);
                Print.imprimirTabuleiro(bot.getTabuleiroEmBranco());
                TabuleiroController.jogada(bot);
                whoStarts = false;
            } else {
                TabuleiroController.jogada(player);
                Print.printOwnerTabuleiro(player);
                Print.imprimirTabuleiro(player.getMatriz());
                whoStarts = true;
            }
        } while (true);
    }


}
