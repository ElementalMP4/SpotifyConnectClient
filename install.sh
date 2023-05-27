#Install dependencies
apt-get install git maven openjdk-17-jdk -y

#Pull things from git
git clone https://github.com/ElementalMP4/RaspiSonos /var/tmp/RaspiSonos
git clone https://github.com/ElementalMP4/librespot-java /var/tmp/librespot-java

#Build librespot-java
cd /var/tmp/librespot-java/api
mvn clean package

#Put librespot-java in the home dir
mkdir -p /home/pi/RaspiSonos
cp target/librespot-api-1.6.3.jar /home/pi/RaspiSonos

#Set up the systemctl unit for librespot-java
cp /var/tmp/RaspiSonos/librespot-java.sh /home/pi/RaspiSonos/
cp /var/tmp/RaspiSonos/LibrespotJava.service /usr/lib/systemd/system/
systemctl daemon-reload
systemctl enable LibrespotJava
systemctl start LibrespotJava

#Drop in the config template
cp /var/tmp/RaspiSonos/config.toml.tmpl /home/pi/RaspiSonos/config.toml
systemctl restart LibrespotJava

