package nfa035.projet2.cellule;

import java.util.Set;

import nfa035.projet2.feuille.Bloc;
import nfa035.projet2.feuille.Cellule;

public class Somme extends Fonction{
	public Somme(Bloc b,String formule) {
		super(b,formule);
	}
	@Override
	public float getResultat() {
		Set<Cellule> cellules = this.getBloc().getCellules();
		float rtr = 0;
		for (Cellule c : cellules) {
			rtr += c.getResultat();
		}
		return rtr;
	}
}