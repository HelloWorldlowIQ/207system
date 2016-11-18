package com.system.services;

import java.util.List;

import com.system.domain.Student;

public interface StudentService {
	/**
	 * ���ѧ��
	 * @param student
	 */
	void AddStudent(Student student);
	/**
	 * ��ѯѧ�������Ƿ���ȷ
	 * @param number
	 * @param password
	 * @return	һ��ѧ��
	 */
	Student isStudent(String number, String password);
	/**
	 * ����id����ѧ��
	 * @return һ��ѧ��
	 */
	Student findUerById(int id);
	/**
	 * �޸�ѧ����Ϣ
	 * @param student
	 */
	void UpdateStudent(Student student);
	/**
	 * ��������ѧ����Ϣ
	 * @return
	 */
	List<Student> findAllStudent();
	/**
	 * ����idɾ��ѧ��
	 * @param id
	 */
	void deleteUerById(int id);
	/**
	 * �����û�������ѧ��
	 * @param username
	 * @return һ��ѧ��
	 */
	Student findUerName(String username);

}
