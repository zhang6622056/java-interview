package jvm.memory;


/***
 *
 * 模拟堆内存溢出
 * @author Nero
 * @date 2019-08-12
 * *@param: null
 * @return 
 */
public class HighMemoryCase {


    public static void main(String[] args) throws InterruptedException {
       // List<Integer> list = new ArrayList<>();

        Integer[] list = new Integer[2000000];


        for (int i = 0 ; i < Integer.MAX_VALUE ; i++){
           // list.add(new Integer(i));
           // System.out.println(list.size());

            list[i] = new Integer(i);

//            Thread.sleep(2);
        }
    }




}
