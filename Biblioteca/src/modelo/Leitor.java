package modelo;
import contrato.Notificavel;

import java.util.List;

public abstract class Leitor implements Notificavel {
    private String id;
    private String nome;
    private String telefone;
    private String email;
    private ItemAcervo[] itensEmprestados;
    private int quantidadeEmprestada;
    private double multaAcumulada;
    private static int totalUsuariosCriados = 0;


    public Leitor(String id, String nome, String telefone, String email, List<ItemAcervo> itensEmprestados) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.itensEmprestados = new ItemAcervo[getLimiteItens()];
        totalUsuariosCriados++;
    }

    public abstract int getLimiteItens();
    public abstract String getCategoria();

    public String getNome() {
        return nome;
    }

    public boolean podeEmprestarMais() {
        return quantidadeEmprestada < getLimiteItens();
    }

    void registrarEmprestimo(ItemAcervo item){
        if(!podeEmprestarMais()){
            throw new IllegalStateException("Limite de emprestimos ja atingido para o leitor " + nome);
        }
        itensEmprestados[quantidadeEmprestada] = item;
        quantidadeEmprestada++;
    }

    boolean registrarDevolucao(ItemAcervo item){
        for (int i = 0; i < quantidadeEmprestada; i++) {
            if (itensEmprestados[i].equals(item)) {      // equals, nao ==
                // desloca os seguintes uma posicao para tras
                for (int j = i; j < quantidadeEmprestada - 1; j++) {
                    itensEmprestados[j] = itensEmprestados[j + 1];
                }
                itensEmprestados[quantidadeEmprestada - 1] = null;
                quantidadeEmprestada--;
                return true;
            }
        }
        return false;
    }

    public void acumularMulta(double valor){
        if (valor < 0){
            throw new IllegalArgumentException("Valor invalido! Valor nao pode ser negativo");
        }
        this.multaAcumulada += valor;
    }

    public void quitarMulta(double valor){
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor invalido! Valor do pagamento deve ser positivo.");
        }
        if (valor > multaAcumulada) {
            throw new IllegalStateException(String.format(
                    "Pagamento de R$ %.2f excede o debito de R$ %.2f.", valor, multaAcumulada));
        }
        this.multaAcumulada -= valor;
    }

    // acessores

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public ItemAcervo[] getItensEmprestados() {
        return itensEmprestados;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public static int getTotalUsuariosCriados() {
        return totalUsuariosCriados;
    }

    // contrato Notificavel

    @Override
    public String getIdentificacaoContato(){
        return email != null ? email : nome;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %d/%d itens | multa R$ %.2f",
                nome, getCategoria(), quantidadeEmprestada, getLimiteItens(), multaAcumulada);
    }
}
