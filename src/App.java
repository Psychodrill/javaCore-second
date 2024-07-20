import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        pigeonSort();
    }

    public static void pigeonSort(){

        int [] intsArray = {-5,8,4,0,10,12,3,7,2,8,0,-2,9,10,11,2,5,7,8,1,-5};
        System.out.println(Arrays.toString(intsArray));

        int[] sortedArray= pigeonSortArr(intsArray);
        System.out.println(Arrays.toString(sortedArray));
    }
    public static int[] pigeonSortArr(int[] arr){
        int [] result = new int[arr.length];
        
        int min =minMaxFind(arr, true);
        int max =minMaxFind(arr, false);
        int[]buffer = new int[max-min+1];
        //buffer[0]=min;
        System.out.println(buffer.length);
        int temp=min;
        for(int i=0; i<buffer.length; i++){
            
            for(int j=0; j<arr.length; j++){
                if(arr[j]==temp){
                    buffer[i]+=1;
                }
            }
            temp+=1;
        }
        temp =min;
        int fillIndex=0;
        for(int i=0; i<buffer.length; i++){
            
            for(int j=0;j<buffer[i];j++){
                result[fillIndex+j]=temp;

            }
            fillIndex+=buffer[i];
            temp+=1;
        }

        return result;
    }
    /**
     *  Method returns min when minMax = true, otherwise max
     */
    public static int minMaxFind(int [] arr, boolean minMax){
        int result =arr[0];
        for(int i=1; i< arr.length; i++){
            if(minMax && result> arr[i]){
                result =arr[i];
            }
            else if(!minMax && result< arr[i]){
                result =arr[i];
            }
        }

        return result;
    }
}
