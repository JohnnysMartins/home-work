package br.com.home.web.homework.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{
    private static final long serialVersionUID = -6666192453307283421L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "produto_id_seq")
    @SequenceGenerator(name = "produto_id_seq", sequenceName = "produto_id_seq")
    @Column(name = "id")
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private String codigo;

    @Column(name = "preco_custo")
    private Double precoCusto;

    @Column(name = "preco_venda")
    private Double precoVenda;

    @Column
    private int quantidade;

    @ManyToOne(optional = true)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
