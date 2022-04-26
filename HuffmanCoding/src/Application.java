/*
 * This class contains the main function - Starting point of my application
 */
public class Application {
    public static void main(String[] args) {

        Huffman huffman = new Huffman();//Object of Huffman class created

        String encodedText = huffman.encode("Nagabhushan N");//call to encode the given text
        System.out.println(encodedText);

        huffman.printCodes();//call to print the characters and corresponding huffman codes

        String originalText = huffman.decode(encodedText);//call to decode the given Encoded binary string
        System.out.println(originalText);

    }

}