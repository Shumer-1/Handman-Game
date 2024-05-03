package org.example;

public class GameLogic {

    public static String gamaWord;
    public static boolean[] isDone;
    public static boolean win = false;
    public static int counterFails = 0;

    public static boolean checkInputWord(String string){
        for (int i = 0; i < string.length(); i++){
            int flagDown = 0;
            int flagUp = 0;
            if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z'){
                flagDown = 1;
            }
            if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z'){
                flagUp = 1;
            }
            if (flagUp + flagDown == 0){
                return false;
            }
        }
        return true;
    }

    private static boolean checkArray(){

        int counter = 0;
        for (int i = 0; i < isDone.length; i++){
            if (isDone[i]){
                counter++;
            }
        }
        if (counter == isDone.length) return true;
        else return false;
    }

    public static String gameLogic(String word, char symbol){

        if (word.indexOf(symbol) >= 0){
            for (int i = 0; i < word.length(); i++){
                if (word.charAt(i) == symbol){
                    isDone[i] = true;
                }
            }
            if (checkArray()){
                win = true;
                return "В этот раз тебе повезло";
            }
            return "Хорош-хорош, посмотрим, что будет дальше...";
        }
        else{
            counterFails++;
            return "А вот ты и попался, дружочек";
        }
    }
}
