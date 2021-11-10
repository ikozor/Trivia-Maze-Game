import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Maze test = new Maze(9);
        System.out.println(test.closeDoor(0, 1));
        System.out.println(test.closeDoor(0, 3));
        System.out.println(test);

    }
}
