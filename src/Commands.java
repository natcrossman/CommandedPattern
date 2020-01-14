
/**
 * <strong>Commands</strong><br>
 * This Commands abstract Class
 * 
 * @author natcross
 */
public abstract class Commands {
	private MyStringBuilder _objMyStringBuilder;
	private int _size = 0;
	
	
	/**
	 * <strong>Commands</strong><br>
	 * This Construct passes the References to the necessary objects
	 * @param MyStringBuilder:obj
	 *
	 */
	protected Commands (MyStringBuilder obj) {
		_objMyStringBuilder = obj;
		_size =  obj.size();
		
		
}
	
	/**
	 * <strong>getObjectOfMyStringBuilder</strong><br>
	 * This method return the MyStringBuilder object
	 * @return MyStringBuilder:_objMyStringBuilder
	 */
	public MyStringBuilder getObjectOfMyStringBuilder() {
		return _objMyStringBuilder;
	}
	
	
	/**
	 * <strong>getSize</strong><br>
	 * This method return the size of MyStringBuilder object
	 * @return int: _size
	 */
	public int getSize() {
		return _size;
	}
	
	/**
	 * <strong>setSize</strong><br>
	 *  This method sets the size of MyStringBuilder object
	 * @param int:size
	 */
	public void setSize(int size) {
		 _size = size;
	}
	
	
	/**
	 * <strong>sizeIncrease1</strong><br>
	 * This method increases the size by one
	 */
	public void sizeIncrease1() {
		 _size++;
	}
	
	/**
	 *  <strong>sizeDecrease1</strong><br>
	 *  This method decrements the size by one
	 */
	public void sizeDecrease1() {
		 _size--;
	}
	
	/**
	 * <strong>isMyObjEmpty</strong><br>
	 * This method specifies whether or not the object is empty
	 * @return boolean: {@value true - false}
	 */
	public boolean isMyObjEmpty() {
		return _objMyStringBuilder.isEmpty();
	}


	
	/**
	 * <strong>getLetter</strong><br>
	 * This method return the letter from MyStringBuilder object at index
	 * @param index
	 * @return
	 */
	public char getLetter(int index) {
		return _objMyStringBuilder.getCharAt(index);
	}
	
	
	/**
	 * <strong>unexecute</strong><br>
	 * abstract
	 */
	public abstract void execute();
	/**
	 * <strong>unexecute</strong><br>
	 * abstract
	 */
	public abstract void unexecute();

}
