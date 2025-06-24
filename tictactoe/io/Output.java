package tictactoe.io;

public final class Output {
    private Output() {};
    public static void writeNewLine(Object obj) {
        write(null, true);
    }

    public static void write(Object obj, boolean addNewLine) {
        if (obj == null){
            System.out.println();
        } else {
            if (addNewLine){
                System.out.println(obj);
            } else {
                System.out.print(obj);
            }
        }
    }

}
