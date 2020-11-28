import java.util.Scanner;

class Food {
  private String name;

  Food(String name) {
    this.name = name;
  }

  public String getter() {
    return this.name;
  }

  public int equals(Food orig, int value) {
    if (orig.getClass().getName() == this.getClass().getName()) {
      return ++value;
    }
    return value;
  }
}

class Burger extends Food {
  Burger(String size) {
    super(size);
  }
}

class Cheese extends Food {
  Cheese(String type) {
    super(type);
  }
}

public class Lab_1 {
  public static void main(String[] args) {
    int value = 0;
    int lenght;
    Scanner in = new Scanner(System.in);
    System.out.println("Введите размер массива ");
    lenght = in.nextInt();
    Food menu[] = new Food[lenght];
    for (int i = 0; i < menu.length; i++) {
      System.out.println("Ввведите блюдо: Burger, Cheese");
      String choice = in.next();
      String name;
      switch (choice) {
        case "Burger": {
          System.out.println("Ввведите размер of Burger: big, medium, small");
          boolean flag = true;
          while (flag) {
            name = in.next();
            if (name.equals("big") || name.equals("small") || name.equals("medium")) {
              menu[i] = new Burger(name);
              flag = false;
            } else {
              System.out.println("Неверно указан размер");
            }
          }
        }
          break;
        case "Cheese": {
          System.out.println("Ввведите сорт of Cheese: cheder, parmezan, tofu");
          boolean flag = true;
          while (flag) {
            name = in.next();
            if (name.equals("cheder") || name.equals("parmezan") || name.equals("tofu")) {
              menu[i] = new Cheese(name);
              flag = false;
            } else {
              System.out.println("Неверно указан сорт");
            }
          }
          break;
        }
        default: {
          System.out.println("Неверно указанj блюдо, введите заново");
          i--;
        }
          break;
      }
    }
    int num = 0;
    Burger hold = new Burger("small");
    for (int i = 0; i < menu.length; i++) {
      num = menu[i].equals(hold, num);
    }
    System.out.println("Количество of Burger: " + num);
  }
}