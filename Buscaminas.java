package RETOS;

import java.util.*;

public class Buscaminas {

	public static void main(String[] args) {

		// VARIABLES
		int[][] matriz = new int[5][5];
		char[][] matrizv = new char[5][5];
		Scanner sc = new Scanner(System.in);
		int cont = 0, cont2 = 0, cont3 = 0;
		int selecc, selecf;
		char contchar = '0';

		// RELLENO MANUAL
//		matriz[0][0] = 0; matriz[0][1] = 0; matriz[0][2] = 0; matriz[0][3] = 0; matriz[0][4] = 0;
//		matriz[1][0] = 0; matriz[1][1] = 1; matriz[1][2] = 0; matriz[1][3] = 1; matriz[1][4] = 0;
//		matriz[2][0] = 0; matriz[2][1] = 1; matriz[2][2] = 1; matriz[2][3] = 0; matriz[2][4] = 0;
//		matriz[3][0] = 1; matriz[3][1] = 1; matriz[3][2] = 1; matriz[3][3] = 1; matriz[3][4] = 1; 
//		matriz[4][0] = 0; matriz[4][1] = 0; matriz[4][2] = 1; matriz[4][3] = 1; matriz[4][4] = 1;

		// RELLENO ALEATORIO
		for (int i = 0; i < 5; i++) {
			for (int y = 0; y < 5; y++) {
				matriz[i][y] = (int) (Math.random() * 2);
			}
		}
		// REDUCIMOS EL NUMERO DE BOMBAS
		for (int i = 0; i < 5; i++) {
			for (int y = 0; y < 5; y++) {
				if (matriz[i][y] == 1) {
					matriz[i][y] = (int) (Math.random() * 2);
				}
			}
		}

		// RELLENAMOS MATRIZV CON ESPACIOS VACIOS
		for (int i = 0; i < 5; i++) {
			for (int y = 0; y < 5; y++) {
				matrizv[i][y] = ' ';
			}
		}
		// MOSTRAMOS LA MATRIZV
		for (int i = 0; i < 5; i++) {
			for (int y = 0; y < 5; y++) {
				System.out.print("[" + matrizv[i][y] + "]");
			}
			System.out.println(" ");
		}
		// CONTAMOS Y MOSTRAMOS EL NUMERO DE BOMBAS
		for (int i = 0; i < 5; i++) {
			for (int y = 0; y < 5; y++) {
				if (matriz[i][y] == 1) {
					cont++;
				}
			}
		}
		System.out.println("Hay " + cont + " bombas.");
		cont3 = cont;

		// SELECCIONAMOS CELDA
		cont = 0;
		do {
			System.out.println("Selecciona la fila ..");
			selecc = sc.nextInt();
			System.out.println("Selecciona la columna :");
			selecf = sc.nextInt();
			if (selecc > 0 && selecc < 6 && selecf > 0 && selecf < 6 && matrizv[selecc - 1][selecf - 1] == ' ') {
				// COMPROBAMOS LA SELECCION
				if (matriz[selecc - 1][selecf - 1] == 1) {
					System.out.println("BOOM!!!!");
					matrizv[selecc - 1][selecf - 1] = 'X';
					cont++;
				} else {
					System.out.println("Bien hecho.");
					cont3++;
					cont2 = 0;
					if (selecc == 1 && selecf == 1) {
						System.out.println("1,1");
						if (matriz[0][1] == 1) {
							cont2++;
						}
						if (matriz[1][0] == 1) {
							cont2++;
						}
						if (matriz[1][1] == 1) {
							cont2++;
						}
					} else if (selecc == 1 && selecf == 5) {
						if (matriz[0][3] == 1) {
							cont2++;
						}
						if (matriz[1][4] == 1) {
							cont2++;
						}
						if (matriz[1][3] == 1) {
							cont2++;
						}
					} else if (selecc == 5 && selecf == 1) {
						if (matriz[3][0] == 1) {
							cont2++;
						}
						if (matriz[4][1] == 1) {
							cont2++;
						}
						if (matriz[3][1] == 1) {
							cont2++;
						}
					} else if (selecc == 5 && selecf == 5) {
						if (matriz[4][3] == 1) {
							cont2++;
						}
						if (matriz[3][4] == 1) {
							cont2++;
						}
						if (matriz[3][3] == 1) {
							cont2++;
						}
					} else if (selecc == 1 && selecf == 2 || selecc == 1 && selecf == 3 || selecc == 1 && selecf == 4) {
						if (matriz[selecc - 1][selecf - 2] == 1) {
							cont2++;
						}
						if (matriz[selecc][selecf - 2] == 1) {
							cont2++;
						}
						if (matriz[selecc][selecf - 1] == 1) {
							cont2++;
						}
						if (matriz[selecc][selecf] == 1) {
							cont2++;
						}
						if (matriz[selecc - 1][selecf] == 1) {
							cont2++;
						}
					} else if (selecc == 2 && selecf == 1 || selecc == 3 && selecf == 1 || selecc == 4 && selecf == 1) {
						if (matriz[selecc - 2][selecf - 1] == 1) {
							cont2++;
						}
						if (matriz[selecc - 2][selecf] == 1) {
							cont2++;
						}
						if (matriz[selecc - 1][selecf] == 1) {
							cont2++;
						}
						if (matriz[selecc][selecf] == 1) {
							cont2++;
						}
						if (matriz[selecc][selecf - 1] == 1) {
							cont2++;
						}
					} else if (selecc == 5 && selecf == 2 || selecc == 5 && selecf == 3 || selecc == 5 && selecf == 4) {
						if (matriz[selecc - 1][selecf - 2] == 1) {
							cont2++;
						}
						if (matriz[selecc - 2][selecf - 2] == 1) {
							cont2++;
						}
						if (matriz[selecc - 2][selecf - 1] == 1) {
							cont2++;
						}
						if (matriz[selecc - 2][selecf] == 1) {
							cont2++;
						}
						if (matriz[selecc - 1][selecf] == 1) {
							cont2++;
						}
					} else if (selecc == 2 && selecf == 5 || selecc == 3 && selecf == 5 || selecc == 4 && selecf == 5) {
						if (matriz[selecc - 2][selecf - 1] == 1) {
							cont2++;
						}
						if (matriz[selecc - 2][selecf - 2] == 1) {
							cont2++;
						}
						if (matriz[selecc - 1][selecf - 2] == 1) {
							cont2++;
						}
						if (matriz[selecc][selecf - 2] == 1) {
							cont2++;
						}
						if (matriz[selecc][selecf - 1] == 1) {
							cont2++;
						}
					} else {
						if (matriz[selecc - 2][selecf - 1] == 1) {
							cont2++;
						}
						if (matriz[selecc - 2][selecf - 2] == 1) {
							cont2++;
						}
						if (matriz[selecc - 1][selecf - 2] == 1) {
							cont2++;
						}
						if (matriz[selecc][selecf - 2] == 1) {
							cont2++;
						}
						if (matriz[selecc][selecf - 1] == 1) {
							cont2++;
						}
						if (matriz[selecc][selecf] == 1) {
							cont2++;
						}
						if (matriz[selecc - 1][selecf] == 1) {
							cont2++;
						}
						if (matriz[selecc - 2][selecf] == 1) {
							cont2++;
						}
					}

					if (cont2 == 0) {
						contchar = '0';
					}
					if (cont2 == 1) {
						contchar = '1';
					}
					if (cont2 == 2) {
						contchar = '2';
					}
					if (cont2 == 3) {
						contchar = '3';
					}
					if (cont2 == 4) {
						contchar = '4';
					}
					if (cont2 == 5) {
						contchar = '5';
					}
					if (cont2 == 6) {
						contchar = '6';
					}
					if (cont2 == 7) {
						contchar = '7';
					}
					if (cont2 == 8) {
						contchar = '8';
					}
					matrizv[selecc - 1][selecf - 1] = contchar;
				}
			} else {
				System.out.println("Has introducido mal las coordenadas.");
			}
			// MOSTRAMOS MATRIZV ACTUALIZADA
			for (int i = 0; i < 5; i++) {
				for (int y = 0; y < 5; y++) {
					System.out.print("[" + matrizv[i][y] + "]");
				}
				System.out.println(" ");
			}
		} while (cont < 1 && cont3 < 25);

		// COMPRUEBA SI GANASTE O PERDISTE Y MUESTRA LA POSICION DE LAS BOMBAS
		if (cont3 == 25) {
			System.out.println("GANASTE!!!");
			for (int i = 0; i < 5; i++) {
				for (int y = 0; y < 5; y++) {
					if (matriz[i][y] == 1) {
						matrizv[i][y] = 'X';
					}
				}
			}
			for (int i = 0; i < 5; i++) {
				for (int y = 0; y < 5; y++) {
					System.out.print("[" + matrizv[i][y] + "]");
				}
				System.out.println(" ");
			}
		} else {
			System.out.println("PERDISTE!!!");
			for (int i = 0; i < 5; i++) {
				for (int y = 0; y < 5; y++) {
					if (matriz[i][y] == 1) {
						matrizv[i][y] = 'X';
					}
				}
			}
			for (int i = 0; i < 5; i++) {
				for (int y = 0; y < 5; y++) {
					System.out.print("[" + matrizv[i][y] + "]");
				}
				System.out.println(" ");
			}
		}
	}
}
//-------------------------------------CREATED BY DANIEL FERNÁNDEZ-------------------------------------------