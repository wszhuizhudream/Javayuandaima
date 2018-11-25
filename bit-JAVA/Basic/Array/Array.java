public class Array{
	public static void main(String[] args){
//数组排序
		// int[] intData = new int[]{1,65,55,23,100};
		// char[] charData = new char[] {'z','A','a','c'};
		// java.util.Arrays.sort(intData);
		// java.util.Arrays.sort(charData);
		// printArray(intData);
		// printArray(charData);
	// }
	// public static void printArray(int[] temp){
		// for(int i=0;i<temp.length;i++){
			// System.out.println(temp[i]);
		// }
		// System.out.println();
	// }
	// //重载
	// public static void printArray(char[] temp){
		// for(int i=0;i<temp.length;i++){
			// System.out.println(temp[i]);
		// }
		// System.out.println();
//数组拷贝
		int[] dataA =new int[]{1,2,3,4,5,6,7,8,9};
		int[] dataB = new int[]{11,22,33,44,55,66,77,88,99};
		System.arraycopy(dataB,4,dataA,1,3);
		printArray(dataA);
	}
	public static void printArray(int[] temp){
		for(int i=0;i<temp.length;i++){
			System.out.println(temp[i]);
		}
		System.out.println();
	}
}