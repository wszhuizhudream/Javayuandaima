package cn.dbat.www;

public class Bijiao {
	public static void main(String[] args){
		String str="856173420";
		int in=str.length();
		int k[]=new int[in];
		int a,i;
		for( i=0;i<in;i++){
			k[i]=Integer.parseInt(str.substring(i, i+1));
		}
		for(int j=0;j<in;j++)
			for(int l=0;l<in-j-1;l++){
				if(k[l]>k[l+1]){
					a=k[l];
					k[l]=k[l+1];
					k[l+1]=a;
				}
			}
		for( i=0;i<in;i++){
			System.out.println(k[i]);
		}
	}
}
