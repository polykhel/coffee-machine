class Cat {

    private String name;
    private int age;
    private static int counter;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        if (++Cat.counter > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        return Cat.counter;
    }
}