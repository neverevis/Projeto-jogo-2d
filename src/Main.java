import entidades.Jogo;

public class Main
{
    public static void main(String[] args)
    {
        Jogo display = new Jogo();

        do {
                display.movimentar();
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
            }
        }while(true);
    }
}