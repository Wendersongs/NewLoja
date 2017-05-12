package teste;

import beans.Cidade;
import beans.Produto;
import java.util.List;
import negocio.ProdutoCtrl;
import persistencia.CidadeDAO;
import persistencia.ProdutoDAO;

public class Teste {
	
    public static void main(String[] args) {
        List<Cidade> listaCidade = listaCidades();
    
    
    }
	
	
public static void main (){

    
}


public static List<Cidade> listaCidades() {
        return CidadeDAO.listaFiltrado(1);
    }
}
