class week1 {
 int next(int n) {
    return n + 1;
}

int previous(int n) {
     return n - 1;
}

double doubleOf(double n) {
     return(n * 2);
}

int square(int n){
    return n * n;
}

int difference(int a, int b) {
return a -  b;
}

double average(double a, double b){
return (a + b) / 2;
}

double average(int a, int b) {
return (a + b) / 2.0;
}

int round(double n) {
    return (int) (n + 0.5);
}

boolean isNegative(int x) {
    return x < 0;
}

boolean isDigit(int n ){
    return 0 <= n && n< 10; 
}

boolean isEven(int n){
    return n % 2 == 0;
}

boolean isOdd(int n){
    return n % 2 != 0;
}

double abs(double n){
    return n < 0 ? -n : n;
}

double min(double a,double b){
  return a < b ? a : b; 
}

int sumNaturals(int n){
    return (n * (n +1)) / 2;
}

boolean isVowel(char c) {
    return c == 'a' ||c == 'e' ||c == 'i' ||c == 'o' ||c == 'u';
}

boolean inOrder(int a, int b, int c){
    return a < b && b < c;
}

boolean isIncluded(int n, int min, int max) {
    return n >= min && n <= max;
}

boolean isExcluded(int n, int min, int max){
    return (n < min && n < max) || (n > min && n > max) || n < min && n > max;
}

boolean xor(boolean a, boolean b) {
    return (a || b) && !(a && b);
}

boolean sameSign(int a, int b){
    return a < 0 && b < 0 || a > 0 && b > 0 ;
}

boolean onlyOnePositive(int a, int b){
    return a < 0 && b > 0 || a > 0 && b < 0 ;
} 
}

class Util {
     static double max(double a, double b) {
         return a > b ? a : b;
     }
     static double min(double a,double b){
        return a < b ? a : b;
     }
     static boolean inOrder(int a, int b, int c){
        return a < b && b < c;
     }
}