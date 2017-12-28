package ResizingArray;

public class GeneralizedQueue<T> {
    T[] array;
    int itemCount;
    int last;
    public GeneralizedQueue(){
        array=(T[])new Object[1];
    }

    public boolean isEmpty(){
        return itemCount==0;
    }

    public void insertItem(T item){
        if(itemCount>0)
            last++;
        array[last]=item;
        itemCount++;
        if(last==array.length-1)
            resize(array.length*2);
    }

    public T delete(int k){
        if(itemCount==0)
            throw new RuntimeException("No item in the list");
        if(k>itemCount)
            throw new RuntimeException("Index out of bounds");
        T item=null;
        int index=last;
        int counter=k;
        while (counter>0){
            if(array[index]!=null){
                counter--;
                if(counter==0) {
                    item = array[index];
                    array[index]=null;
                }
            }
            index--;
        }
        itemCount--;
        if(k==1&itemCount>0){
            for (int i = last-1; i >=0; i--) {
                if(array[i]!=null){
                    last=i;
                    break;
                }
            }
        }
        if(itemCount>0&&itemCount==array.length/4)
            resize(array.length/2);
        return item;
    }

    private void resize(int toSize){
        T[] newArray=(T[])new Object[toSize];
        for (int i = 0,j=i; i < array.length; i++) {
            if(array[i]!=null){
                newArray[j]=array[i];
                last=j++;
            }
        }
        array=newArray;
    }

    public static void main(String[] args) {
        GeneralizedQueue<Integer> q=new GeneralizedQueue<Integer>();
        q.insertItem(1);
        q.insertItem(2);
        q.insertItem(3);
        q.insertItem(4);
        q.insertItem(5);
        System.out.println(q.delete(1));
        System.out.println(q.delete(3));
        System.out.println(q.delete(3));
        q.insertItem(6);
        System.out.println(q.delete(1));


    }


}
