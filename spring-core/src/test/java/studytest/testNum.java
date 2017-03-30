package studytest;

/**
 * Created by braveup on 2017/2/26.
 */
public class testNum {

    public static void main(String args[]) {
        int[] arr = {3, 5, 9, 8, 6, 26};
        System.out.println(new testNum().getMaxTwo(arr));
    }

    /**
     * 第一种比较数组元素的大小
     *
     * @param arr
     */
    public int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 第二种用数组的索引去比较
     */
    public int getMaxTwo(int[] arr) {
        //定义一个变量初始化数组中的任意一个元素
        int max=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        return arr[max];
    }
}
