
package mvc.turistando.model;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "passagens") // Adicione o nome da tabela, se necessário
public class Passagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome_destino;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String valor;
    
    
    @Lob
    @Column(name = "imagem", columnDefinition = "LONGBLOB")
    private byte[] imagemBytes;
    
    public void setImagem(MultipartFile imagem) throws IOException {
        this.imagemBytes = imagem.getBytes();
    }
    

    // Outros métodos e atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_destino() {
        return nome_destino;
    }

    public void setNome_destino(String nome_destino) {
        this.nome_destino = nome_destino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public byte[] getImagemBytes() {
        return imagemBytes;
    }

    public void setImagemBytes(byte[] imagemBytes) {
        this.imagemBytes = imagemBytes;
    }

    public Passagens() {
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome_destino == null) ? 0 : nome_destino.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Passagens other = (Passagens) obj;

        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;

        if (nome_destino == null) {
            if (other.nome_destino != null)
                return false;
        } else if (!nome_destino.equals(other.nome_destino))
            return false;

        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;

        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;

        return true;
    }

    public Passagens(Long id, String nome_destino, String descricao, String valor, byte[] imagemBytes) {
        this.id = id;
        this.nome_destino = nome_destino;
        this.descricao = descricao;
        this.valor = valor;
        this.imagemBytes = imagemBytes;
    }

    @Override
    public String toString() {
        return "Passagens [id=" + id + ", nome_destino=" + nome_destino + ", descricao=" + descricao + ", valor=" + valor
                + "]";
    }
}

