import edu.princeton.cs.introcs.Stopwatch;
import sorting.Insertion;
import sorting.Selection;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Character[] array = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O','N'};
        Stopwatch stopwatch = new Stopwatch();
        Insertion.sort(array,false);
        System.out.println("Insertion:"+stopwatch.elapsedTime());
        array = new Character[]{'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O','N'};
        stopwatch=new Stopwatch();
        Selection.sort(array,false);
        System.out.println("Selection:"+stopwatch.elapsedTime());
    }
}
