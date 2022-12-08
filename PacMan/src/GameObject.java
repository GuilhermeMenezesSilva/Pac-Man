public class GameObject {

	// Atributos
	private int posicaoX;
	private int posicaoY;
	private int tamanhoDaTela;

	// Construtor Padrão
	public GameObject() {
	}

	// Contrutor
	public GameObject(int posicaoX, int posicaoY) {
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}

	// Gets e Sets
	public int getPosicaoX() {
		return posicaoX;
	}
	public void setPosicaoX(int posicaoX) {
		if (posicaoX > 0) {
			this.posicaoX = posicaoX;
		}
	}
	
	public int getPosicaoY() {
		return posicaoY;
	}
	public void setPosicaoY(int posicaoY) {
		if (posicaoY > 0) {
			this.posicaoY = posicaoY;
		}
	}

	public int getTamanhoDaTela() {
		return tamanhoDaTela;
	}
	public void setTamanhoDaTela(int tamanhoDaTela) {
		this.tamanhoDaTela = tamanhoDaTela;
	}
}