public class Arrary{
	//1.计算数组中最大值
		public static int arrayMaxElement(int[] data){
			if(data == null){
				//TODO  参数异常
				throw new IllegalArgumentException("data must not be null");
			}
		int max=data[0];
		for(int i=0;i<data.length;i++){
            if(data[i]>max)
				max=data[i];
		    }
			return max;
		}
		//2.计算数组中最小值
		public static int arrayMinElement(int[] data){
			if(data == null){
				//TODO
				throw new IllegalArgumentException("data must not be null");
			}
			int min=data[0];
			for(i=0;i<data.length;i++){
				if(data[i]<min)
					min=data[i];
			}
			return min;
		}
		//3.计算数组之和
		public static int arrayElementSum(int[] data){
			if(data == null){
				//TODO
				throw new IllegalArgumentException("data must not be null");
			}
			int sum=0;
			for(int i=0;i<data.length;i++){
				sum+=data[i];
			}
			return sum;
		}
		//4.数组拼接
		public static int[] arrayJoin(int[] a,int [] b){
			if(a==null){
				//TODO
				throw new IllegalArgumentException("data must not be null");
			}
			if(b==null){
				//TODO
			}
			int[] c= new int[a.length+b.length];
			for(int i=0;i<a.length;i++){
				c[i]=a[i];
			}
			for(int i=a.length;i<c.length;i++){
				c[i]=b[i-a.length];
			}
			return c;
		}
		//5.数组截取
		//[start,end)  半闭半开区间
        public static int[] arraySub(int[] a,int start,int end){
			if(a == null){
				//TODO
				throw new IllegalArgumentException("data must not be null");
			}
			//TODO 需要对start end 进行限制
			if(start<0 || end<0){
			throw new IllegalArgumentException("data must not be null");
			}
			if(start>end){
			throw new IllegalArgumentException("start>end");
			}
			if(start>=a.length){
			throw new IllegalArgumentException("start must be  < a.length");
			}
			if(end-start >a.length){
				throw new IllegalArgumentException("sub length must be <= a.length");
			}
			int[] b= new int[end-start] ;
			//int[] a=new int {1,2,3,4,5,6}
			for(int i=start;i<end;i++){
				b[i-start]=a[i];
			}
			return b;
			
		}		
	}
	public static void main(String[] args){
		int[] data = new int[]{1,5,6,2,8,9,4,7,3,10};
		int[] a = new int[]{1,2,3};
		int[] b= new int[] {4,5,6};
	    int Max = arrayMaxElement(data);
		System.out.println("最大值："+Max);
		int Min = arrayMinElement(data);
		System.out.println("最小值为："+Min);
		int Sum = arrayElementSum(data);
		System.out.println("数组之和为："+Sum);
		int Join = arrayJoin(a,b);
		System.out.println("拼接后的数组为："+Join);
		int Sub = arrayJoin(a,2,3);
		System.out.println("截取后数组为："+Sub);
	}
}