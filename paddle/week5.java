class week5 {
 static void incrementation() {
int i = 1;
i++;
i++;
i++;
}

static void cumulativeAssign() {
int n = 1;
n += 2;
n += 3;
n += 4;
}

static void whileToFor() {
int s = 0;
for (int i = 1; i < 6; i++){
    s = s + i;
}
}

void invertBooleanValues(boolean[] array){
    for (int i = 0; i < array.length; i++){
        if (array[i] == true){
            array[i] = false;
        } else{
            array[i] = true;
        }
    }
}

void replace(char[] letters, char find, char replace) {
    for (int i = 0; i < letters.length; i++){
        if (letters[i] == find)
            letters[i] = replace;
    }
}

void replaceFirst(char[] letters, char find, char replace) {
    for (int i = 0; i < letters.length; i++){
        if (letters[i] == find){
            letters[i] = replace;
            return;
        }
    }
}

void replaceLast(char[] letters, char find, char replace) {
    for (int i = (letters.length - 1); i >= 0; i--){
        if (letters[i] == find){
            letters[i] = replace;
            return;
        }
    }
}

void constrain (double[] array, double min, double max){
    for(int i = 0;i < array.length; i++){
        if (array[i] < min)
            array[i] = min;
        if (array[i] > max)
            array[i] = max;
    }
} 
}

class SumArrayAbs {
     static void arrayToAbs(int[] array) {
         for(int i = 0; i < array.length; i++)
             if(array[i] < 0)
                 array[i] = -array[i];
     }
     
     static int sum(int[] array) {
         int s = 0;
         for(int i = 0; i < array.length; i++)
             s += array[i];
         return s;
     }
     
     static int sumAbs(int[] array) {
         int[] vet = ArrayCopy.copy(array);
         SumArrayAbs.arrayToAbs(vet);
         return SumArrayAbs.sum(vet);
     }
 }

 class ArrayOrder {
    static void swap(int[] array, int i, int j) {
        int k = array[i];
        array[i] = array[j];
        array[j] = k;
    }
    static void invert(int[] array){
    for (int i = 0; i < array.length / 2; i++){
        ArrayOrder.swap(array,i, array.length - 1 - i);
    }
    }
}

class shuffle{
    static void randomSwap(int[] array){
        int x = RandomInts.randomUntil(array.length - 1);
        int n = RandomInts.randomUntil(array.length - 1);
        ArrayOrder.swap(array,x,n);
    }
    static void shuffle(int[] array){
        for (int i = array.length - 1; (i > 0); i--){
        int x = RandomInts.randomUntil(i);
        ArrayOrder.swap(array,i,x);
    }
    }
}

class arrayShift {
    static void shiftLeft(int[] array) {
        int n = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        array[array.length - 1] = n;
    }
    static void shiftRight(int[] array) {
        int n = array[array.length - 1];
        for(int i = array.length - 1;i > 0; i--){
            array[i] = array[i - 1];
        }
        array[0] = n;
    }
}

class bubbleSort {
    static void sort(int[] array) {
        for (int j = array.length - 1; j >= 0; j--){ 
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    ArrayOrder.swap(array, i, (i + 1));
                }
            }
        }
    }
}