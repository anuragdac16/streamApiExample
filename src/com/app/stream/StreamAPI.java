package com.app.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

	public static void main(String[] args) throws IOException {
		// exampleOne();
		// exampleTwo();
		// exampleThree();
		// exampleFour();
		 exampleFive();
		// exampleSix();
		// exampleSeven();
		// exampleEight();
		// exampleNine();
		//exampleTen();
		//exampleEleven();
		//exampleTwelve();
		//exampleThirteen();
		//exampleFourteen();
	}

	public static void exampleOne() {
		IntStream.range(1, 10).forEach(System.out::println);
	}

	public static void exampleTwo() {
		IntStream.range(1, 10).skip(5).forEach(System.out::println);
	}

	public static void exampleThree() {
		System.out.println(IntStream.range(1, 10).sum());
	}

	public static void exampleFour() {
		Stream.of("Anurag", "Gupta", "Venu", "Gopal", "Ganesh").sorted().findFirst().ifPresent(System.out::println);
	}

	public static void exampleFive() {
		String[] names = { "Anurag", "Gupta", "Venu", "Gopal", "Ganesh", "Amar", "Gaurav", "Aakash" };
		Arrays.stream(names).filter(x -> x.startsWith("A")).sorted().forEach(System.out::println);
	}

	public static void exampleSix() {
		Arrays.stream(new int[] { 2, 4, 6, 8, 10 }).map(x -> x * x).average().ifPresent(System.out::println);

	}

	public static void exampleSeven() {
		List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "Amanda", "Hans", "Shiv", "Anurag",
				"Gupta", "Venu", "Gopal", "Ganesh", "Amar", "Gaurav", "Aakash");
		people.stream().map(x -> x.toLowerCase()).filter(x -> x.startsWith("a")).forEach(System.out::println);

	}

	public static void exampleEight() throws IOException {
		Stream<String> bands = Files.lines(Paths.get("bands.txt"));
		bands.sorted().filter(x -> x.length() > 10).forEach(System.out::println);

		bands.close();
	}

	public static void exampleNine() throws IOException {
		List<String> bands = Files.lines(Paths.get("bands.txt")).filter(x -> x.contains("jit"))
				.collect(Collectors.toList());
		bands.forEach(System.out::println);
	}

	public static void exampleTen() throws IOException {
		Stream<String> rows1 = Files.lines(Paths.get("data.txt"));

		int rowCount = (int) rows1.map(x -> x.split(",")).filter(x -> x.length == 3).count();

		System.out.println(rowCount + " rows");
		rows1.close();
	}

	public static void exampleEleven() throws IOException {

		Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
		rows1.map(x -> x.split(","))
		.filter(x -> x.length == 3)
		.filter(x -> Integer.parseInt(x[1]) > 15)
				.forEach(x -> System.out.println(x[0] + "   " + x[1] + "   " + x[2]));

		rows1.close();
	}

	public static void exampleTwelve() throws IOException {

		Stream<String> rows = Files.lines(Paths.get("data.txt"));
		Map<String, Integer> map = new HashMap<>();
		map = rows.map(x -> x.split(","))
				.filter(x -> x.length == 3)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(
						x -> x[0], 
						x -> Integer.parseInt(x[1] ) ) );
		rows.close();
		
		for (String key : map.keySet()) {
			System.out.println(key+"   "+map.get(key));
			
		}
	}

	public static void exampleThirteen() {

		Double total = Stream.of(7.3 , 1.8 , 4.8)
				.reduce(0.0, (Double a , Double b) -> a+b);
		System.out.println("Total  :  "+total);
	}

	public static void exampleFourteen()  {

		IntSummaryStatistics summary = IntStream.of( 7 ,2 ,19 , 88 , 73 , 4 , 10)
				.summaryStatistics();
		System.out.println(summary);
		
	}


}
