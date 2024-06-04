package trabajoPractico;

public interface ABBTDA {
	int Raiz();
	ABBTDA HijoIzq();
	ABBTDA HijoDer();
	boolean ArbolVacio();
	void InicializarArbol();
	void AgregarElemento(int x);
	void EliminarElemento(int x);
	
}
