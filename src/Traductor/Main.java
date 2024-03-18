package Traductor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        // Crear un árbol binario para el diccionario Inglés-Español
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>(null);

        // Leer el archivo diccionario.txt y construir el árbol binario
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",()");
                String englishWord = tokenizer.nextToken().trim();
                String spanishWord = tokenizer.nextToken().trim();
                Association<String, String> association = new Association<>(englishWord, spanishWord);
                // Insertar la asociación en el árbol binario
                // dictionary.insert(association);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Recorrer el árbol en orden y mostrar la colección de palabras ordenadas por inglés
        System.out.print("Palabras ordenadas por inglés: ");
        // dictionary.inOrderTraversal(dictionary);

        // Leer el archivo texto.txt y traducir cada palabra al español
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken().toLowerCase();
                    // Buscar la palabra en el diccionario y traducirla
                    // if (dictionary.search(word)) {
                    //     System.out.print(spanishTranslation + " ");
                    // } else {
                    //     System.out.print("*" + word + "* ");
                    // }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
