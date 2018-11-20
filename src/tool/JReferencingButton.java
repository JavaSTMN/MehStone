package tool;

import javax.swing.JButton;

public class JReferencingButton<T> extends JButton 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T value;

	public T getValue() 
	{
		return this.value;
	}

	public void setValue(T value) 
	{
		this.value = value;
	}
}
