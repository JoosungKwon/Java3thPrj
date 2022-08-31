package newlec.practice.javaProgramming;

public class PrintSeatTable {

	public static void print(String[][] member) {
		System.out.println();
		System.out.println();
		System.out.println("                   ┏━━━━━━━━━┓             스크린                 ┏━━━━━━━━━━━┓"); 
		System.out.println("                   ┃                  ┗━━━━━━━━━━━━━━━━━━┛                      ┃");
		System.out.println("          문       ┃                                              ┌─────────────┐    ┃");
		System.out.println("                   ┃                                              │                          │    ┃");
		System.out.println(" ┏━━━━━━━━┛                                              │          교수님          │    ┃");
		System.out.println(" ┃                                                                │                          │    ┃");
		System.out.println(" ┃                                                                └─────────────┘    ┃");
		System.out.println(" ┃                                                                                                  ┃");
		System.out.println(" ┃┏━━┓┌────┬─┬────┬─┬────┐  ┏━━┓┌────┬─┬────┬─┬────┐┃");
		System.out.println(" ┃┃1조 ┃├────┤  ├────┤  ├────┤  ┃4조 ┃├────┤  ├────┤  ├────┤┃");
		System.out.printf(" ┃┗━━┛│ %3s │  │ %3s │  │ %3s │  ┗━━┛│ %3s │  │ %3s │  │ %3s │┃",member[0][0],member[0][1],member[0][2]);
		System.out.println(" ┃        └────┴─┴────┴─┴────┘          └────┴─┴────┴─┴────┘┃");
		System.out.println(" ┃        ┌────┬─┬────┬─┬────┐          ┌────┬─┬────┬─┬────┐┃");
		System.out.println(" ┃        ├────┤  ├────┤  ├────┤          ├────┤  ├────┤  ├────┤┃");
		System.out.println(" ┃        │ %3s │  │ %3s │  │ %3s │          │ %3s │  │ %3s │  │   ※   │┃");
		System.out.println(" ┃        └────┴─┴────┴─┴────┘          └────┴─┴────┴─┴────┘┃");
		System.out.println(" ┃┏━━┓┌────┬─┬────┬─┬────┐  ┏━━┓┌────┬─┬────┬─┬────┐┃");
		System.out.println(" ┃┃2조 ┃├────┤  ├────┤  ├────┤  ┃5조 ┃├────┤  ├────┤  ├────┤┃");
		System.out.println(" ┃┗━━┛│ %3s │  │%3s│  │ %3s │  ┗━━┛│ %3s │  │ %3s │  │ %3s │┃");
		System.out.println(" ┃        └────┴─┴────┴─┴────┘          └────┴─┴────┴─┴────┘┃");
		System.out.println(" ┃        ┌────┬─┬────┬─┬────┐          ┌────┬─┬────┬─┬────┐┃");
		System.out.println(" ┃        ├────┤  ├────┤  ├────┤          ├────┤  ├────┤  ├────┤┃");
		System.out.println(" ┃        │ %3s │  │ %3s │  │ %3s │          │ %3s │  │ %3s │  │        │┃");
		System.out.println(" ┃        └────┴─┴────┴─┴────┘          └────┴─┴────┴─┴────┘┃");
		System.out.println(" ┃┏━━┓┌────┬─┬────┬─┬────┐          ┌────┬─┬────┬─┬────┐┃");
		System.out.println(" ┃┃3조 ┃├────┤  ├────┤  ├────┤          ├────┤  ├────┤  ├────┤┃");
		System.out.println(" ┃┗━━┛│ %3s │  │ %3s │  │ %3s │          │ %3s │  │        │  │        │┃");
		System.out.println(" ┃        └────┴─┴────┴─┴────┘          └────┴─┴────┴─┴────┘┃");
		System.out.println(" ┃                                                                                                  ┃");
		System.out.println(" ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		

	}

}
