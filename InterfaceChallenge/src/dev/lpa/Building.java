package dev.lpa;

enum UsageType{
BUSINESS, ENTERTAINMENT, RECREATIONAL, RESIDENTIAL
}

public class Building implements Mappable {

    private String name;
    private UsageType buildingType;

    public Building(String name, UsageType buildingType) {
        this.name = name;
        this.buildingType = buildingType;
    }

//    @Override
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String getUsage() {
//        return buildingType.name();
//    }

    @Override
    public String getLabel() {
        return name + " (" + buildingType + ")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return Color.RED.name() + " " + PointMarkers.DIAMOND.name();
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
                , "name": "%s", "usage": "%s" """.formatted(name, buildingType);
    }
}