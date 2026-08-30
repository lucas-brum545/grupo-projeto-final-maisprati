package modelo;
import contrato.Emprestavel;

public abstract class ItemEmprestavel extends ItemAcervo implements Emprestavel {
    private Leitor leitorAtual;

    protected ItemEmprestavel(Long id, String codigo, String titulo, int ano) {
        super(id, codigo, titulo, ano);
        this.leitorAtual = leitorAtual;
    }


    @Override
    public boolean emprestar(Leitor leitor) {
        if (leitor == null) {
            throw new IllegalArgumentException("Usuario nao pode ser nulo.");
        }

        if (!isDisponivel()) {
            System.out.printf("   [X] %-22s tentou \"%s\" - item indisponivel%n",
                    leitor.getNome(), getTitulo());
            return false;
        }

        if (!leitor.podeEmprestarMais()) {
            System.out.printf("   [X] %-22s tentou \"%s\" - limite de %d item(s) atingido%n",
                    leitor.getNome(), getTitulo(), leitor.getLimiteItens());
            // ✅ %d item(s): evita a concordancia errada quando o limite e 1
            return false;
        }

        leitor.registrarEmprestimo(this);
        marcarComoEmprestado();
        this.leitorAtual = leitor;

        System.out.printf("   [OK] %-21s pegou \"%s\"  [%d/%d]%n",
                leitor.getNome(), getTitulo(),
                leitor.getQuantidadeEmprestada(), leitor.getLimiteItens());
        return true;
    }

}
