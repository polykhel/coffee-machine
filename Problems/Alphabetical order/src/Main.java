import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] arr = s.split(" ");

        boolean alphabetical = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                alphabetical = false;
                break;
            }
        }

        System.out.println(alphabetical);
    }
}