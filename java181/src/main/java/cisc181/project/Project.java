package cisc181.project;

public class Project {

    public static void main(String [] args) {
        char[][] m = {
                {'E', 'E', 'E', 'F', 'E', 'E', 'E'},
                {'X', 'X', 'E', 'E', 'E', 'X', 'X'},
                {'E', 'J', 'E', 'X', 'E', 'J', 'E'},
                {'X', 'E', 'X', 'E', 'X', 'E', 'X'},
                {'X', 'E', 'X', 'E', 'X', 'E', 'X'},
                {'E', 'X', 'E', 'X', 'E', 'X', 'E'},
                {'X', '1', 'X', 'X', 'X', '2', 'X'}
        };
        for (int i = 0; i<m.length; i++){
            for (int j= 0; j<m[i].length; j++){
                System.out.print(m[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }

    }
}
