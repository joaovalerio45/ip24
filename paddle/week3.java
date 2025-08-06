class week3 {
 boolean isPerfectSquare(int n) {
    double x = Math.sqrt(n);
    return x == Math.floor(x);
} 
}

class EvenOdd {
    static boolean isEven(int n) {
        return n % 2 == 0;
    }
    static boolean isOdd(int n){
        boolean even = isEven(n);
        return !even;
    }
}

class RandomInts {
    static int random() {
        return (int) (Math.random() * 1000000);
    }

    static int randomUntil(int max) {
        return (int) (Math.random() * max);
    }

    static int randomWithin(int min, int max) {
        int n = -1;
        while (n < min){
            n = (int) (Math.random() * max);
        }
        return n;
    }
}

class EvenOddRandom {
    static boolean isEven(int n) {
        return n % 2 == 0;
    }
    static boolean isOdd(int n){
        boolean even = isEven(n);
        return !even;
    }
    static int randomUntil(int max) {
        return (int) (Math.random() * max);
    }
    static int randomEven(int max){
        int n = randomUntil(max);
        boolean even = isEven(n);
        while (!even){
            n = randomUntil(max);
            even = isEven(n);
        }
        return n;
    }
        static int randomOdd(int max){
        int n = randomUntil(max);
        boolean odd = isOdd(n);
        while (!odd){
            n = randomUntil(max);
            odd = isOdd(n);
        }
        return n;
    }
}

class Divisors {
    static int countDivisors(int n){
        int i = 0;
        int count = 0;
        while (i < n){
            i = i + 1;
            if (n % i == 0){
                count = count + 1;
            }
        }
        return count;
    }
    static int sumProperDivisors(int n){
        int i = 0;
        int sum = 0;
        while (i < (n - 1)){
            i = i + 1;
            if (n % i == 0){
                sum = sum + i;
            }
        }
        return sum;
    }
    static boolean isPrime(int n){
        int i = 0;
        int count = 0;
        while (i < n){
            i = i + 1;
            if (n % i == 0){
                count = count + 1;
            }
        }
        return count == 2;
    }
}

class primeNumbers{
    static int countPrimes(int n){
        int x = 0;
        int count = 0;
        while (x <= n){
            if (Divisors.isPrime(x) == true){
                count = count + 1;
            }
            x = x + 1;
        }
        return count;
    }
    static boolean existsPrimeBetween(int min, int max){
        int x = min + 1;
        boolean i;
        while ( x < max){
            i = (Divisors.isPrime(x));
            if (i == true){
                return true;
            }
            x = x + 1;
        }
        return false;
    }
}

class perfectNumbers{
    static boolean isPerfect(int x){
    return (Divisors.sumProperDivisors(x) == x);
    }
    static int countPerfectNumbers(int x){
        int count = 0;
        int i = 1;
        while (i < x){
            if (isPerfect(i) == true){
                count = count + 1;
            }
            i = i + 1;
        }
        return count;
    }
}

class LargerPrimeDiff {
    static int largestPrimeDiff(int max) {
        int prime = 2;
        int diff = 0;
        int i = 3;
        while (i <= max) {
            if (Divisors.isPrime(i) == true) {
                if (diff < (i - prime)){
                    diff = i - prime;
                }
                prime = i;
            }
        i = i + 1;
        }
        return diff;
    }
}