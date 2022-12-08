public class Ghost extends GameObject {

    private int direcao;

    // Contrutor Padrão
    public Ghost() {
    }

    // Costrutor
    public Ghost(int posicaoX, int posicaoY, int direcao) {
        super(posicaoX, posicaoY);
        this.direcao = direcao;
    }

    // Métodos de trabalho
    public boolean podeMover() {
        int novaPosicaoY = getPosicaoY();
        int novaPosicaoX = getPosicaoX();

        if (direcao == 0) {
            novaPosicaoY = getPosicaoY() - 10;
            if (novaPosicaoY < 0) {
                return false;
            }
        }
        if (direcao == 90) {
            novaPosicaoX = getPosicaoX() + 10;
            if (novaPosicaoX > getTamanhoDaTela()) {
                return false;
            }
        }
        if (direcao == 180) {
            novaPosicaoY = getPosicaoY() + 10;
            if (novaPosicaoY > getTamanhoDaTela())
                return false;
        }
        if (direcao == 270) {
            novaPosicaoX = getPosicaoX() - 10;
            if (novaPosicaoX < 0) {
                return false;
            }
        }
        return true;
    }

    // Ação
    public void mover() {
        if (podeMover() == true) {
            direcao = (int) (Math.round(Math.random() * 3) * 90);
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

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }
}