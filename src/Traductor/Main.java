package Traductor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BinaryTree<String> dictionary = new BinaryTree<>(null);

        // Leer el archivo diccionario.txt y construir el árbol binario
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",()");
                String englishWord = tokenizer.nextToken().trim();
                String spanishWord = tokenizer.nextToken().trim();
                dictionary.insert(englishWord); // Insertar la palabra en inglés en el árbol
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Recorrer el árbol en orden y mostrar la colección de palabras ordenadas por inglés
        System.out.print("Palabras ordenadas por inglés: ");
        dictionary.inOrderTraversal(dictionary);
        System.out.println(); // Agregar salto de línea después de imprimir las palabras ordenadas

        // Leer el archivo texto.txt y traducir cada palabra al español
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken().toLowerCase();
                    String translation = dictionary.search(word); // Buscar la palabra en el diccionario
                    if (translation != null) {
                        System.out.print(translation + " ");
                    } else {
                        System.out.print("*" + word + "* ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}