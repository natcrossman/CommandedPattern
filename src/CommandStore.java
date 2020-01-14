import java.util.*;
/**
 * <strong>CommandStore</strong><br>
 * This CommandStore class is used to store commands
 * 
 * @author natcross
 */
public class CommandStore {

	private static Stack<Commands> _commandList; // list of commands
	private static int _lastCommandExecuted;
	private static int _commandListEnd;
	private static CommandStore _theStore = new CommandStore();

	/**
	 * <strong>CommandStore</strong><br>
	 * Constructor that set the default for the configurations for the command Its
	 * type is private as we never wanted it to be re-instantiated. for the lifetime
	 * of the program it should remain constant.
	 */
	private CommandStore() {
		_commandList = new Stack<Commands>();
		_lastCommandExecuted = -1;
		_commandListEnd = -1;
	}

	/**
	 * <strong>getInstance</strong><br>
	 * This method gets the CommandStore obj
	 * 
	 * @return CommandStore: _theStore
	 */
	public static CommandStore getInstance() {
		return _theStore;
	}

	/**
	 * <strong>runCommand</strong><br>
	 * This method runs any Command
	 * 
	 * @param Commands:c
	 */
	public void runCommand(Commands c) {
		if(_lastCommandExecuted ==-1 )
			removeCommandForList(); //if we ever empty the stack and then run a new command delete all
		c.execute();
		_commandList.push(c);
		_lastCommandExecuted++;
		_commandListEnd = _lastCommandExecuted;
		System.out.println("_lastCommandExecuted " + _lastCommandExecuted);
		System.out.println("_commandList is size " + _commandList.size());
	}

	/**
	 * <strong>undo</strong><br>
	 * This method Undoes any command
	 */
	public void undo() {
		System.out.println("The Number of command in _commandList our:" + _lastCommandExecuted);
		if (_lastCommandExecuted >= 0) {
			Commands obj = _commandList.get(_lastCommandExecuted);
			_lastCommandExecuted--;
			obj.unexecute();
			
		} else {
			System.out.println("Error: We can not do UNDO\n_commandList is emtpy:" + _lastCommandExecuted + "\n");
		}
	}

	/**
	 * <strong>redo</strong><br>
	 * This method Redoes any command
	 * 
	 * @return boolean: {@value true - false}
	 */
	public boolean redo() {
		System.out.println("The Number of command in _commandList our:" + _lastCommandExecuted);
		if (_lastCommandExecuted < _commandListEnd) {
			if (_lastCommandExecuted == _commandList.size()) { //There is not point redoing when pointer is same as index
				return false;
			} else {
				_lastCommandExecuted++;
				_commandList.get(_lastCommandExecuted).execute();
				return true;
			}
		}
		return false;
	}

	public void removeCommandForList() {
		if (_commandList.size() < 1) {
			return;
		}
		for (int i = _commandList.size()-1; i > _lastCommandExecuted; i--) {
			_commandList.remove(i);
			System.out.println("remove " + i);
			System.out.println("_lastCommandExecuted:" + _lastCommandExecuted);
			
		}

	}

}
