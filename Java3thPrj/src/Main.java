
public class Main{
	public static void main(String[] args){
		int kor, math, eng ;
		int total ;
		double avg ;
		
		kor = 50 ;
		math = 60 ;
		eng = 80 ;
		kor ^= eng ;
		eng ^= kor;
		kor ^= eng ; 
		System.out.print(kor);
		System.out.print(eng);
		total = kor + math + eng ;
		avg = total/3.0;
		System.out.printf("total is %d%n",total);
		System.out.printf("avg is %f%n",avg);
	}
}


 