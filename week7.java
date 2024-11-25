class week7 {
 int count(char c, String text) {
    int count = 0;
    for(int i = 0; i < text.length(); i++){
        if (text.charAt(i) == c){
            count ++;
        }
    }
    return count;
}

boolean allUpperCase(String text) {
    for(int i = 0; i < text.length(); i++){
        if ((text.charAt(i) < 'A') || (text.charAt(i) > 'Z')){
            return false;
        }
    }
    return true;
}

boolean isWord(String text){
    if (text == ""){
        return false;
    }
    for(int i = 0; i < text.length(); i++){
        if (((text.charAt(i) < 'A') || (text.charAt(i) > 'Z')) && ((text.charAt(i) < 'a') || (text.charAt(i) > 'z'))){
            return false;
        }
    }
    return true;
}

boolean isPalindrome(String text){
    int lim = (text.length() / 2);
    for(int i = 0; i <= lim; i++){
        if ( text.charAt(i) != text.charAt(text.length() - 1 - i)){
            return false;
        }
    }
    return true;
}

int countWords(String text) {
    if (text.isEmpty() == true){
        return 0;
    }
    int count = 1;
    for (int i = 0; i < text.length() - 1; i ++){
        boolean empty = true;
        if (text.charAt(i) != ' '){
            empty = false;
        }
        if (empty == true){
            return 0;
        }
    }
    for (int i = 0; i < text.length() - 1; i ++){
        if (text.charAt(i) == ' '){
            count++;
        }
    }
    return count;
}

String wrap(String text, char c){
    if (c == '(' || c == ')'){
        return '(' + text + ')';
    }
    if (c == '[' || c == ']'){
        return '[' + text + ']';
    }
    if (c == '{' || c == '}'){
        return '{' + text + '}';
    }
    return c + text + c;
}

int count(String s, String[] array) {
    int count = 0;
    for (int i = 0; i < array.length; i++){
        if (array[i].equals(s)){
            count++;
        }
    }
    return count;
}

String largest(String[] array){
    String largest = array[0];
    for (int i = 1; i < array.length; i++){
        if ((array[i - 1]).length() < (array[i]).length()){
            largest = array[i];
        }
    }
    return largest;
}

String join(String[] text, String sep){
    String joined = "";
    for (int i = 0; i < text.length; i++){
        joined = joined.concat(text[i]);
        if (i != text.length - 1){
            joined = joined.concat(sep);
        }
    }
    return joined;
} 
}

