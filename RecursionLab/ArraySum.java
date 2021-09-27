
public class ArraySum {

	public int sumOfArray(Integer [] a, int index) {
		int sum = 0;
		
		if (index < 0) {
		      sum = 0;
		      return sum;
		    }
		
		  sum = sumOfArray(a, index - 1) + a[index];
		  return sum;
		  }

}

