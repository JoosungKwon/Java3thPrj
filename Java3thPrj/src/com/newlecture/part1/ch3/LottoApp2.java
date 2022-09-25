package com.newlecture.part1.ch3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class LottoApp2 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      Lotto lotto = new Lotto();
      lotto.nums = new int[6];

      EXIT: while (true) {

         int menu = inputmenu();

         switch (menu) {

         case 1:

            inputLotto(lotto);

            break;
         case 2:

            printLotto(lotto);

            break;

         case 5:
            System.out.println("Bye~~~");
            break EXIT;

         default:
            System.out.println("메뉴는 1~2번만 선택할 수 있습니다.");
            break;
         }
      }

   }

   static void inputLotto(Lotto lotto)

   {
      Scanner scan = new Scanner(System.in);

      System.out.print("┌─────────────────────────────┐\n");
      System.out.print("│            로또 뽑기           │\n");
      System.out.print("└─────────────────────────────┘\n");

      System.out.println("1.로또번호 입력해서 뽑기");
      System.out.println("2.로또번호 자동으로 뽑기");
      System.out.println(">");
      int menu = Integer.parseInt(scan.nextLine());

      switch (menu) {



      case 1:

         for (int i = 0; i < 6; i++) {
            System.out.println("로또번호를 입력하세요 >");
            int lotto_num = Integer.parseInt(scan.nextLine());
            lotto.nums[i] = lotto_num;
         }
         break;

      case 2:
         Random rand = new Random();
         int[] lottonum = new int[45];

         for (int i = 0; i < 45; i++) 
            lottonum[i] = i+1;

            for (int j = 0; j < 100; j++) {
               int rand_num = rand.nextInt(45);
               int temp;
               temp = lottonum[0];
               lottonum[0] = lottonum[rand_num];
               lottonum[rand_num] = temp;
            }

            for (int j = 0; j < 6; j++)
               lotto.nums[j] = lottonum[j];

         

         break;
      }

      System.out.println("로또번호 뽑기 완료!");
   }

   static void printLotto(Lotto lotto)

   {

      System.out.print("┌─────────────────────────────┐\n");
      System.out.print("│            로또 출력           │\n");
      System.out.print("└─────────────────────────────┘\n");

      System.out.println("로또번호는 :");
      for (int i = 0; i < 6; i++)
         System.out.printf("%d,", lotto.nums[i]);
      System.out.println();
   }

   static int inputmenu() {

      Scanner scan = new Scanner(System.in);

      System.out.print("┌─────────────────────────────┐\n");
      System.out.print("│            로또 메뉴           │\n");
      System.out.print("└─────────────────────────────┘\n");
      System.out.println("1. 로또 뽑기");
      System.out.println("2. 로또 출력");

      System.out.print(">");

      int menu = scan.nextInt();

      return menu;

   }

}
