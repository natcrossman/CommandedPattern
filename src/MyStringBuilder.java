
/**
 * <strong>MyStringBuilder</strong><br>
 *  This Class is designed to force the basic functionality of a String
 * @author natcross

 */
public class MyStringBuilder {
	
	private StringBuilder _myStringObj;
	
	/**
	 * Construct a default CommandString object
	 * @param :string
	 */
	public MyStringBuilder() {
			_myStringObj = new StringBuilder();

	}
	/**
	 * Construct a CommandString object with a string
	 * @param :string
	 */
	public MyStringBuilder(String string) {
			_myStringObj = new StringBuilder(string);
			
	}
	/**
	 * Construct a CommandString object with a char
	 * @param char: letter
	 */
	public MyStringBuilder(char letter) {
		_myStringObj = new StringBuilder();
		_myStringObj.append(letter);
		
	}
	
	/**
	 * <strong>getString</strong><br>
	 * This method return the string object
	 * @return
	 */
	public StringBuilder getString() {
		return _myStringObj;
	}
	
	/**
	 *  <strong>size</strong><br>
	 * This method give the size of the string. 
	 * Note: Zero signifies empty string
	 * @return int: @value: {0 ... N}
	 */
	public int size() {
		return (_myStringObj.length());
	}
	
	/**
	 *  <strong>isEmpty</strong><br>
	 *  This method tell if the string is empty
	 * @return boolean
	 */
	public boolean isEmpty() {
		return (_myStringObj.length() ==  0) ? true : false;
	}
	
	/**
	 *  <strong>append</strong><br>
	 * This method will append a letter to a string
	 * @param char: letter
	 */
	public  void append(char letter) {
		this._myStringObj.append(letter);
	}
	
	/**
	 *  <strong>append</strong><br>
	 * This method will append a letter to a string
	 * @param String: letter
	 */
	public  void append(String letter) {
		this._myStringObj.append(letter);
	}
	/**
	 * 
	 * @param index
	 * @param letter
	 */
	public  void insertCharAt(int index, char letter) {
		this._myStringObj.insert(index,letter);
	}
	
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public char getCharAt(int index) {
		return this._myStringObj.charAt(index);
	}
	/**
	 * <strong>firstCharRemove</strong><br>
	 *This method will delete a letter from the start of a string
	 */
	public  void firstCharRemove() {
		this._myStringObj.deleteCharAt(0);
	}	
	
	
	/**
	 *  <strong>lastCharRemove</strong><br>
	 *This method will delete a letter from the end of a string
	 */
	public  void lastCharRemove() {
		this._myStringObj.deleteCharAt((_myStringObj.length()-1));
	}
	
	/**
	 *  <strong>removeCharAtIndex</strong><br>
	 * This method will delete a letter from an index a string
	 * @param int:index
	 */
	public void removeCharAtIndex(int index) {
		this._myStringObj.deleteCharAt(index);
	}
	
	/**
	 * <strong>capitalizeAtIndex</strong><br>
	 * This method will capitalize a letter at any index within a string
	 * @param int index
	 */
	public  void capitalizeAtIndex(int index) {
		char hold = this._myStringObj.charAt(index);
		this._myStringObj.setCharAt(index, Character.toUpperCase(hold));
	}
	
	
	/**
	 * <strong>lowerCaseAtIndex</strong><br>
	 * This method will lower case a letter at any index within a string
	 * @param int index
	 */
	public  void lowerCaseAtIndex(int index) {
		char hold = this._myStringObj.charAt(index);
		this._myStringObj.setCharAt(index, Character.toLowerCase(hold));
	}
	
	/**
	 * <strong>toTitleCase</strong><br>
	 * This method will set the  whole string use title case
	 * Stack overflow and other resources we use to develop this piece of code.
	 * To my knowledge, there is no one precise reference as I built it from many other examples
	 */
	public  void  toTitleCase() {
		boolean isThisTheBeginningOf = true;
		final String DELIMTERS = " '-/";
		StringBuilder newTitleCase = new StringBuilder();
		 for(int i =0; i < _myStringObj.length(); i++) {
			 char hold = _myStringObj.charAt(i);
			 if(isThisTheBeginningOf) {
				 this._myStringObj.setCharAt(i, Character.toTitleCase(Character.toUpperCase(hold))); //Works the best by first forcing them to uppercase
			 }else {
				 this._myStringObj.setCharAt(i, Character.toLowerCase(hold));//Works the best by first forcing them to Lowercase
			 }	
			 newTitleCase.append(hold);
			 isThisTheBeginningOf = (DELIMTERS.indexOf((int) hold) >=0);
	
		 }	
	}
	
	
	/**
	 * <strong>toString</strong><br>
	 * This method simply calls the my string objects to string method
	 */
	public String toString() {
		return _myStringObj.toString();
	}
	
	public void copyObj(MyStringBuilder o) {
		this._myStringObj = new StringBuilder(o.getString());
	}
	
	

}
