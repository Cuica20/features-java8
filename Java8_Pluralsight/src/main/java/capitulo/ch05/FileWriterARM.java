package capitulo.ch05;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.AutoCloseable;

public class FileWriterARM implements AutoCloseable {
    private final FileWriter writer;

    public FileWriterARM( final String fileName ) throws IOException {
        writer = new FileWriter( fileName );
    }

    public void writeStuff( final String message ) throws IOException {
        writer.write( message );
    }

    public void close() throws IOException {
        System.out.println( "close called automatically..." );
        writer.close();
    }

    // ...

    public static void main( final String[] args ) throws IOException {
        try ( final FileWriterARM writerARM = new FileWriterARM( "work/peekaboo.txt" ) ) {
            writerARM.writeStuff( "peek-a-boo" );

            System.out.println( "done with the resource..." );
        }
    }

}
