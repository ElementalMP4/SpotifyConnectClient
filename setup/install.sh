echo Install dependencies
apt-get install git maven openjdk-17-jdk -y
mkdir -p /home/pi/RaspiSonos

echo Pull things from git
git clone https://github.com/ElementalMP4/RaspiSonos /var/tmp/RaspiSonos
git clone https://github.com/ElementalMP4/librespot-java /var/tmp/librespot-java

echo Build librespot-java
cd /var/tmp/librespot-java/api
mvn clean package

echo Put librespot-java in the home dir
cp target/librespot-api-1.6.3.jar /home/pi/RaspiSonos/librespot.jar

echo Set up the systemctl unit for librespot-java
cp /var/tmp/RaspiSonos/librespot-java.sh /home/pi/RaspiSonos/
cp /var/tmp/RaspiSonos/LibrespotJava.service /usr/lib/systemd/system/
systemctl daemon-reload
systemctl enable LibrespotJava
systemctl start LibrespotJava

echo Build raspisonos-api
cd /var/tmp/RaspiSonos/raspisonos-api
mvn clean package

echo Put raspisonos-api in the home dir
cp target/original-RaspiSonos-API-0.0.1.jar /home/pi/RaspiSonos/raspisonos-api.jar

echo Set up the systemctl unit for raspisonos-api
cp /var/tmp/RaspiSonos/raspisonos-api.sh /home/pi/RaspiSonos/
cp /var/tmp/RaspiSonos/RaspiSonos-API.service /usr/lib/systemd/system/
systemctl daemon-reload
systemctl enable RaspiSonos-API
systemctl start RaspiSonos-API

echo Cleanup
sudo rm -rf /var/tmp/RaspiSonos /var/tmp/librespot-java