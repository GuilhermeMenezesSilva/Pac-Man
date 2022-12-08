public class Player extends GameObject {

    // Atributos
    private int direcao;
    private int vida;
    private boolean invencivel;
    private int tempoInvencivel;

    // Contrutor Padrão
    public Player() {
    }

    // Costrutor
    public Player(int posicaoX, int posicaoY, int direcao) {
        super(posicaoX, posicaoY);
        this.direcao = direcao;
    }

    // Métodos de trabalho
    public boolean podeMover() {
        int novaPosicaoY = getPosicaoY();
        int novaPosicaoX = getPosicaoX();

        if (direcao == 0) {
            novaPosicaoY = getPosicaoY() - 10;
        }
        if (direcao == 90) {
            novaPosicaoX = getPosicaoX() + 10;
        }
        if (direcao == 180) {
            novaPosicaoY = getPosicaoY() + 10;
        }
        if (direcao == 270) {
            novaPosicaoX = getPosicaoX() - 10;
        }

        // Pode ou não se mover
        if (novaPosicaoY < 0) { // Pra cima
            return false;
        }
        if (novaPosicaoX < 0) { // Pra esquerda
            return false;
        }
        if (novaPosicaoY > getTamanhoDaTela()) { // Pra baixo
            return false;
        }
        if (novaPosicaoX > getTamanhoDaTela()) { // Pra direita
            return false;
        }
        return true;
    }

    // Ação
    public void mover() {
        if (podeMover() == true) {
            if (direcao == 0) {
                this.setPosicaoY(getPosicaoY() - 10);
            }
            if (direcao == 90) {
                this.setPosicaoX(getPosicaoX() + 10);
            }
            if (direcao == 180) {
                this.setPosicaoY(getPosicaoY() + 10);
            }
            if (direcao == 270) {
                this.setPosicaoX(getPosicaoX() - 10);
            }
        }
    }

    // Gets e Sets
    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isInvencivel() {
        return invencivel;
    }

    public void setInvencivel(boolean invencivel) {
        this.invencivel = invencivel;
    }

    public int getTempoInvencivel() {
        return tempoInvencivel;
    }

    public void setTempoInvencivel(int tempoInvencivel) {
        this.tempoInvencivel = tempoInvencivel;
    }
}