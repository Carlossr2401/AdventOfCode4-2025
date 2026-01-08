package software.aoc.day4.b;

import java.io.IOException;

public interface InstructionReader<T> {
    T readAllLines() throws IOException;
}
