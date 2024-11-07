// Interface que define as operações de gerenciamento de frutas
public interface GerenciamentoFrutas {
    void adicionarFruta(String fruta);  // Método para adicionar uma fruta ao sistema
    void removerFruta(String fruta);   // Método para remover uma fruta do sistema
    void listarFrutas();               // Método para listar todas as frutas armazenadas
}

// Classe que implementa a interface GerenciamentoFrutas
public class GerenciamentoFrutasImpl implements GerenciamentoFrutas {
    
    // Definindo um array de tamanho fixo para armazenar as frutas
    private String[] frutas;
    private int contador;

    // Construtor que inicializa o array de frutas e o contador
    public GerenciamentoFrutasImpl(int capacidade) {
        this.frutas = new String[capacidade];  // Array com capacidade definida pelo usuário
        this.contador = 0;  // Inicializa o contador como 0
    }

    // Método para adicionar uma fruta ao array
    @Override
    public void adicionarFruta(String fruta) {
        // Verifica se há espaço no array para adicionar mais frutas
        if (contador < frutas.length) {
            frutas[contador] = fruta;  // Adiciona a fruta na próxima posição do array
            contador++;  // Incrementa o contador
            System.out.println("Fruta " + fruta + " adicionada com sucesso.");
        } else {
            System.out.println("Não há espaço para adicionar mais frutas.");
        }
    }

    // Método para remover uma fruta do array
    @Override
    public void removerFruta(String fruta) {
        boolean encontrada = false;
        
        // Percorre o array e tenta remover a fruta
        for (int i = 0; i < contador; i++) {
            if (frutas[i].equals(fruta)) {
                // Move as frutas restantes uma posição para a esquerda
                for (int j = i; j < contador - 1; j++) {
                    frutas[j] = frutas[j + 1];
                }
                frutas[contador - 1] = null;  // Apaga a última posição
                contador--;  // Decrementa o contador
                encontrada = true;
                System.out.println("Fruta " + fruta + " removida com sucesso.");
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Fruta " + fruta + " não encontrada no sistema.");
        }
    }

    // Método para listar todas as frutas
    @Override
    public void listarFrutas() {
        if (contador == 0) {
            System.out.println("Não há frutas no sistema.");
        } else {
            System.out.println("Lista de frutas:");
            for (int i = 0; i < contador; i++) {
                System.out.println("- " + frutas[i]);
            }
        }
    }
}

// Classe principal para testar o gerenciamento de frutas
public class Main {
    public static void main(String[] args) {
        
        // Criando um objeto do tipo GerenciamentoFrutasImpl com capacidade para 5 frutas
        GerenciamentoFrutas gerenciamento = new GerenciamentoFrutasImpl(5);

        // Testando a adição de frutas
        gerenciamento.adicionarFruta("Maçã");
        gerenciamento.adicionarFruta("Banana");
        gerenciamento.adicionarFruta("Laranja");

        // Listando as frutas
        gerenciamento.listarFrutas();

        // Testando a remoção de uma fruta
        gerenciamento.removerFruta("Banana");

        // Listando novamente as frutas após a remoção
        gerenciamento.listarFrutas();

        // Tentando remover uma fruta que não existe
        gerenciamento.removerFruta("Manga");

        // Tentando adicionar mais frutas do que o espaço no array
        gerenciamento.adicionarFruta("Uva");
        gerenciamento.adicionarFruta("Pera");
        gerenciamento.adicionarFruta("Morango");
    }
}
