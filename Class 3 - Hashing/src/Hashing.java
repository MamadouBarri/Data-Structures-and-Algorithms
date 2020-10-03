public class Hashing {

    public static int hashForStrings1(String key, int tableSize) {
        int hashVal = 0;

        for(int i = 0; i < key.length(); i++){
            hashVal += key.charAt(i);
        }
        return hashVal % tableSize;
    }

    public static int hashForStrings2(String key, int tableSize){
        return ( key.charAt( 0 ) + 27 * key.charAt( 1 ) +
                 729 * key.charAt( 2))% tableSize;
    }

    public static int hashForStrings3(String key, int tableSize) {
        int hashVal = 0;

        for(int i = 0; i < key.length( ); i++) {
            hashVal += 37 * hashVal + key.charAt(i);
        }

        hashVal %= tableSize;

        if (hashVal < 0){
            hashVal += tableSize;
        }

        return hashVal;
    }
    public static void main(String [] args) {

    }
}
