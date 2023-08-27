package dev.lpa;

enum UtilityType{
    ELECTRICAL, FIBER_OPTIC, WATER, SEWERAGE
}
public class UtilityLine implements Mappable {

    private String name;
    private UtilityType utilityType;

    public UtilityLine(String name, UtilityType utilityType) {
        this.name = name;
        this.utilityType = utilityType;
    }

    //    @Override
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String getUsage() {
//        return utilityType.name();
//    }

    @Override
    public String getLabel() {
        return name + " (" + utilityType + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String getMarker() {
        return Color.GREEN.name() + " " + LineMarkers.DOTTED.name();
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "usage": "%s" """.formatted(name, utilityType);
    }
}
