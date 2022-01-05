public class JavaBuilderDesignPattern {

    public static void main(String[] args) {

        PersonWithConstructor evrenWithFullInfoByConstructor = new PersonWithConstructor(
            "Evren", "Tan", 38, "M");

        PersonWithConstructor evrenWithNamesByConstructor = new PersonWithConstructor(
            "Evren", "Tan");

        PersonWithBuilder evrenWithFullInfoByBuilder = PersonWithBuilder.PersonBuilder.initialize()
            .withFirstName("Evren")
            .withLastName("Tan")
            .withAge(38)
            .withSex("M")
            .build();

        PersonWithBuilder evrenWithNamesWithBuilder = PersonWithBuilder.PersonBuilder.initialize()
            .withFirstName("Evren")
            .withLastName("Tan")
            .build();

        Person person = PersonBuilder.initialize()
            .withFirstName("Evren")
            .withLastName("Tan")
            .withAge(38)
            .withSex("M")
            .build();

        Person personWithFullName = PersonBuilder.initialize()
            .withFullName("Evren", "Tan")
            .build();

        System.out.println("Full Info with Constructor: " + evrenWithFullInfoByConstructor.toString());
        System.out.println("Full Info with Builder: " + evrenWithFullInfoByBuilder.toString());
        System.out.println("Full Info with Builder Class" + person.toString());
        System.out.println("Names with Constructor" + evrenWithNamesByConstructor.toString());
        System.out.println("Names with Builder" + evrenWithNamesWithBuilder.toString());
        System.out.println("Names with Builder Class" + personWithFullName.toString());
    }
}
