// Pedir 3 numeros y mostrar como resultado el mayor
Algoritmo Mayorde3
	Definir N1 Como Real
	Definir N2 Como Real
	Definir N3 Como Real
	// Entradas
	Escribir 'Ingrese el primer n�mero: '
	Leer N1
	Escribir 'Ingrese el segundo n�mero: '
	Leer N2
	Escribir 'Ingrese el tercer n�mero: '
	Leer N3
	// Proceso verificar cu�l es el mayor
	Si N1>N2 Y N1>N3 Entonces
		Escribir N1,' es el mayor'
	SiNo
		Si N2>N1 Y N2>N3 Entonces
			Escribir N2,' es el mayor'
		SiNo
			Escribir N3,' es el mayor'
		FinSi
	FinSi
FinAlgoritmo
