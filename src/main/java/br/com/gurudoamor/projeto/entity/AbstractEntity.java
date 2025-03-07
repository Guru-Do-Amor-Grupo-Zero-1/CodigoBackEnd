package br.com.gurudoamor.projeto.entity;
import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    protected Long id;
}
