package familytreeSrc;

import java.util.ArrayList;
import java.util.List;

class Person {
    String name;
    Person father;
    List<Person> spouses;
    List<Person> children;

    public Person(String name) {
        this.name = name;
        this.spouses = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getGender() {
        if (father != null) {
            return (father.children.indexOf(this) % 2 == 0) ? "Male" : "Female";
        }
        if (!spouses.isEmpty()) {
            return (spouses.get(0).children.indexOf(this) % 2 == 0) ? "Male" : "Female";
        }
        return "Male";
    }
}
