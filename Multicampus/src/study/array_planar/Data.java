package study.array_planar;

public class Data {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public  Data(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTotal() {
		int total = kor+eng+math;
		return total;
	}
	
	public double getAvg() {
		double avg = getTotal()/3.0;
		return avg;
	}

	@Override
	public String toString() {
		String result =  "Data [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
		result = String.format("%4s %3d %3d %4d %5d %.1f", name, kor, eng, math, getTotal(), getAvg());
		return result;
	}
	
	
	
}
