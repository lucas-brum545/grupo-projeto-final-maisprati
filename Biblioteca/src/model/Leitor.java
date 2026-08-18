package model;
import java.util.List;

public abstract class Leitor {
    protected String id;
    protected String nome;
    protected String telefone;
    protected String email;
    protected List<ItemAcervo> ItensEmprestados;


    public Leitor(String id, String nome, String telefone, String email, List<ItemAcervo> itensEmprestados) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        ItensEmprestados = itensEmprestados;
    }


}
