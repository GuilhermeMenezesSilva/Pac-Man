public class Item extends GameObject {

	private boolean visivel;

	public Item() {
	}

	public Item(int posicaoX, int posicaoY) {
		super(posicaoX, posicaoY);
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

}