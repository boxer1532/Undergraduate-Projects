package Homework3.Service;

import Homework3.DataModel.Course;
import Homework3.DataModel.Student;
import Homework3.DataStructure.Node;
import Homework3.DataStructure.Queue;
import Homework3.DataStructure.Tree;

public class CourseRegister {

	public void processRegister(Queue<Student> studentQueue, Tree<Course> courseTree) {
		// Tree������ ���������� �˻��ϰ� ����ϴ� ������ �����ִ�.
		// ���� ���������� ������ �� á�ٸ�, ��������� ���� �ʴ´�.
		
		while (!(studentQueue.isEmpty())) {

			String requested = studentQueue.dequeue().getRequestCourse();

			Node<Course> applyCourse = courseTree.search(requested, courseTree.getRoot());

			if(applyCourse == null){
				continue;
			}
			
			// [Maximum > Current] �϶��� ������û�ϵ��� ����
			if (applyCourse.getData().getCourseMaximum() > applyCourse.getData().getCourseCurrent())
					applyCourse.getData().courseRegister();
			else
				continue;
		}
	}
}
