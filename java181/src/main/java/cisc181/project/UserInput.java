package cisc181.project;

import java.util.Scanner;
public interface UserInput <G extends Game>{
    public abstract <T extends Action<G>> T  getUserNextMove(G game);
}
