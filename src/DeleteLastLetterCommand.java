
/**
 * <strong>DeleteLastLetterCommand</strong><br>
 * This DeleteLastLetterCommand Class is designed to Delete the last Letter of A Character in a string
 * 
 * @author natcross
 */
public class DeleteLastLetterCommand extends Commands {
	

	private MyStringBuilder _objOld;
	/**
	 * <strong>DeleteLastLetterCommand Constructor</strong><br>
	 * Constructor that takes a MyStringBuilder object
	 * @param obj
	 */
	protected DeleteLastLetterCommand(MyStringBuilder obj) {
		super(obj);

	}


	/**
	 * <strong>execute</strong><br>
	 * Executes the Delete Last Letter Command
	 */
	@Override
	public void execute() {
		_objOld = new MyStringBuilder(getObjectOfMyStringBuilder().getString().toString());
		if (!getObjectOfMyStringBuilder().isEmpty()) {
			getObjectOfMyStringBuilder().lastCharRemove();

		} else {
			System.out.println("Error: the list is empty");
		}

	}

	/**
	 * <strong>unexecute</strong><br>
	 * Executes the undo Delete Last Letter Command
	 */
	@Override
	public void unexecute() {
		getObjectOfMyStringBuilder().copyObj(_objOld);
	
	}

}

