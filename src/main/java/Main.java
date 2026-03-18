import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static void main(String[] args) {

        Pizza pizza1 = new Pizza ("Margerita", new ArrayList<String>(Arrays.asList("ost", "tomatsovs")), 1, 90.00, 15.00);
        Pizza pizza2 = new Pizza ("Pepperoni", new ArrayList<String>(Arrays.asList("ost", "tomatsovs","pepperoni")), 1, 90.00, 15.00);
        Pizza pizza3 = new Pizza ("Vesuvio", new ArrayList<String>(Arrays.asList("ost", "tomatsovs","skinke")), 1, 90.00, 15.00);
        Pizza pizza4 = new Pizza ("Amerikaner", new ArrayList<String>(Arrays.asList("ost", "tomatsovs","oksefars", "oregano")), 1, 90.00, 15.00);
        Pizza pizza5 = new Pizza ("Carbona", new ArrayList<String>(Arrays.asList("ost", "tomatsovs","kødsovs","spaghetti","cocktailpølser", "oregano")), 1, 90.00, 15.00);
        Pizza pizza6 = new Pizza ("Denis", new ArrayList<String>(Arrays.asList("ost", "tomatsovs","skinke","pepperoni","cocktailpølser","oregano")), 1, 90.00, 15.00);
        Pizza pizza7 = new Pizza ("Berthil", new ArrayList<String>(Arrays.asList("ost", "tomatsovs","bacon","oregano")), 1, 90.00, 15.00);
        Pizza pizza8 = new Pizza ("Silvia", new ArrayList<String>(Arrays.asList("ost", "tomatsovs","pepperoni","rød peber", "løg", "oliven", "oregano")), 1, 90.00, 15.00);
        Pizza pizza9 = new Pizza ("Victoria", new ArrayList<String>(Arrays.asList("ost", "tomatsovs","skinke","ananas","champingon","løg","oregano")), 1, 90.00, 15.00);
        Pizza pizza10 = new Pizza ("Mafia", new ArrayList<String>(Arrays.asList("ost", "tomatsovs","pepperoni","bacon","løg","oregano")), 1, 90.00, 15.00);


        System.out.println(pizza1.getTilberedningsTid () + " min");
        System.out.println(pizza2.getTilberedningsTid () + " min");
        System.out.println(pizza3.getTilberedningsTid () + " min");
        System.out.println(pizza4.getTilberedningsTid () + " min");
        System.out.println(pizza5.getTilberedningsTid () + " min");
        System.out.println(pizza6.getTilberedningsTid () + " min");
        System.out.println(pizza7.getTilberedningsTid () + " min");
        System.out.println(pizza8.getTilberedningsTid () + " min");
        System.out.println(pizza9.getTilberedningsTid () + " min");
        System.out.println(pizza10.getTilberedningsTid () + " min");
        }
    }