# 🎮 Sudoku Solver

Um aplicativo robusto e eficiente para resolver puzzles de Sudoku implementado em Java, oferecendo múltiplas estratégias de resolução e uma interface intuitiva.

---

## 📋 Visão Geral

Este projeto implementa um **solver automático de Sudoku** com algoritmos otimizados para resolver puzzles de qualquer nível de dificuldade. O aplicativo fornece ferramentas para validação, resolução e análise de grids de Sudoku.

### Características Principais

✅ **Resolução Automática** - Algoritmo backtracking otimizado com constraint propagation  
✅ **Validação de Grids** - Verificação de regras do Sudoku em tempo real  
✅ **Múltiplas Estratégias** - Diferentes abordagens para resolver puzzles  
✅ **Performance** - Otimização para resolver puzzles complexos rapidamente  
✅ **Interface Clara** - Código bem estruturado e documentado  

---

## 🚀 Quick Start

### Pré-requisitos

- **Java 8+** ou versão superior
- **Maven** ou **Gradle** (opcional)
- **IDE**: IntelliJ IDEA (recomendado)

### Instalação

1. **Clone o repositório:**
```bash
git clone https://github.com/ViniciusBraga9/sudoku.git
cd sudoku
```

2. **Compile o projeto:**
```bash
javac -d bin src/**/*.java
```

3. **Execute:**
```bash
java -cp bin Main
```

---

## 💻 Uso

### Exemplo Básico

```java
// Criar uma nova instância do solver
Sudoku sudoku = new Sudoku();

// Carregar um puzzle
sudoku.setPuzzle(grid);

// Resolver
boolean solucao = sudoku.resolve();

if (solucao) {
    sudoku.print();  // Exibir solução
}
```

### Estrutura do Grid

O grid é representado como uma matriz 9x9, onde:
- **0** representa uma célula vazia
- **1-9** representam os números preenchidos

```java
int[][] grid = {
    {5, 3, 0, 0, 7, 0, 0, 0, 0},
    {6, 0, 0, 1, 9, 5, 0, 0, 0},
    {0, 9, 8, 0, 0, 0, 0, 6, 0},
    // ...
};
```

---

## 🏗️ Arquitetura

```
sudoku/
├── src/
│   └── Main.java              # Ponto de entrada
│   └── Sudoku.java            # Classe principal do solver
│   └── Validator.java         # Validação de regras
│   └── Solver.java            # Algoritmos de resolução
│   └── Utils.java             # Funções auxiliares
├── Sudoku.iml                 # Configuração IntelliJ IDEA
├── .gitignore
└── README.md
```

---

## 🧮 Algoritmos Implementados

### 1. **Backtracking com Constraint Propagation**
- Técnica principal para resolução
- Elimina candidatos impossíveis em cada etapa
- Reduz significativamente o espaço de busca

### 2. **Validação de Sudoku**
- Verifica linhas, colunas e blocos 3x3
- Detecta conflitos em tempo real

### 3. **Otimizações**
- Escolha de célula com menor domínio (MRV heuristic)
- Cache de candidatos válidos
- Early termination em casos impossíveis

---

## 📊 Performance

| Nível de Dificuldade | Tempo Médio |
|----------------------|------------|
| Fácil                | < 1ms      |
| Médio                | 1-10ms     |
| Difícil              | 10-100ms   |
| Extremo              | < 1s       |

---

## 🔍 Exemplos de Uso

### Resolver um Puzzle

```java
public static void main(String[] args) {
    int[][] puzzle = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };
    
    Sudoku sudoku = new Sudoku(puzzle);
    
    if (sudoku.resolve()) {
        System.out.println("✓ Solução encontrada:");
        sudoku.print();
    } else {
        System.out.println("✗ Nenhuma solução existe para este puzzle.");
    }
}
```

---

## 🧪 Testes

Execute os testes unitários:

```bash
# Se usando JUnit
mvn test

# Ou compile manualmente
javac -cp .:junit-4.13.jar -d bin src/**/*.java
java -cp bin:junit-4.13.jar org.junit.runner.JUnitCore SudokuTest
```

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. **Fork** o projeto
2. Crie uma **branch** para sua feature (`git checkout -b feature/AmazingFeature`)
3. **Commit** suas mudanças (`git commit -m 'Add AmazingFeature'`)
4. **Push** para a branch (`git push origin feature/AmazingFeature`)
5. Abra um **Pull Request**

### Diretrizes de Contribuição

- Mantenha o código limpo e bem documentado
- Adicione testes para novas funcionalidades
- Siga o padrão de código existente
- Atualize a documentação conforme necessário

---

## 📝 Licença

Este projeto está licenciado sob a **MIT License** - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 👨‍💻 Autor

**Vinicius Braga**
- GitHub: [@ViniciusBraga9](https://github.com/ViniciusBraga9)
- Email: vinilimabraga9@gmail.com

---

## 📞 Suporte

Tem uma dúvida ou encontrou um bug? 

- 📧 Abra uma [Issue](https://github.com/ViniciusBraga9/sudoku/issues)
- 💬 Inicie uma [Discussão](https://github.com/ViniciusBraga9/sudoku/discussions)
- 🔗 Visite a [Wiki](https://github.com/ViniciusBraga9/sudoku/wiki)

---

## ⭐ Reconhecimentos

- Inspirado em puzzles clássicos de Sudoku
- Comunidade de desenvolvedores Java
- Contribuidores e usuários que reportam bugs

---

## 📚 Recursos Adicionais

- [Sudoku - Wikipedia](https://en.wikipedia.org/wiki/Sudoku)
- [Backtracking Algorithm](https://en.wikipedia.org/wiki/Backtracking)
- [Constraint Satisfaction Problems](https://en.wikipedia.org/wiki/Constraint_satisfaction_problem)

---

**Desenvolvido com ❤️ em Java**

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=java&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=flat-square)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=flat-square)
