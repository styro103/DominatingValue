/*
 * The class with the function that finds a dominator,
 * 		a location of the leading value in an array.
 * It has a time complexity of O(N).
 */

class Dominator 
{
	public int getLocation(int [] V)
	{
		if (V.length<3) //If Number of Elements is Less Than 3
		{
			switch (V.length) //Act Depending on Exact Number
			{
			    case 2: //If Two Elements
			        if (V[0]!=V[1]) //If Two Elements Aren't Equal, No Leader, No Dominator
			            break; //Leave Switch, Do Same as Case 0 (Elements)
			    case 1: //If Only One Element (or Two Equal Elements)       
			        return 0; //Return First Index, Location of Leader
			}
			
			return -1; //Case of 0 Elements, No Leader, So No Dominator
		}
		
		/*
		 * To find a location of the leading value, a make-shift stack is used.
		 * A real one isn't needed since only the size and one of the left over values is
		 * needed. Therefore, a real stack isn't used to save memory. Instead, regular
		 * variables are created to store the information needed.		
		 */
		
		int N = V.length; //Number of Elements
		int lead = V[0]; //Current Leader, Initialize and Push on Make-Shift Stack
		int size = 1; //Make-Shift Stack Size, Initialized to 1 With Prior Make-Shift Push
		int limit = N/2; //The Required Minimum to Meet Requirements of Being Leader
		int count = 0; //Keep Count of Leading Value
		
		for (int i=1; i<N; i++) //Loop Through Array From 2nd Element
		{
			if (size==0) //If Size is Zero
			{
				size++; //Increment Size
				lead = V[i]; //Update Leader
				continue; //Next Loop Increment
			}
			if (lead!=V[i]) //Size is Positive, but Leader Doesn't Match Current Element
				size--; //Decrement Size of Make-Shift Stack
			else //Positive Size, Leader Matches Current Element
				size++; //Increment Size of Make-Shift Stack
		}		
		if (size<1) //No Elements Left in Make-Shift Stack
			return -1; //No Leader, No Dominator
		for (int i=0; i<N; i++) //Loop Through Array Again
		{
			if (V[i]==lead) //If Element Equals Leader
			{
				count++; //Increment Count
				
				if (i>=limit && count>limit) //If It's Been More Than Half The Elements, and Count Exceeds Minimum
					return i; //Current Index is Dominator (Location of Array Leader)
			}
		}
		
		return -1; //If Here, No Leader, No Dominator
	}
}