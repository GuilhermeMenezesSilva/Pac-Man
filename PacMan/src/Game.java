import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.Image;


public class Game extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;
    private Player player = new Player(50, 50, 180);
    private Ghost ghost1 = new Ghost(300, 400, 0);
    private Ghost ghost2 = new Ghost(500, 300, 180);
    private Ghost ghost3 = new Ghost(300, 500, 0);
    private Ghost ghost4 = new Ghost(500, 500, 0);
    private Bomb bomb = new Bomb(100, 100);
    private Booster booster = new Booster(400, 400);

    private JLabel imgPlayer = new JLabel(new ImageIcon("src/images/pacman.png"));
    private JLabel imgGhost1 = new JLabel(new ImageIcon("src/images/ghost.png"));
    private JLabel imgGhost2 = new JLabel(new ImageIcon("src/images/ghost.png"));
    private JLabel imgGhost3 = new JLabel(new ImageIcon("src/images/ghost.png"));
    private JLabel imgGhost4 = new JLabel(new ImageIcon("src/images/ghost.png"));
    private JLabel imgBomb = new JLabel(new ImageIcon("src/images/bomb.png"));
    private JLabel imgBooster = new JLabel(new ImageIcon("src/images/booster.png"));

    private final int SCREENSIZE = 600;
    private int speed = 70;

    public static void main(String[] args) {
        new Game().init();
    }

    private void init() {
        setLayout(null);
        player.setTamanhoDaTela(SCREENSIZE);
        player.setVida(15);

        ghost1.setTamanhoDaTela(SCREENSIZE);
        ghost2.setTamanhoDaTela(SCREENSIZE);
        ghost3.setTamanhoDaTela(SCREENSIZE);
        ghost4.setTamanhoDaTela(SCREENSIZE);

        add(imgPlayer);
        add(imgGhost1);
        add(imgGhost2);
        add(imgGhost3);
        add(imgGhost4);
        add(imgBomb);
        add(imgBooster);

        render();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(SCREENSIZE + 100, SCREENSIZE + 100);
        setVisible(true);
        addKeyListener(this);

        run();
    }

    private void render() {

        updateLocation(imgPlayer, player);
        updateLocation(imgGhost1, ghost1);
        updateLocation(imgGhost2, ghost2);
        updateLocation(imgGhost3, ghost3);
        updateLocation(imgGhost4, ghost4);
        updateLocation(imgBomb, bomb);
        updateLocation(imgBooster, booster);
        setTitle("Life: " + player.getVida());
        SwingUtilities.updateComponentTreeUI(this);

    }

    private void updateLocation(JLabel label, GameObject object) {
        label.setBounds(object.getPosicaoX(), object.getPosicaoY(), 50, 50);
        ImageIcon myImage = (ImageIcon) label.getIcon();
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(newImg));
    }

    private void run() {
        while (player.getVida() > 0) {

            // coloque aqui os métodos de movimentação e colisão
            player.mover();
            ghost1.mover();
            ghost2.mover();
            ghost3.mover();
            ghost4.mover();

            // Booster
            if (player.getPosicaoX() == booster.getPosicaoX() && player.getPosicaoY() == booster.getPosicaoY()) {
                player.setInvencivel(true);
                player.setTempoInvencivel(20);
            }

            // Fantasmas
            if (player.isInvencivel() == false) {
                if (player.getPosicaoY() == ghost1.getPosicaoY() && player.getPosicaoX() == ghost1.getPosicaoX()) {
                    player.setVida(player.getVida() - 1);
                    System.out.println("Você perdeu uma vida");
                }
                if (player.getPosicaoY() == ghost2.getPosicaoY() && player.getPosicaoX() == ghost2.getPosicaoX()) {
                    player.setVida(player.getVida() - 1);
                    System.out.println("Você perdeu uma vida");
                }
                if (player.getPosicaoY() == ghost3.getPosicaoY() && player.getPosicaoX() == ghost3.getPosicaoX()) {
                    player.setVida(player.getVida() - 1);
                    System.out.println("Você perdeu uma vida");
                }
                if (player.getPosicaoY() == ghost4.getPosicaoY() && player.getPosicaoX() == ghost4.getPosicaoX()) {
                    player.setVida(player.getVida() - 1);
                    System.out.println("Você perdeu uma vida");
                }

                // Bomba
                if (player.getPosicaoX() == bomb.getPosicaoX() && player.getPosicaoY() == bomb.getPosicaoY()) {
                    player.setVida(player.getVida() - 1);
                    System.out.println("Você perdeu uma vida");
                }
            } else {
                if (player.getTempoInvencivel() > 0) {
                    player.setTempoInvencivel(player.getTempoInvencivel() - 1);
                } else {
                    player.setInvencivel(false);
                }
            }

            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            render();

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (c == '8' || c == 'w')
            player.setDirecao(0);
        if (c == '6' || c == 'd')
            player.setDirecao(90);
        if (c == '2' || c == 's')
            player.setDirecao(180);
        if (c == '4' || c == 'a')
            player.setDirecao(270);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}