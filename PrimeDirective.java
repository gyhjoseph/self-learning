// import to use ArrayList
import java.util.ArrayList;

class PrimeDirective {
  
  // check whether a number is prime
  public boolean isPrime(int number) {
    if (number == 2) {
      System.out.println("This is the smallest prime number!");
      return true;
    } else if (number < 2) {
      System.out.println("This is not a prime number.");
      return false;
    }
    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        System.out.println("This is not a prime number.");
        return false;
      }
    }
    System.out.println("This is a prime number.");
    return true;
  }

  // method to return prime numbers array only
  public ArrayList<Integer> onlyPrimes(int[] numbers) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int number : numbers) {
      if (isPrime(number)) {
        primes.add(number);
      }
    }
    return primes;
  }

  // method to return odd or even array depending on argument
  public ArrayList<Integer> oddEvenSort(String oddOrEven, int[] numbers) {
    ArrayList<Integer> odd = new ArrayList<Integer>();
    ArrayList<Integer> even = new ArrayList<Integer>();
    for (int number : numbers) {
      if (number % 2 == 0) {
        even.add(number);
      } else {
        odd.add(number);
      }
    }
    if (oddOrEven.equalsIgnoreCase("odd")) {
      return odd;
    }
    return even;
  }
  
  public static void main(String[] args) {

    PrimeDirective pd = new PrimeDirective();
    int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};

    // testing a set of prime numbers for isPrime method
    System.out.println(pd.isPrime(7));
    System.out.println(pd.isPrime(28));
    System.out.println(pd.isPrime(2));
    System.out.println(pd.isPrime(0));

    // testing of onlyPrimes ArrayList
    System.out.println(pd.onlyPrimes(numbers));

    // testing of odd or even method
    System.out.println(pd.oddEvenSort("odd", numbers));
  }  

}
