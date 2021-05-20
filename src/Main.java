import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class Main {
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		// To Take Inputs
		Scanner scanner = new Scanner(System.in);
		
		// Song File Linking >--->
		File file = new File("song.wav");
		
		// Audio Thing
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		// Starting Response
		String response = "";
		
		// Looping And Conditions
		while(!response.equals("Q")) {
			System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
			System.out.print("Enter Your Choice: ");
			response = scanner.next();
			response = response.toUpperCase();
			
			switch(response) {
			case("P"): clip.start();
			break;
			case("S"): clip.stop();
			break;
			case("R"): clip.setMicrosecondPosition(0);
			break;
			case("Q"): clip.close();
			break;
			default: System.out.println("Not a Valid Response");
			}
		}	
		
		// On Exit!!
		System.out.println("Thankyou! ");
	}
}
