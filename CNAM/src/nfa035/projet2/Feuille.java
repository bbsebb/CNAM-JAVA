package nfa035.projet2;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeMap;


public class Feuille {
	protected TreeMap<Cellule, LinkedHashSet<Cellule>> cellules;
	protected int xMax,yMax;
	

	public Feuille(int nbrLigne,int nbrColonne) {
		this.setCellules(this.creeBloc(0, 0, nbrLigne - 1, nbrColonne -1));
		this.setxMax(nbrLigne-1);
		this.setyMax(nbrColonne-1);
	}
	
	protected Feuille(int xCellule1,int yCellule1,int xCellule2,int yCellule2) {
		if(xCellule1>xCellule2 || yCellule1>yCellule2) {
			int temp = xCellule1;
			xCellule1=xCellule2;
			xCellule2=temp;
			temp = yCellule1;
			yCellule1=yCellule2;
			yCellule2=temp;
		}
		this.setCellules(this.creeBloc(xCellule1, yCellule1, xCellule2, yCellule2));
		this.setxMax(xCellule2);
		this.setyMax(yCellule2);
	}
	/**
	 * @return the cellules
	 */
	private TreeMap<Cellule, LinkedHashSet<Cellule>> getCellules() {
		return cellules;
	}

	/**
	 * @param cellules the cellules to set
	 */
	private void setCellules(TreeMap<Cellule, LinkedHashSet<Cellule>> cellules) {
		this.cellules = cellules;
	}

	/**
	 * @return the xMax
	 */
	protected int getxMax() {
		return xMax;
	}

	/**
	 * @param xMax the xMax to set
	 */
	private void setxMax(int xMax) {
		this.xMax = xMax;
	}

	/**
	 * @return the yMax
	 */
	protected int getyMax() {
		return yMax;
	}

	/**
	 * @param yMax the yMax to set
	 */
	private void setyMax(int yMax) {
		this.yMax = yMax;
	}	
	
	public void setCellule(String formule) {
		
	}
	public Cellule getCellule(int x, int y) throws HorsFeuilleException {
		Iterator<Cellule> it = this.cellules.keySet().iterator();
		while (it.hasNext()) {
			Cellule c = it.next();
			if (c.getX() == x && c.getY() == y) {
				return c;
			}
		}
		throw new HorsFeuilleException();
	}
	
	public boolean estCelluleVide(int x, int y) throws HorsFeuilleException  {
		if(this.getCellule(x, y).estVide())
			return true;
		else 
			return false;
	}	
	
	private TreeMap<Cellule, LinkedHashSet<Cellule>> creeBloc(int xCellule1,int yCellule1,int xCellule2,int yCellule2) {
		if(xCellule1<0 || xCellule2<0 || yCellule1<0 || yCellule2<0)
			throw new IllegalArgumentException();
		TreeMap<Cellule, LinkedHashSet<Cellule>> cellules = new TreeMap<Cellule, LinkedHashSet<Cellule>>();
		for (int i = xCellule1; i <= xCellule2; i++) {
			for (int j = yCellule1; j <= yCellule2; j++) {
				cellules.put(new Cellule(i, j),null);
			}
		}
		return cellules;
	}
	
	
}
