
/*******************************************************************************
 * Copyright (c) 2016 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package main.java.wasdev.sample.morse;

import static com.ibm.wasdev.arduino.Arduino.Level.HIGH;
import static com.ibm.wasdev.arduino.Arduino.Level.LOW;
import static com.ibm.wasdev.arduino.Arduino.Mode.OUTPUT;

import java.io.IOException;

import com.ibm.wasdev.arduino.Arduino;
import com.ibm.wasdev.arduino.ArduinoService;

public class MorseCodeOutputter {

	public void dot(int x) {
		for (int thisPin = 0; thisPin < x; thisPin++) {
		    light(500);}
	}

	public void dash(int x) {
		for (int thisPin = 0; thisPin < x; thisPin++) {
		    light(1000);}
	}
	
	public void character(char character1){
		if (character1 == 's') {
			dot(3);}
		if (character1 == 'o') {
			dash(3);}			
		if (character1 == 'e') {
			dot(1);}
		if (character1 == 'a') {
			dot(1);
			dash(1);}
		if (character1 == 'd') {
			dash(1);
			dot(2);}
		if (character1 == 'm') {
			dash(2);}
		if (character1 == 'l') {
			dot(1);
			dash(1);
			dot(2);}
		if (character1 == 'u') {
			dot(2);
			dash(1);}
		if (character1 == 'r') {
			dot(1);
			dash(1);
			dot(1);}
		if (character1 == 'b') {
			dash(1);
			dot(3);}
		if (character1 == 'i') {
			dot(2);}
		if (character1 == 'c') {
			dash(1);
			dot(1);
			dash(1);
			dot(1);}
		if (character1 == 'f') {
			dot(2);
			dash(1);
			dot(1);}
		if (character1 == 'g') {
			dash(2);
			dot(1);}
		if (character1 == 'h') {
			dot(4);}
		if (character1 == 'j') { 
			dot(1);
			dash(3);}
		if (character1 == 'k') {
			dash(1);
			dot(1);
			dash(1);}
		if (character1 == 'n') {
			dash(1);
			dot(1);}
		if (character1 == 'p') {
			dot(1);
			dash(2);
			dot(1);}
		if (character1 == 'q') {
			dash(2);
			dot(1);
			dash(1);}
		if (character1 == 't') {
			dash(1);}
		if (character1 == 'v') {
			dot(3);
			dash(1);}
		if (character1 == 'w') {
			dot(1);
			dash(2);}
		if (character1 == 'x') {
			dash(1);
			dot(2);
			dash(1);}
		if (character1 == 'y') {
			dash(1);
			dot(1);
			dash(2);}
		if (character1 == 'z') {
			dash(2);
			dot(2);}
		
	}
	
	public static void light(int duration) {
		Arduino arduino = null;
		try {
			arduino = ArduinoService.get();
		} catch (IOException e2) {
			// TODO Aut LOW);o-generated catch block
			e2.printStackTrace();
		}
		int led = 13;
		try {
			arduino.pinMode(led, OUTPUT);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
		}
		try {
			if (arduino.digitalRead(led) == LOW) {
				arduino.digitalWrite(led, HIGH);
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				arduino.digitalWrite(led, LOW);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
