package software.aoc.day4.a;

import java.io.IOException;

public interface InstructionReader<T> {
    T readAllLines() throws IOException;
}
