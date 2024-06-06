package trabajoPractico;

public class ABB implements ABBTDA {
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
            raiz.HijoIzq = new ABB();
            raiz.HijoIzq.InicializarArbol();
            raiz.HijoDer = new ABB();
            raiz.HijoDer.InicializarArbol();
        } else if (raiz.dato > x) {
            raiz.HijoIzq.AgregarElemento(x);
        } else if (raiz.dato < x) {
            raiz.HijoDer.AgregarElemento(x);
        }
    }

    public void EliminarElemento(int x) {
        if (raiz != null) {
            if (raiz.dato == x && raiz.HijoIzq.ArbolVacio() && raiz.HijoDer.ArbolVacio()) {
                raiz = null;
            } else if (raiz.dato == x && !raiz.HijoIzq.ArbolVacio()) {
                raiz.dato = this.mayor(raiz.HijoIzq);
                raiz.HijoIzq.EliminarElemento(raiz.dato);
            } else if (raiz.dato == x && raiz.HijoIzq.ArbolVacio()) {
                raiz.dato = this.menor(raiz.HijoDer);
                raiz.HijoDer.EliminarElemento(raiz.dato);
            } else if (raiz.dato < x) {
                raiz.HijoDer.EliminarElemento(x);
            } else {
                raiz.HijoIzq.EliminarElemento(x);
            }
        }
    }

    private int mayor(ABBTDA a) {
        if (a.HijoDer().ArbolVacio()) {
            return a.Raiz();
        } else {
            return mayor(a.HijoDer());
        }
    }

    private int menor(ABBTDA a) {
        if (a.HijoIzq().ArbolVacio()) {
            return a.Raiz();
        } else {
            return menor(a.HijoIzq());
        }
    }
    
    public void postOrder(ABBTDA a) {
    	if (!a.ArbolVacio()) {
    		postOrder(a.HijoIzq());
    		postOrder(a.HijoDer());
    		System.out.println(a.Raiz());
    		
    		}
    	}
    
    public ConjuntoTDA ElementosMayoresQue(int k) {
        ConjuntoTDA conjunto = new Conjunto();
        conjunto.InicializarConjunto();
        DeterminarValorK(this, k, conjunto);
        return conjunto;
    }

    private void DeterminarValorK(ABBTDA a, int k, ConjuntoTDA c) {
        if (!a.ArbolVacio()) {
            if (a.Raiz() > k) {
                c.Agregar(a.Raiz());
                DeterminarValorK(a.HijoIzq(), k, c);
                DeterminarValorK(a.HijoDer(), k, c);
            } else {
                DeterminarValorK(a.HijoDer(), k, c);
            }
        }
    }
}