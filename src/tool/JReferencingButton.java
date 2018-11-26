package tool;

import javax.swing.JButton;

public class JReferencingButton<T> extends JButton 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T value;

	/**
	 * Get the value of the specific Card
	 * @return
	 */
	public T getValue() 
	{
		return this.value;
	}

	/**
	 * Set the value of the specific Card
	 * @param value
	 */
	public void setValue(T value) 
	{
		this.value = value;
	}
}
