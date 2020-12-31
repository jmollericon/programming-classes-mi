// programa en c++: Busqueda binaria
#include <iostream>
using namespace std;

int busquedaBinaria(int arreglo[], int tam, int valorBusqueda){ // modulo busqueda binaria
	/* si el valor a buscar se encuentra en el arreglo, entonces el modulo devuelve el indice del lugar donde
	   se encuentra dicho valor, pero si no se encuentra el valor de busqueda en el arreglo, entonces de
	   devuelve el valor de -1.
	   El modulo de busqueda trabaja con tres punteros: Iarriba, I abajo e Icentro.
	*/
	int Iarriba = tam-1; 	// posicion mas alta del arreglo inicialmente
  	int Iabajo = 0; 		// posicion mas baja del arreglo inicialmente
  	int Icentro;			// posicion central de la parte del arreglo a considerar
  	while (Iabajo <= Iarriba){		// mientras el puntero inferior (Iabajo) NO supere al punter superior (Iarriba) se realiza la busqueda del valor
      	Icentro = (Iarriba + Iabajo)/2;				// se obtiene el centro del arreglo, gracias a Iabajo e Iarriba.
      	if (arreglo[Icentro] == valorBusqueda)		// se pregunta si el valor del centro es igual al valor de busqueda, si es termina la busqueda pero caso contrario se continuac buscando
 			return Icentro;							// caso cuando se encuentra el valor buscado, entonces se sale del modulo devolviendo el indeice de este dentro del arreglo[]
      	else if (valorBusqueda < arreglo[Icentro]) 	// si el valor que se busca es menor que el valor del centro del arreglo
   			Iarriba=Icentro-1;						// si es menor, entonces se actualiza el valor del limite superior (Iarriba)
 		else
   			Iabajo=Icentro+1;						// si es mayor, entonces se actualiza el valor del limite inferior (Iabajo) 
   													// se vuelve al buvle while(), donde se calcular un nuevo centro
    }					
  	return -1;										// cuando no se encunetra el valor buscado
}
void mostrar(int arreglo[], int tam){ 				// este modulo imprimi todos los elementos del 'arreglo[}'
	for (int i = 0 ; i < tam ; i++)
    	cout << arreglo[i] << " ";
}
int main(){
	int valorBusqueda =0; 	// es el valor que se va a buscar en el arreglo
  	int tam = 15; 			// 'tam' es el tamaño del arreglo
  	int arreglo[tam] = {2, 4, 5, 7, 8, 9, 11, 12, 14, 16, 17, 18, 20, 28, 50}; // 'arreglo[]' de tamaño 15(0-14) ordenado ascendentemente 
  	cout << "Elementos del arreglo:\n" << endl;
  	mostrar(arreglo, tam); 	// llamada al modulo mostrar(), este mostrará todos los elementos del 'arreglo[]'
  	cout << "\n\nIngrese el valor a buscar: ";
  	cin >> valorBusqueda; 	// lectura del valor a buscar dentro del 'arreglo[]'
  	int indiceValor = busquedaBinaria(arreglo, tam, valorBusqueda); // llamada al modulo 'busquedaBinaria()'
  	if(indiceValor >= 0){ // caso cuando si se encuentra el valor buscado dentro del 'arreglo[]'
  		cout << "\nEl valor " << valorBusqueda << ", se encuentra en: arreglo[" << indiceValor << "].\n";
	}
	else{ // caso cuando No se encuentra el valor buscado dentro del 'arreglo[]'
		cout << "\nEl valor " << valorBusqueda << ", NO se encuentra en el arreglo.\n";
	}
  	return 0;
}

