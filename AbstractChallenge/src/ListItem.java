public abstract class ListItem {

    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    public abstract ListItem next();

    public abstract ListItem setNext(ListItem rightLink);

    public abstract ListItem previous();

    public abstract ListItem setPrevious(ListItem leftLink);

    public abstract int compareTo(ListItem list, Object value);
}
