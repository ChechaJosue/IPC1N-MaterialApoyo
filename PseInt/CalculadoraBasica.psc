Algoritmo CalculadoraBasica
	
	// Hacer una calculadora que permita hacer operaciones de suma, resta, mult, div
	
	Definir N1 Como Entero
	Definir N2 Como Entero
	Definir Operador Como Cadena
	Definir Resultado Como Entero
	
	// Entradas
	Imprimir 'Ingrese el primer numero: '
	Leer N1
	
	Imprimir 'Ingrese el segundo numero: '
	Leer N2
	
	Imprimir 'Ingrese el operador: '
	Leer Operador
		
	// Proceso
	Si Operador == "+"
		// Operacion de suma
		Resultado = N1 + N2
		
	SiNo
		// Operacion de resta
		Si Operador == "-"
			Resultado = N1 - N2
		SiNo
			// Operacion de multiplicacion
			Si Operador == "*"
				Resultado = N1 * N2
			SiNo
				// Operacion de division
				Resultado = N1 / N2
			FinSi
		FinSi
	FinSi
	
	
	// Solucion con switch o segun
	Segun Operador Hacer
		"+":
			Resultado = N1+N2
		"-":
			Resultado = N1-N2
	FinSegun
	
	// Salida
	Imprimir 'El resultado de la operacion es: ', Resultado

FinAlgoritmo
