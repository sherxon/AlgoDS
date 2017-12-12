public class LinearSearch {

	public static <T extends Comparable> boolean linearSearch(T[] array, T element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(element))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Integer[] array = {10, 30, 65, 98, 465, 48};
		System.out.println(linearSearch(array, 48));
	}
}
