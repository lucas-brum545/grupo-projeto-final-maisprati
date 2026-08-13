package model;
import java.util.List;

public abstract class Usuario {
    protected String matricula;
    protected String nome;
    protected List<ItensAcervo> ItensEmprestados;

    public Usuario(String matricula, String nome, List<ItensAcervo> itensEmprestados) {
        this.matricula = matricula;
        this.nome = nome;
        ItensEmprestados = itensEmprestados;
    }



}
