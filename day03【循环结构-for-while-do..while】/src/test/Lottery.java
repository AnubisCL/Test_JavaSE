package test;

import java.util.Scanner;

public class Lottery {

    /*彩票游戏
假设你想开发一个玩彩票的游戏，程序随机地产生一个两位数的彩票，提示用户输入一个两位数，然后按照下面的规则判定用户是否能赢。

1)如果用户输入的数匹配彩票的实际顺序，奖金10 000美元。
2)如果用户输入的所有数字匹配彩票的所有数字，但顺序不一致，奖金 3 000美元。
3)如果用户输入的一个数字仅满足顺序情况下匹配彩票的一个数字，奖金1 000美元。
4)如果用户输入的一个数字仅满足非顺序情况下匹配彩票的一个数字，奖金500美元。
5)如果用户输入的数字没有匹配任何一个数字，则彩票作废。
*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //int num2 = sc.nextInt();

        //[10,100)
        int guessNum = (int) (Math.random() * 90 + 10);

        int guessGe = guessNum%10;
        int guessShi = guessNum/10;

        int numGe = num%10;
        int numShi = num/10;

        System.out.println("获奖号码为："+guessNum);
        if (num == guessNum) {
            System.out.println("奖金10 000美元。");
        } else if (numGe == guessShi && numShi==guessGe){
            System.out.println("奖金 3 000美元。");
        } else if(numShi==guessShi || numGe == guessGe){
            System.out.println("奖金 1 000美元");
        }else if(numShi==guessGe || numGe == guessShi){
            System.out.println("奖金 500美元");
        }else{
            System.out.println("没中奖");
        }

    }
}
