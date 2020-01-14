

/**
 * <strong>LowerCaseCommand</strong><br>
 * This LowerCaseCommand Class is designed to Lower Case any letter at a index in a string
 * 
 * @author natcross
 */
public class LowerCaseCommand extends Commands{
	
	private MyStringBuilder _objOld;
	private int _index = 0;
	
	
	/**
	 * <strong>LowerCaseCommand</strong><br>
	 * Constructor that takes a MyStringBuilder object and an index used to lower case a char
	 * @param MyStringBuilder:obj
	 * @param int:index
	 */
	protected LowerCaseCommand(MyStringBuilder obj,int index) {
		super(obj);
		_index = index;
		
	}

	/**
	 * <strong>execute</strong><br>
	 * Executes the Lower Case Command
	 */
	@Override
	public void execute() {
		_objOld = new MyStringBuilder(getObjectOfMyStringBuilder().getString().toString());
		if (!getObjectOfMyStringBuilder().isEmpty()) {
			getObjectOfMyStringBuilder().lowerCaseAtIndex(_index);
		} else {
			System.out.println("Error: in execute the list is empty");
		}

	}

	/**
	 * <strong>unexecute</strong><br>
	 * Executes the undo Lower Case Command
	 */
	@Override
	public void unexecute() {
		getObjectOfMyStringBuilder().copyObj(_objOld);
	}
}
