package negocio;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.*;
import persistencia.ProdutoDAO;
import beans.Produto;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class ProdutoCtrl implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListagem() {
        return ProdutoDAO.listagem("");
    }

    public String actionGravar() {
        if (produto.getId() == 0) {
            ProdutoDAO.inserir(produto);
            return actionInserir();
        } else {
            ProdutoDAO.alterar(produto);
            return "lista_produto";
        }
    }

    public String actionInserir() {
        produto = new Produto();
        return "form_produto";
    }

    public String actionExcluir(Produto p) {
        ProdutoDAO.excluir(p);
        addMessage("Sucesso", "Produto removido com sucesso");
        return "lista_produto";
    }

    public String actionAlterar(Produto p) {
        produto = p;
        return "form_produto";
    }

    

        public void destroyWorld() {
            addMessage("System Error", "Please try again later.");
        }

        public void addMessage(String summary, String detail) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    
}
