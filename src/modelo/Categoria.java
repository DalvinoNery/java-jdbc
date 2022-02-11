package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private Integer id;
    private String nome;
    private List<Produto>  listaProdutos = new ArrayList<Produto>();


    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
