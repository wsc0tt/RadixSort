/**
 * @author William Scott
 * RadixSort class to implement the radix sort
 */

public class RadixSort {

    // "sort" implements the Radix Sort, taking in a queue and the # of digits as parameters
    public static void sort(FieldQueue q, int digits) {
        FieldQueue [] buckets = new FieldQueue[10];  // make an array of 10 queues
        for (int i = 0; i < 10; i++){  // initialize each queue (buckets)
            buckets[i] = new FieldQueue();
        }
        for (int i = 1; i <= digits; i++) {  // Scatter
            while (!q.isEmpty()) {  // while the q still has items
                int x = (int)Math.pow(10, i);  // 10^i
                int y = x/10;  // 10^i / 10
                Field item = q.dequeue(); // remove and save the item
                //System.out.println(item.toString());
                int magicNumber = Integer.parseInt(item.key)%x/y;  // find the digit using math % (10^i)/10

                //System.out.println(magicNumber);
                buckets[magicNumber].enqueue(item);  // add to the proper bucket based on base 10 number
            }
            for (int j = 0; j < 10; j++) {  // put items back into the queue, fill queue
                while (!buckets[j].isEmpty()) {
                    q.enqueue(buckets[j].dequeue());
                }
            }
        }

    }
}
