package negocio;

import beans.Cidade;
import beans.Estado;
import beans.Fone;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.*;
import persistencia.PessoaDAO;
import beans.Pessoa;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import persistencia.CidadeDAO;
import persistencia.UfDAO;

@ManagedBean
@SessionScoped

public class PessoaCtrl implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getListagem() {
        return PessoaDAO.listagem("");
    }
    
      public List<Cidade> listaCidade() {
        return CidadeDAO.listaFiltrado(1);
    }
   public List<Estado> listaEstado() {
        return UfDAO.listagem("");
    }

    public String actionGravar() {
        if (pessoa.getId() == 0) {
            PessoaDAO.inserir(pessoa);
            return actionInserir();
        } else {
            PessoaDAO.alterar(pessoa);
            return "lista_pessoa";
        }
    }

    public String actionInserir() {
        pessoa = new Pessoa();
        return "form_pessoa";
    }

    public String actionExcluir(Pessoa p) {
        PessoaDAO.excluir(p);
        addMessage("Sucesso", "Produto removido com sucesso!");
        return "lista_pessoa";
    }

    public String actionAlterar(Pessoa p) {
        pessoa = p;
        return "form_pessoa";
    }

    public String actionInserirFone() {
        
        Fone fone = new Fone();
        fone.setPessoa(pessoa);
        pessoa.getFones().add(fone);
        return "form_pessoa";
    }
    
    public String actionExcluirFone(Fone f) {
        
        return "form_pessoa";
        
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
