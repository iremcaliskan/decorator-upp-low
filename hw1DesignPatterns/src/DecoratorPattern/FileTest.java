package DecoratorPattern;
import DecoratorPattern.decorator.UpperCaseInputStream;
import DecoratorPattern.decorator.LowerCaseInputStream;
import java.io.*;

public class FileTest {

    public static void main(String[] args) {
        int i;
        FileInputStream input = null;
        FileOutputStream output = null;

        try {
            input = new FileInputStream("src\\DecoratorPattern\\input.txt");
            output = new FileOutputStream("src\\DecoratorPattern\\output.txt");

            PrintStream out = new PrintStream
                    (new FileOutputStream
                            ("src\\DecoratorPattern\\output.txt"));
            System.setOut(out);

            do {
                i = input.read();
                if (i != -1) {
                    output.write(i);
                }
            } while (i != -1);

        } catch (final IOException f) {
            f.printStackTrace();

        } finally {
            try {
                if (input != null) {
                    input.close();
                }

            } catch (final IOException f) {
                f.printStackTrace();
            }
            try {
                if (output != null) {
                    output.close();
                }
            } catch (final IOException e2) {
                e2.printStackTrace();
            }

        }
        doLowerCaseInputStream();
        doUpperCaseInputStream();
    }

    private static void doUpperCaseInputStream() {
        int x;
        try {
            InputStream in = new UpperCaseInputStream(
                    new BufferedInputStream (
                            new FileInputStream("src\\DecoratorPattern\\input.txt")));

            while( ( x = in.read() ) >= 0 ) {
                System.out.print( (char) x );
            }

            in.close();
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }

    private static void doLowerCaseInputStream() {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream (
                            new FileInputStream("src\\DecoratorPattern\\input.txt")));

            while( ( c = in.read() ) >= 0 ) {
                System.out.print( (char) c );
            }

            in.close();
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }
}


