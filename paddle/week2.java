class week2 {
 double abs(double n) {
if (n >= 0) {
    return n;
    }
    else {
        return -n;
    }
}

int max(int a, int b) {
    if (a < b){
        return b;
    }
    else{
        return a;
    }
}

int min(int a, int b){
    if (a < b){
        return a;
    } else{
        return b;
    }
}

int irsGroup(int ren) {
    int esc;
    esc = 0;
    if (0 <= ren && ren < 10000) {
        esc = 1;
    } else {
        if (10000 <= ren && ren <= 25500) {
            esc = 2;
        } else {
            if (25500 < ren && ren <= 48500) {
                esc = 3;
            } else {
                if ( 48500 < ren){
                    esc = 4;
                }
            }
        }
    }
    return esc;
}

double irsTax(int esc){
    double tax;
    tax = 0;
    if (esc == 1){
        tax = 0.12;
    }else {
        if (esc == 2){
            tax = 0.18;
        }else {
            if (esc == 3){
                tax = 0.23;
            }else {
                if (esc == 4){
                    tax = 0.29;
                }else{
                    tax = 0.0;
                }
            }
        }
    }
    return tax;
}

static void varAssign() {
int n = 1;
n = 2;
n = n + 1;
n = n + 1;
n = n + 1;
}

static void varAssignDiv() {
int v = 2024;
v = v / 10;
v = v / 10;
v = v / 10;
}

int firstDigit(int n){
    while (n > 9){
        n = n / 10;
    }
    return n;
}

static void naturalsIterator() {
int i = 1;
while(i < 5) {
   i = i + 1;
}
}

int sumNaturals(int max){
    int count = 0;
    int sum = 0;
    while (count < max){
        count = count + 1;
        sum = sum + count;
    }
    return sum;
}

static void reverseIteration() {
int x = 5;
while (x > 0)
x = x - 1;

}

int powerOfTwo(int exp){
    int count = 1;
    int sum = 1;
    while (count <= exp){
        count = count + 1;
        sum = sum * 2;
    }
    return sum;
}

boolean isMultiple(int a, int b){
    int mult = b;
    while (a > b){
        b = b + mult;
    }
    return (b == a);
}

int intDivision(int a, int b){
    int div = b;
    int count = 0;
    while (a >= div){
        a = a - div;
        count = count + 1;
    }
    return count;
}

static void iterationStepTwo() {
int p = 2;
while (p < 10){
    p = p + 2;
}
}

int sumEvenBetween(int min, int max){
    if (min % 2 != 0){
        min = min + 1;
    }
    int sum = 0;
    while (min <= max){
        sum = sum + min;
        min = min + 2;
    }
    return sum;
}

char nextLetter(char n){
    if (n == 'z'){
        return 'a';
    } else{
        return (char)(n + 1);
    }
}

int gcd(int a,int b){
    int c = 0;
    while (b != 0){
        c = b;
        b = (a % b);
        a = c;
    }
    return a;
}

int invertInt(int n){
     int inverted = 0;
    while (n != 0) {
        inverted = inverted * 10 + n % 10;
        n /= 10;
    }
    return inverted;
}

int fib(int n){
    if (n == 0){
        return 0;
    }
    if (n == 1){
        return 1;
    }
    return (fib(n - 1) + fib(n - 2));
} 
}

class IrsUtil {
    static int irsGroup(int ren) {
    int esc;
    esc = 0;
    if (0 <= ren && ren < 10000) {
        esc = 1;
    } else {
        if (10000 <= ren && ren <= 25500) {
            esc = 2;
        } else {
            if (25500 < ren && ren <= 48500) {
                esc = 3;
            } else {
                if ( 48500 < ren){
                    esc = 4;
                }
            }
        }
    }
    return esc;
}
    static double irsTax(int esc){
    double tax;
    tax = 0;
    if (esc == 1){
        tax = 0.12;
    }else {
        if (esc == 2){
            tax = 0.18;
        }else {
            if (esc == 3){
                tax = 0.23;
            }else {
                if (esc == 4){
                    tax = 0.29;
                }else{
                    tax = 0.0;
                }
            }
        }
    }
    return tax;
}
}