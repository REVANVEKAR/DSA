package finalhashmap;

import java.util.ArrayList;

public class map<K,V> {

    ArrayList<MapNode<K,V>> buckets;
    int count;
    int numBuckets;


    public map(){
        buckets = new ArrayList<>();
        numBuckets = 20;

        for (int i = 0; i<numBuckets;i++){
            buckets.add(null);
        }



    }

    private int getBucketIndex(K key){ //  this function is to get the bucket index
        // to do that we will first get the hashcode and then compress. we can override the default
        // hashcode which java gives by creating our own
        // this is present in the object class
        // every generic class is inherited from the object class in which a hashcode function is present
        // for example string class has a hashcode function . it will call strings hashcode function
        // if key type is unknown it will get it from the object  class
        int hc = key.hashCode();
        int index = hc % numBuckets; // compression
        return index;
    }

    public void insert(K key  , V value ){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        while (head != null){ // to check if the element is already present and change its element
            if (head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        // element isn't present insert at 0th position;
        head = buckets.get(bucketIndex);
        MapNode<K,V> newNode = new MapNode<>(key,value);
        newNode.next = head;
        buckets.set(bucketIndex,newNode);
        count++;
        double loadFactor = 1.0*count/numBuckets;
        if (loadFactor>0.7){
            reHash();
        }

    }


    public int size(){
        return count;
    }

    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        while(head != null){
            if (head.key.equals(key)){
                return head.value;
            }
        }
        return null;
    }


    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        MapNode<K,V> prev = null;
        while(head != null){
            if (head.key.equals(key)){
                if (prev!=null){
                    prev.next = head.next;
                }
                else{
                    buckets.set(bucketIndex,head.next);
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }


    /*
    so the time complexity of these functions are
    1) we do not consider the worst case where all the entries go to one single bucket
    as we have enough proof and research done to say that won't happen
    2) in avg case the time taken to traverse over the linked list in a single bucket is
    n/b where n = no of entries and b is the bucket size
    3) we always keep the n/b value less than 0.7 which is the load factor
    for example if there are 100 entries the bucket size will bw around 120-130
    4) increasing your bucket size to double to maintain the load factor is called rehashing

     */

    private void reHash(){
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        for (int i = 0; i<2*numBuckets;i++){
            buckets.add(null);
        }
        count = 0;
        numBuckets = numBuckets*2;
        for (int i = 0; i< temp.size();i++){
            MapNode<K,V> head = temp.get(i);
            while (head!=null){
                K key = head.key;
                V value = head.value;;
                insert(key,value);
                head = head.next;
            }
        }

    }

    public double loadFactor(){
        return 1.0*count/numBuckets;
    }

}
