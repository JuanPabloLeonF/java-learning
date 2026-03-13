import annotation.InformationConfiguration;
import oop.models.Person;


void main() {
    Person person = new Person("papo", "12345");
    InformationConfiguration informationConfiguration = person.getClass().getAnnotation(InformationConfiguration.class);
    System.out.println(informationConfiguration);
}
