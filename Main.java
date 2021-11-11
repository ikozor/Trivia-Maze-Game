import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Maze test = new Maze(9);
        test.closeDoor(-10,299);
        System.out.println(test.toString());

    }
}
