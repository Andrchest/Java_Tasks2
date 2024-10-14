import java.util.Arrays;
import java.util.Scanner;

class Calculator {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        String b = sc.next();
        double c = sc.nextDouble();
        switch (b) {
            case "+":
                System.out.println(a + c);
                break;
            case "-":
                System.out.println(a - c);
                break;
            case "*":
                System.out.println(a * c);
                break;
            case "/":
                System.out.println(a / c);
                break;
            default:
                System.out.println("Invalid operation");
                break;
        }
    }
}

class Author {
    String name;
    String email;
    char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String toString() {
        return name + " " + email + " " + gender;
    }
}

class Book {
    String name;
    Author author;
    double price;
    int qty = 0;

    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String toString() {
        return getName() + " " + getAuthor().toString() + " " + getPrice() + " " + getQty();
    }
}

class BookChecker {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        String author_name = sc.next();
        String author_email = sc.next();
        char author_gender = sc.next().charAt(0);
        String book_name = sc.next();
        double book_price = Double.parseDouble(sc.next());
        int book_qty = sc.nextInt();
        Author author = new Author(author_name, author_email, author_gender);

        Book book = new Book(book_name, author, book_price, book_qty);

        System.out.println(book);

        double book_new_price = Double.parseDouble(sc.next());
        int book_new_qty = sc.nextInt();

        book.setPrice(book_new_price);
        book.setQty(book_new_qty);

        System.out.println(book);
    }
}

class Time {
    int hours = 0;
    int minutes = 0;
    int seconds = 0;

    public Time(int hours) {
        this.hours = hours;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = 0;
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time inc() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes >= 60) {
            minutes = 0;
            hours++;
        }
        if (hours >= 24) {
            hours = 0;
        }
        return this;
    }

    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
}

class TimeCreator {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] nums = line.split(":");
        Time time1;
        Time time2;

        if (nums.length == 1) {
            int[] numbers = Arrays.stream(line.split(":")).mapToInt(Integer::parseInt).toArray();
            time1 = new Time(numbers[0]);
        } else if (nums.length == 2) {
            int[] numbers = Arrays.stream(line.split(":")).mapToInt(Integer::parseInt).toArray();
            time1 = new Time(numbers[0], numbers[1]);
        } else {
            int[] numbers = Arrays.stream(line.split(":")).mapToInt(Integer::parseInt).toArray();
            time1 = new Time(numbers[0], numbers[1], numbers[2]);
        }

        // yes, I copied my code
        // yes, it is bad
        // yes, I am lazy
        line = sc.nextLine();
        nums = line.split(":");
        if (nums.length == 1) {
            int[] numbers = Arrays.stream(line.split(":")).mapToInt(Integer::parseInt).toArray();
            time2 = new Time(numbers[0]);
        } else if (nums.length == 2) {
            int[] numbers = Arrays.stream(line.split(":")).mapToInt(Integer::parseInt).toArray();
            time2 = new Time(numbers[0], numbers[1]);
        } else {
            int[] numbers = Arrays.stream(line.split(":")).mapToInt(Integer::parseInt).toArray();
            time2 = new Time(numbers[0], numbers[1], numbers[2]);
        }

        System.out.println(time1);
        System.out.println(time2);

        time1.inc().inc().inc().inc();

        System.out.println(time1);

    }
}

public class Main {
    public static void main(String[] args) {
        Calculator.solution();
        //BookChecker.solution();
        //TimeCreator.solution();
    }
}