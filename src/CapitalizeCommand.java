
/**
 * <strong>CapitalizeCommand</strong><br>
 * This CapitalizeCommand Class is designed to Capitalize any letter at a index in a string
 * 
 * @author natcross
 */
public class CapitalizeCommand extends Commands {
	private MyStringBuilder _objOld;
	private int _index = 0;
	
	/**
	 * <strong>CapitalizeCommand Constructor</strong><br>
	 * Constructor that takes a MyStringBuilder object and an index used to Capitalize a char
	 * @param MyStringBuilder:obj
	 * @param int:index
	 */
	protected CapitalizeCommand(MyStringBuilder obj, int index) {
		super(obj);
		_index = index;
	}

	/**
	 * <strong>execute</strong><br>
	 * Executes the Capitalize Command
	 */
	@Override
	public void execute() {
		_objOld = new MyStringBuilder(getObjectOfMyStringBuilder().getString().toString());
		if (!getObjectOfMyStringBuilder().isEmpty()) {
			getObjectOfMyStringBuilder().capitalizeAtIndex(_index);
		} else {
			System.out.println("Error: in execute the list is empty");
		}

	}

	/**
	 * <strong>unexecute</strong><br>
	 * Executes the undo Capitalize Command
	 */
	@Override
	public void unexecute() {
		getObjectOfMyStringBuilder().copyObj(_objOld);
	}
}
