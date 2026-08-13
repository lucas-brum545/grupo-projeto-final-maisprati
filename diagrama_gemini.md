[ com.ong.biblioteca ]
│
├── 📁 model (Entidades / Dados)
│   ├── 🟦 Livro
│   │   ├── - id: Long
│   │   ├── - titulo: String
│   │   ├── - autor: String
│   │   ├── - genero: String
│   │   └── - disponivel: boolean
│   │
│   ├── 🟦 Leitor
│   │   ├── - id: Long
│   │   ├── - nome: String
│   │   ├── - telefone: String
│   │   └── - email: String
│   │
│   └── 🟦 Emprestimo
│       ├── - id: Long
│       ├── - livro: Livro
│       ├── - leitor: Leitor
│       ├── - dataEmprestimo: LocalDate
│       ├── - dataDevolucaoPrevista: LocalDate
│       └── - devolvido: boolean
│
├── 📁 repository (Interfaces de Contrato de Banco de Dados)
│   ├── 🔸 LivroRepository (implements JpaRepository)
│   ├── 🔸 LeitorRepository (implements JpaRepository)
│   └── 🔸 EmprestimoRepository (implements JpaRepository)
│
├── 📁 service (Regras de Negócio da ONG)
│   └── 🟩 BibliotecaService
│       ├── + realizarEmprestimo(livroId: Long, leitorId: Long): Emprestimo
│       ├── + registrarDevolucao(emprestimoId: Long): void
│       └── + listarLivrosDisponiveis(): List<Livro>
│
└── 📁 controller (Endpoints da API / Entradas Web)
    └── 🟨 BibliotecaController
        ├── + GET /api/livros
        ├── + POST /api/emprestimos
        └── + PUT /api/devolucoes/{id}