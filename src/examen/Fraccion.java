package examen;

/**
 * Este es el examen de recuperacion el cual trata de un ejecicio que se llama
 * fraccion que trata de que el usuario le da un numero y te lo fracciona
 * 
 * @author mromero
 * @version 1.0
 */
public class Fraccion {
	/**
	 * Este es el aitributo num que sera el numero que da y lo ponemos en private
	 * porque solo se utilizara en esta clase
	 */
	private int num;
	/**
	 * Este es el atributo den y esta en private porque solo se utilizara en esta
	 * clase
	 */
	private int den;

	// Constructor por defecto

	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con par�metros
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0) {
			den = 1;
		}
		this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	// getters y setters

	public void setNum(int num) {
		this.num = num;

	}

	public int getNum() {
		return num;

	}

	public void setDen(int den) {
		this.den = den;
	}

	public int getDen() {
		return den;
	}

	// C�lculo del m�ximo com�n divisor por el algoritmo de Euclides
	/**
	 * Este es el el metodo que, calcula del valor maximo comun divisor por el
	 * algoritmo de Euclides
	 * 
	 * @return devuelve el valor minimo, el cual es un numero entero
	 */

	// C�lculo del m�ximo com�n divisor por el algoritmo de Euclides
	private int maxComunDivisor() {

		int maximo = Math.max(Math.abs(num), Math.abs(den));
		int minimo = Math.min(Math.abs(num), Math.abs(den));
		int resto = maximo % minimo;

		while (resto != 0) {
			maximo = minimo;
			minimo = resto;
			resto = maximo % minimo;
		}

		return minimo;
	}

	// m�todo para simplificar fracciones

	/**
	 * Este metodo no devuelve nada y lo que hace es simplificar el numero
	 */

	public void simplificar() {
		int numero = maxComunDivisor();
		num = num / numero;
		den = den / numero;
	}

	// M�todo toString

	/**
	 * Este es el metodo ToString en el cual viene la informacion que ve el usuario,
	 * y cada vez que se cambia algun valor este se actualizara
	 * 
	 * @return devuelve una cadena
	 */

	public String toString() {
		String mensaje = extracted();
		return mensaje;

	}

	private String extracted() {
		return num + "/" + den;
	}

	// Sumar fracciones

	/**
	 * Este es el metodo en el cual se suma las fracciones
	 * 
	 * @param f el parametro f hara falta durante el proceso de suma, el cual se
	 *          usara para analizar o valorar una situación.
	 * @return devolvera el objeto aux, el cual devolvera el resultado de la suma
	 */

	public Fraccion sumar(Fraccion factor) {

		Fraccion aux = new Fraccion();
		int cruce1 = num * factor.den + den * factor.num;
		aux.num = cruce1;
		aux.den = den * factor.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones

	/**
	 * Este es el metodo en el cual se resta las fracciones
	 * 
	 * @param f el parametro f hara falta durante el proceso de la resta, el cual se
	 *          usara para analizar o valorar una situación.
	 * @return devolvera el objeto aux, el cual devolvera el resultado de la resta
	 */

	public Fraccion restar(Fraccion factor) {

		Fraccion aux = new Fraccion();
		int cruce2 = num * factor.den - den * factor.num;
		aux.num = cruce2;
		aux.den = den * factor.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones

	/**
	 * Este es el metodo en el cual se multiplica las fracciones
	 * 
	 * @param f el parametro f hara falta durante el proceso de la multiplicacion,
	 *          el cual se usara para analizar o valorar una situación.
	 * @return devolvera el objeto aux, el cual devuleve el resultado de la
	 *         multiplicacion
	 */

	public Fraccion multiplicar(Fraccion factor) {

		Fraccion aux = new Fraccion();
		aux.num = num * factor.num;
		aux.den = den * factor.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones

	/**
	 * Este es el metodo en el cual se divide las fracciones
	 * 
	 * @param f el parametro f hara falta durante el proceso de divicion, el cual se
	 *          usara para analizar o valorar una situación.
	 * @return devolvera el objeto aux, el cual devuleve el resultado de la divicion
	 */
	public Fraccion dividir(Fraccion factor) {

		Fraccion aux = new Fraccion();
		aux.num = num * factor.den;
		aux.den = den * factor.num;
		aux.simplificar();
		return aux;

	}

}
