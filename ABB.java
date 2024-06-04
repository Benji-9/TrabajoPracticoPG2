package trabajoPractico;

public class ABB implements ABBTDA{
	NodoABB raiz;
	
	public int Raiz() {
		return raiz.dato;
	}

	public ABBTDA HijoIzq() {
		return raiz.HijoIzq;
	}

	public ABBTDA HijoDer() {
		return raiz.HijoDer;
	}

	public boolean ArbolVacio() {
		return raiz == null;
	}

	public void InicializarArbol() {
		raiz = null;
	}

	public void AgregarElemento(int x) {
		if (raiz == null) {
			raiz = new NodoABB();
			raiz.dato = x;
			raiz.HijoIzq = new NodoABB();
			raiz.HijoIzq.InicializarArbol();
			raiz.HijoDer = new NodoABB();
			raiz.HijoDer.InicializarArbol();
		} else if (raiz.dato > x) {
			raiz.HijoIzq.AgregarElemento(x);
		}else if (raiz.dato < x) {
			raiz.HijoDer.AgregarElemento(x);
		}
		
	}
	
	public void EliminarElemento(int x) {
		if (raiz != null) {
			if (raiz.dato == x && raiz.HijoIzq.ArbolVacio() && raiz.HijoDer.ArbolVacio()) {
				raiz = null;
			}else if (raiz.dato == x && !raiz.HijoIzq.ArbolVacio()) {
				raiz.dato = this.mayor(raiz.HijoIzq);
				raiz.HijoIzq.EliminarElemento(raiz.dato);
			}else if (raiz.dato == x && raiz.HijoIzq.ArbolVacio()) {
				raiz.dato = this.menor(raiz.HijoDer);
				raiz.HijoDer.EliminarElemento(raiz.dato);
			}else if (raiz.dato < x) {
				raiz.HijoDer.EliminarElemento(x);
			} else {
				raiz.HijoIzq.EliminarElemento(x);
			}
		}
		
	}
	
	private int mayor(ABBTDA a) {
		if (a.HijoDer().ArbolVacio()) {
			return a.Raiz();
		}else {
			return mayor(a.HijoDer());
		}
	}
	
	private int menor(ABBTDA a) {
		if (a.HijoIzq().ArbolVacio()) {
			return a.Raiz();
		}else {
			return menor(a.HijoIzq());
		}
	}
}
