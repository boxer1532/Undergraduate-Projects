package Homework3.DataModel;

public class LiberalArt extends Course { //�������
	
	@Override
	public int compareTo(Course course) {
		// TODO �ڵ� ������ �޼ҵ� ����
		//1. ���ʰ���, �������, �������� ������ ��ũ��.(���������� ����ũ��)
		//2. ���� ������ �����̶��, ���� ���ڰ� �� Ŭ���� ��ũ��.
		//3. �̷��� ������ �����Ϸ��� �� ����Ŭ�������� ������ compareTo�޼ҵ�� ���ݾ� �ٸ���.
		
		if(course instanceof Major || course.getCourseId().charAt(0) == 'C')
			return -1;
		else if(course instanceof LiberalArt || course.getCourseId().charAt(0) == 'L')
			return this.getCourseId().compareTo(course.getCourseId());
		else if(course instanceof Basic || course.getCourseId().charAt(0) == 'B')
			return 1;

		return 0;
	}

	@Override
	public String toString() {
		return this.getCourseId() + " " + this.getCourseName() + 
									" " + this.getCourseMaximum() + 
									" " + this.getCourseCurrent();
	}
	

}