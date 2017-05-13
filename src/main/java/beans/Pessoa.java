package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    private int id;
    @Column(name = "pessoa_nome", length = 60, nullable = true)
    private String nome;
    @Column(name = "pessoa_endereco", nullable = true)
    private String endereco;
    @Column(name = "pessoa_cidade", nullable = true)
    private String cidade;
    @Column(name = "pessoa_estado", nullable = true)
    private String estado;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    //  Relacionamento
   @OneToMany (mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Fone> fones = new ArrayList<Fone>();

    public List<Fone> getFones() {
        return fones;
    }

    public void setFones(List<Fone> fones) {
        this.fones = fones;
    }

}
