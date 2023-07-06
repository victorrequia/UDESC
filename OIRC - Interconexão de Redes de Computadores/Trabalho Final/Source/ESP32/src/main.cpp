#include <Arduino.h>
#include <BLEDevice.h>
#include <BLEAdvertisedDevice.h>
#include <WiFi.h>
#include <PubSubClient.h>

const char *SSID = "Ap_304";
const char *PWD = "ninaebarto";
int scanTime = 120; //In seconds
BLEScan* pBLEScan;
WiFiClient wifiClient;
PubSubClient mqttClient(wifiClient); 
char *mqttServer = "broker.hivemq.com";
int mqttPort = 1883;

// WiFi Connection
void connectToWiFi() {
  Serial.print("Connecting to ");
 
  WiFi.begin(SSID, PWD);
  Serial.println(SSID);
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }
  Serial.println(" Connected.");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
  
}

void setupMQTT() {
  mqttClient.setServer(mqttServer, mqttPort);
}

void reconnect() {
  Serial.println("Connecting to MQTT Broker...");
  while (!mqttClient.connected()) {
      Serial.println("Reconnecting to MQTT Broker..");
      String clientId = "CLIENT ESP32 - ";
      clientId += String(random(0xffff), HEX);
      
      if (mqttClient.connect(clientId.c_str())) {
        Serial.println("Connected.");
        // subscribe to topic
        mqttClient.subscribe("/teste");
      }
      
  }
}

class MyAdvertisedDeviceCallbacks: public BLEAdvertisedDeviceCallbacks {
    void onResult(BLEAdvertisedDevice advertisedDevice) {
      // VER SE É POSSIVEL AJUSTAR A DISTÂNCIA. 
      // Serial.printf("Advertised Device: %s \n", advertisedDevice.toString().c_str());
      Serial.printf("Publicando MAC= %s e RSSI= %d \n", advertisedDevice.getAddress().toString().c_str(), advertisedDevice.getRSSI());
      const char* data = advertisedDevice.getAddress().toString().c_str() + '#' + advertisedDevice.getRSSI();
      digitalWrite(SCK,HIGH);
      delay(500);
      digitalWrite(SCK,LOW);
      delay(500);
      mqttClient.publish("/teste/trabalhoOIRC", data);
    }
};



void setup() {
  pinMode(SCK,OUTPUT);
  Serial.begin(9600);

  connectToWiFi();
  setupMQTT();
  Serial.println("Scanning...");

  BLEDevice::init("felipe");
  pBLEScan = BLEDevice::getScan(); //create new scan
  pBLEScan->setAdvertisedDeviceCallbacks(new MyAdvertisedDeviceCallbacks());
  pBLEScan->setActiveScan(true); //active scan uses more power, but get results faster
  pBLEScan->setInterval(100);
  pBLEScan->setWindow(99);  // less or equal setInterval value
}

void loop() {
  if (!mqttClient.connected())
    reconnect();
  mqttClient.loop();

  BLEScanResults foundDevices = pBLEScan->start(scanTime, false);
  Serial.print("Devices found: ");
  Serial.println(foundDevices.getCount());
  Serial.println("Scan done!");
  pBLEScan->clearResults();   // delete results fromBLEScan buffer to release memory
  delay(2000);
  
}
