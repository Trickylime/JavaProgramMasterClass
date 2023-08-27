import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MiniChallenge {

    public static void main(String[] args) {

        ///////////////////////
        //MINI CHALLENGE ONE!//
        ///////////////////////

        String string = "Hello world how are you";

        Consumer<String> printTheParts = new Consumer<String>() {
            @Override
            public void accept(String s) {
                String[] parts = s.split(" ");
                for (String part: parts){
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printThePartsLambda = s -> {
            String[] parts = s.split(" ");
            for (String part: parts){
                System.out.println(part);
            }
        };

        printTheParts.accept(string);
        printThePartsLambda.accept(string);

        Consumer<String> printThePartsLambdaForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };

        printThePartsLambdaForEach.accept(string);

        Consumer<String> printThePartsLambdaConcise = sentence ->
            Arrays.asList(sentence.split(" ")).
                    forEach(s -> System.out.println(s));

        printThePartsLambdaConcise.accept("Get fucked you cunt");


        ///////////////////////
        //MINI CHALLENGE TWO!//
        ///////////////////////
        Function<String, String> everySecondChar = (s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                if (i % 2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("Jack"));

        UnaryOperator<String> everySecondCharUnary = s ->{
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                if (i % 2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        /////////////////////////
        //MINI CHALLENGE THREE!//
        /////////////////////////
        System.out.println(everySecondCharUnary.apply("1234567890"));

        ////////////////////////
        //MINI CHALLENGE FIVE!//
        ////////////////////////
        String numString = "1234567890";
        System.out.println(everySecondCharacter(everySecondChar, numString));

        ///////////////////////
        //MINI CHALLENGE SIX!//
        ///////////////////////
        Supplier<String> iLovejava = () -> "I love Java";
        System.out.println(iLovejava.get());

        /////////////////////////
        //MINI CHALLENGE SEVEN!//
        /////////////////////////
        String supplierResult = iLovejava.get();
        System.out.println(supplierResult);

    }


    ////////////////////////
    //MINI CHALLENGE FOUR!//
    ////////////////////////
    public static String everySecondCharacter(Function<String, String> function,
                                                String string){
        return function.apply(string);
    }
}
