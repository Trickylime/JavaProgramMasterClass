import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{

    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        List<String> list = new ArrayList<>();

        list.add(0, getName());
        list.add(1, Integer.toString(getHitPoints()));
        list.add(2, Integer.toString(getStrength()));

        return list;
    }

    @Override
    public void read(List<String> list) {

        if( list != null && list.size() > 0){
            this.name = list.get(0);
            this.hitPoints = Integer.parseInt(list.get(1));
            this.strength = Integer.parseInt(list.get(2));
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + "{name='" + getName()
                + "', hitPoints=" + getHitPoints()
                + ", strength=" + getStrength() + "}";
    }
}
