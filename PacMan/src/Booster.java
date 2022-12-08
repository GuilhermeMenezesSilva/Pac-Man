public class Booster extends Item {

    private int duracao;

    public Booster() {
    }

    public Booster(int posicaoX, int posicaoY) {
        super(posicaoX, posicaoY);
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}