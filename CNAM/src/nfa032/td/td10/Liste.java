package nfa032.td.td10;

public class Liste {
	ElementListe premier;

	public ElementListe getPremier() {
		return premier;
	}

	public boolean estVide() {
		return premier == null;
	}

	public void ajouterAuDebut(int v) {
		ElementListe ancienPremier = premier;
		premier = new ElementListe(v, ancienPremier);
	}

	public int getLongueur() {
		return getLongueurRec(premier);
	}

	private int getLongueurRec(ElementListe elt) {
		if (elt == null)
			return 0;
		else
			return 1 + getLongueurRec(elt.getSuivant());
	}

	public boolean contient(int v) {
		return contientRec(getPremier(), v);
	}

	private boolean contientRec(ElementListe elt, int v) {
		// Si la liste est vide, elle ne contient pas v:
		if (elt == null)
			return false;
		else if (elt.getValeur() == v)
			// Sinon, si elle commence par v, alors elle le contient
			return true;
		else
			// Sinon, elle contient v si la suite de la liste le contient
			return contientRec(elt.getSuivant(), v);
	}

	public void concatener(Liste l) {
		if (this.estVide()) {
			this.premier = l.premier;
		} else {
			concatenerRec(premier, l.getPremier());
		}
	}

	private void concatenerRec(ElementListe l0, ElementListe l1) {
		if (l0.getSuivant() == null) {
			l0.setSuivant(l1);
		} else {
			concatenerRec(l0.getSuivant(), l1);
		}
	}

	public void retirerPremiereOccurrence(int v) {
		// On �limine le probl�me de la liste vide
		if (!estVide()) {
			premier = retirerPremiereOccurrenceRec(premier, v);
		}
	}

	private ElementListe retirerPremiereOccurrenceRec(ElementListe l, int v) {
		if (l == null) {
			return l;
		} else if (l.getValeur() == v) {
			return l.getSuivant();
		} else {
			l.setSuivant(retirerPremiereOccurrenceRec(l.getSuivant(), v));
			return l;
		}

	}

	public void ecrireListeI() {
		ElementListe l = this.premier;
		System.out.print(l.getValeur());
		while (l.getSuivant() != null) {
			l = l.getSuivant();
			System.out.print(", " + l.getValeur());
		}
		System.out.println();
	}

	public void ecrireListeR() {
		ecrireListeRec(this.premier);
		System.out.println();
	}

	private static ElementListe ecrireListeRec(ElementListe l) {
		if (l.getSuivant() != null) {

			System.out.print(l.getValeur() + ", ");

			return ecrireListeRec(l.getSuivant());
		} else {
			System.out.print(l.getValeur());
			return l;
		}
	}

	public void insererEntre(int ins) {

		this.insererEntreRec(this.premier, ins);
	}

	public ElementListe insererEntreRec(ElementListe l, int ins) {
		ElementListe ElementIns = new ElementListe(ins);
		ElementListe temp;
		if (l.getSuivant() != null) {
			ElementIns.setSuivant(l.getSuivant());
			temp = l.getSuivant();
			l.setSuivant(ElementIns);
			return insererEntreRec(temp, ins);
		} else {
			ElementIns.setSuivant(l);
			return l;
		}
	}

	public void ajouterALaFin(int v) {
		if (estVide()) {
			premier = new ElementListe(v);
		} else {
			// Il y a un dernier �l�ment.
			// On le cherche et on ajoute apr�s lui.
			ElementListe dernier = getDernierElement();
			// nous savons que
			// dernier.getSuivant() == null => dernier est bien le dernier �l�ment.
			dernier.setSuivant(new ElementListe(v));
		}
	}

	private ElementListe getDernierElement() {
		ElementListe dernier = premier;
		while (dernier.getSuivant() != null) {
			dernier = dernier.getSuivant();
		}
		return dernier;
	}

	public void inserer(ElementListe ins, int n) {
		if (n < 1 || n > this.getLongueur() + 1)
			throw new IllegalArgumentException();

		ElementListe el = this.getPremier();

		int i = 1;
		while (el != null) {
			if (i == n - 1) {
				ins.setSuivant(el.getSuivant());
				el.setSuivant(ins);
				break;
			}
			el = el.getSuivant();
			i++;
		}
		if (n == 1) {
			this.ajouterAuDebut(ins.valeur);
		} else if (el == null) {
			ElementListe dernier = getDernierElement();
			// nous savons que
			// dernier.getSuivant() == null => dernier est bien le dernier �l�ment.
			dernier.setSuivant(ins);
		}

	}
}
