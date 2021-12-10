// Import statement:
import java.util.ArrayList;

class PrimeDirective {
  
  // Add your methods here:
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

  public ArrayList<Integer> onlyPrimes(int[] numbers) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int number : numbers) {
      if (isPrime(number)) {
        primes.add(number);
      }
    }
    return primes;
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
  }  

}
