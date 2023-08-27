package dev.lpa;

enum Geometry {LINE, POINT, POLYGON}
enum Color {BLACK, WHITE, BLUE, RED, YELLOW, ORANGE, GREEN}
enum PointMarkers{CIRCLE, SQUARE, DIAMOND, CROSS}
enum LineMarkers{DASHED, DOTTED, SOLID}
interface Mappable {
    String JSON_PROPERTY = """
                "properties": {%s} """;
    String getLabel();   //How the item will be described on the map

    Geometry getShape(); //return POINT or LINE - which is what the type will look

    // like on the map
    String getMarker();  //sometimes called a map marker

//    String getName();
//    String getUsage();

    default String toJSON() {
        //how i did it
//        return System.out.printf("\"properties\": {\"type\": \"%s\", \"label\": \"%s\", \"marker\": \"%s\", \"name\": \"%s\", \"usage\": \"%s\"}"
//                ,getShape().name(),getLabel(),getMarker(),getName(), getUsage()).toString();
        return """
                "type": "%s", "label": "%s", "marker": "%s" """
                .formatted(getShape(),getLabel(),getMarker());
    }

    static void mapIt(Mappable mappable) {

        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }
}


