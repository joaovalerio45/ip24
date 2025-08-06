class week4 {
 static void arrayRead() {
int[] numbers = {4, 3, 2, 1}; 
int sum = numbers[0];
sum = sum + numbers[1];
sum = sum + numbers[2];
sum = sum + numbers[3];
}

int sum(int[] array) {
    int s = 0;
    int i = 0;
    while (i < array.length){
        s = s + array[i];
        i = i + 1;
    }
    return s;
}

static void arrayOfDigits() {
int[] digits = new int[10];
int i = -1;
while (i < 9){
    i = i + 1;
    digits[i]= i;
}
}

int[] naturals(int n) {
    assert n >= 0 : "argumento não pode ser negativo";
    int[] nats = new int[n];
        int i = 1;
        while (i <= n){
            nats[(i - 1)]= i;
            i = i + 1;   
        }
    return nats;
}

boolean isOrdered(int[] array) {
    if (array.length <= 1) {
        return true;
    }
    int i = 0;
    while (i < (array.length - 1)){
        if (array[i] > array[i + 1]) {
            return false;
        }
        i = i + 1;
    }
    return true;
}

int[] inverted(int[] array){
    int[] inv = new int[array.length];
    int i = 0;
    int x = array.length - 1;
    while (i < (x + 1)){
        inv[i] = array[x - i];
        i = i + 1;
    }
    return inv;
}

boolean contains(int[] array, int x){
    int i = 0;
    while (i < array.length){
        if (array[i] == x){
            return true;
        }
        i = i + 1;
    }
    return false;
} 

int count(int[] array, int x){
    int i = 0;
    int count = 0;
    while (i < array.length){
        if (array[i] == x){
            count = count + 1;
        }
        i = i + 1;
    }
    return count;
}

boolean isPalindrome(char[] array){
    int i = 0;
    int x = array.length - 1;
    while (i < array.length){
        if (array[i] != array[(x-i)]){
            return false;
        }
    i= i + 1;
    }
    return true;
}

boolean areEqual(int[] a, int[] b) {
    int i = 0;
    if (a.length != b.length){
        return false;
    }
    while (i < a.length){
        if (a[i] != b[i]){
            return false;
        }
        i++;
    }
    return true;
}

int[] merge(int[] left, int[] right) {
    int length = left.length + right.length;
    int[] vet = new int[length];
    int i = 0;
    while (i < left.length){
        vet[i] = left[i];
        i++;
    }
    i = 0;
     while (i < right.length){
        vet[left.length + i] = right[i];
        i++;
    }
    return vet;
}

boolean alternatedBooleans(boolean[] array){
    int i = 0;
    while (i < (array.length - 1)){
        if (array[i] == array[i + 1]){
            return false;
        }
        i++;
    }
    return true;
}

boolean[] invertedBooleans(boolean[] array){
    boolean[] vet = new boolean[array.length];
    int i = 0;
    while (i < (array.length - 1)){
        if (array[i] == true){
            vet[i] = false;
        }else{
            vet[i] = true;
        }
        i++;
    }
    return vet;
} 
}

class arrayUtil{
    static boolean isEmpty(int array[]){
        if (array.length == 0){
            return true;
        }
        else{
            return false;
        }
    }
    static int first(int array[]){
        return array [0];
    }
    static int last(int array[]){
        return array [(array.length - 1)];
    }
    static int nextIndex(int array[], int ind){
        assert (ind < array.length);
        if (ind == array.length - 1){
            return 0;
        }
            return ind + 1;
    }
        static int prevIndex(int array[], int ind){
        assert (ind < array.length);
        if (ind == 0){
            return (array.length - 1);
        }
            return ind - 1;
    }
    static int element(int array[], int ind){
        assert (ind >= (-(array.length)) && (ind < array.length));
        int val = 0;
        int size = array.length - 1;
        if (ind < 0){
            val = array[array.length + ind];
        }
        if (ind >= 0){
            val = array[ind];
        }
        return val;
    }
}

class ArrayCopy {
    static int[] copyNewSize(int[] array, int x) {
        int[] cop = new int[x];
        int i = 0;
        while ((i < array.length) && (i < cop.length)) {
            cop[i] = array[i];
            i = i + 1;
        }
        return cop;
    }
    static int[] copy(int[] array){
        int x = array. length;
        return ArrayCopy.copyNewSize(array,x);
    }
}

class randomArray{
    static int[] randomArray(int x){
        int[] array = new int[x];
        int i = 0;
        while (i < x){
            array[i] = RandomInts.randomWithin(0,10);
            i = i + 1;
        }
        return array;
    }
    static int randomIndex(int [] array){
        return RandomInts.randomWithin(0,(array.length));
    }
    static int randomElement(int[] array){
        int n = RandomInts.randomWithin(0,(array.length));
        return array[n];
    }
}

class doubleStats{
    static double min(double array[]){
        int i = 0;
        double min = array[0];
        while (i < array.length){
            if (min > array[i]){
                min = array[i];
            }
            i++;
        }
        return min;
    }
    static double max(double array[]){
        int i = 0;
        double max = 0;
        while (i < array.length){
            if ( max < array[i]){
                max = array[i];
            }
            i++;
        }
        return max;
    }
    static double sum(double array[]){
        double sum = 0;
        int i = 0;
        while (i < array.length){
            sum = sum + array[i];
            i++;
        }
        return sum;
    }
    static double average(double array[]){
        return (doubleStats.sum(array)/array.length);
    }
}

class subVet{
    static int[] subArray(int[] array, int n, int x){
        int i = n;
        int count = 0;
        int[] sub = new int[(x-n+1)];
        while ((i <= x) && (i < array.length)){
            sub[count] = array[i];
            i++;
            count++;
        }
        return sub;
    }
    static int[] leftSide(int[] left,boolean middle){
        int n = 0;
            if (middle == true){
                n = (left.length / 2);
            }
            if (middle == false){
                n = ((left.length / 2) - 1);
            }
            return subVet.subArray(left,0,n);
    }
    static int[] rightSide(int[] right,boolean middle){
        int n = 0;
            if (middle == true){
                n = (right.length / 2);
            }
            if (middle == false){
                n = ((right.length / 2) + 1);
            }
            return subVet.subArray(right,n,(right.length - 1));
    }
}