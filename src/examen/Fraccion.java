package examen;

public class Fraccion {
	private int num;
	private int den;
	
	
	//Constructor por defecto
	
	public Fraccion() { //debe generar el valor neutro que es 0/1
		num=0;
		den=1;
		
	}
	
	//Constructor con par�metros
	public Fraccion (int num,int den) {
		//debo evitar crear fracciones con 0 en el divisor
		this.num=num;
		if(den==0) {
			den=1;
		}
		this.den=den;
		//devuelvo la fracci�n simplificada
		simplificar();
	}
	
	//getters y setters
	
	public void setNum(int num) {
		this.num=num;
		
	}
	
	public int getNum() {
		return num;
		
	}
	
	public void setDen(int den) {
		this.den=den;
	}
	public int getDen() {
		return den;
	}
	
	 //C�lculo del m�ximo com�n divisor por el algoritmo de Euclides                                               
    private int maxComunDivisor() {
        int maximo = Math.max(Math.abs(num), Math.abs(den));
        int minimo = Math.min(Math.abs(num), Math.abs(den));
        int resto = maximo % minimo;
        
        while(resto != 0) {
        	maximo = minimo;
        	minimo = resto;
        	resto = maximo % minimo;
        } 
        
        return minimo;
    }
    
    //m�todo para simplificar fracciones
    public void simplificar() {
    	int numero=maxComunDivisor();
    	num=num/numero;
    	den=den/numero;
    }
    
    //M�todo toString
    
    public String toString() {
    	String mensaje = extracted();
    	return mensaje;
    	
    }

	private String extracted() {
		String mensaje = num+ "/"+den;
		return mensaje;
	}
    
    
    //Sumar fracciones
    
    public Fraccion sumar(Fraccion factor) {
    	Fraccion aux= new Fraccion();
    	int cruce1 = num*factor.den+den*factor.num;
		aux.num=cruce1;
    	aux.den=den*factor.den;
    	aux.simplificar();
    	return aux;
    	
    }
    
    //Restar fracciones
    
    public Fraccion restar(Fraccion factor) {
    	Fraccion aux=new Fraccion();
    	int cruce2 = num*factor.den-den*factor.num;
		aux.num=cruce2;
    	aux.den=den*factor.den;
    	aux.simplificar();
    	return aux;
    	
    	
    }
    
//Multiplicar fracciones
    
    public Fraccion multiplicar(Fraccion factor) {
    	Fraccion aux=new Fraccion();
    	aux.num=num*factor.num;
    	aux.den=den*factor.den;
    	aux.simplificar();
    	return aux;
    	
    }
    
//Dividir fracciones
    
    public Fraccion dividir(Fraccion factor) {
    	Fraccion aux=new Fraccion();
    	aux.num=num*factor.den;
    	aux.den=den*factor.num;
    	aux.simplificar();
    	return aux;
    	
    }
    

}
