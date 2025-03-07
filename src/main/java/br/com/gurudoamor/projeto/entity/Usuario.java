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
    private int telefone;

    @Getter @Setter
    @Column (name = "signoUsuario", length = 15, unique = true)
    private Signos signoUsuario;

    @Getter @Setter
    @Lob
    @Column(name = "imagemPerfil")
    private byte[] imagemPerfil;
    @Getter @Setter
    @Column(name = "endereco")
    private String endereco;

    public Usuario(){}

    public Usuario(Long id,String nomeUsuario, int telefone, Signos signoUsuario,byte[] imagemPerfil, String endereco) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.telefone = telefone;
        this.signoUsuario = signoUsuario;
        this.imagemPerfil = imagemPerfil;
        this.endereco = endereco;
    }

}
