// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		System.err.println("\n" + pow(-2, 3));
		System.out.println(div(-15, 3));
		System.out.println(div(-15, -3));

	}

	// Returns the positive value of x
	public static int abs(int x) {
        if (x < 0) {
			String str = Integer.toString(x);
            str = str.substring(1);
			return Integer.parseInt(str);
        }
		return x;
    }

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int x2_abs = abs(x2);
		for (int i = 0; i < x2_abs; i++){
			if (x2 > 0){
				x1++;
			} else {
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int x2_abs = abs(x2);
		for (int i = 0; i < x2_abs; i++){
			if (x2 > 0){
				x1--;
			} else {
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 == 0 || x2 == 0){
			return 0;
		}
		int x1_abs = abs(x1);
		int x2_abs = abs(x2);
		int result = x1_abs;
		for (int i = 0; i < x2_abs - 1; i++){
			result = plus(result, x1_abs);
		}
		if ((x1 < 0  && x2 > 0) || (x2 < 0  && x1 > 0)){
			result = -result;
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0){
			return 1;
		}
		int result = x;
		for (int i = 0; i < n - 1; i++){
			result = times(result, x);
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int x1_abs = abs(x1);
		int x2_abs = abs(x2);
		if (x2_abs > x1_abs || x2 == 0){
			return 0;
		}
		int temp = x2_abs;
		int result = 1;
		while (temp < x1_abs){
			temp = plus(temp, x2_abs);
			if (temp <= x1_abs){
				result++;
			}
		}
		if ((x1 < 0  && x2 > 0) || (x2 < 0  && x1 > 0)){
			result = -result;
		}
		return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x1 == 0){
			return 0;
		}
		int temp = x2;
		while (plus(temp, x2) <= x1){
			temp = plus(temp, x2);
		}
		return minus(x1, temp);
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x == 1){
			return 1;
		}
		int epsilon = 1;
		int low = 0;
		int high = x;
		int result = div(plus(low, high), 2);
		while ((minus(times(result, result), x) >= epsilon || minus(times(result, result), x) <= -epsilon) && 
				low < minus(high, 1)){
			if (times(result, result) < x){
				low = result;
			} else {
				high = result;
			}
			result = div(plus(low, high), 2);
		}
		return result;
	}  	  
}