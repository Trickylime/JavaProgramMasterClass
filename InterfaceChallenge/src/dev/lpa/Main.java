package dev.lpa;

public class Main {
    public static void main(String[] args) {
        Building building = new Building("JM Offices", UsageType.BUSINESS);
        UtilityLine utilityLine = new UtilityLine("JM Electrical", UtilityType.ELECTRICAL);

        Mappable.mapIt(building);
        Mappable.mapIt(utilityLine);
    }
}
