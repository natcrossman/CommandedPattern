

/**
 * <strong>DeleteFirstLetterCommand</strong><br>
 * This DeleteFirstLetterCommand Class is designed to Delete the  First Letter of A Character in a string
 * 
 * @author natcross
 */
public class DeleteFirstLetterCommand extends Commands {


	private MyStringBuilder _objOld;
	/**
	 * <strong>DeleteFirstLetterCommand Constructor</strong><br>
	 * Constructor that takes a MyStringBuilder object
	 * 
	 * @param obj
	 * 
	 */
	protected DeleteFirstLetterCommand(MyStringBuilder obj) {
		super(obj);

	}

	/**
	 * <strong>execute</strong><br>
	 * Executes the Delete First Letter Command
	 */
	@Override
	public void execute() {
		_objOld = new MyStringBuilder(getObjectOfMyStringBuilder().getString().toString());
		if (!getObjectOfMyStringBuilder().isEmpty()) {
			getObjectOfMyStringBuilder().firstCharRemove();
		} else {
			System.out.println("Error: the list is empty");
		}

	}

	/**
	 * <strong>unexecute</strong><br>
	 * Executes the undo Delete First Letter Command
	 */
	@Override
	public void unexecute() {
		getObjectOfMyStringBuilder().copyObj(_objOld);

	}

}
