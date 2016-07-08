# sample.arduino.write
Type some text and an LED flashes the message in Morse code. Uses the Liberty Arduino user feature to integrate Liberty with Arduino.


## Troubleshooting
If, when you enter some text in the webpage and press Submit, you get an error like this, it's because you have the port specified in the `server.xml` file doesn't match the port on which your Arduino is connected to your computer:

    Application Error
    SRVE0777E: Exception thrown by application class 'com.ibm.wasdev.arduino.impl.ArduinoAsyncImpl.findCommPort:228'
    java.lang.IllegalArgumentException: Could not find COM port from : [ttyACM1], in available ports: [ttyACM0, ttyS4, ttyS31, ttyS30, ttyS29, ttyS28, ttyS27, ttyS26, ttyS25, ttyS24, ttyS23, ttyS22, ttyS21, ttyS20, ttyS19, ttyS18, ttyS17, ttyS16, ttyS15, ttyS14, ttyS13, ttyS12, ttyS11, ttyS10, ttyS9, ttyS8, ttyS7, ttyS6, ttyS5, ttyS3, ttyS2, ttyS1, ttyS0]
    at com.ibm.wasdev.arduino.impl.ArduinoAsyncImpl.findCommPort(ArduinoAsyncImpl.java:228)
    at com.ibm.wasdev.arduino.impl.ArduinoAsyncImpl.open(ArduinoAsyncImpl.java:151)
    at com.ibm.wasdev.arduino.impl.ArduinoAsyncImpl.doCommand2(ArduinoAsyncImpl.java:547)
    at com.ibm.wasdev.arduino.impl.ArduinoAsyncImpl.doCommand(ArduinoAsyncImpl.java:535)
    at com.ibm.wasdev.arduino.impl.ArduinoAsyncImpl.digitalWrite(ArduinoAsyncImpl.java:260)
    at main.java.wasdev.sample.morse.MorseCodeOutputter.light(MorseCodeOutputter.java:150)
    at main.java.wasdev.sample.morse.MorseCodeOutputter.dash(MorseCodeOutputter.java:38)
    at main.java.wasdev.sample.morse.MorseCodeOutputter.character(MorseCodeOutputter.java:50)
    at main.java.wasdev.sample.morsecode.servlet.MorseCodeServlet.doGet(MorseCodeServlet.java:50)
    at javax.servlet.http.HttpServlet.service(HttpServlet.java:687)
    at [internal classes]

To fix it:

1. Open the Arduino IDE and click **Tools > Serial Port** to see the port number that Arduino is connected to.
2. In Eclipse, open the `server.xml`: In the Servers view, expand the Liberty installation and double-click **Server Configuration [server.xml]**
3. In the `server.xml`, update the `ports` value in the line `<usr_arduino id="default" ports="ttyACM1"/>` to match the port number you found in the Arduino IDE.
4. Save the `server.xml`. The Liberty server automatically updates (you don't need to restart the server) so just try submitting your message again.
