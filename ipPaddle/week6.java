class week6 {
  
}

record Range(int min, int max) {

}

class RangeUtil {
    static int length(Range r) {
        if (r.min() > r.max()){
            return 0;
        }
        int length = r.max() - r.min() + 1;
        return length;
    }
    static int sum(Range r){
        int soma = 0;
        for(int i = r.min(); i <= r.max(); i++){
            soma = soma + i;
        }
        return soma;
    }
    static Range indexes(int[] array){
         return array.length == 0 ? new Range(0, -1) : new Range(0, array.length - 1);
    }
        static Range expand(Range r, int x){
        return x < 0 ? new Range(r.min() + x, r.max()) : new Range(r.min() , r.max() + x);
    }
}

record Range(int min, int max) {
    boolean isEmpty() {
        return (min >max);
    }
    int length(){
        return min > max ? 0 : max - min + 1;
    }
    boolean includes(int x){
        return ((min <= x) && (max >= x)); 
    }
    boolean excludes(int x){
        return ((min > x) || (max < x)); 
    }
    boolean isValidFor(int[] array){
        return ((min >= 0) && (max < array.length));
    }
    boolean contains(Range r){
        return ((r.min >= min) && (r.max <= max));
    }
    Range expand(int x){
        return x < 0 ? new Range(min + x, max) : new Range(min, max+ x);
    }
}

class ArrayFunction {
    static int sum(int[] array, Range r) {
        int sum = 0;
        for (int i = r.min(); i < r.max() + 1; i++) {
            sum = sum + array[i];
        }
        return sum;
    }
    static int[] subArray(int[] array, Range r) {
        int[] vet = new int[r.max() - r.min() + 1];
        int n = 0;
        for (int i = r.min(); i <= r.max(); i++) {
            vet[n] = array[i];
            n++;
        }
        return vet;
    }
    static Range valueRange(int[] array){
        int a = array[0];
        int b = array[0];
        for (int i = 1; i < array.length; i++){
            if (b > array[i]){
                b = array[i];
            }
            if (a < array[i]){
                a = array[i];
            }
        }
        return new Range(b,a);
    }
}

record Dimension(int width, int height){
    int area (){
        return (width * height);
    }
    int perimeter (){
        return ((width * 2) + (height * 2));
    }
    boolean isSquare(){
        return width == height;
    }
    boolean isVertical(){
        return width < height;
    }
    boolean isHorizontal(){
        return width > height;
    }
    boolean largerThan(Dimension d){
        return area() > d.area();
    }
    Dimension scale(int x){
        assert x > 0;
        return new Dimension(x * width, x * height);
    }
}

record Position(int line, int column) {
    Position top() {
        return new Position(line - 1, column);
    }
    Position right() {
        return new Position(line, column + 1);
    }
    Position bottom() {
        return new Position(line + 1, column);
    }
    Position left() {
        return new Position(line, column - 1);
    }
    Position[] adjacent() {
        return new Position[] {
            top(), right(), bottom(), left()
        };
    }
    Position[] adjacentNonNegative() {
        if (line == 0 && column == 0) {
            return new Position[] {
                right(), bottom()
            };
        }
        if (line == 0) {
            return new Position[] {
                right(), bottom(), left()
            };
        }
        if (column == 0) {
            return new Position[] {
                top(), right(), bottom()
            };
        }
        return new Position[] {
            top(), right(), bottom(), left()
        };

    }
}

class positionUtil{
    static Position[] diagonal(int x){
        Position[] array = new Position[x];
        for (int i = 0;i < x; i++){
            array[i] = new Position(i, i);
        }
        return array;
    }
    static Position[] positions(Dimension d){
        Position[] array = new Position[d.width() * d.height()];
        int n = 0;
        for (int i = 0; i < d.height(); i++){
            for(int x = 0; x < d.width(); x++){
            array[n] = new Position(i,x);
            n++;
            }
        }
        return array;
    }
    static boolean contains(Position[] array, Position p){
        for(int i = 0; i < array.length; i++){
            if ((array[i].line() == p.line()) && (array[i].column() == p.column())){
                return true;
            }
        }
        return false;
    }
}

record Point(double x, double y){
    boolean isOrigin(){
        if (x == 0 && y == 0){
            return true;
        }
        return false;
    }
    Point scale(double n){
        return new Point(x * n, y * n);
    }
    Point sum(Point p){
        return new Point(x + p.x(), y + p.y());
    }
    double distance(Point p){
        return Math.sqrt(Math.pow(p.x() - x,2) + Math.pow(p.y() - y,2));
    }
}