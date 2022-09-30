package t43_ObversableList;
	
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.stage.*;
import javafx.util.Callback;

public class Main extends Application {
	
		@Override 
	public void start(Stage primaryStage) 		{
		/*	� JavaFX ������� ������� ����� �����������, ����������� ���������� ���������� ������ ����� � ��������� � ����������� 
	����������. ������ ������������ ��������� "������/�������������", ����������� �������� ������ �� �� �����������. � ����
	������� ��������� ������, ����������� ��������� Obversablelist<E>, � � ���� �������������- ChoiseBox, ComboBox, ListView.
	��������� Obversablelist<E> ��������� ���������� Iterable<E>, Collection<E>, List<E>, Obversable.
		�������� Obversable ����� ������ addListener() � removeListener(), ������� ��������� ��������� � ������� ���������� �������
	��������� ������  */
		
			// ����������� ������ ��� �������� Obversablelist<E>
		// 1-�� ������� - �������� ������� ������
	ObservableList<Integer> obvList1 =  FXCollections.<Integer>observableArrayList();
	System.out.println(obvList1);
		// ���������� addListener
	obvList1.addListener((Observable obversable) -> {
		System.out.print("������ ���������"); System.out.println("   " + obvList1);
	});
	obvList1.add(11);
	obvList1.addAll(12,13);
	
		// 2-o� ������� - �������� ������ �� ������ �� ������ ������� ��� �������� ����� �������
	Integer[] array = {1,2,3,};
	ObservableList<Integer> obvList2 =  FXCollections.<Integer>observableArrayList(array);
	ObservableList<Integer> obvList3 =  FXCollections.<Integer>observableArrayList(4,5,6);
	System.out.println(obvList2);
	System.out.println(obvList3);
	
		// 3-�� ������� �������� ������ �� ������ �����
	ArrayList<Integer> arrlist = new ArrayList<Integer>();
	Collections.addAll(arrlist, 7,8,9);
	ObservableList<Integer> obvList4 =  FXCollections.<Integer>observableArrayList(arrlist);
	System.out.println(obvList4);
	
		/* 4-�� ������� - Observablelist<E> observableArrayList (Callback<E, Observable[]> extractor)
		������� ��� ������ � JavaFX-���������� ��� � ���������, ����������� ��, � ����� ��������� �� ��������� 	 */
	DoubleProperty p = new SimpleDoubleProperty(20.0);
	DoubleProperty p2 = new SimpleDoubleProperty(5.0);
	
	ObservableList<DoubleProperty> list = FXCollections.<DoubleProperty>observableArrayList(
			new Callback<DoubleProperty, Observable[]>() {
					@Override
				public Observable[] call(DoubleProperty param) {
					return new Observable[] {param};
				}
			});
	list.addListener((Observable obversable) -> {
		System.out.println("������ ���������");
	});
	list.addAll(p,p2);		// ������ �������� ��� ���������� �������� � ������
	p2.setValue(33.0);		// ������ �������� ��� ��������� �������� ��������
	
		// ���������� � ������
	ObservableList<Integer> obvList5 =  FXCollections.<Integer>observableArrayList();
	obvList5.add(11);				// ��������� ������� � ����� ������
	obvList5.addAll(12,13);			// ��������� �������� � ����� ������
	System.out.println("obvList5= " + obvList5);
	
		// ���������� ������ ����� ��������
	FXCollections.<Integer> fill(obvList5, 0);
	
		// ������� ������ �� ���� ������ � ��������� ������� list1 + list2
	ObservableList<Integer> obvList01 =  FXCollections.concat(obvList1, obvList2);
	
		// ��������� � ������ ������ list1 ������ list2
	FXCollections.copy(obvList1, obvList2);
	
		// ������������ �������� ��������� �������
	FXCollections.shuffle(obvList01);
	
		// ������ ������� ���������� ��������� �� ��������������� (������� � ��������� �������� ���������� �� ������ ����� � ��������)
	FXCollections.reverse(obvList01);
	
		// �������� ��� �������� �� ��������� ���������. �������� �� ����� ������ ������� � ������ ������. ��� �� ������� ������
	FXCollections.rotate(obvList01, 4);
	
		// �������� ��� ��������� �������� �� �������� oldVla �� ����� �������� newVal
	FXCollections.<Integer> replaceAll(obvList01, 3, 5);
	
		// ��������� ������
	FXCollections.sort(obvList01);								// � ������ �������
	FXCollections.sort(obvList01, (a,b) ->b.compareTo(a));		// � �������� �������

		// ������� � ��������� ��������
	obvList5.setAll(1,2,3,4,5);
	System.out.println("obvList5= " + obvList5);
	
		// ������� �� ������ ��������� �������� � ��������� �� � ��
	obvList5.remove(1,2);
	System.out.println("obvList5= " + obvList5);
//	obvList5.removeAll();		// ������� ��� ��������
	
		// ������� �� ������ ��������� ��������
	obvList5.remove((Integer)5);
	System.out.println("obvList5= " + obvList5);
	
		// ��������� � ������ ������ ��������� ��������, ��������� �������
	obvList5.retainAll((Integer)4);
	System.out.println("obvList5= " + obvList5);
	
		/* FilteredList<E> filtered (Predicate<E> predicate)
  	������� ��� �������� ������� ������������ ��������, � ������� �������� ��������, ��������������� ������� predicate
  	���� ������ ������ ��������� �� ��������� ������ 3-�	*/
	obvList5.addAll(1,2,3,6,7,8,6);
	FilteredList<Integer> filter = obvList5.filtered(new Predicate<Integer>() {
		@Override
		public boolean test(Integer elem) {
			if (elem > 3) return true;
			else return false;
		}
	});
	System.out.println("obvList5= " + obvList5);
	System.out.println("filter = " + filter);
	
		/* SortedList<E> sorted (Comparatoe<E> comparator)
  	������� ��� �������� ������� ������������ ��������, � ������� �������� �������������	*/
	SortedList<Integer> sortedList = obvList5.sorted(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1<o2) return 1;
			else if (o1>o2) return -1;
			else return 0;
		}
	});
	System.out.println("obvList5= " + obvList5);
	System.out.println("sortedList = " + sortedList);
	
		/* ���������� ������� ��������� ������
	�������������� � ������� ������ addlistener() � ���������� InvalidationListener<E> � ListChangeListener<? super > 
	void addListener(InvalidationListener invalidationListener)
	 */
	ObservableList<Integer> obvList6 =  FXCollections.<Integer>observableArrayList();
	obvList6.addAll(1,2,3,4,5,6,7);	
	
	InvalidationListener invListener = new InvalidationListener() {
		@Override
		public void invalidated(Observable observable) {
			System.out.println("������ ���������");
		}
	};
	obvList6.addListener(invListener);
//	obvList6.add(0);
	obvList6.removeListener(invListener);   // �������� �����������
	
	ListChangeListener<Integer> listListener = new ListChangeListener<Integer>() {
		@Override
		public void onChanged(Change<? extends Integer> c) {
				// ����� next() ��������� ���������� �� ����������� ����������   true - ���� ��������� ���������  false - ���
			while (c.next()) {
				System.out.print("������ " + c.getList() + "���������   " );
				if (c.wasPermutated()) {
					System.out.println("������� ������� ���������� (���������� ��������");
					System.out.println("��������� ������ ��������� ���������" + c.getFrom());
					System.out.println("�������� ������ ��������� ���������" + c.getTo());
					for (int i = c.getFrom(), j = c.getTo(); i<j; i++) {
						System.out.println("����� ������ �������� �� ������ �������� i ����� �������������� -" + c.getPermutation(i));	
					}
					System.out.println();
				}
				else if (c.wasReplaced()) {
					System.out.println("������� �������");
					System.out.println("��������� ������ ��������� ���������" + c.getFrom());
					System.out.println("�������� ������ ��������� ���������" + c.getTo());
					System.out.println("���������� ����������� ��������� " + c.getAddedSize());
					System.out.println("������ ����������� ��������� " + c.getList());
					System.out.println("���������� ��������� ��������� " + c.getRemovedSize());
					System.out.println("������ ��������� ��������� " + c.getRemoved());	System.out.println();
				}
				else if (c.wasAdded()) { 
					System.out.println("�������� ����� �������");
					System.out.println("��������� ������ ��������� ���������" + c.getFrom());
					System.out.println("�������� ������ ��������� ���������" + c.getTo());
					System.out.println("���������� ����������� ��������� " + c.getAddedSize());
					System.out.println("������ ����������� ��������� " + c.getList());	System.out.println();
				}
				else if (c.wasRemoved()) {
					System.out.println("������ �������");
					System.out.println("��������� ������ ��������� ���������" + c.getFrom());
					System.out.println("�������� ������ ��������� ���������" + c.getTo());
					System.out.println("���������� ��������� ��������� " + c.getRemovedSize());
					System.out.println("������ ��������� ��������� " + c.getRemoved());	System.out.println();
				}
				else if (c.wasUpdated()) {
					System.out.println("�������� �������");
					System.out.println("��������� ������ ��������� ���������" + c.getFrom());
					System.out.println("�������� ������ ��������� ���������" + c.getTo()); System.out.println();
				}
			}
		}
	};
	obvList6.addListener(listListener);
	obvList6.add(101);
	obvList6.remove(1,3);
//	obvList6.replaceAll(new UnaryOperator<Integer>() {		// ������ ��������
//		@Override
//		public Integer apply(Integer t) {
//			if (t==(Integer)5) return 20;
//			else return t;
//		}
//	});
	obvList6.set(4, 1000);							// ���������� �������� ��������
	obvList6.sort(new Comparator<Integer>() {		// ���������� �������
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1<o2) return 1;
			else if (o1>o2) return -1;
			else return 0;
		}
	});
	obvList6.removeListener(listListener);   // �������� �����������
	
	
	
	
	
	
	
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}