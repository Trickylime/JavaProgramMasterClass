import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Theatre {

    class Seat {
        private char row;
        private int seatNumber;
        private boolean reserved = false;

        public Seat(char row, int seatNumber) {
            this.row = row;
            this.seatNumber = seatNumber;
        }

        public char getRow() {
            return row;
        }

        public int getSeatNumber() {
            return seatNumber;
        }

        public boolean isReserved() {
            return reserved;
        }

        public void setReserved(boolean reserved) {
            this.reserved = reserved;
        }

        @Override
        public String toString() {
            String reservedFlag = reserved ? "(Reserved)" : ""; // Include "R" if reserved is true, otherwise an empty string
            return String.format("%c%03d%s", row, seatNumber, reservedFlag);
        }

    }

    private String name;
    private int numberOfRows;
    private int numberOfSeatsInRow;
    private int numberOfSeatsTotal;
    private TreeSet<Seat> seats;

    public Theatre(String name, int numberOfRows, int numberOfSeatsInRow) {
        this.name = name;
        this.numberOfRows = numberOfRows;
        this.numberOfSeatsInRow = numberOfSeatsInRow;
        this.numberOfSeatsTotal = numberOfSeatsInRow * numberOfRows;

        Comparator<Seat> mySort = Comparator
                .comparing(Seat::getRow)
                .thenComparing(Seat::getSeatNumber);

        this.seats = new TreeSet<>(mySort);
        for(char row = 'A'; row < 'A' + numberOfRows; row++){
            for(int j = 1; j <= numberOfSeatsInRow; j++){
                seats.add(new Seat(row, j));
            }
        }
    }

    public void reserveSeat(char row, int seatNum){

        Seat seat = seats.floor(new Seat(row, seatNum));
        if (seat == null) {
            System.out.println("Seat does not exist");
            return;
        }
        if(!seat.reserved){
            System.out.println("Your seat " + seat + " has been successfully reserved");
            seat.setReserved(true);
        } else {
            System.out.println("Your seat " + seat + " is already reserved");
        }
    }

    public void reserveMultiSeats(char rowRangeStart, char rowRangeEnd, int seatRangeStart, int seatRangeEnd){

        List<Seat> seats = new ArrayList<>();
        int seatsRequestTotal = (rowRangeEnd - rowRangeStart) * (seatRangeEnd - seatRangeStart);
    }

    public void printSeatMap() {
        char currentRow = 'A';
        boolean firstSeatInRow = true;

        System.out.println("-".repeat(60));
        for (Seat seat : seats) {
            if (currentRow != seat.getRow()) {
                System.out.println();
                currentRow = seat.getRow();
                firstSeatInRow = true;
            }

            if (!firstSeatInRow) System.out.print(", ");
            firstSeatInRow = false;

            System.out.print(seat);
        }
        System.out.println();
        System.out.println("-".repeat(60));
    }
}
