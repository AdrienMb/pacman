import java.util.Scanner;
public class Jeu {
	public static int majScore(int score,Position posP, Position posR){
		score=score+1;
		if (posP==posR){
			score=score+5;
		}
		return score;
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String nom;
		System.out.println("Entrez votre nom !");
		nom = scan.nextLine();
		boolean[][] laby = GenerateurLabyrinthe.generer();
		Position[] init = new Position[5];
		init=Position.positionInit(laby);    //"init=(posB,posR,posP,posD,posA)"
		int score=0;
		GenerateurLabyrinthe.printLabyrinthe(laby, init[0], init[1], init[2], init[2], init[3]);
		Position posB=init[0];
		Position posR=init[1];
		Position posP=init[2];
		Position posD = new Position(init[2].getPositionX(),init[2].getPositionY());
		Position posA=init[3];
		while (Position.testEgale(posP, posA)==false){		//Tant que le joueur n'est pas arrivé
			posB=Personnage.deplacementFantome(laby,posB);
			posR=Personnage.deplacementFantome(laby,posR);
			Personnage.deplacementJoueur(laby, posP);
			score=majScore(score,posP,posR);
			Personnage.testFantomeB(laby, posP, posB, posD);
			GenerateurLabyrinthe.printLabyrinthe(laby, posB, posR, posP, posD, posA);
		}
		System.out.println("Votre score est de " + score +", bien joué "+nom);
		}
	}
