package com.newlecture.part3.ch2;

import java.util.Scanner;

public class App2 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      Lotto lotto = new Lotto();

      EXIT: while (true) {

         int menu = inputmenu();

         switch (menu) {

         case 1:
            lotto.input();
            break;
         case 2:
            lotto.print();
            break;
         case 3:
             lotto.sort();
             break;
         case 4:
        	 lotto.autoSetting();
             break;
         case 5:
            System.out.println("Bye~~~");
            break EXIT;

         default:
            System.out.println("메뉴는 1~5번만 선택할 수 있습니다.");
            break;
         }
      }

   }

   
   static int inputmenu() {

      Scanner scan = new Scanner(System.in);

      System.out.print("┌─────────────────────────────┐\n");
      System.out.print("│            로또 메뉴           │\n");
      System.out.print("└─────────────────────────────┘\n");
      System.out.println("1. 로또 뽑기");
      System.out.println("2. 로또 출력");
      System.out.println("3. 정렬 하기");
      System.out.println("4. 자동 뽑기");
      System.out.println("5. 종료 하기");
      System.out.print(">");

      int menu = scan.nextInt();

      return menu;

   }

}
