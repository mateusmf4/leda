package problems;

/**
 * Classe com metodos para calcular raiz n-esima de um numero com aproximacao
 * e para encontrar os limites que dividem um array em 3 partes de mesmo tamanho
 * 
 * @author adalbertocajueiro
 *
 */
public class RaizImpl implements Raiz {
	public double raiz(int num, int raiz, double erro) {
		return raiz(num, raiz, erro, 0.0, num);
	}


	private double raiz(double num, int raiz, double targetErr, double lowerBound, double upperBound) {
		// devemos achar a raiz de x**raiz - numero = 0
		// essa solução está entre lowerBound e upperBound
		// então escolhemos o do meio
		double guess = (lowerBound + upperBound) / 2.0;
		double valor = pow(guess, raiz);

		// calcular o erro absoluto
		double err = valor - num;
		if (err < 0.0)
			err = -err;
		
		double result = 0.0;
		if (err < targetErr) {
			result = guess;
		} else {
			if (valor > num) {
				// se o nosso guess deu maior que num, então procura na metade menor
				result = raiz(num, raiz, targetErr, lowerBound, guess);
			} else {
				// se não, na metade maior
				result = raiz(num, raiz, targetErr, guess, upperBound);
			}
		}

		return result;
	}

	// Calcula numero elevado a power.
	private double pow(double number, int power) {
		double result = 1.0;
		if (power > 0) {
			// x^n = x * x^(n-1)
			result = number * pow(number, power - 1);
		}
		return result;
	}
}