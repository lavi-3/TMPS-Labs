package creational.factory;
// avem o functie care returneaza un tip de scoala
public class SchoolTypeFactory {
    public SchoolType chooseSchoolType(String schoolType)
    {
        if (schoolType == null || schoolType.isEmpty())
            return null;
        return switch (schoolType) {
            case "P" -> new PrimarySchool();     // se da un string, si in dependenta de el se
            case "L" -> new Lyceum();            // determina tipul de scoala
            case "G" -> new Gymnasium();
            default -> throw new IllegalArgumentException("Unknown schoolType " + schoolType);
        };
    }
}
