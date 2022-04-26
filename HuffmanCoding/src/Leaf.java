/*
 * Leaf class - Child class of Node class
 * this will acts as a class of the Leaf node which contains an extra argument character to store the character
 */
public class Leaf extends Node {

    private final char character;

    //constructor
    public Leaf(char character, int frequency) {
        super(frequency);//calling parent class constructor
        this.character = character;
    }

    //getter function of the character
	public char getCharacter() {
		return character;
	}

}