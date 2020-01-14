
/**
 * <strong>TitleCaseCommand</strong><br>
 * This Title Case Command Class is designed to Title Case A string 
 * @author natcross
 */
public class TitleCaseCommand extends Commands {
	
	private MyStringBuilder _objOld;
	
	/**
	 * <strong>TitleCaseCommand</strong><br>
	 * Constructor that takes a MyStringBuilder object
	 * @param MyStringBuilder:obj
	 * @param int:index
	 */
	protected TitleCaseCommand(MyStringBuilder obj) {
		super(obj);
	}
	

	/**
	 * <strong>execute</strong><br>
	 * Executes the Title Case Command
	 */
	@Override
	public void execute() {
		_objOld = new MyStringBuilder(getObjectOfMyStringBuilder().getString().toString());
		if (!getObjectOfMyStringBuilder().isEmpty()) {
			getObjectOfMyStringBuilder().toTitleCase();
		} else {
			System.out.println("Error: in execute the list is empty");
		}

	}

	/**
	 * <strong>unexecute</strong><br>
	 * Executes the undo Title Case Command
	 */
	@Override
	public void unexecute() {
		getObjectOfMyStringBuilder().copyObj(_objOld);
	}

}
