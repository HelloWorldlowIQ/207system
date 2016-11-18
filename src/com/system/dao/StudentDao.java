package com.system.dao;

import java.util.List;

import com.system.domain.Student;

public interface StudentDao {
	/**
	 * �������ֲ�ѧ��
	 * @param username
	 * @return	һ��ѧ��
	 */
	Student findUerByName(String username);
	/**
	 * ���ѧ��
	 * @param student
	 */
	void addStudent(Student student);
	/**
	 * ��ѯѧ�������Ƿ���ȷ
	 * @param number
	 * @param password
	 * @return һ��ѧ��
	 */
	Student isStudent(String number, String password);
	/**
	 * ����ѧ�Ų�ѧ��
	 * @param number
	 * @return	һ��ѧ��
	 */
	Student findUerByNumber(String number);
	/**
	 * ����id��ѧ��
	 * @param id
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

}
