package negocio;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.*;
import persistencia.FormaPgtoDAO;
import beans.FormaPgto;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class FormaPgtoCtrl implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private FormaPgto formaPgto = new FormaPgto();
    private String filtro = "";

    public FormaPgto getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(FormaPgto formaPgto) {
        this.formaPgto = formaPgto;
    }

    public List<FormaPgto> getListagem() {
        return FormaPgtoDAO.listagem(filtro);
    }

    public String actionGravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (formaPgto.getId() == 0) {
            FormaPgtoDAO.inserir(formaPgto);
          context.addMessage(null, new FacesMessage("Sucesso", "Inserido com Sucesso"));
        } else {
            FormaPgtoDAO.alterar(formaPgto);
            context.addMessage(null, new FacesMessage("Sucesso", "Alterado com Sucesso"));
            
        }
        return "lista_formaPgto";
    }

    public String actionInserir() {
        formaPgto = new FormaPgto();
        return "form_formaPgto";
    }

    public String actionExcluir() {
        FormaPgtoDAO.excluir(formaPgto);
        addMessage("Sucesso", "FormaPgto removido com sucesso");
        return "lista_formaPgto";
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String actionAlterar(FormaPgto p) {
        formaPgto = p;
        return "form_formaPgto";
    }

    

        public void destroyWorld() {
            addMessage("System Error", "Please try again later.");
        }

        public void addMessage(String summary, String detail) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    
}
