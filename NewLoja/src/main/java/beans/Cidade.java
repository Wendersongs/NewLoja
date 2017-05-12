package beans;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid_id")
    private int id;
    @Column(name = "est_id", length = 60, nullable = true)
    private int estId;
    @Column(name = "cid_nome", nullable = true)
    private String nome;

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstId() {
        return estId;
    }

    public void setEstId(int estId) {
        this.estId = estId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
