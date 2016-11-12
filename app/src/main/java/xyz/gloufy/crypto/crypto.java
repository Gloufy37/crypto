package xyz.gloufy.crypto;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gloufy on 16/03/16.
 */
public class crypto {

    private static HashMap<String,String> hexToBinMap = new HashMap<String,String>();
    static
    {
        hexToBinMap.put("0","0000");
        hexToBinMap.put("1","0001");
        hexToBinMap.put("2","0010");
        hexToBinMap.put("3","0011");
        hexToBinMap.put("4","0100");
        hexToBinMap.put("5","0101");
        hexToBinMap.put("6","0110");
        hexToBinMap.put("7","0111");
        hexToBinMap.put("8","1000");
        hexToBinMap.put("9","1001");
        hexToBinMap.put("a","1010");
        hexToBinMap.put("b","1011");
        hexToBinMap.put("c","1100");
        hexToBinMap.put("d","1101");
        hexToBinMap.put("e","1110");
        hexToBinMap.put("f","1111");
    }

    private static HashMap<String,String> binToHexMap = new HashMap<String,String>();
    static
    {
        binToHexMap.put("0000","0");
        binToHexMap.put("0001","1");
        binToHexMap.put("0010","2");
        binToHexMap.put("0011","3");
        binToHexMap.put("0100","4");
        binToHexMap.put("0101","5");
        binToHexMap.put("0110","6");
        binToHexMap.put("0111","7");
        binToHexMap.put("1000","8");
        binToHexMap.put("1001","9");
        binToHexMap.put("1010","a");
        binToHexMap.put("1011","b");
        binToHexMap.put("1100","c");
        binToHexMap.put("1101","d");
        binToHexMap.put("1110","e");
        binToHexMap.put("1111","f");
    }

    private static HashMap<String,String> intToBinMap = new HashMap<String,String>();
    static
    {
        intToBinMap.put("0","0000");
        intToBinMap.put("1","0001");
        intToBinMap.put("2","0010");
        intToBinMap.put("3","0011");
        intToBinMap.put("4","0100");
        intToBinMap.put("5","0101");
        intToBinMap.put("6","0110");
        intToBinMap.put("7","0111");
        intToBinMap.put("8","1000");
        intToBinMap.put("9","1001");
        intToBinMap.put("10","1010");
        intToBinMap.put("11","1011");
        intToBinMap.put("12","1100");
        intToBinMap.put("13","1101");
        intToBinMap.put("14","1110");
        intToBinMap.put("15","1111");
    }

    private static HashMap<String,String> binToIntMap = new HashMap<String,String>();
    static
    {
        binToIntMap.put("00","0");
        binToIntMap.put("01","1");
        binToIntMap.put("10","2");
        binToIntMap.put("11","3");
        binToIntMap.put("0000","0");
        binToIntMap.put("0001","1");
        binToIntMap.put("0010","2");
        binToIntMap.put("0011","3");
        binToIntMap.put("0100","4");
        binToIntMap.put("0101","5");
        binToIntMap.put("0110","6");
        binToIntMap.put("0111","7");
        binToIntMap.put("1000","8");
        binToIntMap.put("1001","9");
        binToIntMap.put("1010","10");
        binToIntMap.put("1011","11");
        binToIntMap.put("1100","12");
        binToIntMap.put("1101","13");
        binToIntMap.put("1110","14");
        binToIntMap.put("1111","15");
    }

    static int [][][] s = {
                            {{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                            {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                            {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                            {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}},

                            {{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                            {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                            {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                            {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}},

                            {{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                            {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                            {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                            {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}},

                            {{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                            {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                            {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                            {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}},

                            {{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                            {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                            {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                            {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}},

                            {{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                            {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                            {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                            {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}},

                            {{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                            {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                            {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                            {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}},

                            {{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
                            {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
                            {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
                            {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}}
                            };

    public static String hexToBinary(String hex){
        String result ="";
        hex = hex.toLowerCase();

        for(int i=0;i<hex.length();i++){
            String current = hex.charAt(i)+"";
            result += hexToBinMap.get(current);
        }

        return result;
    }

    public static String BinaryToHex(String bin){
        String result ="";

        for(int i=0;i<bin.length();i=i+4){
            String current = bin.substring(i,i+4);
            result += binToHexMap.get(current);
        }

        return result;
    }

    public static String intToBinary(int dec){
        return intToBinMap.get(dec + "");
    }

    public static int BinaryToInt(String bin){
        return Integer.parseInt(binToIntMap.get(bin));
    }

    private static String xor(String a, String b){
        String result ="";

        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                result += "1";
            }
            else{
                result += "0";
            }
        }

        return result;
    }

    private static String[] buildKeys(String key){
        String[] keys = new String[16];

        int[] permutation = {57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36,
                             63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
        int[] permutation2 = {14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2,41,
                              52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32};

        String pc1 = "";
        String[] c = new String[17];
        String[] d = new String[17];

        for (int i=0;i<permutation.length;i++){
            pc1 += key.charAt(permutation[i]-1);
        }

        c[0] = pc1.substring(0,28);
        d[0] = pc1.substring(28,56);

        for (int i=1;i<17;i++){
            if(i==1 || i==2 || i==9 || i==16){
                c[i] =  c[i-1].substring(1,28) +  c[i-1].substring(0,1);
                d[i] =  d[i-1].substring(1,28) +  d[i-1].substring(0,1);
            }
            else{
                c[i] =  c[i-1].substring(2,28) +  c[i-1].substring(0,2);
                d[i] =  d[i-1].substring(2,28) +  d[i-1].substring(0,2);
            }

            String cd = c[i]+d[i];
            keys[i-1] = "";
            for (int j=0;j<permutation2.length;j++){
                keys[i-1] += cd.charAt(permutation2[j]-1);
            }
        }

        return keys;
    }

    private static String initialPermutation(String x) {
        String y = "";

        int[] permutation = {58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,30,22,14,6,64,56,48,40,32,24,16,8,
                             57,49,41,33,25,17,9,1,59,51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,39,31,23,15,7};

        for (int i=0;i<permutation.length;i++){
            y += x.charAt(permutation[i]-1);
        }

        return y;
    }

    private static String finalPermutation(String x) {
        String z = "";

        int[] permutation = {40,8,48,16,56,24,64,32,39,7,47,15,55,23,63,31,38,6,46,14,54,22,62,30,37,5,45,13,53,21,61,29,
                             36,4,44,12,52,20,60,28,35,3,43,11,51,19,59,27,34,2,42,10,50,18,58,26,33,1,41,9,49,17,57,25};

        for (int i=0;i<permutation.length;i++){
            z += x.charAt(permutation[i]-1);
        }

        return z;
    }

    private static String confusion(String D, String key){
        String result = "";

        //Expansion
        String newD = "";
        int[] expension = {32,1,2,3,4,5,4,5,6,7,8,9,8,9,10,11,12,13,12,13,14,15,16,17,16,17,18,
                            19,20,21,20,21,22,23,24,25,24,25,26,27,28,29,28,29,30,31,32,1};
        for (int i=0;i<expension.length;i++){
            newD += D.charAt(expension[i]-1);
        }
        D = newD;

        //Ajout de la clef
        String Bline = xor(D,key);
        String [] B = new String[8];
        for (int i=0;i<B.length;i++){
           B[i] = Bline.substring(i * 6, i * 6 + 6);
        }

        //Transformations locales
        String C = "";
        for (int i=0;i<B.length;i++){
            int line = BinaryToInt(B[i].charAt(0)+""+B[i].charAt(5));
            int col =  BinaryToInt(B[i].substring(1,5));
            C += intToBinary(s[i][line][col]);
        }

        //Permutation finale
        int[] final_permutation = {16,7,20,21,29,12,28,17,1,15,23,26,5,18,31,10,2,8,24,14,32,27,3,9,19,13,30,6,22,11,4,25};
        for (int i=0;i<final_permutation.length;i++) {
            result += C.charAt(final_permutation[i] - 1);
        }

        return result;
    }

    public static String des(String msg, String key, boolean encrypt){
        String result = "";

        String msgBin = hexToBinary(msg);
        String keyBin = hexToBinary(key);

        String [] keys = buildKeys(keyBin);
        String y = initialPermutation(msgBin);
        String G = y.substring(0, 32);
        String D = y.substring(32, 64);
        String k = "";

        for (int i=0;i<16;i++) {
            if(encrypt){
                k = keys[i];
            }
            else{
                k = keys[15-i];
            }

            String temp = G;
            G = D;
            D = xor(temp, confusion(D, k));
        }

        String z = finalPermutation(D+G);
        result = BinaryToHex(z);

        return result;
    }

    public static String caesar(String msg,int key,boolean encrypt){
        String result ="";
        int firstChar = (int) ' ';
        int lastChar = (int) '~';
        int nbChars = lastChar-firstChar+1;

        for(int i=0;i<msg.length();i++){
            int current = (int) msg.charAt(i);
            int newchar = current;

            if(current >= firstChar && current <= lastChar){
                if(encrypt){
                    newchar = firstChar + (current-firstChar+key)%nbChars;
                }
                else{
                    newchar = lastChar - (lastChar-current+key)%nbChars;
                }
            }
            result += ((char) newchar);
        }
        return result;
    }

    public static String vigenere(String msg,String secret,boolean encrypt){
        String result ="";
        int firstChar = (int) ' ';
        int lastChar = (int) '~';
        int nbChars = lastChar-firstChar+1;

        for(int i=0;i<msg.length();i++){
            int secretChar = (int) secret.charAt(i%secret.length());
            int key = secretChar-firstChar;
            int current = (int) msg.charAt(i);
            int newchar = current;

            if(current >= firstChar && current <= lastChar){
                if(encrypt){
                    newchar = firstChar + (current-firstChar+key)%nbChars;
                }
                else{
                    newchar = lastChar - (lastChar-current+key)%nbChars;
                }
            }

            result += ((char) newchar);
        }
        return result;
    }

    public static String transposition_rect(String msg, String key, boolean encrypt){

        String result = "";
        int key_length = key.length();
        int [] ordre = new int [key_length];
        int index = 0   ;
        key=key.toLowerCase();

        // Attribution d'un index a chaque lettre de la clé
        for (int i=0; i<26; i++) {
            int posA = (int) 'a';
            char lettre = (char) (posA+i);

            for (int j=0; j<key_length; j++) {
                if(key.charAt(j)==lettre){
                    ordre[index]=j;
                    index++;
                }
            }
        }

        // Cryptage
        if(encrypt){
            for(int i=0;i<ordre.length;i++){
                for (int j=ordre[i]; j<msg.length(); j=j+key_length) {
                    result += msg.charAt(j);
                }
            }
        }
        //Decryptage
        else{
            char [] res = new char[msg.length()];
            int nb_line = msg.length()/key_length;
            int nb_last_line = msg.length()%key_length;

            int comp = 0;
            for(int i=0;i<ordre.length;i++){

                int nb_elem = nb_line;
                if(nb_last_line>ordre[i]){
                    nb_elem++;
                }

                for (int j=0;j<nb_elem;j++) {
                    int pos = ordre[i]+key_length*j;
                    res[pos] = msg.charAt(comp);
                    comp++;
                }

                result = new String(res);
            }
        }

        return result;
    }

    public static char[][] polybe(String key){
        key = key.toUpperCase();
        int key_length = key.length();
        char [][] result = new char[5][5];
        char [][] tempTab = new char[(25/key_length+1)][key_length];
        String chars = "";

        // Generation de la liste des caractere a partir du mot clé sans doublon
        for (int i=0;i<key.length();i++) {
            char c = key.charAt(i);
            if(c=='J'){
                c='I';
            }
            if(chars.indexOf(c)<0){
                chars += c;
            }
        }
        int posA = (int) 'A';
        for (int i=posA;i<posA+26;i++) {
            char c = (char) i;
            if(c=='J'){
                c='I';
            }
            if(chars.indexOf(c)<0){
                chars += c;
            }
        }

        // Remplissage du tableau temporaire
        for (int i=0;i<tempTab[0].length*tempTab.length;i++) {
            int lig = i/key_length;
            int col = i%key_length;
            if(i<chars.length()){
                tempTab[lig][col]=chars.charAt(i);
            }
            else{
                tempTab[lig][col]=' ';
            }
        }

        // Remplissage du carre de polybe en lisant le tableau temporaire de haut en bas
        int index = 0;
        for (int i=0;i<tempTab[0].length;i++) {
            for (int j=0;j<tempTab.length;j++) {
                if(tempTab[j][i]!=' '){
                    int lig = index/5;
                    int col = index%5;
                    result[lig][col] = tempTab[j][i];
                    index++;
                }
            }
        }

        return result;
    }

    public static int [] posInPolybe(char c,char [][]polybe){
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                if(c==polybe[i][j]){
                    return  new int[]{i,j};
                }
            }
        }
        return  new int[]{-1,-1};
    }

    public static int positiveMod(int a,int b ){
        int mod = a%b;
        if(mod >= 0){
            return(mod);
        }
        else{
            return(b+mod);
        }
    }

    public static String playfair(String msg, String key, boolean encrypt){
        msg = msg.toUpperCase();
        msg = msg.replace(" ","");
        msg = msg.replace("J", "I");
        String result = "";
        char [][] polybe = polybe(key);

        boolean doublon = true;
        while(doublon){
            doublon = false;
            for (int i=1;i<msg.length();i=i+2) {
                if(msg.charAt(i-1)==msg.charAt(i)&&msg.charAt(i)!='J'){
                    msg = msg.substring(0,i)+"Q"+msg.substring(i);
                    doublon = true;
                }
            }
        }
        if(msg.length()%2>0){
            msg += "Q";
        }

        for (int i=1;i<msg.length();i=i+2) {
            int [] posFirst = posInPolybe(msg.charAt(i-1),polybe);
            int [] posSecond = posInPolybe(msg.charAt(i),polybe);
            int sens = -1;

            if(encrypt){
                sens = 1;
            }

            if(posFirst[0]!=posSecond[0]&&posFirst[1]!=posSecond[1]){
                result += polybe[posFirst[0]][posSecond[1]];
                result += polybe[posSecond[0]][posFirst[1]];
            }
            else if(posFirst[0]==posSecond[0]){
                result += polybe[positiveMod(posFirst[0]+sens,5)][posFirst[1]];
                result += polybe[positiveMod(posSecond[0]+sens,5)][posSecond[1]];
            }
            else if(posFirst[1]==posSecond[1]){
                result += polybe[posFirst[0]][positiveMod(posFirst[1]+sens,5)];
                result += polybe[posSecond[0]][positiveMod(posSecond[1]+sens,5)];
            }

            if(!encrypt){
                result = result.replace("Q","");
            }
        }

        return(result);
    }

    public static String homophonique(String msg, String key, boolean encrypt){
        msg = msg.toUpperCase();
        char [][] polybe = polybe(key);
        String result = "";

        if(encrypt){
            for (int i=0;i<msg.length();i++) {
                char c = msg.charAt(i);
                if(c>='A' && c<='Z'){
                    int [] pos = posInPolybe(c,polybe);
                    int rand = (int) (Math.random() * 5);
                    int rand2 = (int) (Math.random() * 5);
                    result += polybe[pos[0]][rand];
                    result += polybe[rand2][pos[1]];
                }
            }
        }
        else{
            for (int i=1;i<msg.length();i=i+2) {
                int [] posFirst = posInPolybe(msg.charAt(i-1),polybe);
                int [] posSecond = posInPolybe(msg.charAt(i),polybe);
                result += polybe[posFirst[0]][posSecond[1]];
            }
        }

        return(result);
    }

    public static int pgcd(int a, int b) {
        if(a%b==0){
            return(b);
        }
        else{
            return(pgcd(a,b-1));
        }
    }

    public static String hill(String msg, int [] key, boolean encrypt,Context c){
        String result = "";
        int firstChar = (int) ' ';
        int lastChar = (int) '~';
        int nbChars = lastChar-firstChar+1;
        int det = key[0]*key[3]-key[1]*key[2];

        if(pgcd(det, nbChars)>1){
            Toast.makeText(c, "Cette clé n'est pas réversible !", Toast.LENGTH_LONG).show();
            return(msg);
        }

        if(encrypt){
            if(msg.length()%2!=0){
                msg +=" ";
            }

            for (int i=1;i<msg.length();i=i+2) {
                int posChar1 = ((int) msg.charAt(i-1))-firstChar;
                int posChar2 = ((int) msg.charAt(i))-firstChar;
                int z1 = (key[0]*posChar1+key[1]*posChar2)%nbChars;
                int z2 = (key[2]*posChar1+key[3]*posChar2)%nbChars;
                result += (char) (firstChar + z1);
                result += (char) (firstChar + z2);
            }
        }
        else{
            int [] temp = key;
            for (int i=1;i<msg.length();i=i+2) {
                int posChar1 = ((int) msg.charAt(i-1))-firstChar;
                int posChar2 = ((int) msg.charAt(i))-firstChar;
                int z1 = positiveMod(((key[3]*posChar1)/det+(-key[1]*posChar2)/det),nbChars);
                int z2 = positiveMod(((-key[2]*posChar1)/det+(key[0]*posChar2)/det),nbChars);

                result += (char) (firstChar + z1);
                result += (char) (firstChar + z2);
            }
        }
        return(result);
    }

}
