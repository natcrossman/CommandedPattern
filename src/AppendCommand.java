
/**
 * <strong>AppendCommand</strong><br>
 * This AppendCommand Class is designed to Append A Character to the string
 * 
 * @author natcross
 * 
 * 
 *
 */
public class AppendCommand extends Commands {
	private char _letter;
	private MyStringBuilder _objOld;

	/**
	 * Constructor that takes a MyStringBuilder object and A single character
	 * 
	 * @param MyStringBuilder:obj
	 * @param char:letter
	 */
	protected AppendCommand(MyStringBuilder obj, char letter) {
		super(obj);
		_letter = letter;
	}

	/**
	 * <strong>execute</strong><br>
	 * Executes the Append Command
	 */
	@Override
	public void execute() {
		_objOld = new MyStringBuilder(getObjectOfMyStringBuilder().getString().toString());
		getObjectOfMyStringBuilder().append(_letter);
	}

	/**
	 * <strong>unexecute</strong><br>
	 * Executes the undo Append Command
	 */
	@Override
	public void unexecute() {
		getObjectOfMyStringBuilder().copyObj(_objOld);
	}

}
