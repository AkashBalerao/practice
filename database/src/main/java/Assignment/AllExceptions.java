package Assignment;

class InvalidItemNumber extends Exception{
	InvalidItemNumber(String msg)
	{
		super(msg);
	}
}

class CartIsEmptyException extends Exception
{
	CartIsEmptyException(String msg)
	{
		super(msg);
	}
}

class NotEnoughItemsAvaliable extends Exception
{
	NotEnoughItemsAvaliable(String msg)
	{
		super(msg);
	}
}