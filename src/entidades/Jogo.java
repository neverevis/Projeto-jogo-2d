package entidades;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jogo extends JFrame implements KeyListener
{
    private JLabel mapa;
    private JLabel personagem;
    ImageIcon imagem;
    ImageIcon mapaImg;

    private int pTamanho= 50;
    private int pVelocidade = 6;

    private int telaLargura = 1280;
    private int telaAltura = 720;

    public boolean movDir = false;
    public boolean movEsq = false;
    public boolean movCima = false;
    public boolean movBaixo = false;

    public Jogo()
    {
        //definir titulo da janela
        setTitle("Jogo 2d");
        //definir tamanho
        setSize(telaLargura,telaAltura);
        //fechar o programa ao clicar em close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //visibilidade
        setVisible(true);
        //tira o layout automatico
        setLayout(null);
        //colocar relativo ao centro da tela
        setLocationRelativeTo(null);
        //adicionar keylistener ao JFrame
        addKeyListener(this);

        imagem = new ImageIcon(getClass().getResource("/down.png"));
        mapaImg = new ImageIcon(getClass().getResource("/map.png"));

        personagem = new JLabel();
        mapa = new JLabel();

        mapa.setBounds(0,0,telaLargura,telaAltura);
        personagem.setBounds(telaLargura/2 - pTamanho/2,telaAltura/2 - pTamanho/2,pTamanho,pTamanho);
        personagem.setIcon(imagem);
        mapa.setIcon(mapaImg);
        //personagem.setBackground(Color.blue);
        //personagem.setOpaque(true);

        this.add(personagem);
        this.add(mapa);
        this.revalidate();
        this.repaint();
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyChar() == 'd')
        {
            imagem = new ImageIcon(getClass().getResource("/right.png"));
            personagem.setIcon(imagem);
            movDir = true;
            System.out.println("direita");
        }
        else if(e.getKeyChar() == 'a')
        {
            movEsq = true;
            imagem = new ImageIcon(getClass().getResource("/left.png"));
            personagem.setIcon(imagem);
            System.out.println("esquerda");
        }
        else if(e.getKeyChar() == 'w')
        {
            movCima = true;
            imagem = new ImageIcon(getClass().getResource("/up.png"));
            personagem.setIcon(imagem);
            System.out.println("cima");

        }
        else if(e.getKeyChar() == 's')
        {
            movBaixo = true;
            imagem = new ImageIcon(getClass().getResource("/down.png"));
            personagem.setIcon(imagem);
            System.out.println("baixo");
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyChar() == 'd')
        {
            movDir = false;
        }
        else if(e.getKeyChar() == 'a')
        {
            movEsq = false;
        }
        else if(e.getKeyChar() == 'w')
        {
            movCima = false;
        }
        else if(e.getKeyChar() == 's')
        {
            movBaixo = false;
        }
    }

    public void movimentar()
    {
        if(movCima && movDir)
            personagem.setLocation(personagem.getX() + pVelocidade/4*3,personagem.getY() - pVelocidade/4*3);
        else if(movCima && movEsq)
            personagem.setLocation(personagem.getX() - pVelocidade/4*3,personagem.getY() - pVelocidade/4*3);
        else if(movBaixo && movDir)
            personagem.setLocation(personagem.getX() + pVelocidade/4*3,personagem.getY() + pVelocidade/4*3);
        else if(movBaixo && movEsq)
            personagem.setLocation(personagem.getX() - pVelocidade/4*3,personagem.getY() + pVelocidade/4*3);
        else
        {
            if (movDir)
                personagem.setLocation(personagem.getX() + pVelocidade, personagem.getY());
            else if (movEsq)
                personagem.setLocation(personagem.getX() - pVelocidade, personagem.getY());
            else if (movCima)
                personagem.setLocation(personagem.getX(), personagem.getY() - pVelocidade);
            else if (movBaixo)
                personagem.setLocation(personagem.getX(), personagem.getY() + pVelocidade);
        }
    }

}
