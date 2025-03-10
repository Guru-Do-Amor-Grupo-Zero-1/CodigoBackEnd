package br.com.gurudoamor.projeto.entity;

import br.com.gurudoamor.projeto.enums.Signos;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table (name = "usuarios", schema = "public")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Usuario extends AbstractEntity{

    @Getter
    @Setter
    @Column(name = "nomeUsuario", length = 50, unique = true)
    private String nomeUsuario;

    @Getter @Setter
    @Column (name = "telefone", length = 15, unique = true)
    private String telefone;

    @Getter @Setter
    @Column (name = "signoUsuario", length = 15)
    private Signos signoUsuario;

    @Getter @Setter
    @Lob
    @Column(name = "imagemPerfil")
    private byte[] imagemPerfil;
    @Getter @Setter
    @Column(name = "endereco")
    private String endereco;

    public Usuario(){}

    public Usuario(Long id,String nomeUsuario, String telefone, Signos signoUsuario,byte[] imagemPerfil, String endereco) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.telefone = telefone;
        this.signoUsuario = signoUsuario;
        this.imagemPerfil = imagemPerfil;
        this.endereco = endereco;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Signos getSignoUsuario() {
        return signoUsuario;
    }

    public void setSignoUsuario(Signos signoUsuario) {
        this.signoUsuario = signoUsuario;
    }

    public byte[] getImagemPerfil() {
        return imagemPerfil;
    }

    public void setImagemPerfil(byte[] imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
