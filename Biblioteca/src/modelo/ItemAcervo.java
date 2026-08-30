package modelo;
import contrato.Config;
public abstract class ItemAcervo {
    private Long id;
    private final String codigo;
    private final String titulo;
    private final int ano;
    private boolean disponivel;
    private static int itensCriados = 0;

    protected ItemAcervo(Long id, String codigo, String titulo, int ano) {
        this.id = id;

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Codigo é obrigatorio.");
        }

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo é obrigatorio.");
        }

        if (ano < Config.ANO_MINIMO_PUBLICACAO || ano > Config.ANO_MAXIMO_PUBLICACAO) {
            throw new IllegalArgumentException(
                    "Ano invalido: " + ano + ". Esperado entre "
                            + Config.ANO_MINIMO_PUBLICACAO + " e " + Config.ANO_MAXIMO_PUBLICACAO + ".");
        }

        this.codigo = codigo;
        this.titulo = titulo;
        this.ano = ano;
        this.disponivel = true;   // todo item nasce disponivel

        itensCriados++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    protected void marcarComoEmprestado() {
        this.disponivel = false;
    }

    public abstract int getPrazoEmprestimo();

    public abstract double getMultaDiaria();

//    public abstract boolean permiteRenovacao();

    public abstract String getDescricaoDetalhada();


    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public abstract String getCategoria();
}

