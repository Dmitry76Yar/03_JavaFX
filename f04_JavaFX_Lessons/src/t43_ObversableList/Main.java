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
		/*	В JavaFX имеется широкий выбор компонентов, позволяющих отображать одномерный список строк в свернутом и развернутом 
	состояниях. Списки поддерживают концепцию "модель/представление", позволяющую отделить данные от их отображения. В роли
	мождели выступают объект, реализующий интерфейс Obversablelist<E>, а в роли представления- ChoiseBox, ComboBox, ListView.
	Интерфейс Obversablelist<E> наследует интерфейсы Iterable<E>, Collection<E>, List<E>, Obversable.
		Интефейс Obversable имеют методы addListener() и removeListener(), которые позволяют назначить и удалить обработчик события
	изменения списка  */
		
			// Статические методы для создания Obversablelist<E>
		// 1-ый вариант - создание пустого списка
	ObservableList<Integer> obvList1 =  FXCollections.<Integer>observableArrayList();
	System.out.println(obvList1);
		// Назначение addListener
	obvList1.addListener((Observable obversable) -> {
		System.out.print("Список изменился"); System.out.println("   " + obvList1);
	});
	obvList1.add(11);
	obvList1.addAll(12,13);
	
		// 2-oй вариант - создание списка из списка на основе массива или значений через запятую
	Integer[] array = {1,2,3,};
	ObservableList<Integer> obvList2 =  FXCollections.<Integer>observableArrayList(array);
	ObservableList<Integer> obvList3 =  FXCollections.<Integer>observableArrayList(4,5,6);
	System.out.println(obvList2);
	System.out.println(obvList3);
	
		// 3-ий вариант создание списка на основе листа
	ArrayList<Integer> arrlist = new ArrayList<Integer>();
	Collections.addAll(arrlist, 7,8,9);
	ObservableList<Integer> obvList4 =  FXCollections.<Integer>observableArrayList(arrlist);
	System.out.println(obvList4);
	
		/* 4-ый вариант - Observablelist<E> observableArrayList (Callback<E, Observable[]> extractor)
		полезен при работе с JavaFX-свойствами или с объектами, содержащими их, с целью обработки их изменений 	 */
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
		System.out.println("Список изменился");
	});
	list.addAll(p,p2);		// Список меняется при добавлении значений в список
	p2.setValue(33.0);		// Список меняется при изменении значения свойства
	
		// Добавление в список
	ObservableList<Integer> obvList5 =  FXCollections.<Integer>observableArrayList();
	obvList5.add(11);				// Добавляет элемент в конец списка
	obvList5.addAll(12,13);			// Добавляет элементы в конец списка
	System.out.println("obvList5= " + obvList5);
	
		// Заполнение списка одним объектом
	FXCollections.<Integer> fill(obvList5, 0);
	
		// Создает список из двух других в указанном порядке list1 + list2
	ObservableList<Integer> obvList01 =  FXCollections.concat(obvList1, obvList2);
	
		// Добавляет в начало списка list1 список list2
	FXCollections.copy(obvList1, obvList2);
	
		// Перемешивает элементы случайным образом
	FXCollections.shuffle(obvList01);
	
		// Меняет порядок следования элементов на противоположный (элемент с последним индексом становится на первое место и наоборот)
	FXCollections.reverse(obvList01);
	
		// Сдвигает все элементы на указанное растояние. Элементы из конца списка встанут в начало списка. Как бы вращает список
	FXCollections.rotate(obvList01, 4);
	
		// Заменяет все вхождения элемента со значение oldVla на новое значение newVal
	FXCollections.<Integer> replaceAll(obvList01, 3, 5);
	
		// Сортирует список
	FXCollections.sort(obvList01);								// В прямом порядке
	FXCollections.sort(obvList01, (a,b) ->b.compareTo(a));		// В обратном порядке

		// Очищает и добавляет элементы
	obvList5.setAll(1,2,3,4,5);
	System.out.println("obvList5= " + obvList5);
	
		// Удаляет из списка указанные элементы с индексами от и до
	obvList5.remove(1,2);
	System.out.println("obvList5= " + obvList5);
//	obvList5.removeAll();		// Удаляет все элементы
	
		// Удаляет из списка указанные элементы
	obvList5.remove((Integer)5);
	System.out.println("obvList5= " + obvList5);
	
		// Оставляет в списке только указанные элементы, остальные удаляет
	obvList5.retainAll((Integer)4);
	System.out.println("obvList5= " + obvList5);
	
		/* FilteredList<E> filtered (Predicate<E> predicate)
  	создает над исходным списком неизменяемую оболочку, в которую попадают элементы, соответствующие условию predicate
  	Ниже пример отбора элементов со значением больше 3-х	*/
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
  	создает над исходным списком неизменяемую оболочку, в которой элементы отсортированы	*/
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
	
		/* ОБРАБОТЧИК СОБЫТИЙ ИЗМЕНЕНИЯ СПИСКА
	осуществляется с помощьб метода addlistener() и интерфейса InvalidationListener<E> и ListChangeListener<? super > 
	void addListener(InvalidationListener invalidationListener)
	 */
	ObservableList<Integer> obvList6 =  FXCollections.<Integer>observableArrayList();
	obvList6.addAll(1,2,3,4,5,6,7);	
	
	InvalidationListener invListener = new InvalidationListener() {
		@Override
		public void invalidated(Observable observable) {
			System.out.println("Список изменился");
		}
	};
	obvList6.addListener(invListener);
//	obvList6.add(0);
	obvList6.removeListener(invListener);   // Удаление обработчика
	
	ListChangeListener<Integer> listListener = new ListChangeListener<Integer>() {
		@Override
		public void onChanged(Change<? extends Integer> c) {
				// Метод next() позволяет переходить по совершенным изменениям   true - если следующее изменение  false - нет
			while (c.next()) {
				System.out.print("Список " + c.getList() + "изменился   " );
				if (c.wasPermutated()) {
					System.out.println("Изменен порядок элеметнтов (сортировка например");
					System.out.println("Начальный индекс диапазона изменений" + c.getFrom());
					System.out.println("Конечный индекс диапазона изменений" + c.getTo());
					for (int i = c.getFrom(), j = c.getTo(); i<j; i++) {
						System.out.println("Новый индекс элемента со старым индексом i после перерестановки -" + c.getPermutation(i));	
					}
					System.out.println();
				}
				else if (c.wasReplaced()) {
					System.out.println("Заменен элемент");
					System.out.println("Начальный индекс диапазона изменений" + c.getFrom());
					System.out.println("Конечный индекс диапазона изменений" + c.getTo());
					System.out.println("Количество добавленных элементов " + c.getAddedSize());
					System.out.println("Список добавленных элементов " + c.getList());
					System.out.println("Количество удаленных элементов " + c.getRemovedSize());
					System.out.println("Список удаленных элементов " + c.getRemoved());	System.out.println();
				}
				else if (c.wasAdded()) { 
					System.out.println("Добавлен новый элемент");
					System.out.println("Начальный индекс диапазона изменений" + c.getFrom());
					System.out.println("Конечный индекс диапазона изменений" + c.getTo());
					System.out.println("Количество добавленных элементов " + c.getAddedSize());
					System.out.println("Список добавленных элементов " + c.getList());	System.out.println();
				}
				else if (c.wasRemoved()) {
					System.out.println("Удален элемент");
					System.out.println("Начальный индекс диапазона изменений" + c.getFrom());
					System.out.println("Конечный индекс диапазона изменений" + c.getTo());
					System.out.println("Количество удаленных элементов " + c.getRemovedSize());
					System.out.println("Список удаленных элементов " + c.getRemoved());	System.out.println();
				}
				else if (c.wasUpdated()) {
					System.out.println("Обновлен элемент");
					System.out.println("Начальный индекс диапазона изменений" + c.getFrom());
					System.out.println("Конечный индекс диапазона изменений" + c.getTo()); System.out.println();
				}
			}
		}
	};
	obvList6.addListener(listListener);
	obvList6.add(101);
	obvList6.remove(1,3);
//	obvList6.replaceAll(new UnaryOperator<Integer>() {		// Замена элемента
//		@Override
//		public Integer apply(Integer t) {
//			if (t==(Integer)5) return 20;
//			else return t;
//		}
//	});
	obvList6.set(4, 1000);							// Обновление значения элемента
	obvList6.sort(new Comparator<Integer>() {		// Сортировка массива
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1<o2) return 1;
			else if (o1>o2) return -1;
			else return 0;
		}
	});
	obvList6.removeListener(listListener);   // Удаление обработчика
	
	
	
	
	
	
	
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}