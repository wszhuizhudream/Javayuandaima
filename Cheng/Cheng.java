public class Cheng{
	public static void main(String[] args){
		int[] data =init();
		bigger(data);
		printArray(data);
    }
	//定义一个返回数组的方法
	public static int[] init(){
		return new int[] {1,2,3,4,5};//匿名数组
	}
	//将数组中每个元素的值夸大5倍
	public static void bigger(int[] arr){
		for(int i=0;i<arr.length;i++){
			arr[i]*=5;
		}
	}
	public static void printArray(int[] temp){
		for(int i=0;i<temp.length;i++){
			System.out.println(temp[i]);
		}
	}
}
// public void Str(){
		    // // int row=1;
		    // // int col=1;
		    // // int result=0;
		    // // for(row=1;row<10;row++){
			  // // for(col=1;col<row;col++){
				// // result=col*row;
				// // System.out.print(row+"*"+col+"="+result+" ");
			    // // }
			    // // System.out.println();
		    // // }
	    // // }
		// int[] a = new int[8];
// for(int i=0;i<a.length;i++){
// System.out.println(a[i]);
        // }