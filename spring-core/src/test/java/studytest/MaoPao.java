package studytest;

import org.junit.Test;

/**
 * Created by braveup on 2017/2/28.
 */
public class MaoPao {
    @Test
    public void bubbleSort(){
        int arr []={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int temp=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        for (int x=0;x<arr.length-1;x++){
            if (x==arr.length){
                System.out.printf(String.valueOf(arr[x]));
            }else{
                System.out.print(arr[x]+",");
            }

        }
    }
}
