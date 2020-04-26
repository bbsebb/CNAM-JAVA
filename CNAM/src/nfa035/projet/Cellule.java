package nfa035.projet;
/**
 * Classe abstraite d'une cellule dans une {@link Feuille feuille} 
 * @author bbseb
 *
 */
 public abstract class Cellule implements AffichageCellule{
	protected int x,y;
	protected String formule;
	
	/**
	 * Constructeur par defaut
	 */
	public Cellule() {
		this.setX(0);
		this.setY(0);

	}

	/**
	 * Constructeur instanciant le placement absolu d'une cellule. La formule est vide.
	 * @param x est le num�ro de ligne
	 * @param y est le num�ro de colonne
	 */
	public Cellule(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cellule other = (Cellule) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}


	
	public  String getResultatToString() {
		return String.valueOf(this.getResultat());
	}

	/**
	 * @return le num�ro de la ligne
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param modifie le num�ro de ma ligne
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return le num�ro de colonne 
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param modifie le num�ro de la colonne
	 */
	public void setY(int y) {
		this.y = y;
	}

	
}
