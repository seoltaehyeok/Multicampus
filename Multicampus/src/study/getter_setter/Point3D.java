package study.getter_setter;

public class Point3D extends Point {

	private int z;

	public Point3D(int x, int y, int z) {
		super(x, y); // 부모클래스의 생성자 호출
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return String.format("%3d %3d %3d", x, y, z);
	}

}
