import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Example driver that uses a couple streams
 * and leverages a lambda expression as a filter.
 * reference: https://www.mkyong.com/java8/java-8-streams-filter-examples/
 */
public class Main {

    public static void main(String[] args) {

        // Populate a collection of people for this example
        List<Person> people = Arrays.asList(
                new Person("Ryder Dale", 27),
                new Person("Lindsay Elizabeth", 25),
                new Person("Aliza Dale", 1)
        );

        // find a particular person to print out
        String name = people.stream()
                // filter on this lambda
                .filter(x -> "Ryder Dale".equals(x.getName()))
                .map(Person::getName) // convert stream to string
                .findAny()
                .orElse("No matching name found....");
        System.out.println("Found name: " + name);

        // Print out everyone in the collection of people
        List<String> collect = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        // pass in the name of the function with its
        // scope resolved (::)
        collect.forEach(System.out::println);
    }
}
