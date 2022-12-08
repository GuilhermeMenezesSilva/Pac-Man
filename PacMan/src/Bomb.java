public class Bomb extends Item {

	private int removerVida;

	public Bomb() {
	}

	public Bomb(int posicaoX, int posicaoY) {
		super(posicaoX, posicaoY);
	}

	public int getRemoverVida() {
		return removerVida;
	}

	public void setRemoverVida(int removerVida) {
		this.removerVida = removerVida;
	}
}