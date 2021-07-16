package Utility;

import java.util.Scanner;

public class Utility {

    static Scanner scanner = new Scanner(System.in);

    public static char readMainMenu(){
        char key;
        for( ; ; ){
            String str = readKeyBoard(1,false);
            key = str.charAt(0);
            if(key != '1' && key != '2' && key != '3' && key != '4' && key != '5'){
                System.out.print("输入有误，请重新输入：");
            }else{
                break;
            }
        }
        return key;
    }

    public static char readChar(){
        String str = readKeyBoard(1,false);
        return str.charAt(0);
    }

    public static char readChar(char defaultValue){
        String str = readKeyBoard(1,true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    public static int readInt(){
        int n;
        for( ; ; ){
            String str = readKeyBoard(3,false);
            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.print("输入有误，请重新输入:");
            }
        }
        return n;
    }

    public static int readInt(int defaultValue){
        int n;
        for ( ; ; ){
            String str = readKeyBoard(3,true);
            if(str.length() == 0){
                return defaultValue;
            }
            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.print("输入有误，请重新输入：");
            }
        }
        return n;
    }

    public static String readString(int limit){
        String str = readKeyBoard(limit,false);
        return str;
    }

    public static String readString(int limit,String defaultValue){
        String str = readKeyBoard(limit,true);
        return (str.length() == 0) ? defaultValue : str;
    }

    public static char readConfirm(){
        char confirm;
        for( ; ; ){
            String str = readKeyBoard(1,false).toUpperCase();
            confirm = str.charAt(0);
            if(confirm != 'Y' && confirm != 'N'){
                System.out.print("输入有误，请重新输入：");
            }else{
                break;
            }
        }
        return confirm;
    }

    public static String readKeyBoard(int limit,boolean flag){
        String str = "";
        while (scanner.hasNextLine()){
            str = scanner.nextLine();
            if(str.length() == 0){
                if (flag){
                    return str;
                }else{
                    continue;
                }
            }
            if(str.length() > limit || str.length() < 1){
                System.out.print("输入有误，请重新输入：");
            }else{
                break;
            }
        }
        return str;
    }
}
